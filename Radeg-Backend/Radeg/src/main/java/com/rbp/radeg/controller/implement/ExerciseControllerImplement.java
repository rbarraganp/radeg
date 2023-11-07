package com.rbp.radeg.controller.implement;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.rbp.radeg.controller.ExerciseControllerInterface;
import com.rbp.radeg.dto.ExerciseDto;
import com.rbp.radeg.services.implement.ExerciseServiceImplement;
import com.rbp.radeg.utils.constans.*;
import com.rbp.radeg.utils.exceptions.RadegException;
import com.rbp.radeg.utils.responses.RadegResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/** * EXERCISE CONTROLLER IMPLEMENT */
@Tag(name = "Exercise", description = "Exercise Controller Implement")
@RequestMapping(ResourceConstants.RESOURCE_EXERCISE)
@RestController
public class ExerciseControllerImplement implements ExerciseControllerInterface {


    @Autowired
    ExerciseServiceImplement exerciseServi;

    // CONTINUE WITH CHECK ENDPOINT

    @Override
    @Operation(description = DescriptionConstants.CREATE_NEW_EXERCISE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = ResponseConstants.CREATE),
            @ApiResponse(responseCode = "204", description = ExceptionConstants.MESSAGE_INEXISTENT_TRAINING),
            @ApiResponse(responseCode = "204", description = ExceptionConstants.MESSAGE_INEXISTENT_SUBMUSCLE_GROUP)})

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public RadegResponse<ExerciseDto> createNewExerciseController(
            @Parameter(name= ParametrerConstants.PARAMETER_EXERCISE, required = true)
           @RequestBody ExerciseDto exerciseDto) throws RadegException {

        return new RadegResponse<ExerciseDto>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.CREATED),
                CommonConstants.OK, exerciseServi.createNewExerciseService(exerciseDto));
    }


}
