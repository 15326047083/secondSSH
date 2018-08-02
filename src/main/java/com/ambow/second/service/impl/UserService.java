package com.ambow.second.service.impl;

import java.util.List;

import com.ambow.second.dao.ICheckDao;
import com.ambow.second.vo.CheckVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ambow.second.dao.IUserDao;
import com.ambow.second.entity.User;
import com.ambow.second.service.IUserService;

import javax.management.Query;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserDao userDao;
    @Autowired
    private ICheckDao checkDao;

    @Override
    public List<User> queryAll() {
        // TODO Auto-generated method stub
        return userDao.queryAll();
    }
    @Override
    public User findUserById(User user){
        return userDao.get(user.getId());
    }

    @Override
    public String saveOrUpdate(User user) {
        return userDao.saveOrUpdate(user);
    }

    @Override
    public void delete(User user) {
        userDao.delete(user.getId());
    }

    @Override
    public List<CheckVo> queryCheckVoAll() {
        String sql="";
        return checkDao.queryCheckVoAll(sql);
    }
    @Override
    public List<CheckVo> getByCheckVoId(String id) {

        return checkDao.getByCheckVoId(id);
    }

    /**
     * 删除用户信息
     * @param user
     */
    @Override
    public void updateAlive(User user) {
        userDao.updateAlive(user);
    }

    /**
     * 模糊查询
     */

    @Override
    public List<User> likeSelect(String selectKey) {
        return null;
    }

    @Override
    public User getByNum(int num) {
        return userDao.getByNum(num);
    }

}
