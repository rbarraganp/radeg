package com.rbp.radeg.controller;

import com.rbp.radeg.dto.ExerciseDto;
import com.rbp.radeg.utils.exceptions.RadegException;
import com.rbp.radeg.utils.responses.RadegResponse;

/** * EXERCISE CONTROLLER INTERFACE */
public interface ExerciseControllerInterface {

    /** * Create new Exercise */
    public RadegResponse<ExerciseDto> createNewExerciseController(ExerciseDto exerciseDto) throws RadegException;



}
