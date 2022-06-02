package com.ssg.ssgproduct.repository;

import com.ssg.ssgproduct.domain.user.User;
import com.ssg.ssgproduct.domain.user.UserRepository;
import com.ssg.ssgproduct.domain.user.enums.UserStat;
import com.ssg.ssgproduct.domain.user.enums.UserType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("Repository - 유저 생성")
    public void save() {
        // given
        User user = createUser();

        // when
        User result = userRepository.save(user);

        // then
        assertThat(result, equalTo(user));
    }

    @Test
    @DisplayName("Repository - 유저 삭제")
    public void delete() {
        // given
        User user = createUser();

        // when
        userRepository.save(user);
        userRepository.delete(user);
        Optional<User> result = userRepository.findById(user.getUserId());

        // then
        assertThat(result.isEmpty(), equalTo(true));
    }

    private User createUser() {
        return User.builder()
//                .userId(1L)
                .userName("김석원")
                .userStat(UserStat.NORMAL)
                .userType(UserType.NORMAL)
                .build();
    }
}