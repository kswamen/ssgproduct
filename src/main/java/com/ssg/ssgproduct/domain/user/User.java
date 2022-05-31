package com.ssg.ssgproduct.domain.user;

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
    public User(String userName, UserType userType, UserStat userStat) {
        UserName = userName;
        UserType = userType;
        UserStat = userStat;
    }
}
