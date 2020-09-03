package com.htsc.domain;

import java.io.Serializable;
import java.util.List;

/**
 * <h3>mybatisdemoV2</h3>
 * <p></p>
 *
 * @author : liuyuwei
 * @date : 2020-09-03 09:39
 **/
public class Role implements Serializable {
    private Integer roleId;
    private String roleName;
    private String roleDeso;
    private List<User> users;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDeso() {
        return roleDeso;
    }

    public void setRoleDeso(String roleDeso) {
        this.roleDeso = roleDeso;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
