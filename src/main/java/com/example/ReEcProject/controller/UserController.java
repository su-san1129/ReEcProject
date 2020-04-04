package com.example.ReEcProject.controller;

import com.example.ReEcProject.domain.Item;
import com.example.ReEcProject.domain.User;
import com.example.ReEcProject.repository.ItemRepository;
import com.example.ReEcProject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final ItemRepository itemRepository;

    @GetMapping
    public String index(){
        Iterable<User> all = userRepository.findAll();
        all.forEach(System.out::println);
        return all.toString();
    }
}
