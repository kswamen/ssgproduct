package com.ssg.ssgproduct.domain.user.dtos;

import com.ssg.ssgproduct.domain.user.User;
import com.ssg.ssgproduct.domain.user.enums.UserStat;
import com.ssg.ssgproduct.domain.user.enums.UserType;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserPostRequestDto {
    public String userName;
    public String userType;
    public String userStat;

    public UserType convertedUserType;
    public UserStat convertedUserStat;

    public void convert() {
        convertedUserType = UserType.nameOf(userType);
        convertedUserStat = UserStat.nameOf(userStat);
    }

    public User toEntity() {
//        convert();
        return User.builder()
                .userName(userName)
                .userType(convertedUserType)
                .userStat(convertedUserStat)
                .build();
    }
}
