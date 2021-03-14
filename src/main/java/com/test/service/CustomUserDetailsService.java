package com.test.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.test.Mapper.UserMapper;
import com.test.entity.RoleEntity;
import com.test.entity.UserEntity;
import com.test.entity.UserRoleEntity;
import com.test.exception.BaseException;

@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UserMapper userMapper;
	@Override
	public UserDetails loadUserByUsername(String username) {
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		UserEntity user = userMapper.findbyusernamefromuser(username);// 从数据库中取出用户信息
		System.err.println("user:"+user);
		if (user == null) {// 判断用户是否存在
			try {
				throw new BaseException("用户名不存在");
			} catch (BaseException e) {
				e.printStackTrace();
			}
		}
		// 添加权限
		List<UserRoleEntity> userRoles = userMapper.findbyuidfromuserrole(user.getId());
		for (UserRoleEntity userRole : userRoles) {
			RoleEntity role = userMapper.findbyidfromrole(userRole.getRid());
			authorities.add(new SimpleGrantedAuthority(role.getRolename()));
		}
		// 返回UserDetails实现类
		return new User(user.getUsername(), user.getPassword(), authorities);
	}
}
