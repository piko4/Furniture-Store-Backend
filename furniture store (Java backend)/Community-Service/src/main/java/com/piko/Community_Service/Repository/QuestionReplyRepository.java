package com.piko.Community_Service.Repository;

import com.piko.Community_Service.Model.QuestionReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionReplyRepository extends JpaRepository<QuestionReply,Long> {
    List<QuestionReply> findByrefferdcommentid(String referredCommentId);
}
