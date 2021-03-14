package com.test.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.test.entity.RoleEntity;
import com.test.entity.UserEntity;
import com.test.entity.UserRoleEntity;

@Mapper
public interface UserMapper {
	//1
	UserEntity findbyusernamefromuser(String username);
	//2
	RoleEntity findbyidfromrole(int id);
	//3
	List<UserRoleEntity> findbyuidfromuserrole(int uid);
}
