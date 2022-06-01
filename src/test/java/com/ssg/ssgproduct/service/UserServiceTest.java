package com.ssg.ssgproduct.service;

import com.ssg.ssgproduct.domain.user.User;
import com.ssg.ssgproduct.domain.user.UserRepository;
import com.ssg.ssgproduct.domain.user.dtos.UserDeleteRequestDto;
import com.ssg.ssgproduct.domain.user.dtos.UserPostRequestDto;
import com.ssg.ssgproduct.domain.user.enums.UserStat;
import com.ssg.ssgproduct.domain.user.enums.UserType;
import com.ssg.ssgproduct.service.UserService;
import com.ssg.ssgproduct.util.CustomResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    @DisplayName("Service - 유저 생성")
    public void save() {
        // given
        User user = createUser();
        when(userRepository.save(any())).thenReturn(user);

        // when
        ResponseEntity<Object> result = userService.save(createUserDto());

        // then
        verify(userRepository, times(1)).save(any());
        assertThat(result, equalTo(CustomResponse.create("OK", HttpStatus.OK, user)));
    }

    @Test
    @DisplayName("Service - 유저 삭제")
    public void delete() {
        // given
        UserDeleteRequestDto userDeleteRequestDto = new UserDeleteRequestDto(1L);
        User user = createUser();
        when(userRepository.findById(any())).thenReturn(Optional.ofNullable(user));

        // when
        ResponseEntity<Object> result = userService.delete(userDeleteRequestDto);

        // then
        verify(userRepository, times(1)).delete(any());
        assertThat(result, equalTo(CustomResponse.create("OK", HttpStatus.OK, userDeleteRequestDto)));
    }


    private User createUser() {
        return User.builder()
//                .userId(1L)
                .userName("김석원")
                .userStat(UserStat.NORMAL)
                .userType(UserType.NORMAL)
                .build();
    }

    private UserPostRequestDto createUserDto() {
        return UserPostRequestDto.builder()
                .userName("김석원")
                .userType("일반")
                .userStat("정상")
                .build();
    }
}