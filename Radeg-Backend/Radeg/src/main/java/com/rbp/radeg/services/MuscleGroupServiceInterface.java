package com.rbp.radeg.services;

import com.rbp.radeg.dto.MuscleGroupDto;
import com.rbp.radeg.utils.exceptions.RadegException;
import com.rbp.radeg.utils.responses.RadegResponse;

import java.util.List;

/**
 * MUSCLE GROUP SERVICE INTERFACE
 */
public interface MuscleGroupServiceInterface {

    /*Create new Muscle Group */
    public List<MuscleGroupDto> createNewMuscleGroupService(MuscleGroupDto muscleGroupDto)throws RadegException;
}
