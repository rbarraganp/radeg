package com.rbp.radeg.services.implement;

import com.rbp.radeg.dto.TrainingDto;
import com.rbp.radeg.model.Training;
import com.rbp.radeg.model.User;
import com.rbp.radeg.repositories.TrainingRepository;
import com.rbp.radeg.repositories.UserRepository;
import com.rbp.radeg.services.TrainingServiceInterface;
import com.rbp.radeg.utils.constans.ExceptionConstants;
import com.rbp.radeg.utils.exceptions.NotFoundException;
import com.rbp.radeg.utils.exceptions.RadegException;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainingServiceImplement implements TrainingServiceInterface {


    @Autowired
    TrainingRepository trainingRepo;

    @Autowired
    UserRepository userRepo;

    private ModelMapper modelMapper= new ModelMapper();
    private static final Logger lg= LoggerFactory.getLogger(RoleUserServiceImplement.class);


    /**
     * CREATE NEW TRAINING
     * @param idUser
     * @return
     * @throws RadegException
     */
    @Override
    public TrainingDto createNewTrainingService(Long idUser) throws RadegException {

        User user= userRepo.findById(idUser)
                .orElseThrow(()-> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_USER));

        Training newTraining= new Training(user);

        return modelMapper.map(trainingRepo.save(newTraining), TrainingDto.class);

    }






}
