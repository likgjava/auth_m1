package com.likg.auth.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.likg.auth.dao.UserMapper;
import com.likg.auth.domain.Page;
import com.likg.auth.domain.User;

@Service
public class UserService {
	
	@Resource
	private UserMapper userMapper;

	
	public User getUser(int id) throws Exception {
		return userMapper.getUser(id);
	}
	
	public List<User> getUserList() throws Exception {
		return userMapper.getUserList();
	}

	public void saveUser(User User) throws Exception {
		userMapper.saveUser(User);
	}

	public void delete(int id) throws Exception {
		userMapper.delete(id);
	}

	public Page<User> getPage(Page<User> UserPage, User User) throws Exception {
		UserPage = userMapper.getPage(UserPage, User);
		return UserPage;
	}

}
