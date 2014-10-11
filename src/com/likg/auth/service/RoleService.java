package com.likg.auth.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.likg.auth.dao.RoleMapper;
import com.likg.auth.domain.Page;
import com.likg.auth.domain.Role;

@Service
public class RoleService {
	
	@Resource
	private RoleMapper roleMapper;

	public Role getRole(int id) throws Exception {
		return roleMapper.getRole(id);
	}
	
	public List<Role> getRoleList() throws Exception {
		return roleMapper.getRoleList();
	}

	public void saveRole(Role Role) throws Exception {
		roleMapper.saveRole(Role);
	}

	public void delete(int id) throws Exception {
		roleMapper.delete(id);
	}

	public Page<Role> getPage(Page<Role> rolePage, Role role) throws Exception {
		rolePage = roleMapper.getPage(rolePage, role);
		return rolePage;
	}
	
	

}
