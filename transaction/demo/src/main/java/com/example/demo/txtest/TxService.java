package com.example.demo.txtest;

import com.example.demo.domain.User;
import com.example.demo.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Slf4j
public class TxService {
    private final UserRepository userRepository;
    private final TxInnerService txInnerService;

    @Transactional
    void insertUser() throws IOException {
        User harris = new User("harris");
        userRepository.save(harris);
    }

    @Transactional
    public void txInsertUser() throws IOException {
//        txInnerService.throwRuntimeException();

//        User harris = new User(111L, "harris");
//        User save = userRepository.save(harris);
//        throw new RuntimeException();
//        try {
            txInnerService.throwRuntimeException();
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw new RuntimeException();
//        }
//        throw new IOException();
    }

    @Transactional
    public void throwInMethod() {
        throw new RuntimeException("wtf");
    }

}
