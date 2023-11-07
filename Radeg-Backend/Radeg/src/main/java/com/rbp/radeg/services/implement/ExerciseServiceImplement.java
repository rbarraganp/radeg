package com.rbp.radeg.services.implement;

import com.rbp.radeg.dto.ExerciseDto;
import com.rbp.radeg.model.Exercise;
import com.rbp.radeg.model.MuscleSubGroup;
import com.rbp.radeg.model.Training;
import com.rbp.radeg.repositories.ExerciseRepository;
import com.rbp.radeg.repositories.MuscleSubGroupRepository;
import com.rbp.radeg.repositories.TrainingRepository;
import com.rbp.radeg.services.ExerciseServiceInterface;
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

/** * EXERCISE SERVICE IMPLEMENT */

@Service
public class ExerciseServiceImplement implements ExerciseServiceInterface {


    @Autowired
    ExerciseRepository exerciseRepo;
    @Autowired
    TrainingRepository trainingRepo;
    @Autowired
    MuscleSubGroupRepository muscleSubGroupRepo;


    private ModelMapper modelMapper = new ModelMapper();

    private static final Logger lg= LoggerFactory.getLogger(ExerciseServiceImplement.class);


    /**
     * create new Exercise
     * @param exerciseDto
     * @return
     * @throws RadegException
     */
    @Override
    public ExerciseDto createNewExerciseService(ExerciseDto exerciseDto) throws RadegException {


        Training training = trainingRepo.findById(exerciseDto.getIdTraining())
                .orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_TRAINING));

        List<MuscleSubGroup> muscleSubGroupDtoList= createMuscleSubGroupList(exerciseDto.getIdMuscleSubGroupList());

        Exercise exercise = new Exercise(training);

        exercise.setMuscleSubGroupList(muscleSubGroupDtoList);

        return modelMapper.map(exerciseRepo.save(exercise), ExerciseDto.class);

    }


    /** * PRIVATE  METHODS **/

    /**
     * check exist id´s muscle subgroup and create list
     * @param longList
     * @throws RadegException
     */
    private  List<MuscleSubGroup> createMuscleSubGroupList (List<Long> longList)throws RadegException{

        List<MuscleSubGroup> muscleSubGroupList= new ArrayList<>();

        for (Long idMuscleSubGroup: longList) {

           MuscleSubGroup muscleSubGroup = muscleSubGroupRepo.findById(idMuscleSubGroup)
                   .orElseThrow(()-> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_SUBMUSCLE_GROUP));

           muscleSubGroupList.add(muscleSubGroup);
        }

        return muscleSubGroupList;
        
    }




}
