package com.likg.auth.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.likg.auth.domain.Page;
import com.likg.auth.domain.Role;

@Repository
public class RoleMapper extends BaseDao {
	
	public Role getRole(int id) throws Exception {
		return this.getSqlSession().selectOne("com.likg.auth.dao.RoleMapper.selectRole", id);
	}

	public List<Role> getRoleList() throws Exception {
		return this.getSqlSession().selectList("com.likg.auth.dao.RoleMapper.selectList");
	}
	
	public void saveRole(Role role) throws Exception {
		//新增
		if(role.getId() == 0) {
			this.getSqlSession().insert("com.likg.auth.dao.RoleMapper.insertRole", role);
		}
		//修改
		else {
			this.getSqlSession().update("com.likg.auth.dao.RoleMapper.updateRole", role);
		}
	}

	public void delete(int id) throws Exception {
		this.getSqlSession().delete("com.likg.auth.dao.RoleMapper.deleteRole", id);
	}

	public Page<Role> getPage(Page<Role> rolePage, Role role) throws Exception {
		Integer totalCount = this.getCount(role);
		rolePage.setTotal(totalCount);
		if(totalCount > 0) {
			RowBounds rowBounds = new RowBounds(rolePage.getIndex(), rolePage.getPageSize());
			List<Role> roleList = this.getSqlSession().selectList("com.likg.auth.dao.RoleMapper.getPage", role, rowBounds);
			rolePage.setRows(roleList);
		}
		return rolePage;
	}


	public Integer getCount(Role role) throws Exception {
		return this.getSqlSession().selectOne("com.likg.auth.dao.RoleMapper.getCount", role);
	}
	
}
