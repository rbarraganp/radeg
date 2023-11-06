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
    private TrainingDto training;

    //*** MUSCLE SUBGROUP ***
    private List<MuscleSubGroup> muscleSubGroupList= new ArrayList<>();


    //*** SERIE***
    private List<Serie> serieList= new ArrayList<>();


    //BUILDER
    public ExerciseDto() {}

    //GETTER AND SETTER


}
