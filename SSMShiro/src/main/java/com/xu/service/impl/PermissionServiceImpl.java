package com.xu.service.impl;

import com.xu.dao.PermissionMapper;
import com.xu.domain.Permission;
import com.xu.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper mapper;

    @Override
    public Collection<String> queryPermissionByUserId(Integer userId) {
        List<Permission> list = mapper.queryPermissionByUserId(userId);
        HashSet<String> perSet = new HashSet<>();
        for(Permission permission : list) {
            perSet.add(permission.getPercode());
        }
        return perSet;
    }
}
