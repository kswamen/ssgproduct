package com.ssg.ssgproduct.domain.user;

import com.ssg.ssgproduct.domain.user.dtos.UserPostResponseDto;
import com.ssg.ssgproduct.domain.user.enums.UserStat;
import com.ssg.ssgproduct.domain.user.enums.UserStatConverter;
import com.ssg.ssgproduct.domain.user.enums.UserType;
import com.ssg.ssgproduct.domain.user.enums.UserTypeConverter;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UserId;

    @Column
    private String UserName;

//    @Enumerated(EnumType.STRING)
    @Convert(converter = UserTypeConverter.class)
//    @Column
    private UserType UserType;

//    @Enumerated(EnumType.STRING)
    @Convert(converter = UserStatConverter.class)
//    @Column
    private UserStat UserStat;

    @Builder
    public User(Long userId, String userName, UserType userType, UserStat userStat) {
        UserId = userId;
        UserName = userName;
        UserType = userType;
        UserStat = userStat;
    }

    public UserPostResponseDto convertToResponseDto() {
        return UserPostResponseDto.builder()
                .userId(UserId)
                .userName(UserName)
                .userType(UserType.getUserTypeString())
                .userStat(UserStat.getUserStatString()).build();
    }
}
