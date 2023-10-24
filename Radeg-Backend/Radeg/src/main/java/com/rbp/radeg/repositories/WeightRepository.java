package com.rbp.radeg.repositories;

import com.rbp.radeg.model.RoleUser;
import com.rbp.radeg.model.User;
import com.rbp.radeg.model.Weight;
import com.rbp.radeg.utils.exceptions.RadegException;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WeightRepository extends JpaRepository<Weight, Long> {


    /** List User´s Weights * */
    Optional <List<Weight>> findByUser(User user)throws RadegException;

    /** Delete all User´s Weights * */
    @Transactional
    void deleteAllByUser(User user)throws RadegException;

    /** * Update User´s Weight*/
    Optional <Weight> findByUserAndIdWeight(User user, Long idWeight)throws RadegException;

}

