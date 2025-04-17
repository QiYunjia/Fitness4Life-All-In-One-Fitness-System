package com.cpt202.FitnessTrainerAppointmentSystem.repository;
import org.springframework.stereotype.Repository;
// import javax.persistence.Query;
import com.cpt202.FitnessTrainerAppointmentSystem.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

// @Query("SELECT u FROM User u WHERE u.username = :username")
@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

    User findByUsername(@Param("username") String username);
    User findByEmail(@Param("email") String email);

}
