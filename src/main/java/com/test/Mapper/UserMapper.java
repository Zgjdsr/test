package com.test.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.test.entity.RoleEntity;
import com.test.entity.UserEntity;
import com.test.entity.UserRoleEntity;

@Mapper
public interface UserMapper {
	UserEntity findbyusernamefromuser(String username);
	RoleEntity findbyidfromrole(int id);
	List<UserRoleEntity> findbyuidfromuserrole(int uid);
}
