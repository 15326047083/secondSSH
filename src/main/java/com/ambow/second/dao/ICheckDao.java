package com.ambow.second.dao;


import com.ambow.second.entity.Check;
import com.ambow.second.vo.CheckVo;

import java.util.List;

public interface ICheckDao extends ICommonDao<Check> {
    /**
     * 根据UserID查找查看考勤
     * @param id UserId
     * @return 考情
     */
    List<CheckVo> getByCheckVoId(String id);

    /**
     * 查找全部考勤列表
     * @return 考勤列表
     */
    List<CheckVo> queryCheckVoAll(String sql,int index);

    /**
     * 根据UserId 和 CourseId查询 考勤记录
     * @param check
     * @return
     */
    Check getByUserIdAndCourseId(Check check);

    /**
     * 根据ID查找vo类
     * @param id
     * @return
     */
    CheckVo getById(String id);
    /**
     * 模糊查询
     * @param str
     * @return
     */
    List fuzzyQuery(String str,int index);

    /**
     * 模糊查询(教师）
     * @param str
     * @return
     */
    List<CheckVo> fuzzyQueryOfTeacher(String str,String teacherId,int index);

    /**
     * 统计条目
     * @return
     */
    long countVo();

    /**
     * 统计条目(模糊)
     * @return
     */
    long fuzzyCountVo(String str);

    /**
     * 教师统计条目
     * @return
     */
    long countVoOfTeacher(String teacherId);
    long fuzzyCountVoOfTeacher(String str, String teacherId);
}
