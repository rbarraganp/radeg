package com.rbp.radeg.repositories;

import com.rbp.radeg.model.MuscleGroup;
import com.rbp.radeg.utils.exceptions.RadegException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface MuscleGroupRepository extends JpaRepository<MuscleGroup, Long> {

/** * Find Muscle Group By Name*/
Optional <MuscleGroup> findByUserIdUserAndName(Long idUser , String name)throws RadegException;



}

