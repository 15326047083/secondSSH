package com.ambow.second.service.impl;

import com.ambow.second.dao.ICheckDao;
import com.ambow.second.service.ICheckService;
import com.ambow.second.vo.CheckVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckService implements ICheckService {

    @Autowired
    private ICheckDao checkDao;

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
    public List<CheckVo> getByCheckVoId(String id) {

        return checkDao.getByCheckVoId(id);
    }

    /**
     * 查找全部考勤列表
     *
     * @return 考勤列表
     */
    @Override
    public List<CheckVo> queryCheckVoAll() {
        String sql="";
        return checkDao.queryCheckVoAll(sql);
    }

    /**
     * 查找全部考勤列表
     *
     * @param id 教师Id
     * @return
     */
    @Override
    public List<CheckVo> queryCheskVoAllByTeacherId(String id) {
        String sql=" and o.teacherId="+id;
        return checkDao.queryCheckVoAll(sql);
    }
}
