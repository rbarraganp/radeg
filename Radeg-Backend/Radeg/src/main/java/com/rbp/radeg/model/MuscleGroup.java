
package com.rbp.radeg.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Null;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MUSCLE_GROUP")
public class MuscleGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    //ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MUSCLE_GROUP")
    private long idMuscleGroup;

    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @Column(name = "IMG", nullable = true)
    private String img;

    //RELATIONS

    //*** USER ***
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER", nullable = false)
    private User user;

    //*** MUSCLE SUBGROUP***
    @OneToMany(mappedBy = "muscleGroup", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MuscleSubGroup> muscleSubGroupList= new ArrayList<>();


    //BUILDER
    public MuscleGroup() {}

    public MuscleGroup(User user, String name) {
        this.name = name;
        this.user = user;
    }

    //GETTER AND SETTER

    public long getIdMuscleGroup() { return idMuscleGroup;}
    public void setIdMuscleGroup(long idMuscleGroup) { this.idMuscleGroup = idMuscleGroup;}

    public String getName() { return name;}
    public void setName(String name) { this.name = name;}

    public String getImg() { return img;}
    public void setImg(String img) { this.img = img;}

    public User getUser() { return user;}
    public void setUser(User user) { this.user = user;}

    public List<MuscleSubGroup> getMuscleSubGroupList() { return muscleSubGroupList;}
    public void setMuscleSubGroupList(List<MuscleSubGroup> muscleSubGroupList) {
        this.muscleSubGroupList = muscleSubGroupList;
    }


    //METHODS
}

