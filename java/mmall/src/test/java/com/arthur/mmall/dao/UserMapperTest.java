package com.arthur.mmall.dao;

import com.arthur.mmall.MmallApplication;
import com.arthur.mmall.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = MmallApplication.class)
public class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void selectByPrimaryKey() {

        User user = userMapper.selectByPrimaryKey(13);
        assertThat(user.getUsername()).isEqualTo("geely");
    }

    @Test
    public void checkUserName() {

        int userNumber = userMapper.checkUserName("geely");
        assertThat(userNumber).isEqualTo(1);

        int userNumber2 = userMapper.checkUserName("invalideUser");
        assertThat(userNumber2).isEqualTo(0);
    }

    @Test
    public void selectByUserNamePassword() {
        User user = userMapper.selectByUserNamePassword("geely", "08E9A6EA287E70E7E3F7C982BF7923AC");
        assertThat(user).isNotNull();
    }

    @Test
    public void checkEmail() {
        userMapper.checkEmail("abc@qq.com");
    }


    @Test
    public void selectQuestionByUsername() {
        String question = userMapper.selectQuestionByUsername("geely");
        assertThat(question).isNotBlank();
    }

    @Test
    public void checkAnswer() {
        int rowNum = userMapper.checkAnswer("geely", "q", "a");
        assertThat(rowNum).isEqualTo(0);
    }

    @Test
    public void checkPassword() {
        int rowNum = userMapper.checkPassword("08E9A6EA287E70E7E3F7C982BF7923AC", 13);
        assertThat(rowNum).isEqualTo(1);
    }

    @Test
    public void checkEmailByUserId() {
        int rowNum = userMapper.checkEmailByUserId("abc@qq.com", 13);
        assertThat(rowNum).isEqualTo(0);
    }
}