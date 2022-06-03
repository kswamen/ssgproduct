package com.ssg.ssgproduct.repository;

import com.ssg.ssgproduct.domain.customer.Customer;
import com.ssg.ssgproduct.domain.customer.CustomerRepository;
import com.ssg.ssgproduct.util.EntityCreator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;

import static com.ssg.ssgproduct.util.EntityCreator.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(locations = "classpath:application-test.properties")
class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    @DisplayName("Repository - 유저 생성")
    public void save() {
        // given
        Customer user = createUser();

        // when
        Customer result = customerRepository.save(user);

        // then
        assertThat(result, equalTo(user));
    }

    @Test
    @DisplayName("Repository - 유저 삭제")
    public void delete() {
        // given
        Customer user = createUser();

        // when
        customerRepository.save(user);
        customerRepository.delete(user);
        Optional<Customer> result = customerRepository.findById(user.getCustomerId());

        // then
        assertThat(result.isEmpty(), equalTo(true));
    }


}