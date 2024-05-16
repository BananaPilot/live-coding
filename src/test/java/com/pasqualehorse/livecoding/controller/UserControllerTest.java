package com.pasqualehorse.livecoding.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pasqualehorse.livecoding.controller.dto.BaseResponse;
import com.pasqualehorse.livecoding.controller.dto.WithIdResponseDto;
import com.pasqualehorse.livecoding.entity.User;
import com.pasqualehorse.livecoding.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    MockMvc mock;

    @Autowired
    UserController userController;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    UserRepository userRepository;

    @Test
    public void postUser() throws Exception {
        userRepository.deleteAll();
        User user = new User("AAAAA", "AAAA@AAAA", "1234");

        this.mock.perform(post("/user/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user))
        )
                .andDo(print())
                .andExpect(status().is(201))
                .andExpect(result -> {
                    WithIdResponseDto userOut = objectMapper.readValue(result.getResponse().getContentAsString(), WithIdResponseDto.class);
                    Assertions.assertNotNull(userOut.getId());
                });
    }
    @Test
    public void postUser_testUserNameCanNotBeDuplicate() throws Exception {
        userRepository.deleteAll();
        User user1 = new User("AAAAA", "AAAA@AAAA", "1234");
        User user2 = new User("BBBBB", "AAAA@AAAA", "9874");

        this.mock.perform(post("/user/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user1))).andDo(print()).andReturn();
        MvcResult res = this.mock.perform(post("/user/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user2))).andDo(print()).andExpect(status().is(409)).andReturn();
        BaseResponse baseResponse = objectMapper.readValue(res.getResponse().getContentAsString(), BaseResponse.class);
        assertFalse(baseResponse.getErrorMessage().isEmpty(), "Email già presente");
    }

    @Test
    public void testAddUser() throws Exception{
        userRepository.deleteAll();
        User user1 = new User("willo", "willo@gmail.com", "1234");
        //chiamo l endpoint
        MockHttpServletResponse response = this.mock.perform(post("/user/add")
                //tipo di media json
                .contentType(MediaType.APPLICATION_JSON)
                //conversione dell oggetto in jason
                .content(objectMapper.writeValueAsString(user1))).andReturn().getResponse();

        assertEquals(201,response.getStatus());

        WithIdResponseDto withIdResponseDto = objectMapper.readValue(response.getContentAsString(),WithIdResponseDto.class);
        assertNotNull(withIdResponseDto.getId());

        byte[] bytes = Files.readAllBytes(Paths.get("C:\\Users\\Gianni\\OneDrive\\Documenti\\develhope\\Spring\\live-coding\\src\\test\\resources\\gattino.JPG"));

        MockMultipartFile gattino = new MockMultipartFile("file","gattino.JPG","image/jpeg",bytes);

        MockHttpServletResponse gattinoResponse = this.mock.perform(MockMvcRequestBuilders.multipart("/user/"+ withIdResponseDto.getId() + "/add-picture")
                .file(gattino)).andReturn().getResponse();

        assertEquals(200,gattinoResponse.getStatus());

        MockHttpServletResponse finalResponseJack = this.mock.perform(get("/user/"+ withIdResponseDto.getId() +"/download")).andReturn().getResponse();
        assertEquals(200,finalResponseJack.getStatus());
    }
}