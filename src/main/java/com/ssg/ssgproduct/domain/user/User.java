package com.ssg.ssgproduct.domain.user;

import com.ssg.ssgproduct.domain.user.dtos.UserResponseDto;
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
    private com.ssg.ssgproduct.domain.user.enums.UserType UserType;

//    @Enumerated(EnumType.STRING)
    @Convert(converter = UserStatConverter.class)
//    @Column
    private com.ssg.ssgproduct.domain.user.enums.UserStat UserStat;

    @Builder
    public User(Long userId, String userName, UserType userType, UserStat userStat) {
        UserId = userId;
        UserName = userName;
        UserType = userType;
        UserStat = userStat;
    }

    public UserResponseDto convertToResponseDto() {
        return UserResponseDto.builder()
                .userId(UserId)
                .userName(UserName)
                .userType(UserType.getUserTypeString())
                .userStat(UserStat.getUserStatString()).build();
    }
}
