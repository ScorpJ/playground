package com.arthur.mmall.controller.portal;


import com.arthur.mmall.common.Constant;
import com.arthur.mmall.common.ResponseCode;
import com.arthur.mmall.common.ServerResponse;
import com.arthur.mmall.entity.User;
import com.arthur.mmall.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * @param userName
     * @param pwd
     * @param session
     * @return
     */
    @RequestMapping(path = "login.do", method = RequestMethod.POST)
    public ServerResponse<User> login(@RequestParam("username") String userName, @RequestParam("password") String pwd, HttpSession session) {

        logger.info("In login, userName: {}, password: {}", userName, pwd);
        ServerResponse<User> resp = userService.login(userName, pwd);
        if (resp.isSuccess()) {
            session.setAttribute(Constant.CURRENT_USER, resp.getData());
        }
        return resp;
    }

    @RequestMapping(path = "logout.do", method = RequestMethod.POST)
    public ServerResponse<String> logout(HttpSession session) {
        session.removeAttribute(Constant.CURRENT_USER);
        return ServerResponse.createBySuccess();
    }


    @RequestMapping(path = "register.do", method = RequestMethod.POST)
    public ServerResponse<String> register(User user) {
        return userService.register(user);
    }

    @RequestMapping(path = "checkValid.do", method = RequestMethod.POST)
    public ServerResponse<String> checkValid(String type, String value) {
        return userService.checkValid(type, value);
    }


    @RequestMapping(path = "get_user_info.do", method = RequestMethod.POST)
    public ServerResponse<User> getUserInfo(HttpSession session) {
        User user = (User) session.getAttribute(Constant.CURRENT_USER);
        if (user != null) {
            return ServerResponse.createBySuccess(user);
        }
        return ServerResponse.createByErrorMessage("用户未登录");

    }

    @RequestMapping(path = "get_forget_question.do", method = RequestMethod.POST)
    public ServerResponse<String> getForgetQuestion(String username) {
        return userService.selectQuestion(username);
    }

    @RequestMapping(path = "forget_check_answer.do", method = RequestMethod.POST)
    public ServerResponse<String> checkForgetAnswer(String username, String question, String answer) {
        return userService.checkAnswer(username, question, answer);
    }


    @RequestMapping(path = "reset_pwd_forget.do", method = RequestMethod.POST)
    public ServerResponse<String> resetPassword4Forget(String username, String passwordNew, String token) {
        return userService.resetPassword4Forget(username, passwordNew, token);
    }


    @RequestMapping(path = "reset_pwd.do", method = RequestMethod.POST)
    public ServerResponse<String> resetPassword4Forget(HttpSession session, String passwordOld, String passwordNew) {
        User user = (User) session.getAttribute(Constant.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMessage("用户未登录");
        }

        return userService.resetPassword(passwordOld, passwordNew, user);
    }

    @RequestMapping(path = "update_information.do", method = RequestMethod.POST)
    public ServerResponse<User> updateInfomation(HttpSession session, User user) {
        User currentUser = (User) session.getAttribute(Constant.CURRENT_USER);
        if (currentUser == null) {
            return ServerResponse.createByErrorMessage("用户未登录");
        }

        user.setId(currentUser.getId());
        user.setUsername(currentUser.getUsername());
        ServerResponse<User> resp = userService.updateInformation(user);
        if (resp.isSuccess()) {
            session.setAttribute(Constant.CURRENT_USER, resp.getData());
        }
        return resp;
    }

    @RequestMapping(value = "get_information.do", method = RequestMethod.POST)
    public ServerResponse<User> get_information(HttpSession session) {
        User currentUser = (User) session.getAttribute(Constant.CURRENT_USER);
        if (currentUser == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "未登录,需要强制登录status=10");
        }
        return userService.getInformation(currentUser.getId());
    }


}
