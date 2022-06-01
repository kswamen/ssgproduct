package com.ssg.ssgproduct.controller;

import com.ssg.ssgproduct.domain.user.dtos.UserDeleteRequestDto;
import com.ssg.ssgproduct.domain.user.dtos.UserGetRequestDto;
import com.ssg.ssgproduct.domain.user.dtos.UserPostRequestDto;
import com.ssg.ssgproduct.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @GetMapping("")
    public ResponseEntity<Object> readUser(@RequestBody UserGetRequestDto userGetDto) {
        return userService.find(userGetDto);
    }

    @PostMapping("")
    public ResponseEntity<Object> createUser(@RequestBody UserPostRequestDto userPostDto) {
        userPostDto.convert();
        return userService.save(userPostDto);
    }

    @DeleteMapping("")
    public ResponseEntity<Object> deleteUser(@RequestBody UserDeleteRequestDto userDeleteDto) {
        return userService.delete(userDeleteDto);
    }
}
