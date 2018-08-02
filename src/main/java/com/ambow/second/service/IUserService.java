package com.ambow.second.service;

import java.util.List;

import com.ambow.second.entity.User;
import com.ambow.second.vo.CheckVo;

public interface IUserService {
	// 查询所有的用户
	List<User> queryAll();
	// 根据用户ID查询用户
	User findUserById(User user);
    // 修改用户信息
	String saveOrUpdate(User user);
	// 物理删除用户
	void delete(User user);
	// 查询自己的考勤
	List<CheckVo> queryCheckVoAll();
	// 根据Id查考勤
	List<CheckVo> getByCheckVoId(String id);
	// 删除用户：修改用户alive状态   0为正常 1为删除
	void updateAlive(User user);
	// 模糊查询
	List<User> likeSelect(String selectKey);
    //  根据num查询
	User getByNum(int num);
}
