package com.example.mobilego;

import com.alibaba.fastjson.JSONObject;
import com.example.mobilego.entity.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;

/**
 * @author： ygl
 * @date： 2018/3/16-13:56
 * @Description：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductControllerTest {


    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }


    @Test
    public void saveSuccess() throws Exception{
        Product product = new Product();
        product.setName("优乐美");
        product.setDescription("2018新上市，新口味，新期待，为了最优秀的你。");
        product.setMajorImgUrl("http://s15.sinaimg.cn/bmiddle/61fc0698hbe9d92c84cde&690");
        product.setMinorImgUrls("http://s15.sinaimg.cn/bmiddle/61fc0698hbe9d92c84cde&690");
        product.setPrice(new BigDecimal("6.8"));
        String content = JSONObject.toJSONString(product);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/product")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(content))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
    }


}
