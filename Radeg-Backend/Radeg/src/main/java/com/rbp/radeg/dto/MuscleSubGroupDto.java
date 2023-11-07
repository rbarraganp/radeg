package com.rbp.radeg.dto;

import com.rbp.radeg.model.MuscleSubGroup;
import com.rbp.radeg.model.User;

import java.util.ArrayList;
import java.util.List;

public class MuscleSubGroupDto {

    private static final long serialVersionUID = 1L;

    //ATTRIBUTES
    private Long idMuscleGroup;
    private String name;
    private String img;

    //RELATIONS

    //*** USER ***
    private Long idUser;

    //*** MUSCLE SUBGROUP***
    private List<Long> idMuscleSubGroupList= new ArrayList<>();


    //BUILDER
    public MuscleSubGroupDto() {}

    //GETTER AND SETTER

    public Long getIdMuscleGroup() {
        return idMuscleGroup;
    }

    public void setIdMuscleGroup(Long idMuscleGroup) {
        this.idMuscleGroup = idMuscleGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public List<Long> getIdMuscleSubGroupList() {
        return idMuscleSubGroupList;
    }

    public void setIdMuscleSubGroupList(List<Long> idMuscleSubGroupList) {
        this.idMuscleSubGroupList = idMuscleSubGroupList;
    }


    //METHODS

}
