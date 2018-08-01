package com.ambow.second.service;

import java.util.List;

import com.ambow.second.entity.User;
import com.ambow.second.vo.CheckVo;

public interface IUserService {

	List<User> queryAll();
	// 根据用户ID查询用户
	User findUserById(User user);
    // 修改用户信息
	String saveOrUpdate(User user);
	// 删除用户
	void delete(User user);
	// 查询自己的考勤
	List<CheckVo> queryCheckVoAll();
	// 根据Id查考勤
	List<CheckVo> getByCheckVoId(String id);
}
