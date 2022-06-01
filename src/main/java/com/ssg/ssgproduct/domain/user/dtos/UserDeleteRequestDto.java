package com.ssg.ssgproduct.domain.user.dtos;

import com.ssg.ssgproduct.domain.user.User;
import com.ssg.ssgproduct.domain.user.enums.UserStat;
import com.ssg.ssgproduct.domain.user.enums.UserType;
import lombok.*;

@Getter
@Builder
@ToString
@AllArgsConstructor
public class UserDeleteRequestDto {
    public Long userId;
}
