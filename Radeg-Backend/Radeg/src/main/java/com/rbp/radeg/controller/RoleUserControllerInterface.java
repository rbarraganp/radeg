package com.rbp.radeg.controller;
import com.rbp.radeg.dto.RoleUserDto;
import com.rbp.radeg.utils.constans.ParametrerConstants;
import com.rbp.radeg.utils.exceptions.RadegException;
import com.rbp.radeg.utils.responses.RadegResponse;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * ROLEUSER CONTROLLER INTERFACE
 */


public interface RoleUserControllerInterface {

    /** * Create New RoleUser */
    public RadegResponse<Void> createNewRoleUserController(RoleUserDto roleUserDto) throws RadegException;


    /** * Delete RoleUser */
    public RadegResponse<Void> deleteRoleUserController(short idRoleUser) throws RadegException;

}
