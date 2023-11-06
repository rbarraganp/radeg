package com.rbp.radeg.controller.implement;

import com.rbp.radeg.controller.TrainingControllerInterface;
import com.rbp.radeg.dto.TrainingDto;
import com.rbp.radeg.services.implement.TrainingServiceImplement;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/** * TRAINING CONTROLLER IMPLEMENT */
@Tag(name = "Training", description = "Training Controller Implement")
@RequestMapping(ResourceConstants.RESOURCE_TRAINING)
@RestController
public class TrainingControllerImplement implements TrainingControllerInterface {


    @Autowired
    TrainingServiceImplement trainingServi;


    /**
     * CREATE NEW TRAINING
     * @param idUser
     * @return
     * @throws RadegException
     */
    @Override
    @Operation(description = DescriptionConstants.CREATE_NEW_TRAINING)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = ResponseConstants.CREATE),
            @ApiResponse(responseCode = "404", description = ExceptionConstants.MESSAGE_INEXISTENT_USER)
    })
    @PostMapping( value = ResourceConstants.RESOURCE_USER_ID ,produces = MediaType.APPLICATION_JSON_VALUE)
    public RadegResponse<TrainingDto> createNewTrainingController(
            @Parameter(name = ParametrerConstants.PARAMETER_USER_ID, required = true)
           @PathVariable Long idUser) throws RadegException {

            return new RadegResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),
                    CommonConstants.OK, trainingServi.createNewTrainingService(idUser));

    }






}
