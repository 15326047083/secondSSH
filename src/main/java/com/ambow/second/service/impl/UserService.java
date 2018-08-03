package com.ambow.second.service.impl;

import java.util.List;

import com.ambow.second.dao.ICheckDao;
import com.ambow.second.dao.IUserRolesDao;
import com.ambow.second.entity.UserRoles;
import com.ambow.second.vo.CheckVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ambow.second.dao.IUserDao;
import com.ambow.second.entity.User;
import com.ambow.second.service.IUserService;

import javax.management.Query;

@Service
public class UserService implements IUserService {

    //  注入userDao
    @Autowired
    private IUserDao userDao;
    //  注入checkDao
    @Autowired
    private ICheckDao checkDao;
    @Autowired
    private IUserRolesDao userRolesDao;

    /**
     * 分页查询所有用户
     *
     * @return
     */
    @Override
    public List<User> queryAll(int index) {
        // TODO Auto-generated method stub
        return userDao.queryAll(index);
    }

    /**
     * 查询全部
     *
     * @return
     */
    @Override
    public List<User> queryAll() {
        return userDao.queryAll();
    }

    /**
     * 根据Id查询用户
     *
     * @param user
     * @return
     */
    @Override
    public User findUserById(User user) {
        return userDao.get(user.getId());
    }

    /**
     * 新增或修改
     *
     * @param user
     * @return
     */

    @Override
    public String saveOrUpdate(User user) {
        if (user.getNum() == 0) {
            user.setNum((int) ((Math.random() * 9 + 1) * 100000));
            user.setPassword("123456");
        }
        if (user.getId() == null) {
            UserRoles userRoles = new UserRoles();
            switch (user.getUserType()) {
                case "管理员":
                    userRoles.setRoles("admin");
                    break;
                case "普通用户":
                    userRoles.setRoles("user");
                    break;
                case "老师":
                    userRoles.setRoles("teacher");
                    break;
            }
            userRoles.setUserNum(user.getNum() + "");
            userRolesDao.saveOrUpdate(userRoles);
        }
        return userDao.saveOrUpdate(user);
    }

    /**
     * 删除用户
     *
     * @param user
     */
    @Override
    public void delete(User user) {
        userDao.delete(user.getId());
    }

    /**
     * 根据考勤查询所有
     *
     * @return
     */

    @Override
    public List<CheckVo> queryCheckVoAll() {
        String sql = "";
        return null;
    }

    /**
     * 根据考勤查询
     *
     * @param id
     * @return
     */
    @Override
    public List<CheckVo> getByCheckVoId(String id) {

        return checkDao.getByCheckVoId(id);
    }

    /**
     * 删除用户信息
     *
     * @param user
     */
    @Override
    public void updateAlive(User user) {
        userDao.updateAlive(user);
    }

    /**
     * 模糊查询
     *
     * @param selectKey
     * @return
     */

    @Override
    public List<User> likeSelect(String selectKey) {
        return userDao.likeSelect(selectKey);
    }

    /**
     * 根据num查询
     *
     * @param num
     * @return
     */

    @Override
    public User getByNum(int num) {
        return userDao.getByNum(num);
    }
    /**
     * Excel表格导入插入方法
     * @param importList
     */
    @Override
    public void saveOrUpdate(List<User> importList) {
        for (User user: importList
        ) {
            userDao.saveOrUpdate(user);
        }
    }

}
