package com.rbp.radeg.model;


import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import jakarta.validation.constraints.DecimalMax;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;

@Entity
@Table(name= "USER")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    //ATTRIBUTES

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USER")
    private Long idUser;

    @Column(name = "NICK", nullable = false, unique = true)
    @Length(max = 25, min = 3)
    private String nick;

    @Column(name="EMAIL", nullable = false, unique = true)
    private String email;

    @Column(name= "NAME", nullable = false)
    private String name;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name="DISCHARGE_DATE", nullable = true)
    @CreationTimestamp
    private Timestamp  dischargeDate;

    @Column(name = "LAST_UPDATE_DATE", nullable = false)
    @UpdateTimestamp
    private Timestamp lastUpdateDate;

    @Column(name= "BIRHT_DATE", nullable = true)
    private Date birhtDate;

    @Column(name ="PHONE", nullable = true)
   // @Length(min=9, max=9)
    private Integer phone;

    @Column(name= "HEIGHT", nullable = true)
    //@Digits(integer = 1, fraction = 2)
    @DecimalMax(value = "3.00", inclusive = true)
    private float Height;

    //RELATIONS

    //*** ROLE USER ***
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROLE", nullable = false)
    private RoleUser role;

    //*** WEIGHT ***
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private List<Weight> weightList= new ArrayList<>();


    //*** MUSCLE GROUP***
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private List<MuscleGroup> muscleGroupList= new ArrayList<>();

    //*** MUSCLE SUB GROUP***
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private List<MuscleGroup> muscleSubGroupList= new ArrayList<>();


    //*** TRAINING***
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private List<Training> trainingList= new ArrayList<>();


    //BUILDER
    public User() {}


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

