package com.example.userservice;

import org.apache.commons.collections4.ListUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class UserServiceApplicationTests {

    @Test
    void contextLoads() {
        List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        List<List<Integer>> partition = ListUtils.partition(ints, 15);
        for (List<Integer> p : partition) {
            System.out.println(p);
        }
    }

}
