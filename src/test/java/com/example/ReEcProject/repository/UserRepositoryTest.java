package com.example.ReEcProject.repository;

import com.example.ReEcProject.domain.Item;
import com.example.ReEcProject.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class UserRepositoryTest {

    private final ItemRepository userRepository;

    UserRepositoryTest(ItemRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @BeforeEach
//    public void setUp(){
//    }

    @Test
    public void findAllTest(){
        Iterable<Item> all = userRepository.findAll();
        all.forEach(System.out::println);
    }

}