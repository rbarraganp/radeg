package com.rbp.radeg.services;

import com.rbp.radeg.dto.RoleUserDto;
import com.rbp.radeg.utils.exceptions.RadegException;

/**
 * ROLEUSER SERVICE IMPLEMENT
 */
public interface RoleUserServiceInterface {


    /** * Crea new roleUser */
    public void createNewRoleUserService(RoleUserDto roleUserDto) throws RadegException;

    /** * Delete  roleUser */
    public void deleteRoleUserService(short idRole) throws RadegException;



}

