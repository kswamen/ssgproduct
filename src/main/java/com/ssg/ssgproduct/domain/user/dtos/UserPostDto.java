package com.ssg.ssgproduct.domain.user.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ssg.ssgproduct.domain.user.UserStat;
import com.ssg.ssgproduct.domain.user.UserType;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UserPostDto {
    public String userName;
    public String userType;
    public String userStat;

    public UserType convertedUserType;
    public UserStat convertedUserStat;

    public void convert() {
        convertedUserType = UserType.nameOf(userType);
        convertedUserStat = UserStat.nameOf(userStat);
    }
}
