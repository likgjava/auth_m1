package com.likg.auth.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.likg.auth.domain.Page;
import com.likg.auth.domain.User;

@Repository
public class UserMapper extends BaseDao {
	
	public User getUser(int id) throws Exception {
		return this.getSqlSession().selectOne("com.likg.auth.dao.UserMapper.selectUser", id);
	}

	public List<User> getUserList() throws Exception {
		return this.getSqlSession().selectList("com.likg.auth.dao.UserMapper.selectList");
	}
	
	public void saveUser(User user) throws Exception {
		//新增
		if(user.getId() == 0) {
			this.getSqlSession().insert("com.likg.auth.dao.UserMapper.insertUser", user);
			
			for(int i=0; i<50; i++) {
				Map<String, Object> param = new HashMap<String, Object>();
				param.put("userId", user.getId());
				param.put("UserId", i+1);
				this.getSqlSession().insert("com.likg.auth.dao.UserMapper.saveUserUser", param);
			}
		}
		//修改
		else {
			this.getSqlSession().update("com.likg.auth.dao.UserMapper.updateUser", user);
		}
	}

	public void delete(int id) throws Exception {
		this.getSqlSession().delete("com.likg.auth.dao.UserMapper.deleteUser", id);
	}

	public Page<User> getPage(Page<User> UserPage, User User) throws Exception {
		Integer totalCount = this.getCount(User);
		UserPage.setTotal(totalCount);
		if(totalCount > 0) {
			RowBounds rowBounds = new RowBounds(UserPage.getIndex(), UserPage.getPageSize());
			List<User> UserList = this.getSqlSession().selectList("com.likg.auth.dao.UserMapper.getPage", User, rowBounds);
			UserPage.setRows(UserList);
		}
		return UserPage;
	}


	public Integer getCount(User User) throws Exception {
		return this.getSqlSession().selectOne("com.likg.auth.dao.UserMapper.getCount", User);
	}
	



	
}
