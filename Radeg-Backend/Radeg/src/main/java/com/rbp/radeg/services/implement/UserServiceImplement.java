package com.rbp.radeg.services.implement;

import com.rbp.radeg.dto.UserDto;
import com.rbp.radeg.dto.UserUdpDto;
import com.rbp.radeg.model.RoleUser;
import com.rbp.radeg.model.User;
import com.rbp.radeg.repositories.RoleUserRepository;
import com.rbp.radeg.repositories.UserRepository;
import com.rbp.radeg.services.UserServiceInterface;
import com.rbp.radeg.utils.constans.ExceptionConstants;
import com.rbp.radeg.utils.exceptions.ConflictException;
import com.rbp.radeg.utils.exceptions.NotFoundException;
import com.rbp.radeg.utils.exceptions.RadegException;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplement implements UserServiceInterface {

    private ModelMapper modelMapper = new ModelMapper();
    private static final Logger lg = LoggerFactory.getLogger(UserServiceImplement.class);


    @Autowired
    UserRepository userRepo;

    @Autowired
    RoleUserRepository roleUserRepo;


    /**
     * CREATE NEW USER
     * @param userDto
     * @throws RadegException
     */
    @Override
    public void createNewUserService(UserDto userDto) throws RadegException {


            if(checkEmailService(userDto.getEmail())){

                throw new ConflictException(ExceptionConstants.MESSAGE_ALREADY_EXIST_EMAIL_USER);

            }else if(checkNickService(userDto.getNick())) {

                throw new ConflictException(ExceptionConstants.MESSAGE_ALREADY_EXIST_NICK_USER);
            }
            else{

                //Create user Object
                User user= modelMapper.map(userDto, User.class);

                //check RoleUser
                addDefaultRoleUser(user);

                //save to database
                userRepo.save(user);
            }

    }


    /**
     * CHECK EXIT USER´S NICK
     * @param nick
     * @return
     * @throws RadegException
     */
    @Override
    public Boolean checkNickService(String nick) throws RadegException {

        return ( userRepo.findByNick(nick).isPresent());
    }


    /**
     * CHECK EXIT USER´S EMAIL
     * @param email
     * @return
     * @throws RadegException
     */
    @Override
    public Boolean checkEmailService(String email) throws RadegException {

        return (userRepo.findByEmail(email).isPresent());
    }


    /**
     * DELETE USER
     * @param idUser
     * @throws RadegException
     */
    @Override
    public void deleteUserService(Long idUser) throws RadegException {

        User user= userRepo.findById(idUser)
                .orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_USER));

        userRepo.delete(user);
    }


    /**
     * UPDATE USER
     *
     * @param userUdpDto
     * @return
     * @throws RadegException
     */
    @Override
    public UserUdpDto updateUserService(UserUdpDto userUdpDto) throws RadegException {

        User user= userRepo.findById(userUdpDto.getIdUser())
                .orElseThrow(() -> new  NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_USER));

        //update user´s fields
        user.setNick(userUdpDto.getNick());
        user.setEmail(userUdpDto.getEmail());
        user.setName(userUdpDto.getName());
        user.setBirhtDate(userUdpDto.getBirhtDate());
        user.setPhone(userUdpDto.getPhone());
        user.setHeight(userUdpDto.getHeight());

        return modelMapper.map(userRepo.save(user), UserUdpDto.class);
    }


    /** * PRIVATE  METHODS **/

    /**
     * CHECK VALOR TYPE ROLE USER
     * @param user
     * @throws RadegException
     */
    private void addDefaultRoleUser(User user) throws RadegException {

        //if the roleUser of the new user is null, we add "User" by default as roleUser
        if (user.getRole() == null) {

            RoleUser roleUser = roleUserRepo.findByName("USER")
                    .orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_ROLE_USER));

            //add RoleUser to user
            user.setRole(roleUser);
        }

    }





}
