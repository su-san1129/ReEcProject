package com.example.ReEcProject.controller;

import com.example.ReEcProject.domain.LoginUser;
import com.example.ReEcProject.domain.User;
import com.example.ReEcProject.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class UserControllerTest {

    private MockMvc mvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserController controller;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private ObjectMapper mapper;

    LoginUser loginUser;

    @BeforeEach
    void setUp() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(SecurityMockMvcConfigurers.springSecurity())
                .build();
        final var authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        User user = User.builder()
                .id(1000)
                .name("admin")
                .email("test@test.co.jp")
                .telephone("xxx-xxxx-xxxx")
                .address("tokyo")
                .password("password")
                .build();
        System.out.println("user = " + user);
        loginUser = new LoginUser(user, authorities);
    }


    /** ログインエラー */
    @Test
    void indexTestNoLoginUser() throws Throwable{
        mvc.perform(get(RequestPath.USER_PATH))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    void indexTestWithLoginUser() throws Throwable{
        final var users = (List<User>) userRepository.findAll();
        mvc.perform(get(RequestPath.USER_PATH)
                .with(user(loginUser))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
        assertEquals(2, users.size());
    }

}