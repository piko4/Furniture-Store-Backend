package com.piko.Community_Service.Repository;

import com.piko.Community_Service.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {

    Optional<Question> findBycommentid(String commentid);
}
