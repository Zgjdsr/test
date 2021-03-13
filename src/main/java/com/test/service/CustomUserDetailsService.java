package com.test.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.test.Mapper.UserMapper;
import com.test.entity.User;
import com.test.exception.BaseException;

@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UserMapper userMapper;

	@Override
	    public UserDetails loadUserByUsername(String username) {
	        Collection<GrantedAuthority> authorities = new ArrayList<>();
	        // 从数据库中取出用户信息
	        User user = userMapper.findbyusernamefromuser();
	        // 判断用户是否存在
	        if(user == null) {
	            throw new BaseException("用户名不存在");
	        }
	        // 添加权限
	        List<SysUserRole> userRoles = userRoleService.listByUserId(user.getId());
	        for (SysUserRole userRole : userRoles) {
	            SysRole role = roleService.selectById(userRole.getRoleId());
	            authorities.add(new SimpleGrantedAuthority(role.getName()));
	        }

	        // 返回UserDetails实现类
	        return new User(user.getName(), user.getPassword(), authorities);
	    }
