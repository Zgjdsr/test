package com.test.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	@RequestMapping("/")
	public String showHome() {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		System.err.println("name:" + name);
		return "home.html";
	}

	@RequestMapping("/login")
	public String showLogin() {
		return "login.html";
	}

	@RequestMapping("/admin")
	@ResponseBody
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String printAdmin() {
		return "如果你看见这句话，说明你有ROLE_ADMIN角色";
	}

	@RequestMapping("/user")
	@ResponseBody
	@PreAuthorize("hasRole('ROLE_USER')")
	public String printUser() {
		return "如果你看见这句话，说明你有ROLE_USER角色";
	}

	@RequestMapping("/login/error")
	public void loginError(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=utf-8");
		AuthenticationException exception = (AuthenticationException) request.getSession()
				.getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
		try {
			response.getWriter().write(exception.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
