package com.xu.service;

import java.util.Collection;


public interface PermissionService {
    Collection<String> queryPermissionByUserId(Integer userId);
}
