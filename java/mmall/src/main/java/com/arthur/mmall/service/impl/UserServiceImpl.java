package com.arthur.mmall.service.impl;

import com.arthur.mmall.common.Constant;
import com.arthur.mmall.common.ServerResponse;
import com.arthur.mmall.common.TokenCache;
import com.arthur.mmall.dao.UserMapper;
import com.arthur.mmall.entity.User;
import com.arthur.mmall.service.UserService;
import com.arthur.mmall.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ServerResponse<User> login(String userName, String password) {

        int rtCount = userMapper.checkUserName(userName);

        if (rtCount == 0) {
            return ServerResponse.createByErrorMessage("用户名不存在");
        }

        User user = userMapper.selectByUserNamePassword(userName, MD5Util.MD5EncodeUtf8(password));

        if (user == null) {
            return ServerResponse.createByErrorMessage("密码错误");
        }

        user.setPassword(StringUtils.EMPTY);
        return ServerResponse.createBySuccess("登录成功", user);
    }

    public ServerResponse<String> register(User user) {

        ServerResponse<String> checkResp = checkValid(Constant.USER_NAME, user.getUsername());
        if (!checkResp.isSuccess()) {
            return checkResp;
        }

        checkResp = this.checkValid(Constant.EMAIL, user.getEmail());

        if (!checkResp.isSuccess()) {
            return checkResp;
        }

        user.setRole(Constant.Role.ROLE_CUSTOMER);
        //MD5 加密
        user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));

        int rtCount = userMapper.insert(user);

        if (rtCount == 0) {
            return ServerResponse.createByErrorMessage("注册失败");
        }
        return ServerResponse.createBySuccessMessage("注册成功失败");

    }


    public ServerResponse<String> checkValid(String type, String value) {
        int rtCount = 0;
        if (StringUtils.isNotBlank(type)) {
            if (Constant.EMAIL.equals(type)) {
                rtCount = userMapper.checkEmail(value);
                if (rtCount > 0) {
                    return ServerResponse.createByErrorMessage("Email已存在");
                }
            } else if (Constant.USER_NAME.equals(type)) {
                rtCount = userMapper.checkUserName(value);
                if (rtCount > 0) {
                    return ServerResponse.createByErrorMessage("用户名已存在");
                }
            }

        } else {
            return ServerResponse.createByErrorMessage("参数错误");
        }

        return ServerResponse.createBySuccessMessage("校验成功");
    }

    @Override
    public ServerResponse<String> selectQuestion(String username) {
        ServerResponse<String> checkResp = checkValid(Constant.USER_NAME, username);
        if (!checkResp.isSuccess()) {
            return ServerResponse.createByErrorMessage("用户不存在");
        }
        String quest = userMapper.selectQuestionByUsername(username);
        if (StringUtils.isNotBlank(quest)) {
            return ServerResponse.createBySuccess(quest);
        }
        return ServerResponse.createByErrorMessage("找回密码的问题是空的");
    }

    @Override
    public ServerResponse<String> checkAnswer(String username, String question, String answer) {
        int rtCount = userMapper.checkAnswer(username, question, answer);
        if (rtCount > 0) {
            //问题答案用户校验正确
            String forgettoken = UUID.randomUUID().toString();
            TokenCache.setKey(TokenCache.PREFIX_TOKEN + username, forgettoken);
            return ServerResponse.createBySuccess(forgettoken);
        }
        return ServerResponse.createByErrorMessage("问题答案错误");
    }

    @Override
    public ServerResponse<String> resetPassword4Forget(String username, String passwordNew, String token) {
        if (StringUtils.isBlank(token)) {
            return ServerResponse.createByErrorMessage("参数错误, token需要传递");
        }
        ServerResponse<String> checkResp = checkValid(Constant.USER_NAME, username);
        if (!checkResp.isSuccess()) {
            return ServerResponse.createByErrorMessage("用户不存在");
        }

        String cachedToken = TokenCache.getKey(TokenCache.PREFIX_TOKEN + username);

        if (StringUtils.isBlank(cachedToken)) {
            return ServerResponse.createByErrorMessage("token无效或过期");
        }

        if (StringUtils.equals(token, cachedToken)) {
            String md5Password = MD5Util.MD5EncodeUtf8(passwordNew);
            int rowCount = userMapper.updtePasswordByUsername(username, md5Password);
            if (rowCount == 1) {
                return ServerResponse.createBySuccessMessage("修改密码成功");
            }
        } else {
            return ServerResponse.createByErrorMessage("token错误， 请重新获取token");
        }
        return ServerResponse.createBySuccessMessage("修改密码失败");
    }

    @Override
    public ServerResponse<String> resetPassword(String passwordOld, String passwordNew, User user) {
        //防止横向越权,要校验一下这个用户的旧密码,
        // 一定要指定是这个用户.因为我们会查询一个count(1),如果不指定id,那么结果就是true啦count>0;
        int resultCount = userMapper.checkPassword(MD5Util.MD5EncodeUtf8(passwordOld), user.getId());
        if (resultCount == 0) {
            return ServerResponse.createByErrorMessage("旧密码错误");
        }

        user.setPassword(MD5Util.MD5EncodeUtf8(passwordNew));
        int updateCount = userMapper.updateByPrimaryKeySelective(user);
        if (updateCount > 0) {
            return ServerResponse.createBySuccessMessage("密码更新成功");
        }
        return ServerResponse.createByErrorMessage("密码更新失败");
    }

    @Override
    public ServerResponse<User> updateInformation(User user) {
        //username是不能被更新的
        //email也要进行一个校验,校验新的email是不是已经存在,并且存在的email如果相同的话,不能是我们当前的这个用户的.
        int resultCount = userMapper.checkEmailByUserId(user.getEmail(), user.getId());
        if (resultCount > 0) {
            return ServerResponse.createByErrorMessage("email已存在,请更换email再尝试更新");
        }
        User updateUser = new User();
        updateUser.setId(user.getId());
        updateUser.setEmail(user.getEmail());
        updateUser.setPhone(user.getPhone());
        updateUser.setQuestion(user.getQuestion());
        updateUser.setAnswer(user.getAnswer());

        int updateCount = userMapper.updateByPrimaryKeySelective(updateUser);
        if (updateCount > 0) {
            return ServerResponse.createBySuccess("更新个人信息成功", updateUser);
        }
        return ServerResponse.createByErrorMessage("更新个人信息失败");
    }

    @Override
    public ServerResponse<User> getInformation(Integer userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        if (user == null) {
            return ServerResponse.createByErrorMessage("找不到当前用户");
        }
        user.setPassword(org.apache.commons.lang3.StringUtils.EMPTY);
        return ServerResponse.createBySuccess(user);

    }

    @Override
    public ServerResponse checkAdminRole(User user) {
        if (user != null && user.getRole().intValue() == Constant.Role.ROLE_ADMIN) {
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }


}
