package com.gencore.backend.java.service.admin.impl;

import java.util.List;

import com.gencore.backend.java.dao.admin.RoleDAO;
import com.gencore.backend.java.entity.UserRole;
import com.gencore.backend.java.service.admin.RoleService;

public class RoleServiceImpl implements RoleService {

    RoleDAO roleDAO;

    public RoleDAO getRoleDAO() {
        return roleDAO;

    }

    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    public void deleteRole(UserRole role) {
        roleDAO.deleteRole(role);
    }

    public UserRole getRole(Long id) {
        return roleDAO.getRole(id);
    }

    public List<UserRole> getRoles() {
        return roleDAO.getRoles();
    }

    public void insertRole(UserRole role) {
        roleDAO.insertRole(role);
    }

    public void updateRole(UserRole role) {
        roleDAO.updateRole(role);
    }

    public void deleteRoles(List<UserRole> roles) {
        roleDAO.deleteRoles(roles);
    }

}
