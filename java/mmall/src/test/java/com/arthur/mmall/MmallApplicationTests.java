package com.arthur.mmall;

import com.arthur.mmall.dao.CategoryMapperTest;
import com.arthur.mmall.dao.UserMapperTest;
import com.arthur.mmall.service.impl.ProductServiceImplTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Suite.class)
@SpringBootTest(classes = MmallApplication.class)
@Suite.SuiteClasses({UserMapperTest.class, CategoryMapperTest.class, ProductServiceImplTest.class})
public class MmallApplicationTests {

//    @Test
//    public void contextLoads() {
//    }

}
