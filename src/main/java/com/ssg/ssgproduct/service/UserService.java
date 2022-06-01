package com.ssg.ssgproduct.service;

import com.ssg.ssgproduct.domain.user.*;
import com.ssg.ssgproduct.domain.user.dtos.UserDeleteRequestDto;
import com.ssg.ssgproduct.domain.user.dtos.UserGetRequestDto;
import com.ssg.ssgproduct.domain.user.dtos.UserPostRequestDto;
import com.ssg.ssgproduct.util.CustomResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public ResponseEntity<Object> save(UserPostRequestDto userPostDto) {
        User user = userRepository.save(userPostDto.toEntity());
        return CustomResponse.create("OK", HttpStatus.OK, user.convertToResponseDto());
    }

    @Transactional
    public ResponseEntity<Object> delete(UserDeleteRequestDto userDeleteDto) {
        User user = userRepository.findById(userDeleteDto.getUserId()).orElseThrow();
        userRepository.delete(user);
        return CustomResponse.create("OK", HttpStatus.OK, userDeleteDto);
    }

    public ResponseEntity<Object> find(UserGetRequestDto userGetDto) {
        User user = userRepository.findById(userGetDto.getUserId()).orElseThrow();
        return CustomResponse.create("OK", HttpStatus.OK, user.convertToResponseDto());
    }
}
