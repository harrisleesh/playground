package com.example.demo.txtest;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class TxController {

    private final TxService txService;

    @GetMapping("/txtest")
    String txtest() {
        return "txsuccess";
    }

    @GetMapping("/save")
    String save() throws IOException {
        txService.insertUser();
        return "save success";
    }

    @GetMapping("/save-with-tx")
    String txsave() throws IOException {
        txService.txInsertUser();
        return "save success";
    }
}
