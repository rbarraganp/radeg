package com.rbp.radeg.controller;

import com.rbp.radeg.dto.WeightDto;
import com.rbp.radeg.utils.exceptions.RadegException;
import com.rbp.radeg.utils.responses.RadegResponse;

import java.util.List;

public interface WeightControllerInterface {


    /** * Add new weight */
    public RadegResponse <List<WeightDto>> addNewWeightController(Long idUser, Double weight)throws RadegException;

    /** * Delete weight */
    public RadegResponse <List<WeightDto>> deleteWeightController(Long idUser, Long idWeight)throws RadegException;

    /** Delete All weight */
    public RadegResponse <List<WeightDto>> deleteAllWeightController(Long idUser)throws RadegException;

    /** * Update weight */
    public RadegResponse <List<WeightDto>> updateWeightController(WeightDto weightDto)throws RadegException;

    /** * List User´s weights */

}
