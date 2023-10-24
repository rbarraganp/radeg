package com.rbp.radeg.model;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "SERIE")
public class Serie implements Serializable {

    private static final long serialVersionUID = 1L;

    //ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SERIE")
    private Long idSerie;

    @Column(name = "ORDER_SERIE", nullable = false, unique = true)
    private short orderSerie;

    @Column(name = "REPITIONS", nullable = true)
    private Integer Repitions;

    @Column(name = "LOAD_MAX", nullable = true)
    private Double loadMax;

    @Column(name = "DURATION_SERIE", nullable = true)
    private Double duration;

    @Column(name = "COMMENT", nullable = true)
    private String comment;

    @Column(name="discharge_date", nullable = false)
    @CreationTimestamp
    private Timestamp date;


    //RELATIONS

    //*** EXERCISE ***
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EXERCISE", nullable = false)
    private Exercise exercise;




    //BUILDER
    public Serie() {}


    //GETTER AND SETTER

    public Long getIdSerie() { return idSerie;}
    public void setIdSerie(Long idSerie) { this.idSerie = idSerie;}

    public short getOrderSerie() { return orderSerie;}
    public void setOrderSerie(short orderSerie) { this.orderSerie = orderSerie;}

    public Integer getRepitions() { return Repitions;}
    public void setRepitions(Integer repitions) { Repitions = repitions; }

    public Double getLoadMax() { return loadMax; }
    public void setLoadMax(Double loadMax) { this.loadMax = loadMax; }

    public Timestamp getDate() { return date;}
    public void setDate(Timestamp date) { this.date = date;}

    public Double getDuration() { return duration;}
    public void setDuration(Double duration) { this.duration = duration;}

    public String getComment() { return comment;}
    public void setComment(String comment) { this.comment = comment;}

    public Exercise getExercise() { return exercise;}
    public void setExercise(Exercise exercise) { this.exercise = exercise;}

    //METHODS

}

