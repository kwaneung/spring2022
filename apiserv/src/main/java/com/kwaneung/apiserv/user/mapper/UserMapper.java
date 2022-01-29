package com.kwaneung.apiserv.user.mapper;

import com.kwaneung.apiserv.user.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<UserDto> selectUserList();
}
