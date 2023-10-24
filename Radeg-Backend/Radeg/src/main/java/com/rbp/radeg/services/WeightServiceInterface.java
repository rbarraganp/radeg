package com.rbp.radeg.services;

import com.rbp.radeg.dto.WeightDto;
import com.rbp.radeg.utils.exceptions.RadegException;

import java.util.List;

/** WEIGHT SERVICE INTERFACE*/

public interface WeightServiceInterface {

    /** * Add new weight */
    public List <WeightDto> addNewWeightService(Long idUser, Double weight)throws RadegException;


    /** * Delete weight */
    public List <WeightDto> deleteWeightService(Long idUser, Long idWeight)throws RadegException;

    /** Delete All weight */
    public List <WeightDto> deleteAllWeightService(Long idUser)throws RadegException;

    /** * Update weight */
    public List <WeightDto> updateWeightService(WeightDto weightDto)throws RadegException;


    /** * List User´s weights */


}
