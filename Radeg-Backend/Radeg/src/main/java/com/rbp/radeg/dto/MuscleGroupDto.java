package com.rbp.radeg.dto;

import com.rbp.radeg.model.MuscleSubGroup;
import java.util.ArrayList;
import java.util.List;

public class MuscleGroupDto {

    //ATTRIBUTES
    private long idMuscleGroup;
    private String name;
    private String img;

    //RELATIONS

    //*** USER ***
    private Long idUser;

    //*** MUSCLE SUBGROUP***
    private List<MuscleSubGroup> muscleSubGroupList= new ArrayList<>();


    //BUILDER
    public MuscleGroupDto() {}

    //GETTER AND SETTER

    public long getIdMuscleGroup() { return idMuscleGroup;}
    public void setIdMuscleGroup(long idMuscleGroup) { this.idMuscleGroup = idMuscleGroup;}

    public String getName() { return name;}
    public void setName(String name) { this.name = name;}

    public String getImg() { return img;}
    public void setImg(String img) { this.img = img;}

    public Long getIdUser() { return idUser;}
    public void setIdUser(Long idUser) { this.idUser = idUser;}

    public List<MuscleSubGroup> getMuscleSubGroupList() { return muscleSubGroupList;}
    public void setMuscleSubGroupList(List<MuscleSubGroup> muscleSubGroupList) {
        this.muscleSubGroupList = muscleSubGroupList;
    }


}
