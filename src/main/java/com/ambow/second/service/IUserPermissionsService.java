package com.ambow.second.service;

import java.util.List;

public interface IUserPermissionsService {
    List<String> getByRoles(String str);
}
