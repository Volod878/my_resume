package ru.volod878.my_resume.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;



import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@Transactional
@SpringBootTest
public class MainControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void login() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/login"))
                .andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();
        int status = response.getStatus();

        assertEquals(200, status);
    }

    @Test
    void editorResumePage() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/editor/1"))
                .andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();
        int status = response.getStatus();

        assertEquals(200, status);
    }

    @Test
    void shouldUpdateStack() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("id","1");
        params.add("idStack","5");
        params.add("name", "Java");
        MvcResult msg = mockMvc.perform(MockMvcRequestBuilders.put("/editor/1/stack").params(params))
                .andReturn();
        assertEquals(302,msg.getResponse().getStatus());
    }

    @Test
    void shouldDeletedStack() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("id","1");
        params.add("idStack","5");
        MvcResult msg = mockMvc
                .perform(MockMvcRequestBuilders.delete("/editor/1/stack").params(params))
                .andReturn();
        assertEquals(302, msg.getResponse().getStatus());
    }
}