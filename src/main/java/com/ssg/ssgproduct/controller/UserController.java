package com.ssg.ssgproduct.controller;

import com.ssg.ssgproduct.domain.user.dtos.UserGetDto;
import com.ssg.ssgproduct.domain.user.dtos.UserPostDto;
import com.ssg.ssgproduct.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @GetMapping("")
    public Object readUser(@RequestBody UserGetDto userGetDto) {
        return userService.find(userGetDto);
    }

    @PostMapping("")
    public String createUser(@RequestBody UserPostDto userPostDto) {
        userPostDto.convert();
        userService.save(userPostDto);
        return "done!";
    }
}
