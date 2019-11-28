package com.xu.util;

import com.xu.domain.User;

import java.util.Collection;

public class ActiveUser {

    private User user;
    private Collection<String> roles;
    private Collection<String> permissions;

    public ActiveUser(User user, Collection<String> roles, Collection<String> permissions) {
        this.user = user;
        this.roles = roles;
        this.permissions = permissions;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Collection<String> getRoles() {
        return roles;
    }

    public void setRoles(Collection<String> roles) {
        this.roles = roles;
    }

    public Collection<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(Collection<String> permissions) {
        this.permissions = permissions;
    }
}
