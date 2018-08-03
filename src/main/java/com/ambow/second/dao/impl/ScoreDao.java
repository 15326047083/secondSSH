package com.ambow.second.dao.impl;

import com.ambow.second.dao.IScoreDao;
import com.ambow.second.entity.Course;
import com.ambow.second.entity.Score;
import com.ambow.second.entity.User;
import com.ambow.second.vo.ScoreVo;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class ScoreDao extends CommonDao<Score> implements IScoreDao {
    @Autowired
    private SessionFactory sessionFactory;


    final int num = 10;        // 一页显示的数目

    /**
     * 根据用户 ID查询成绩
     *
     * @param userId
     * @return
     */

    @Override
    @Transactional
    public List<ScoreVo> getScoreByuserId(String userId) {

        Query query = sessionFactory.getCurrentSession().createQuery("select new com.ambow.second.vo.ScoreVo(c.id as courseId,c.name as courseName,c.teacherId as teacherId,u.name as userName,s.id as scoreId,s.score as score,c.lessons as courseLessons  ) from Score s,User u,Course c  " +
                "where s.userId=u.id and s.courseId=c.id and u.id='" + userId + "'");


        return query.list();
    }


    /**
     * 根据教师Id查询成绩
     */
    @Override
    @Transactional
    public List<ScoreVo> getScoreByteacherId(String teacherid, int index) {

        Query query = sessionFactory.getCurrentSession().createQuery("select new com.ambow.second.vo.ScoreVo(c.id as courseId,c.name as courseName,c.teacherId as teacherId,u.name as userName,s.id as scoreId,s.score as score,c.lessons as courseLessons  ) from Score s,User u,Course c  " +
                "where s.userId=u.id and s.courseId=c.id and c.teacherId='" + teacherid + "'");
        query.setFirstResult((index - 1) * num);
        query.setMaxResults(num);

        return query.list();
    }

    /**
     * 管理员查询成绩
     */

    @Override
    @Transactional
    public List<ScoreVo> getScoreByadminId(int index) {

        Query query = sessionFactory.getCurrentSession().createQuery("select new com.ambow.second.vo.ScoreVo(c.id as courseId,c.name as courseName,c.teacherId as teacherId,u.name as userName,s.id as scoreId,s.score as score,c.lessons as courseLessons  ) from Score s,User u,Course c  " +
                "where s.userId=u.id and s.courseId=c.id ");
        query.setFirstResult((index - 1) * num);
        query.setMaxResults(num);

        return query.list();
    }


    /**
     * 添加前查出全部课程名
     *
     * @return
     */
    @Override
    @Transactional
    public List<User> getAllUser() {
        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }

    @Override
    @Transactional
    public List<Course> getAllCourse() {
        return sessionFactory.getCurrentSession().createQuery("from Course").list();
    }

    /**
     * 添加前查询
     */

    @Override
    @Transactional
    public Score savebefor(String userId,String courseId) {
        return (Score) sessionFactory.getCurrentSession().createQuery("from Score where userId='"+ userId +"' and  courseId='"+ courseId +"' ").uniqueResult();
    }

    /**
     * 管理员模糊查询
     */

    @Override
    @Transactional
    public List<ScoreVo> getScoredBylike(String like) {


        return sessionFactory.getCurrentSession().createQuery("select new com.ambow.second.vo.ScoreVo(c.id as courseId,c.name as courseName,c.teacherId as teacherId,u.name as userName,s.id as scoreId,s.score as score,c.lessons as courseLessons  ) from Score s,User u,Course c  " +
                "where s.userId=u.id and s.courseId=c.id and (u.num like'%" + like + "%' or u.name like '%" + like + "%' or c.name like'%" + like + "%')").list();
    }
    /**
     * 教师模糊查询
     */
    @Override
    @Transactional
    public List<ScoreVo> getScoredByteacherike(String tescherId,String like) {

        return sessionFactory.getCurrentSession().createQuery("select new com.ambow.second.vo.ScoreVo(c.id as courseId,c.name as courseName,c.teacherId as teacherId,u.name as userName,s.id as scoreId,s.score as score,c.lessons as courseLessons  ) from Score s,User u,Course c  " +
                "where s.userId=u.id and s.courseId=c.id and c.teacherId='"+ tescherId+"'and (u.num like'%" + like + "%' or u.name like '%" + like + "%' or c.name like'%" + like + "%')").list();
    }


    /**
     * 统计管理员查看成绩的个数
     *
     * @return
     */
    @Override
    @Transactional
    public long countScoreVo() {
        String sql = "select count(*) from Score s,User u,Course c  where s.userId=u.id and s.courseId=c.id ";
        return (long) sessionFactory.getCurrentSession().createQuery(sql).uniqueResult();

    }

    /**
     * 统计老师查看成绩的个数
     */
    @Override
    @Transactional
    public long countScoreVoByteacher(String teacherId) {
        String sql = "select count(*) from Score s,User u,Course c  where s.userId=u.id and s.courseId=c.id and c.teacherId='"+teacherId+"' ";
        return (long) sessionFactory.getCurrentSession().createQuery(sql).uniqueResult();

    }

}