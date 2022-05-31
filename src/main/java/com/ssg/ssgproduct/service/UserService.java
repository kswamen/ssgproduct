package com.ssg.ssgproduct.service;

import com.ssg.ssgproduct.domain.user.*;
import com.ssg.ssgproduct.domain.user.dtos.UserGetDto;
import com.ssg.ssgproduct.domain.user.dtos.UserPostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void save(UserPostDto userPostDto) {
        userRepository.save(User.builder()
                .userName(userPostDto.getUserName())
                .userType(userPostDto.getConvertedUserType())
                .userStat(userPostDto.getConvertedUserStat())
                .build());
    }

    public Object find(UserGetDto userGetDto) {
        User user = userRepository.findById(userGetDto.getUserId()).orElse(null);
        return user;
    }
}
