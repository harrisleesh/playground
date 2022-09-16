package com.example.webmvctest.controller

import com.example.webmvctest.service.SampleService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SampleController(
    val sampleService: SampleService
) {

    @GetMapping("/sample")
    fun sample(): String {
        return sampleService.sample()
    }
}