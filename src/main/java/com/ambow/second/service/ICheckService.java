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
    List<CheckVo> queryCheckVoAll();

    /**
     * 查找全部考勤列表
     * @param id 教师Id
     * @return
     */
    List<CheckVo> queryCheskVoAllByTeacherId(String id);

}
