package com.example.webmvctest.service

import org.springframework.stereotype.Service

@Service
open class SampleService {
    fun sample(): String {
        return "sample-service-test"
    }
}