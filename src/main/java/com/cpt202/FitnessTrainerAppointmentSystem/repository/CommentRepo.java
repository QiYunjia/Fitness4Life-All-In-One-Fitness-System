package com.cpt202.FitnessTrainerAppointmentSystem.repository;

import com.cpt202.FitnessTrainerAppointmentSystem.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment, Long> {
    List<Comment> findByTrainerId(Long trainerId);

}
