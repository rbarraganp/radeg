package com.rbp.radeg.controller;


import com.rbp.radeg.dto.MuscleGroupDto;
import com.rbp.radeg.utils.exceptions.RadegException;
import com.rbp.radeg.utils.responses.RadegResponse;

import java.util.List;

/* MUSCLE GROUP INTER*/
public interface MuscleGroupControllerInterface {

    public RadegResponse<List<MuscleGroupDto>> createNewMuscleGroupController(MuscleGroupDto muscleGroupDto) throws RadegException;
}
