package com.rbp.radeg.controller.implement;

import com.rbp.radeg.controller.WeightControllerInterface;
import com.rbp.radeg.dto.WeightDto;
import com.rbp.radeg.services.WeightServiceInterface;
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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Weight", description = "Weight Controller Implement")
@RequestMapping(ResourceConstants.RESOURCE_WEIGHT)
public class WeightControllerImplement implements WeightControllerInterface {


    @Autowired
    WeightServiceInterface weightServi;



    /**
     * CREATE NEW WEIGHT
     *
     * @param idUser
     * @param weight
     * @return
     * @throws RadegException
     */
    @Override
    @Operation(description = DescriptionConstants.CREATE_NEW_WEIGHT)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = ResponseConstants.CREATE),
            @ApiResponse(responseCode = "404", description = ExceptionConstants.MESSAGE_INEXISTENT_USER)})
    @PostMapping(value = ResourceConstants.RESOURCE_NEW_WEIGHT, produces = MediaType.APPLICATION_JSON_VALUE)
    public RadegResponse<List<WeightDto>> addNewWeightController(
            @Parameter(name = ParametrerConstants.PARAMETER_USER_ID, required = true)
            @PathVariable Long idUser,
            @Parameter(name = ParametrerConstants.PARAMETER_FIELD_WEIGHT, required = true)
            @PathVariable Double weight) throws RadegException {


            return new RadegResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.CREATED),
                    CommonConstants.OK, weightServi.addNewWeightService(idUser,weight));
    }



    /**
     * DELETE WEIGHT
     *
     * @param idUser
     * @param idWeight
     * @return
     * @throws RadegException
     */
    @Override
    @Operation(description = DescriptionConstants.DELETE_WEIGHT)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = ResponseConstants.OK),
            @ApiResponse(responseCode = "404", description = ExceptionConstants.MESSAGE_INEXISTENT_USER),
            @ApiResponse(responseCode = "404", description = ExceptionConstants.MESSAGE_INEXISTENT_WEIGHT)})
    @DeleteMapping(value = ResourceConstants.RESOURCE_DELETE_WEIGHT , produces = MediaType.APPLICATION_JSON_VALUE)
    public RadegResponse<List<WeightDto>> deleteWeightController(
            @Parameter(name = ParametrerConstants.PARAMETER_USER_ID, required = true)
            @PathVariable Long idUser,
            @Parameter(name = ParametrerConstants.PARAMETER_ID_WEIGHT, required = true)
            @PathVariable Long idWeight) throws RadegException {

        return new RadegResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),
                CommonConstants.OK, weightServi.deleteWeightService(idUser, idWeight));
    }


    /**
     * DELETE ALL USER´S WEIGHT
     * @param idUser
     * @return
     * @throws RadegException
     */
    @Override
    @Operation(description = DescriptionConstants.DELETE_ALL_WEIGHT)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = ResponseConstants.OK),
            @ApiResponse(responseCode = "404", description = ExceptionConstants.MESSAGE_INEXISTENT_USER)})
    @DeleteMapping(value = ResourceConstants.RESOURCE_NEW_ALL_WEIGHT, produces = MediaType.APPLICATION_JSON_VALUE)
    public RadegResponse<List<WeightDto>> deleteAllWeightController(
            @Parameter(name = ParametrerConstants.PARAMETER_USER_ID, required = true)
           @PathVariable Long idUser) throws RadegException {

        return new RadegResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),
                CommonConstants.OK, weightServi.deleteAllWeightService(idUser));
    }


    /**
     * UPDATE USER´S WEIGHT
     * @param weightDto
     * @return
     * @throws RadegException
     */
    @Override
    @Operation(description = DescriptionConstants.DELETE_ALL_WEIGHT)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = ResponseConstants.OK),
            @ApiResponse(responseCode = "404", description = ExceptionConstants.MESSAGE_INEXISTENT_USER),
            @ApiResponse(responseCode = "404", description = ExceptionConstants.MESSAGE_INEXISTENT_WEIGHT)})
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public RadegResponse<List<WeightDto>> updateWeightController(
            @Parameter(name = ParametrerConstants.PARAMETER_WEIGHT, required = true)
            @RequestBody  WeightDto weightDto) throws RadegException {

        return new RadegResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),
                CommonConstants.OK, weightServi.updateWeightService(weightDto));
    }
}
