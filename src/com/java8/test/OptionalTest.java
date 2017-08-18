package com.java8.test;

import java.util.Optional;

import com.java8.domain.Role;
import com.java8.domain.User;

public class OptionalTest {

	public static void main(String[] args) {
		User u = new User("Jack","123");
		Role role = new Role("管理员", "最高权限");
		u.setRole(role);
		String name = getName(u);
		System.out.println(name);
		
		Optional<User> user = Optional.ofNullable(u);
		user.ifPresent(System.out::println);
	}
	
	
	
	public static String getName(User u) {
//	    if (u == null)
//	        return "Unknown";
//	    return u.getName();

//		return Optional.ofNullable(u)
//				.map(user -> user.getName())
//				.orElse("unknow");
		
		return Optional.ofNullable(u)
				.map(c -> c.getRole())
				.map(r -> r.getName())
				.map(name -> name.toUpperCase())
				.orElse("unknown");
	}
}
