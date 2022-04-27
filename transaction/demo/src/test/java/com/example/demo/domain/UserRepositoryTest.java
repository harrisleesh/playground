package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Slf4j
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    @Transactional
    void save(){
        User harris = new User("harris");

        userRepository.save(harris);
        log.info("commit");
        entityManager.flush();
        entityManager.clear();

        User user = entityManager.find(User.class, harris.getId());
//        User user = entityManager.getReference(User.class, harris.getId());
        log.info("sout");
        System.out.println(user.getClass());
        entityManager.flush();
        entityManager.clear();

        System.out.println(user.getUserName());
        log.info("finish");
    }

}