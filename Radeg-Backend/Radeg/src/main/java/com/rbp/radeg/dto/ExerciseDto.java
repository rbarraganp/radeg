package com.rbp.radeg.dto;

import com.rbp.radeg.model.MuscleSubGroup;
import com.rbp.radeg.model.Serie;
import com.rbp.radeg.model.Training;
import com.rbp.radeg.model.User;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * EXERCISE DTO
 */
public class ExerciseDto {

    private static final long serialVersionUID = 1L;


    //ATTRIBUTES
    private long idExercise;
    private String name;
    private String description;
    private String img;


    //RELATIONS

    //*** TRAINING ***
    private Long idTraining;

    //*** MUSCLE SUBGROUP ***
    private List<Long> idMuscleSubGroupList= new ArrayList<>();


    //*** SERIE***
    private List<Long> idSerieList= new ArrayList<>();


    //BUILDER
    public ExerciseDto() {}

    //GETTER AND SETTER

    public long getIdExercise() { return idExercise;}
    public void setIdExercise(long idExercise) { this.idExercise = idExercise; }

    public String getName() { return name;}
    public void setName(String name) { this.name = name;}

    public String getDescription() { return description;}
    public void setDescription(String description) { this.description = description;}

    public String getImg() { return img; }
    public void setImg(String img) { this.img = img; }

    public Long getIdTraining() {
        return idTraining;
    }

    public void setIdTraining(Long idTraining) {
        this.idTraining = idTraining;
    }

    public List<Long> getIdMuscleSubGroupList() {
        return idMuscleSubGroupList;
    }

    public void setIdMuscleSubGroupList(List<Long> idMuscleSubGroupList) {
        this.idMuscleSubGroupList = idMuscleSubGroupList;
    }

    public List<Long> getIdSerieList() {
        return idSerieList;
    }

    public void setIdSerieList(List<Long> idSerieList) {
        this.idSerieList = idSerieList;
    }
}
