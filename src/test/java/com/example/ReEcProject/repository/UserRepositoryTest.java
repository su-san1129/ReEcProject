package com.example.ReEcProject.repository;

import com.example.ReEcProject.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJdbcTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findAllTest(){
        List<User> users = (List<User>) userRepository.findAll();
        assertEquals(2, users.size());
    }

}