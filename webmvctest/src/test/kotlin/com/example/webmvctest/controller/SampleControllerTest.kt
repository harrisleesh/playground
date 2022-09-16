package com.example.webmvctest.controller

import com.example.webmvctest.service.SampleService
import com.ninjasquad.springmockk.MockkBean
import io.kotest.core.spec.style.BehaviorSpec
import io.mockk.every
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@WebMvcTest
class SampleControllerTest(@Autowired val mvc: MockMvc,
    @MockkBean val sampleService: SampleService
) : BehaviorSpec(){
//    @MockBean
//    lateinit var sampleService: SampleService
//    override fun beforeSpec(spec: Spec) {
//        MockKAnnotations.init(sampleService)
//    }

    init {
        Given("test"){
            every{sampleService.sample()} returns "sample-test"
            When("test"){
                println(sampleService)
//            every{sampleService.sample()} returns "sample-test"
                Then("test"){
                    mvc.get("/sample")
                        .andExpect {
                            status { isOk() }
                            content { string("sample-test") }
                        }
                }
            }
        }
    }
}
