package com.piko.Community_Service.Controller;


import com.piko.Community_Service.Model.Question;
import com.piko.Community_Service.Model.QuestionReply;
import com.piko.Community_Service.Service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/community")
public class CommunityController {
    @Autowired
    CommunityService communityService;

    @GetMapping("getAll")
    public List<Question> getAllQuestions() {
        System.out.println("got all");
        return communityService.fetchAllQuestions();
    }

    @PostMapping("setQuestion")
    public void setQuestion(@RequestBody Question question) {
        question.setDate(new Date());
        System.out.println("question set.." + question.getUsername());
        communityService.saveQuestion(question);
    }

    //----------------Set reply----------------
    @PostMapping("setQuestionReply")
    public ResponseEntity<String> setQuestionReply(@RequestBody QuestionReply questionReply){
        questionReply.setDate(new Date());
        
        communityService.saveReply(questionReply);
        System.out.println("reply added !!");
        return ResponseEntity.ok("reply added");
    }

    @GetMapping("getAllReplies")
    public List<QuestionReply> getAllQuestionReply(){
        return communityService.fetchAllQuestionReplies();
    }

    @GetMapping("getReplyByRefCommentid/{referredCommentId}")
    public ResponseEntity<List<QuestionReply>> getRepliesByReferredCommentId(@PathVariable String referredCommentId) {
        List<QuestionReply> replies = communityService.getRepliesByReferredCommentId(referredCommentId);
        System.out.println("getting replies...");
        return ResponseEntity.ok(replies);
    }

    @GetMapping("/question/{id}")
    public ResponseEntity<Question> getQuestion(@PathVariable String id) {
        Optional<Question> question = communityService.findBycommentid(id);
        return question.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


}
