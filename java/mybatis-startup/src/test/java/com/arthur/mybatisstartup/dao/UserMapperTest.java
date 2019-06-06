package com.arthur.mybatisstartup.dao;

import com.arthur.mybatisstartup.MybatisStartupApplication;
import com.arthur.mybatisstartup.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

//@MybatisTest
@RunWith(SpringRunner.class)
@EnableAutoConfiguration
@SpringBootTest(classes = MybatisStartupApplication.class)
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

//        User user = userMapper.selectByPrimaryKey(13);
//        assertThat(user.getUsername()).isEqualTo("geely");
    }
}