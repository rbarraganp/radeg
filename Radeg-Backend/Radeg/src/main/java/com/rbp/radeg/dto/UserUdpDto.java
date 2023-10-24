package com.rbp.radeg.dto;

import com.rbp.radeg.model.MuscleGroup;
import com.rbp.radeg.model.RoleUser;
import com.rbp.radeg.model.Training;
import com.rbp.radeg.model.Weight;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * USER DTO
 */
public class UserUdpDto implements Serializable {

    private static final long serialVersionUID = 1L;

    //ATTRIBUTES
    private Long idUser;
    private String nick;
    private String email;
    private String name;
    private Date birhtDate;
    private Integer phone;
    private float Height;


    //RELATIONS

    //*** MUSCLE GROUP***

    //BUILDER
    public UserUdpDto() {}


    //GETTER AND SETTER
    public Long getIdUser() { return idUser;}
    public void setIdUser(Long idUser) { this.idUser = idUser;}

    public String getNick() { return nick;}
    public void setNick(String nick) { this.nick = nick;}

    public String getEmail() { return email;}
    public void setEmail(String email) { this.email = email;}

    public String getName() { return name;}
    public void setName(String name) { this.name = name;}


    public Date getBirhtDate() { return birhtDate;}
    public void setBirhtDate(Date birhtDate) { this.birhtDate = birhtDate;}

    public Integer getPhone() { return phone;}
    public void setPhone(Integer phone) { this.phone = phone;}

    public float getHeight() { return Height; }
    public void setHeight(float height) { Height = height;}





}
