package com.kwaneung.apiserv.controller;

import com.kwaneung.apiserv.dto.Info;
import com.kwaneung.apiserv.service.MainService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/main")
public class MainController {
    private final MainService mainService;

    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

//    localhost:8888/main/user?name=kwaneung
    @GetMapping("/user")
    ResponseEntity<?> getHelloWorld(@RequestParam(required = false) String name){
        System.out.println("[GET] /main/user");
        System.out.println("name : " + name);
        return new ResponseEntity<>(mainService.myName(name), HttpStatus.OK);
    }

//    localhost:8888/main/user/28
    @PostMapping("/user/{age}")
    ResponseEntity<?> postHelloWorld(@PathVariable("age") Integer age){
        System.out.println("[POST] /main/user");
        System.out.println("age : " + age);
        return new ResponseEntity<>(mainService.myAge(age),HttpStatus.OK);
    }

//    localhost:8888/main/user
//    body
//    {
//        "name": "kwaneung",
//        "age": 13
//    }
    @PutMapping("/user")
    ResponseEntity<?> putHelloWorld(@RequestBody Info info){
        System.out.println("[PUT] /main/user");
        System.out.println(info);
        return new ResponseEntity<>(mainService.myInfo(info),HttpStatus.OK);
    }

//    localhost:8888/main/user
//    header
//    role admin
//    body
//    {
//        "name": "kwaneung",
//            "age": 13
//    }
    @DeleteMapping("/user")
    ResponseEntity<?> deleteHelloWorld(@RequestHeader String role, @RequestBody Info info){
        System.out.println("[DELETE] /main/user");
        System.out.println(role);
        System.out.println(info);
        return new ResponseEntity<>(mainService.myInfoWithRole(role, info),HttpStatus.OK);
    }

}