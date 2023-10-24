package com.rbp.radeg.services.implement;

import com.rbp.radeg.dto.MuscleGroupDto;
import com.rbp.radeg.model.MuscleGroup;
import com.rbp.radeg.model.User;
import com.rbp.radeg.repositories.MuscleGroupRepository;
import com.rbp.radeg.repositories.UserRepository;
import com.rbp.radeg.services.MuscleGroupServiceInterface;
import com.rbp.radeg.utils.constans.ExceptionConstants;
import com.rbp.radeg.utils.exceptions.ConflictException;
import com.rbp.radeg.utils.exceptions.NotFoundException;
import com.rbp.radeg.utils.exceptions.RadegException;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * MUSCLE GROUP SERVICE IMPLEMENT
 */
@Service
public class MuscleGroupServiceImplement implements MuscleGroupServiceInterface {

    @Autowired
    MuscleGroupRepository muscleGroupRepo;

    @Autowired
    UserRepository userRepo;

    private ModelMapper modelMapper= new ModelMapper();
    private static final Logger lg= LoggerFactory.getLogger(MuscleGroupServiceImplement.class);

    @Override
    public List<MuscleGroupDto> createNewMuscleGroupService(MuscleGroupDto muscleGroupDto) throws RadegException {

        User user= userRepo.findById(muscleGroupDto.getIdUser())
                .orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_USER));

        muscleGroupDto.setName(formatString(muscleGroupDto.getName()));

        if(checkExistName(muscleGroupDto.getIdUser(), muscleGroupDto.getName())){
            new ConflictException(ExceptionConstants.MESSAGE_ALREADY_EXIST_MUSCLE_GROUP_NAME);}

        MuscleGroup  muscleGroup= new MuscleGroup(user, muscleGroupDto.getName());

        muscleGroupRepo.save(muscleGroup);


        return loadMuscleGroupDto(user);

        /* RBP
        * Crear una funcion que cree un array list de grupo muscular, debe contener tanto los grupos musculares por
        * defecto como los del propio usuario
        *  */



    }


    /* PRIVATE METHODS*/

    /**
     * CHECK EXIST NAME MUSCLE GROUP
     * @param name
     * @return
     * @throws RadegException
     */
    private boolean checkExistName(Long idUser, String name)throws RadegException{

        User defaulUser= getDefaultUser();

        /** RBP
         * FUTURA ACTUALIZACIÓN:
         *  Actualizar la consulta para que busque el nombre tanto por el usuario que intenta crearla,
         *  como por defaulUser
         */

       if(muscleGroupRepo.findByUserIdUserAndName(defaulUser.getIdUser(), name).isPresent()){ return false; }

        return muscleGroupRepo.findByUserIdUserAndName(idUser, name).isEmpty();

    }


    /**
     * FORMAT MUSCLE GROUP NAME
     * @param name
     * @return
     * @throws RadegException
     */
    private String formatString(String name)throws RadegException{

     String[] array=  name.split(" ");

     for(String str: array){
         str.toLowerCase();
         str.toUpperCase().charAt(0);
     }

     return  array.toString();

    }


    /**
     * CREATE LIST MUSCLE GROUP DTO
     * @return
     * @throws RadegException
     */
    private List<MuscleGroupDto> loadMuscleGroupDto(User user)throws RadegException{

        User defaultUser= getDefaultUser();

        List<MuscleGroupDto> muscleGroupDtos= new ArrayList<>();

        //Optional<User> defaulUserMuscleGroup= userRepo.findById(defaultUser.getIdUser());

        //Optional<User> userMuscleGroup= userRepo.findById(user.getIdUser());

        //if(defaulUserMuscleGroup.isPresent()){

        // RBP * MIRAR MODELMAPPER ERROR  *

        List<MuscleGroupDto> listDefaultUser= userRepo.findById(defaultUser.getIdUser())
                .stream()
                .map(muscleGroup-> modelMapper.map(muscleGroup,MuscleGroupDto.class))
                .collect(Collectors.toList());

        List<MuscleGroupDto> listUser= userRepo.findById(user.getIdUser())
                .stream()
                .map(muscleGroup-> modelMapper.map(muscleGroup,MuscleGroupDto.class))
                .collect(Collectors.toList());

        listDefaultUser.addAll(listUser);

        return  listDefaultUser;

        }




    /**
     * GET DEFAULT USER
     * @return
     * @throws RadegException
     */
    private User getDefaultUser()throws RadegException{

        return userRepo.findByNick("defaultUser")
                .orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_NOT_FOUND_DEFAULT_USER));

    }




}
