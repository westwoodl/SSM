package com.xu.service;

import java.util.Collection;
import java.util.List;

public interface RoleService {
    /**
     * 根据
     */
    Collection<String> queryRoleByUserId(Integer userId);
}
