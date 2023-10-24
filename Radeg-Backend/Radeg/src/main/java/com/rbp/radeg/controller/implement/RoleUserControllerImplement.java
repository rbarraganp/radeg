package com.rbp.radeg.controller.implement;

import com.rbp.radeg.controller.RoleUserControllerInterface;
import com.rbp.radeg.dto.RoleUserDto;
import com.rbp.radeg.services.implement.RoleUserServiceImplement;
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

/**
 * ROLEUSER CONTROLLER IMPLEMENT
 */
@Tag(name = "RoleUser", description = "RoleUser Controller implement")
@RestController
@RequestMapping(ResourceConstants.RESOURCE_ROLE_USER)
public class RoleUserControllerImplement implements RoleUserControllerInterface {

    @Autowired
    RoleUserServiceImplement roleUserService;

    /**
     * CREATE NEW ROLEUSER
     * @param roleUserDto
     * @return
     * @throws RadegException
     */
    @Override
    @Operation(description = DescriptionConstants.CREATE_NEW_ROLE_USER)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = ResponseConstants.CREATE),
            @ApiResponse(responseCode = "409", description =  ExceptionConstants.MESSAGE_ALREADY_EXIST_NICK_USER)})
    @PostMapping (consumes = MediaType.APPLICATION_JSON_VALUE)
    public RadegResponse<Void> createNewRoleUserController(
            @Parameter(name=ParametrerConstants.PARAMETER_ROLE_USER, required = true)
            @RequestBody  RoleUserDto roleUserDto) throws RadegException {

        roleUserService.createNewRoleUserService(roleUserDto);

        return new RadegResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.CREATED), CommonConstants.OK);

    }

    /**
     * DELETE ROLE USER
     * @param idRoleUser
     * @return
     * @throws RadegException
     */
    @Override
    @Operation(description = DescriptionConstants.DELETE_ROLE_USER)
    @ApiResponses(value={
            @ApiResponse(responseCode = "204", description =ResponseConstants.NO_CONTENT),
            @ApiResponse(responseCode = "404", description =ResponseConstants.NOT_FOUNT)})
    @DeleteMapping(ResourceConstants.RESOURCE_ID_ROLE_USER)
    public RadegResponse<Void> deleteRoleUserController(
            @Parameter(name = ParametrerConstants.PARAMETER_ROLE_USER_ID, required = true)
            @PathVariable  short idRoleUser) throws RadegException {

        roleUserService.deleteRoleUserService(idRoleUser);

        return new RadegResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.NO_CONTENT), CommonConstants.OK);
    }
}
