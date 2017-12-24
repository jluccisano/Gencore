package com.gencore.backend.java.dao.admin;

import java.util.List;

import com.gencore.backend.java.entity.UserRole;

public interface RoleDAO {

    List<UserRole> getRoles();

    UserRole getRole(Long id);

    UserRole getRoleByName(String roleName);

    void insertRole(UserRole role);

    void deleteRole(UserRole role);

    void deleteRoles(List<UserRole> roles);

    void updateRole(UserRole role);
}
