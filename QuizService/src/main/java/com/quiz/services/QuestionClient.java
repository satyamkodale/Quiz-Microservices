package com.quiz.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.quiz.entities.Question;

//@FeignClient(url="http://localhost:8082",value="Question-Client") in normal case without multiple instnce and load balancing 
@FeignClient(name="QUESTION-SERVICE")
public interface QuestionClient {
	
	@GetMapping("/question/quiz/{qid}")
	List<Question> getQuestionOfQuiz(@PathVariable Long qid);
	

}
