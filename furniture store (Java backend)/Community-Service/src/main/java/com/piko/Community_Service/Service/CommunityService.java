package com.piko.Community_Service.Service;

import com.piko.Community_Service.Model.Question;
import com.piko.Community_Service.Model.QuestionReply;
import com.piko.Community_Service.Repository.QuestionReplyRepository;
import com.piko.Community_Service.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommunityService {
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    QuestionReplyRepository questionReplyRepository;

    public void saveQuestion(Question question) {
        questionRepository.save(question);
    }

    public List<Question> fetchAllQuestions()
    {
       return questionRepository.findAll();
    }

    public void saveReply(QuestionReply questionReply) {
      questionReplyRepository.save(questionReply);
    }

    public List<QuestionReply> fetchAllQuestionReplies() {
       return questionReplyRepository.findAll();
    }

    public List<QuestionReply> getRepliesByReferredCommentId(String referredCommentId) {
            return questionReplyRepository.findByrefferdcommentid(referredCommentId);

    }


    public Optional<Question> findBycommentid(String commentid) {
        return questionRepository.findBycommentid(commentid);
    }
}
