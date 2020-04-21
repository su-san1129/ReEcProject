package com.example.ReEcProject.controller;

import com.example.ReEcProject.domain.User;
import com.example.ReEcProject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(RequestPath.USER_PATH)
public class UserController {

    private final UserRepository userRepository;

    @GetMapping
    public  List<User> index(){
        return (List<User>) userRepository.findAll();
    }

}
