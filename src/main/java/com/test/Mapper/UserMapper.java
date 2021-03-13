package com.test.Mapper;

import org.apache.ibatis.annotations.Mapper;

import com.test.entity.User;

@Mapper
public interface UserMapper {
	User findbyusernamefromuser();
}
