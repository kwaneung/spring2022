package com.kwaneung.apiserv.user.controller;

import com.kwaneung.apiserv.user.dto.UserInfoDto;
import com.kwaneung.apiserv.user.service.TestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class TestController {
    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/name")
    ResponseEntity<?> getHelloWorld(@RequestParam(required = false) String name){
        return new ResponseEntity<>(testService.myName(name), HttpStatus.OK);
    }

    @PostMapping("/age/{age}")
    ResponseEntity<?> postHelloWorld(@PathVariable("age") Integer age){
        return new ResponseEntity<>(testService.myAge(age),HttpStatus.OK);
    }

    @PutMapping("/info")
    ResponseEntity<?> putHelloWorld(@RequestBody UserInfoDto userInfoDto){
        return new ResponseEntity<>(testService.myInfo(userInfoDto),HttpStatus.OK);
    }

    @DeleteMapping("/name")
    ResponseEntity<?> deleteHelloWorld(@RequestHeader String address, @RequestBody UserInfoDto userInfoDto){
        return new ResponseEntity<>(testService.myInfoWithaddress(address, userInfoDto),HttpStatus.OK);
    }
}
