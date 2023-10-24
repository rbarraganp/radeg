package com.rbp.radeg.controller.implement;


import com.rbp.radeg.controller.MuscleGroupControllerInterface;
import com.rbp.radeg.dto.MuscleGroupDto;
import com.rbp.radeg.services.MuscleGroupServiceInterface;
import com.rbp.radeg.services.implement.MuscleGroupServiceImplement;
import com.rbp.radeg.utils.constans.*;
import com.rbp.radeg.utils.exceptions.RadegException;
import com.rbp.radeg.utils.responses.RadegResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/** * MUSCLE GROUP CONTROLLER IMPLEMENT */
@Tag(name = "Muscle Group", description = "Muscle Group Controller Implement")
@RestController
@RequestMapping(ResourceConstants.RESOURCE_MUSCLE_GROUP)

public class MuscleGroupControllerImplement implements MuscleGroupControllerInterface {


@Autowired
    MuscleGroupServiceImplement muscleGroupServi;


    @Override
    @Operation(description = DescriptionConstants.CREATE_NEW_MUSCLE_GROUP)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = ResponseConstants.CREATE),
            @ApiResponse(responseCode = "404", description = ExceptionConstants.MESSAGE_INEXISTENT_USER),
            @ApiResponse(responseCode = "409", description = ExceptionConstants.MESSAGE_ALREADY_EXIST_MUSCLE_GROUP_NAME)})
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public RadegResponse<List<MuscleGroupDto>> createNewMuscleGroupController(
        @Parameter(name = ParametrerConstants.PARAMETER_MUSCLE_GROUP)
        @RequestBody MuscleGroupDto muscleGroupDto) throws RadegException {

        return new RadegResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.CREATED), CommonConstants.OK,
                muscleGroupServi.createNewMuscleGroupService(muscleGroupDto));
    }


}
