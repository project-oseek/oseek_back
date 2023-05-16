package com.foodfinder.oseek.web;


import com.foodfinder.oseek.web.requestDto.HelloWorldRequest;
import com.foodfinder.oseek.web.responseDto.HelloWorldResponse;
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
    public HelloWorldResponse createHelloWorld(@RequestBody HelloWorldRequest helloWorldRequest){

        HelloWorldResponse helloWorldResponse = new HelloWorldResponse();
        helloWorldResponse.setHelloMessage("resultHello");

        return helloWorldResponse;
    }


}
