package com.example.ReEcProject.controller;

import com.example.ReEcProject.domain.User;
import com.example.ReEcProject.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class UserControllerTest {

    private MockMvc mvc;
    // private final LoginUser loginUser = new LoginUser(user.builder().build());

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserController controller;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private ObjectMapper mapper;

    @BeforeEach
    void setUp() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(SecurityMockMvcConfigurers.springSecurity())
                .build();
    }

    /** 認証エラーになるはず */
    @Test
    void indexTestNoLoginUser() throws Throwable{
        mvc.perform(get("/"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void indexTestWithLoginUser() throws Throwable{
        final var users = (List<User>) userRepository.findAll();
        final var s = mapper.writeValueAsString(users);
        System.out.println(s);
        mvc.perform(get("/").with(user("user"))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

}