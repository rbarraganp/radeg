package com.rbp.radeg.services;
import com.rbp.radeg.dto.TrainingDto;
import com.rbp.radeg.utils.exceptions.RadegException;

/** * TRAINING SERVICE INTERFACE */
public interface TrainingServiceInterface {


    /** * Create new training  */
    public TrainingDto createNewTrainingService(Long idUser)throws RadegException;

}
