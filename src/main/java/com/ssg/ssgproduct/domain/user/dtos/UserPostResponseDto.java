package com.ssg.ssgproduct.domain.user.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserPostResponseDto {
    public Long userId;
    public String userName;
    public String userType;
    public String userStat;
}
