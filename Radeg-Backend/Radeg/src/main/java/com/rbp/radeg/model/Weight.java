package com.rbp.radeg.model;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Digits;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name= "WEIGHT")
public class Weight implements Serializable {

   // private static final long serialVersionUID= 1L;

    //ATTRIBUTES
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name= "ID_WEIGHT")
    private long idWeight;

    @Column(name="DATE", nullable = false)
    @CreationTimestamp
    private Timestamp date;

    @Column(name= "WEIGHT", nullable = false)
    @DecimalMax(value = "1000.00", inclusive = true)
    private double weight;

    //RELATIONS

    //*** USER ***
    @ManyToOne
    @JoinColumn(name = "USER", nullable = false)
    private User user;


    //BUILDER
    public Weight() {}

    public Weight(User user, double weight) {
        this.weight = weight;
        this.user = user;
    }

    //GETTER AND SETTER
    public long getIdWeight() { return idWeight;}
    public void setIdWeight(long idWeight) { this.idWeight = idWeight;}

    public Timestamp getDate() { return date;}
    public void setDate(Timestamp date) { this.date = date;}

    public double getWeight() { return weight;}
    public void setWeight(double weight) { this.weight = weight;}

    public User getUser() { return user;}
    public void setUser(User user) { this.user = user;}


    //METHODS


}

