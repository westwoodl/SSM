package com.xu.service.impl;

import com.xu.dao.RoleMapper;
import com.xu.domain.Role;
import com.xu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;


    @Override
    public Collection<String> queryRoleByUserId(Integer userId) {


        List<Role> roles = roleMapper.queryRoleByUserId(userId);
        HashSet<String> rolesStrings = new HashSet<>();
        for (Role role : roles) {
            rolesStrings.add(role.getRolename());
        }
        return rolesStrings;
    }
}
