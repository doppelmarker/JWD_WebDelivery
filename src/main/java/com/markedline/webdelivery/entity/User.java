package com.markedline.webdelivery.entity;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String login;
    private String password;
    private Integer detailId;
    private Integer roleId;
    private Integer statusId;

    public User() {

    }

    public User(Integer id, String login, String password, Integer detailId, Integer roleId, Integer statusId) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.detailId = detailId;
        this.roleId = roleId;
        this.statusId = statusId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", detailId=" + detailId +
                ", roleId=" + roleId +
                ", statusId=" + statusId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(detailId, user.detailId) &&
                Objects.equals(roleId, user.roleId) &&
                Objects.equals(statusId, user.statusId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, detailId, roleId, statusId);
    }
}
