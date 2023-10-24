package com.rbp.radeg.controller;

import com.rbp.radeg.dto.UserDto;
import com.rbp.radeg.dto.UserUdpDto;
import com.rbp.radeg.utils.exceptions.RadegException;
import com.rbp.radeg.utils.responses.RadegResponse;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * USER CONTROLLER INTERFACE
 */
public interface UserControllerInterface {


    public String testConnection()throws RadegException;

    /*** Create new User */
    public RadegResponse<Void> createNewUserController(@RequestBody UserDto userDto) throws RadegException;


    /** * Delete User */
    public RadegResponse<Void> deleteUserController(Long idUser)throws RadegException;

    /** * Update User */
    public  RadegResponse<UserUdpDto> updateUserController(UserUdpDto userUdpDto) throws RadegException;


    /** * Return a Users */



    /** * Update User´s password */

}

