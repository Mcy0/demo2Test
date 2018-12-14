package com.mcy.ssm.mybatis.mapper;

import com.mcy.ssm.mybatis.entity.Role;

import java.util.List;

public interface RoleMapper {
    public int insertRole(Role role);
    public int deleteRole(Long id);
    public int updateRole(Role role);
    public Role getRole(Long id);
    public List<Role> findRoles(String roleName);
    public List<Role> findRoles2(String roleName);
}
