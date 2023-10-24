
package com.rbp.radeg.model;



import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MUSCLE_SUB_GROUP")
public class MuscleSubGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    //ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MUSCLE_SUB_GROUP")
    private long idMuscleSubGroup;

    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @Column(name = "IMG", nullable = false)
    private String img;

    //RELATIONS

    //*** USER ***
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER", nullable = false)
    private User user;

    //*** MUSCLE GROUP ***
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MUSCLE_GROUP", nullable = false)
    private MuscleGroup muscleGroup;

    //*** EXERCISE***
    @ManyToMany(fetch = FetchType.LAZY, mappedBy="muscleSubGroupList")
    private List<Exercise> exerciseList= new ArrayList<>();


    //BUILDER
    public MuscleSubGroup() {}

    //GETTER AND SETTER

    public long getIdMuscleSubGroup() { return idMuscleSubGroup;}
    public void setIdMuscleSubGroup(long idMuscleSubGroup) { this.idMuscleSubGroup = idMuscleSubGroup;}

    public String getName() { return name;}
    public void setName(String name) { this.name = name;}

    public String getImg() { return img;}
    public void setImg(String img) { this.img = img;}

    public User getUser() { return user;}
    public void setUser(User user) { this.user = user;}

    public MuscleGroup getMuscleGroup() { return muscleGroup;}
    public void setMuscleGroup(MuscleGroup muscleGroup) { this.muscleGroup = muscleGroup;}

    public List<Exercise> getExerciseList() { return exerciseList;}
    public void setExerciseList(List<Exercise> exerciseList) { this.exerciseList = exerciseList;}


    //METHODS
}

