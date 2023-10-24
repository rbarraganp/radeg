package com.rbp.radeg.services.implement;

import com.rbp.radeg.dto.RoleUserDto;
import com.rbp.radeg.model.RoleUser;
import com.rbp.radeg.repositories.RoleUserRepository;
import com.rbp.radeg.services.RoleUserServiceInterface;
import com.rbp.radeg.utils.constans.ExceptionConstants;
import com.rbp.radeg.utils.exceptions.ConflictException;
import com.rbp.radeg.utils.exceptions.NotFoundException;
import com.rbp.radeg.utils.exceptions.RadegException;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** * ROLEUSER SERVICE IMPLEMENT */
@Service
public class RoleUserServiceImplement implements RoleUserServiceInterface {

    private ModelMapper modelMapper= new ModelMapper();
    private static final Logger lg= LoggerFactory.getLogger(RoleUserServiceImplement.class);

    @Autowired
    RoleUserRepository roleUserRepo;

    /**
     * CREATE NEW ROLEUSER
     * @param roleUserDto
     * @throws RadegException
     */
    @Override
    public void createNewRoleUserService(RoleUserDto roleUserDto) throws RadegException {


        //check exist roleUser with this type in database
        if(roleUserRepo.findByName(roleUserDto.getName()).isPresent()){

            throw new ConflictException(ExceptionConstants.MESSAGE_ALREADY_EXIT_ROLE_USER);

        }else{

            //Create new RoleUser object
            RoleUser roleUser= modelMapper.map(roleUserDto, RoleUser.class);

            //save to database
            roleUserRepo.save(roleUser);
        }


    }


    /**
     * DELETE ROLE USER
     * @param idRole
     * @throws RadegException
     */
    @Override
    public void deleteRoleUserService(short idRole) throws RadegException {

        RoleUser roleUser = roleUserRepo.findById((short) idRole)
                .orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_ROLE_USER));

        roleUserRepo.delete(roleUser);


    }




    /** *** PRIVATE  METHODS **/


     }