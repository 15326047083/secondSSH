package com.ambow.second.service.impl;

import com.ambow.second.dao.ICheckDao;
import com.ambow.second.entity.Check;
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
    public void setAbsNum(Check check) {
        checkDao.saveOrUpdate(check);

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
    public List<CheckVo> queryCheckVoAll(int index) {
        String sql="";
        return checkDao.queryCheckVoAll(sql,index);
    }

    /**
     * 查找全部考勤列表
     *
     * @param id 教师Id
     * @return
     */
    @Override
    public List<CheckVo> queryCheskVoAllByTeacherId(String id,int index) {
        String sql=" and o.teacherId="+id;
        return checkDao.queryCheckVoAll(sql,index);
    }

    /**
     * 判断是否可以新建
     * 如不可以新建，则返回考勤ID；
     * @param check
     * @return 考勤的ID
     */
    @Override
    public Check sava(Check check) {
        return checkDao.getByUserIdAndCourseId(check);

    }

    /**
     * 根据ID查找vo类
     *
     * @param id
     * @return
     */
    @Override
    public CheckVo getById(String id) {
        return checkDao.getById(id);
    }

    /**
     * 根据ID查找 check表全部信息
     *
     * @param id
     * @return
     */
    @Override
    public Check get(String id) {
        return checkDao.get(id);
    }

    /**
     * 模糊查询
     *
     * @param str
     * @return
     */
    @Override
    public List<CheckVo> fuzzyQuery(String str) {
        return checkDao.fuzzyQuery(str);
    }

    /**
     * 模糊查询(教师）
     *
     * @param str
     * @return
     */
    @Override
    public List<CheckVo> fuzzyQueryOfTeacher(String str,String teacherId) {
        return checkDao.fuzzyQueryOfTeacher(str,teacherId);
    }

    /**
     * 统计条目
     *
     * @return
     */
    @Override
    public long countVo() {
        return checkDao.countVo();
    }


}
