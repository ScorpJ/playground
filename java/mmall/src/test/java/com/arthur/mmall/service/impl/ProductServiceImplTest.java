package com.arthur.mmall.service.impl;

import com.arthur.mmall.MmallApplication;
import com.arthur.mmall.common.ServerResponse;
import com.arthur.mmall.service.ProductService;
import com.arthur.mmall.vo.ProductListVo;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MmallApplication.class)
public class ProductServiceImplTest {

    @Autowired
    private ProductService productService;

    @Test
    public void getProductList() {

        ServerResponse<PageInfo> resp = productService.getProductList(2, 2);
        PageInfo pageInfo = resp.getData();
        List<ProductListVo> rtList = pageInfo.getList();
        assertThat(pageInfo.getTotal()).isEqualTo(4);
        assertThat(rtList.size()).isEqualTo(2);


    }

    @Test
    public void searchProduct1() {
        ServerResponse<PageInfo> resp = productService.searchProduct(null, 100002, 1, 2);
        PageInfo pageInfo = resp.getData();
        List<ProductListVo> rtList = pageInfo.getList();
        assertThat(pageInfo.getTotal()).isEqualTo(2);
        assertThat(rtList.size()).isEqualTo(2);
    }

    @Test
    public void searchProduct2() {
        ServerResponse<PageInfo> resp = productService.searchProduct("Huawei", 100002, 1, 2);
        PageInfo pageInfo = resp.getData();
        List<ProductListVo> rtList = pageInfo.getList();
        assertThat(pageInfo.getTotal()).isEqualTo(1);
        assertThat(rtList.size()).isEqualTo(1);
    }

    @Test
    public void searchProduct3() {
        ServerResponse<PageInfo> resp = productService.searchProduct("Huawei", null, 1, 2);
        PageInfo pageInfo = resp.getData();
        List<ProductListVo> rtList = pageInfo.getList();
        assertThat(pageInfo.getTotal()).isEqualTo(1);
        assertThat(rtList.size()).isEqualTo(1);
    }
}