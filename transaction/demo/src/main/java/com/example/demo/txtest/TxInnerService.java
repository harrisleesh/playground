package com.example.demo.txtest;

import com.example.demo.domain.User;
import com.example.demo.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class TxInnerService {
    private final UserRepository userRepository;

    @Transactional(rollbackFor = IOException.class)
    public void throwRuntimeException() throws IOException {
        User harris = new User(111L, "harris");
        User save = userRepository.save(harris);
//        try {
//            throw new RuntimeException("wtf");
//        } catch (RuntimeException e) {
//            e.printStackTrace();
//        }
        throw new IOException();
    }
}
