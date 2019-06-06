package com.arthur.mybatisstartup;

import com.arthur.mybatisstartup.dao.UserMapperTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//@EnableAutoConfiguration
@SpringBootTest(classes = MybatisStartupApplication.class)
@Suite.SuiteClasses(UserMapperTest.class)
public class MybatisStartupApplicationTests {

    @Test
    public void contextLoads() {
    }

}
