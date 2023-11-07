package com.rbp.radeg.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "EXERCISE")
public class Exercise implements Serializable {

    private static final long serialVersionUID = 1L;

    //ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EXERCISE")
    private long idExercise;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION", nullable = true)
    private String description;

    @Column(name = "IMG", nullable = true)
    private String img;


    //RELATIONS

    //*** TRAINING ***
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TRAINING", nullable = false)
    private Training training;

    //*** MUSCLE SUBGROUP ***
    @ManyToMany (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable( name = "EXERCISE_MSG",
            joinColumns = @JoinColumn(name = "EXERCISE"),
            inverseJoinColumns = @JoinColumn(name = "MUSCLE_SUB_GROUP"))
    private List<MuscleSubGroup> muscleSubGroupList= new ArrayList<>();


    //*** SERIE***
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "exercise")
    private List<Serie> serieList= new ArrayList<>();


    //BUILDER
    public Exercise() {}
    public Exercise(Training training) { this.training = training;}

    //GETTER AND SETTER

    public long getIdExercise() { return idExercise;}
    public void setIdExercise(long idExercise) { this.idExercise = idExercise;}

    public String getName() { return name;}
    public void setName(String name) { this.name = name;}

    public String getDescription() { return description;}
    public void setDescription(String description) { this.description = description;}

    public String getImg() { return img;}
    public void setImg(String img) { this.img = img;}


    public Training getTraining() { return training;}
    public void setTraining(Training training) { this.training = training;}

    public List<MuscleSubGroup> getMuscleSubGroupList() { return muscleSubGroupList;}
    public void setMuscleSubGroupList(List<MuscleSubGroup> muscleSubGroupList) {
        this.muscleSubGroupList = muscleSubGroupList;
    }

    public List<Serie> getSerieList() { return serieList;}
    public void setSerieList(List<Serie> serieList) { this.serieList = serieList;}



    //METHODS
}
