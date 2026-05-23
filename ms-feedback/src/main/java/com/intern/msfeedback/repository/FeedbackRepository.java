package com.intern.msfeedback.repository;

import com.intern.msfeedback.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
