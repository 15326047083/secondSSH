package com.ambow.second.dao.impl;

import com.ambow.second.dao.ICheckDao;
import com.ambow.second.entity.Check;
import org.springframework.stereotype.Repository;

@Repository
public class CheckDao extends CommonDao<Check> implements ICheckDao {
}
