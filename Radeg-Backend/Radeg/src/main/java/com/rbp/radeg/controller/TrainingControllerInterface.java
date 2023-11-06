package com.rbp.radeg.controller;

import com.rbp.radeg.dto.TrainingDto;
import com.rbp.radeg.utils.exceptions.RadegException;
import com.rbp.radeg.utils.responses.RadegResponse;

/** * TRAINING CONTROLLER INTERFACE */

public interface TrainingControllerInterface {

    /** * Create new training  */
    public RadegResponse<TrainingDto> createNewTrainingController(Long idUser)throws RadegException;

}
