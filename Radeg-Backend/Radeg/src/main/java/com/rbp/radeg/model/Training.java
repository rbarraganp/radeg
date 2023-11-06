package com.rbp.radeg.model;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TRAINING")
public class Training implements Serializable {

    private static final long serialVersionUID = 1L;

    //ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TRAINING")
    private long idTraining;

    @Column(name="DATE", nullable = false)
    @CreationTimestamp
    private Timestamp date;


    @Column(name = "COMMENT", nullable = true)
    private String comment;


    //RELATIONS

    //*** USER ***
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER", nullable = false)
    private User user;

    //*** EXERCISE***
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "training")
    private List<Exercise> exerciseList= new ArrayList<>();

    //BUILDER
    public Training() {}

    public Training(User user) { this.user = user;}

    //GETTER AND SETTER
    public long getIdTraining() { return idTraining;}
    public void setIdTraining(long idTraining) { this.idTraining = idTraining;}

    public Timestamp getDate() { return date;}
    public void setDate(Timestamp date) { this.date = date;}

    public String getComment() { return comment;}
    public void setComment(String comment) { this.comment = comment;}

    public User getUser() { return user;}
    public void setUser(User user) { this.user = user;}

    public List<Exercise> getExerciseList() { return exerciseList;}
    public void setExerciseList(List<Exercise> exerciseList) { this.exerciseList = exerciseList;}


    //METHODS
}

