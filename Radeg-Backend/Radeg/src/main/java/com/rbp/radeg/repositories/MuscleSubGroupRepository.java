package com.rbp.radeg.repositories;

import com.rbp.radeg.model.MuscleSubGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MuscleSubGroupRepository extends JpaRepository<MuscleSubGroup, Long> {
}

