package com.rbp.radeg.controller.implement;

import com.rbp.radeg.controller.UserControllerInterface;
import com.rbp.radeg.dto.UserDto;

import com.rbp.radeg.dto.UserUdpDto;
import com.rbp.radeg.services.implement.UserServiceImplement;
import com.rbp.radeg.utils.constans.*;
import com.rbp.radeg.utils.exceptions.RadegException;
import com.rbp.radeg.utils.responses.RadegResponse;

//import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/** * USER CONTROLLER IMPLEMENT */
@Tag(name = "User", description = "User Controller Implement")
@RestController
@RequestMapping(ResourceConstants.RESOURCE_USER)
public class UserControllerImplement implements UserControllerInterface {

    @Autowired
    UserServiceImplement userService;


    @Override
    @GetMapping()
    public String testConnection() throws RadegException {
        return "hola";
    }
 
    /**
     * CREATE NEW USER
     * @param userDto
     * @return
     * @throws RadegException
     */

    @Override
   // @ResponseStatus(HttpStatus.OK)
    @Operation(description = DescriptionConstants.CREATE_NEW_USER)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = ResponseConstants.CREATE),
            @ApiResponse(responseCode = "409", description = ExceptionConstants.MESSAGE_ALREADY_EXIST_NICK_USER)})

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public RadegResponse<Void> createNewUserController(
            @Parameter(name = ParametrerConstants.PARAMETER_USER, required = true)
            @RequestBody UserDto userDto) throws RadegException {


        userService.createNewUserService(userDto);

        return new RadegResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.CREATED), CommonConstants.OK);

    }


    /**
     * DELETE USER
     * @param idUser
     * @return
     * @throws RadegException
     */
    @Override
    @Operation(description = DescriptionConstants.DELETE_USER)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = ResponseConstants.NO_CONTENT),
            @ApiResponse(responseCode = "404", description = ResponseConstants.NOT_FOUNT)
    })
    @DeleteMapping(ResourceConstants.RESOURCE_USER_ID)
    public RadegResponse<Void> deleteUserController(
            @Parameter(name = ParametrerConstants.PARAMETER_USER_ID, required = true)
           @PathVariable Long idUser) throws RadegException {

        userService.deleteUserService(idUser);

        return  new RadegResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.NO_CONTENT), CommonConstants.OK);
    }


    /**
     * UPDATE USER
     * @param userUdpDto
     * @return
     * @throws RadegException
     */

    @Override
    @Operation(description = DescriptionConstants.UPDATE_USER)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = ResponseConstants.OK),
            @ApiResponse(responseCode = "404", description = ResponseConstants.NOT_FOUNT)})
    @PutMapping (consumes =  MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public RadegResponse<UserUdpDto> updateUserController(
            @Parameter(name = ParametrerConstants.PARAMETER_USER_ID, required = true)
           @RequestBody UserUdpDto userUdpDto) throws RadegException {

        return new RadegResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK),
                CommonConstants.OK, userService.updateUserService(userUdpDto) );
    }



}
