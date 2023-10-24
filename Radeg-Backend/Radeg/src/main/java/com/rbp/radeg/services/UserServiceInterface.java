package com.rbp.radeg.services;

import com.rbp.radeg.dto.UserDto;
import com.rbp.radeg.dto.UserUdpDto;
import com.rbp.radeg.utils.exceptions.RadegException;

/** * USER SERVICE INTERFACE */
public interface UserServiceInterface {
    

    /** * Create new User */
    public void  createNewUserService(UserDto userDto)throws RadegException;

    /** * Check user´s nick */
    public Boolean checkNickService(String nick)throws RadegException;

    /** * Check user´s email */
    public Boolean checkEmailService(String email)throws RadegException;

    /** * Delete User */
    public void deleteUserService(Long idUser)throws RadegException;

    /** * Update User */
    public UserUdpDto updateUserService(UserUdpDto userUdpDto) throws RadegException;




}
