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
public class UserDto implements Serializable {

    private static final long serialVersionUID = 1L;

    //ATTRIBUTES

    private Long idUser;
    private String nick;
    private String email;
    private String name;
    private String password;
    private Timestamp dischargeDate;
    private Timestamp lastUpdateDate;
    private Date birhtDate;
    private Integer phone;
    private float Height;


    //RELATIONS

    //*** ROLE USER ***

    private RoleUser role;

    //*** WEIGHT ***
    private List<Weight> weightList= new ArrayList<>();

    //*** MUSCLE GROUP***

    private List<MuscleGroup> muscleGroupList= new ArrayList<>();

    //*** MUSCLE SUB GROUP***
    private List<MuscleGroup> muscleSubGroupList= new ArrayList<>();


    //*** TRAINING***
    private List<Training> trainingList= new ArrayList<>();


    //BUILDER
    public UserDto() {}


    //GETTER AND SETTER
    public Long getIdUser() { return idUser;}
    public void setIdUser(Long idUser) { this.idUser = idUser;}

    public String getNick() { return nick;}
    public void setNick(String nick) { this.nick = nick;}

    public String getEmail() { return email;}
    public void setEmail(String email) { this.email = email;}

    public String getName() { return name;}
    public void setName(String name) { this.name = name;}

    public String getPassword() { return password;}
    public void setPassword(String password) { this.password = password;}

    public Timestamp getDischargeDate() { return dischargeDate;}
    public void setDischargeDate(Timestamp dischargeDate) { this.dischargeDate = dischargeDate;}

    public Timestamp getLastUpdateDate() { return lastUpdateDate;}
    public void setLastUpdateDate(Timestamp lastUpdateDate) { this.lastUpdateDate = lastUpdateDate;}

    public Date getBirhtDate() { return birhtDate;}
    public void setBirhtDate(Date birhtDate) { this.birhtDate = birhtDate;}

    public Integer getPhone() { return phone;}
    public void setPhone(Integer phone) { this.phone = phone;}

    public float getHeight() { return Height; }
    public void setHeight(float height) { Height = height;}

    public RoleUser getRole() { return role;}
    public void setRole(RoleUser role) { this.role = role;}

    public List<Weight> getWeightList() { return weightList;}

    public void setWeightList(List<Weight> weightList) { this.weightList = weightList;}

    public List<MuscleGroup> getMuscleGroupList() { return muscleGroupList;}
    public void setMuscleGroupList(List<MuscleGroup> muscleGroupList) { this.muscleGroupList = muscleGroupList;}

    public List<MuscleGroup> getMuscleSubGroupList() { return muscleSubGroupList;}
    public void setMuscleSubGroupList(List<MuscleGroup> muscleSubGroupList) {
        this.muscleSubGroupList = muscleSubGroupList;
    }

    public List<Training> getTrainingList() { return trainingList;}
    public void setTrainingList(List<Training> trainingList) { this.trainingList = trainingList;}

    //METHODS




}
