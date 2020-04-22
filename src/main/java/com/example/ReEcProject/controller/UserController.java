package com.example.ReEcProject.controller;

import com.example.ReEcProject.domain.LoginUser;
import com.example.ReEcProject.domain.User;
import com.example.ReEcProject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    public  List<User> index(@AuthenticationPrincipal LoginUser loginUser){
        System.out.println(loginUser.getUser().getEmail());
        return (List<User>) userRepository.findAll();
    }

}
