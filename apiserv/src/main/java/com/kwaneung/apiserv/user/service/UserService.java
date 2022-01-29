package com.kwaneung.apiserv.user.service;

import com.kwaneung.apiserv.user.dto.UserDto;
import com.kwaneung.apiserv.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<UserDto> getUserList() {
        return userMapper.selectUserList();
    }

    public String myName(String name) {
        if (name != null) {
            return "my name is " + name;
        } else {
            return "name param is null";
        }
    }

    public String myAge(Integer age) {
        if (age != null) {
            return "my age is " + age;
        } else {
            return "age param is null";
        }
    }

    public String myRole(String role) {
        if (role != null) {
            return "my role is " + role;
        } else {
            return "role param is null";
        }
    }

    public String myInfo(UserDto userDto){
        userDto.setUser_name("test");
        return myName("name : " + userDto.getUser_name()) + "\nage : " + myAge(userDto.getUser_age()) + "\nrole : " + myRole(userDto.getUser_role());
    }

    public String myInfoWithaddress(String address, UserDto userDto){
        return myInfo(userDto) + "\naddress : " + address;
    }
}