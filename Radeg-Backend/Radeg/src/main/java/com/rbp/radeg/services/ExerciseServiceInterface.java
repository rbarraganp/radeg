package com.rbp.radeg.services;
import com.rbp.radeg.dto.ExerciseDto;
import com.rbp.radeg.model.Exercise;
import com.rbp.radeg.utils.exceptions.RadegException;

/** * Exercise SERVICE INTERFACE */
public interface ExerciseServiceInterface {


    /** * Create new Exercise  */
    public ExerciseDto createNewExerciseService(ExerciseDto exerciseDto)throws RadegException;

}
