package com.kwaneung.apiserv.user.controller;

import com.kwaneung.apiserv.user.dto.UserDto;
import com.kwaneung.apiserv.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/test")
    public List<UserDto> getUserList() {
        return userService.getUserList();
    }

    @GetMapping("/name")
    ResponseEntity<?> getName(@RequestParam(required = false) String name){
        return new ResponseEntity<>(userService.myName(name), HttpStatus.OK);
    }

    @PostMapping("/age/{age}")
    ResponseEntity<?> postAge(@PathVariable("age") Integer age){
        return new ResponseEntity<>(userService.myAge(age),HttpStatus.OK);
    }

    @PutMapping("/info")
    ResponseEntity<?> putInfo(@RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.myInfo(userDto),HttpStatus.OK);
    }

    @DeleteMapping("/name")
    ResponseEntity<?> deleteAddInfo(@RequestHeader String address, @RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.myInfoWithaddress(address, userDto),HttpStatus.OK);
    }
}
