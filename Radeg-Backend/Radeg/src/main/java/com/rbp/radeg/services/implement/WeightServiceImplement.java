package com.rbp.radeg.services.implement;

import com.rbp.radeg.dto.WeightDto;
import com.rbp.radeg.model.User;
import com.rbp.radeg.model.Weight;
import com.rbp.radeg.repositories.UserRepository;
import com.rbp.radeg.repositories.WeightRepository;
import com.rbp.radeg.services.WeightServiceInterface;
import com.rbp.radeg.utils.constans.ExceptionConstants;
import com.rbp.radeg.utils.exceptions.NotFoundException;
import com.rbp.radeg.utils.exceptions.RadegException;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/** WEIGHT SERVICE IMPLEMENT*/
@Service
public class WeightServiceImplement implements WeightServiceInterface {


    @Autowired
    WeightRepository weightRepo;

    @Autowired
    UserRepository userRepo;

   private static ModelMapper modelMapper= new ModelMapper();

    private static final Logger lg= LoggerFactory.getLogger(WeightServiceImplement.class);


    /**
     * CREATE NEW USER´S WEIGHT
     * @param idUser
     * @param weight
     * @return
     * @throws RadegException
     */
    @Override
    public List<WeightDto> addNewWeightService(Long idUser, Double weight) throws RadegException {

        User user = userRepo.findById(idUser)
              .orElseThrow(() ->  new  NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_USER));


            Weight newWeight= new Weight(user, weight);

            weightRepo.save(newWeight);

            return createListWeightDto(user);

    }




    /**
     * DELETE WEIGHT
     * @param idUser
     * @param idWeight
     * @return
     * @throws RadegException
     */
    @Override
    public List<WeightDto> deleteWeightService(Long idUser, Long idWeight) throws RadegException {

        User user = userRepo.findById(idUser)
                .orElseThrow(() ->  new  NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_USER));

        Weight weight= weightRepo.findById(idWeight)
                .orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_WEIGHT));

        weightRepo.delete(weight);

        return createListWeightDto(user);

    }


    /**
     * DELETE ALL USER´S WEIGHT
     * @param idUser
     * @return
     * @throws RadegException
     */
    @Override
    public List<WeightDto> deleteAllWeightService(Long idUser) throws RadegException {

        User user = userRepo.findById(idUser)
                .orElseThrow(() ->  new  NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_USER));

        weightRepo.deleteAllByUser(user);

        return createListWeightDto(user);

    }



    /**
     * UPDATE USER´S WEIGHT
     * @param weightDto
     * @return
     * @throws RadegException
     */
    @Override
    public List<WeightDto> updateWeightService(WeightDto weightDto) throws RadegException {

        User user = userRepo.findById(weightDto.getIdUser())
                .orElseThrow(() ->  new  NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_USER));

        Weight weight= weightRepo.findByUserAndIdWeight(user, weightDto.getIdWeight())
                .orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_WEIGHT));

        weight.setWeight(weightDto.getWeight());

        weightRepo.save(weight);

        return createListWeightDto(user);

    }



    // PRIVATE METHODS

    /**
     * CREATE LIST USER´S WEIGHT DTO
     * @param user
     * @return
     * @throws RadegException
     */
    private List<WeightDto> createListWeightDto(User user)throws RadegException{

       /* return   weightRepo.findByUser(user)
                .stream()
                .map(weight->modelMapper.map(weight,WeightDto.class))
                .collect(Collectors.toList());*/

        List<Weight> weightList =  weightRepo.findByUser(user)
                .orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_USER));

        List<WeightDto> weightDtoList = new ArrayList<>();

        for(Weight weight: weightList){

            WeightDto weightDto= new WeightDto();

            weightDto.setIdUser(weight.getUser().getIdUser());
            weightDto.setIdWeight(weight.getIdWeight());
            weightDto.setWeight(weight.getWeight());
            weightDto.setDate(weight.getDate());

            weightDtoList.add(weightDto);
        }

        return  weightDtoList;

    }

}
