package com.ambow.second.service;

import com.ambow.second.vo.CheckVo;

import java.util.List;

public interface ICheckService {

    /**
     * 修改干部缺勤次数
     */
    void setAbsNum();

    /**
     * 根据UserID查找查看考勤
     * @param id UserId
     * @return 考情
     */
    CheckVo getByCheckVoId(String id);

    /**
     * 查找全部考勤列表
     * @return 考勤列表
     */
    List<CheckVo> queryCheckVoAll();
}
