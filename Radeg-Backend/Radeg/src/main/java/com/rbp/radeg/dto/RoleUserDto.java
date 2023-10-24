package com.rbp.radeg.dto;

import com.rbp.radeg.model.User;

import java.util.List;

/**
 * ROLEUSER DTO
 */
public class RoleUserDto {

    //ATTRIBUTES

    private short idRoleUser;
    private String name;


    //RELATIONS

    //*** USER ***
    private List<User> userList;

    //BUILDER
    public RoleUserDto() {}
    public RoleUserDto(String name) { this.name = name;}
    public RoleUserDto(short idRoleUser) { this.idRoleUser = idRoleUser;}

    //GETTER AND SETTER

    public short getIdRoleUser() { return idRoleUser;}
    public void setIdRoleUser(short idRoleUser) { this.idRoleUser = idRoleUser;}

    public String getName() { return name;}
    public void setName(String name) { this.name = name.toUpperCase();}

    public List<User> getUserList() { return userList;}
    public void setUserList(List<User> userList) { this.userList = userList;}


}
