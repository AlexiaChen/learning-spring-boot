package com.mathxhspringboot.demo;

import com.mathxhspringboot.demo.component.ProjectProperties;
import com.mathxhspringboot.demo.web.HelloController;
import com.mathxhspringboot.demo.web.UserController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    private MockMvc mvc;


    @Autowired
    private ProjectProperties projectProperties;

    @Test
	public void contextLoads() {
	}

	@Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new HelloController(),
                new UserController()).build();

    }

    @Test
    public void getHello() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hello World")));
    }

    @Test
    public void testProjectProperties() throws  Exception {
        Assert.assertEquals(projectProperties.getTitle(),"Learning Spring Boot");
        Assert.assertEquals(projectProperties.getContent(),"Learning by doing guide");
    }


    @Test
    public void testUserController() throws  Exception {
        RequestBuilder request = null;

        request = MockMvcRequestBuilders.get("/users").accept(MediaType.APPLICATION_JSON);
        mvc.perform(request).andExpect(status().isOk()).
                andExpect(content().string(equalTo("[]")));

        request = MockMvcRequestBuilders.post("/users").accept(MediaType.APPLICATION_JSON)
                .param("id", "1")
                .param("name", "测试大师")
                .param("age", "20");

        mvc.perform(request)
                .andExpect(content().string(equalTo("success")));

        request = MockMvcRequestBuilders.get("/users").accept(MediaType.APPLICATION_JSON);
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"测试大师\",\"age\":20}]")));

        request = MockMvcRequestBuilders.put("/users/1").accept(MediaType.APPLICATION_JSON)
                .param("name", "测试终极大师")
                .param("age", "30");
        mvc.perform(request)
                .andExpect(content().string(equalTo("success")));

        request = MockMvcRequestBuilders.get("/users/1").accept(MediaType.APPLICATION_JSON);
        mvc.perform(request)
                .andExpect(content().string(equalTo("{\"id\":1,\"name\":\"测试终极大师\",\"age\":30}")));

        request = MockMvcRequestBuilders.delete("/users/1").accept(MediaType.APPLICATION_JSON);
        mvc.perform(request)
                .andExpect(content().string(equalTo("success")));

        request = MockMvcRequestBuilders.get("/users/").accept(MediaType.APPLICATION_JSON);
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));



    }

}
