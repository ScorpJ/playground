package com.arthur.mmall.dao;

import com.arthur.mmall.MmallApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = MmallApplication.class)
public class CategoryMapperTest {

    @Autowired
    private CategoryMapper categoryMaper;

    @Test
    public void selectCategoryChildrenByParentId() {
        categoryMaper.selectCategoryChildrenByParentId(0);
    }
}