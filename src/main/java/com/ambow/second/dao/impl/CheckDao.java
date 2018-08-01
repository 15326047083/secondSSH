package com.ambow.second.dao.impl;

import com.ambow.second.dao.ICheckDao;
import com.ambow.second.entity.Check;
import com.ambow.second.vo.CheckVo;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CheckDao extends CommonDao<Check> implements ICheckDao {
    @Autowired
    private SessionFactory sessionFactory;


    /**
     * 根据UserID查找查看考勤列表
     *
     * @param id UserId
     * @return 考情
     */
    @Override
    @Transactional
    public List<CheckVo> getByCheckVoId(String id) {
       
        String sql="select new com.ambow.second.vo.CheckVo(c.id as checkId,u.id as userId,u.name as userName,u.num as num,u.deptId as deptName,c.time as time,o.id as courseId,o.name as courseName,c.info as info,c.num as absNum) from Check c,User u,Course o where c.userId=u.id and c.courseId=o.id and u.id='"+id+"'";

        return (List<CheckVo>) sessionFactory.getCurrentSession().createQuery(sql).list();
    }

    /**
     * 查找全部考勤列表
     *
     * @return 考勤列表
     */
    @Override
    @Transactional
    public List<CheckVo> queryCheckVoAll(String addsql) {
        String sql="select new com.ambow.second.vo.CheckVo(c.id as checkId,u.id as userId,u.name as userName,u.num as num,u.deptId as deptName,c.time as time,o.id as courseId,o.name as courseName,c.info as info,c.num as absNum) from Check c,User u,Course o where c.userId=u.id and c.courseId=o.id"+addsql;

        return (List<CheckVo>) sessionFactory.getCurrentSession().createQuery(sql).list();

    }

}
