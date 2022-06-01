package com.ssg.ssgproduct.domain.user.dtos;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponseDto {
    public Long userId;
    public String userName;
    public String userType;
    public String userStat;
}
