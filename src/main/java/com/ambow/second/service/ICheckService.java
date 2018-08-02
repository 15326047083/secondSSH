package com.ambow.second.service;

import com.ambow.second.entity.Check;
import com.ambow.second.vo.CheckVo;

import java.util.List;

public interface ICheckService {

    /**
     * 修改干部缺勤次数
     */
    void setAbsNum(Check check);

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
    List<CheckVo> queryCheckVoAll(int index);

    /**
     * 查找全部考勤列表
     * @param id 教师Id
     * @return
     */
    List<CheckVo> queryCheskVoAllByTeacherId(String id,int index);

    /**
     * 判断是否可以新建
     * @param check
     * @return
     */
    Check sava(Check check);

    /**
     * 根据ID查找vo类
     * @param id
     * @return
     */
    CheckVo getById(String id);

    /**
     * 根据ID查找 check表全部信息
     * @param Id
     * @return
     */
    Check get(String id);

    /**
     * 模糊查询(管理员)
     * @param str
     * @return
     */
    List<CheckVo> fuzzyQuery(String str);

    /**
     * 模糊查询(教师）
     * @param str
     * @return
     */
    List<CheckVo> fuzzyQueryOfTeacher(String str,String teacherId);

    /**
     * 统计条目
     * @return
     */
    long countVo();
}
