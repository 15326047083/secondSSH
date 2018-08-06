package com.ambow.second.dao.impl;

import com.ambow.second.dao.ICheckDao;
import com.ambow.second.entity.Check;
import com.ambow.second.vo.CheckVo;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CheckDao extends CommonDao<Check> implements ICheckDao {
    @Autowired
    private SessionFactory sessionFactory;

    final int num=10;        // 一页显示的数目
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
    public List<CheckVo> queryCheckVoAll(String addsql,int index) {
        String sql="select new com.ambow.second.vo.CheckVo(c.id as checkId,u.id as userId,u.name as userName,u.num as num,u.deptId as deptName,c.time as time,o.id as courseId,o.name as courseName,c.info as info,c.num as absNum) from Check c,User u,Course o where c.userId=u.id and c.courseId=o.id"+addsql;

        Query query=sessionFactory.getCurrentSession().createQuery(sql);
        query.setFirstResult((index-1)*num);
        query.setMaxResults(num);
        return query.list();

    }

    /**
     * 根据UserId 和 CourseId查询 考勤记录
     *
     * @param check
     * @return
     */
    @Override
    @Transactional
    public Check getByUserIdAndCourseId(Check check) {
        String sql="from Check where userId='"+check.getUserId()+"' and courseId='"+check.getCourseId()+"'";
        return (Check) sessionFactory.getCurrentSession().createQuery(sql).uniqueResult();
    }

    /**
     * 根据ID查找vo类
     *
     * @param id
     * @return
     */
    @Override
    @Transactional
    public CheckVo getById(String id) {
        String sql="select new com.ambow.second.vo.CheckVo(c.id as checkId,u.id as userId,u.name as userName,u.num as num,u.deptId as deptName,c.time as time,o.id as courseId,o.name as courseName,c.info as info,c.num as absNum) from Check c,User u,Course o where c.userId=u.id and c.courseId=o.id and c.id='"+id+"'";

        return (CheckVo) sessionFactory.getCurrentSession().createQuery(sql).uniqueResult();

    }

    /**
     * 模糊查询
     *
     * @param str
     * @return
     */
    @Override
    @Transactional
    public List<CheckVo> fuzzyQuery(String str,int index) {

        String sql="select new com.ambow.second.vo.CheckVo(c.id as checkId,u.id as userId,u.name as userName,u.num as" +
                " num,u.deptId as deptName,c.time as time,o.id as courseId,o.name as courseName,c.info as info,c.num " +
                "as absNum) from Check c,User u,Course o where c.userId=u.id and c.courseId=o.id and(u.name  like '%"+str+"%' or o.name like '%"+str+"%' or u.num like '%"+str+"%')";
        Query query=sessionFactory.getCurrentSession().createQuery(sql);
        query.setFirstResult((index-1)*num);
        query.setMaxResults(num);
        return query.list();
    }

    /**
     * 模糊查询(教师）
     *
     * @param str
     * @return
     */
    @Override
    @Transactional
    public List<CheckVo> fuzzyQueryOfTeacher(String str,String teacherId,int index) {
        String sql="select new com.ambow.second.vo.CheckVo(c.id as checkId,u.id as userId,u.name as userName,u.num as" +
                " num,u.deptId as deptName,c.time as time,o.id as courseId,o.name as courseName,c.info as info,c.num " +
                "as absNum) from Check c,User u,Course o where c.userId=u.id and c.courseId=o.id and o.teacherId='"+teacherId+"' and(u.name  like '%"+str+"%' or o.name like '%"+str+"%' or u.num like '%"+str+"%')";
        Query query=sessionFactory.getCurrentSession().createQuery(sql);
        query.setFirstResult((index-1)*num);
        query.setMaxResults(num);
        return query.list();
    }

    /**
     * 统计条目
     *
     * @return
     */
    @Override
    @Transactional
    public long countVo() {
        String sql="select count(*) from Check c,User u,Course o where c.userId=u.id and c.courseId=o.id";
        return (long) sessionFactory.getCurrentSession().createQuery(sql).uniqueResult();

    }

    /**
     * 统计条目(模糊)
     *
     * @return
     */
    @Override
    @Transactional
    public long fuzzyCountVo(String str) {
        String sql="select count(*) from Check c,User u,Course o where c.userId=u.id and c.courseId=o.id and(u.name like '%"+str+"%' or o.name like '%"+str+"%' or u.num like '%"+str+"%')";
        return (long) sessionFactory.getCurrentSession().createQuery(sql).uniqueResult();
    }

    /**
     * 教师统计条目
     *
     * @param teacherId
     * @return
     */
    @Override
    @Transactional
    public long countVoOfTeacher(String teacherId) {
        String sql="select count(*) from Check c,User u,Course o where c.userId=u.id and c.courseId=o.id where c.teacherId='"+teacherId+"'";
        return (long) sessionFactory.getCurrentSession().createQuery(sql).uniqueResult();
    }

    @Override
    @Transactional
    public long fuzzyCountVoOfTeacher(String str, String teacherId) {
        String sql="select count(*) from Check c,User u,Course o where c.userId=u.id and c.courseId=o.id and o.teacherId='"+teacherId+"' and(u.name like '%"+str+"%' or o.name like '%"+str+"%' or u.num like '%"+str+"%')";
        return (long) sessionFactory.getCurrentSession().createQuery(sql).uniqueResult();
    }

}
