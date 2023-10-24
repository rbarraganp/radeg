package com.rbp.radeg.repositories;

import com.rbp.radeg.model.RoleUser;
import com.rbp.radeg.utils.exceptions.RadegException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleUserRepository extends JpaRepository<RoleUser, Short> {

    /** Find By Name * */
    Optional<RoleUser> findByName(String name)throws RadegException;

}

