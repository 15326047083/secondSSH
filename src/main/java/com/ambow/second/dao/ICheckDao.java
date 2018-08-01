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
    List<CheckVo> queryCheckVoAll(String sql);


}
