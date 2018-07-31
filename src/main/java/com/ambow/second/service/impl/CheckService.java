package com.ambow.second.service.impl;

import com.ambow.second.service.ICheckService;
import com.ambow.second.vo.CheckVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckService implements ICheckService {

    /**
     * 修改干部缺勤次数
     */
    @Override
    public void setAbsNum() {

    }

    /**
     * 根据UserID查找查看考勤
     *
     * @param id UserId
     * @return 考情
     */
    @Override
    public CheckVo getByCheckVoId(String id) {
        return null;
    }

    /**
     * 查找全部考勤列表
     *
     * @return 考勤列表
     */
    @Override
    public List<CheckVo> queryCheckVoAll() {
        return null;
    }
}
