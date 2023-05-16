package com.foodfinder.oseek.controller.hello;


import com.foodfinder.oseek.dto.hello.HelloWorldResDto;
import com.foodfinder.oseek.dto.hello.HelloWorldReqDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {


    @GetMapping("/hello")
    public String getHelloWorld(){
        return "helloworld";
    }

    @PostMapping("/hello")
    public HelloWorldReqDto createHelloWorld(@RequestBody HelloWorldResDto helloWorldResDto){

        HelloWorldReqDto helloWorldReqDto = new HelloWorldReqDto();
        helloWorldReqDto.setHelloMessage("resultHello");

        return helloWorldReqDto;
    }


}
