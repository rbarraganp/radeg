package com.rbp.radeg.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rbp.radeg.model.Exercise;
import com.rbp.radeg.model.Training;
import com.rbp.radeg.model.User;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * TRAINING DTO
 */

@JsonIgnoreProperties({"user", "exerciseList"})
public class TrainingDto implements Serializable {

        private static final long serialVersionUID = 1L;

        //ATTRIBUTES
        private long idTraining;
        private Timestamp date;
        private String comment;


        //RELATIONS

        //*** USER ***
        private UserDto user;

        //*** EXERCISE***
        private List<ExerciseDto> exerciseList= new ArrayList<>();

        //BUILDER
        public TrainingDto() {}

        //GETTER AND SETTER

        public long getIdTraining() { return idTraining; }
        public void setIdTraining(long idTraining) { this.idTraining = idTraining;}

        public Timestamp getDate() { return date; }
        public void setDate(Timestamp date) { this.date = date;}

        public String getComment() { return comment; }
        public void setComment(String comment) { this.comment = comment;}

        public UserDto getUser() { return user; }
        public void setUser(UserDto user) { this.user = user; }

        public List<ExerciseDto> getExerciseList() { return exerciseList;}
        public void setExerciseList(List<ExerciseDto> exerciseList) { this.exerciseList = exerciseList;}


        //METHODS


    }



