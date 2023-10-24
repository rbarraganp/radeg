package com.rbp.radeg.repositories;

import com.rbp.radeg.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {



    //Check if nickUser exist
    Optional<User> findByNick(String nick);

    //Check if email exists
    Optional<User> findByEmail(String email);

}

