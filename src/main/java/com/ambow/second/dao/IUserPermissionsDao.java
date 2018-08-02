package com.ambow.second.dao;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IUserPermissionsDao {
    List<String> getByRoles(String roles);
}
