package com.ambow.second.dao.impl;

import com.ambow.second.dao.ICourseDao;
import com.ambow.second.entity.Course;
import org.springframework.stereotype.Repository;

@Repository
public class CourseDao extends CommonDao<Course> implements ICourseDao {
}
