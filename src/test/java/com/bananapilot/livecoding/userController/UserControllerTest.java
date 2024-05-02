package com.bananapilot.livecoding.userController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pasqualehorse.livecoding.controller.UserController;
import com.pasqualehorse.livecoding.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    UserController userController;
    @Autowired
    MockMvc mock;
    @Autowired
    ObjectMapper mapper;
    @Test
    public void testGet () throws Exception {
        User user = new User("vMunita", "vmunita@hotmail.it", "12345678" );
        ResultActions resultActions = this.mock.perform(
                post("/user/signin").content(mapper.writeValueAsString(user))
            );
        MvcResult mvcResult = resultActions.andReturn();
        User user1 = mapper.readValue(mvcResult.getResponse().getContentAsString(),User.class);
    }


}
