package com.question.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.question.entities.Question;
import com.question.services.QuestionService;


@RestController
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	
	   //create 
		@PostMapping("/create")
		public Question create(@RequestBody Question question) 
		{
		
			return questionService.create(question);
		}
		
		//getall
		@GetMapping("/get")
		public List<Question> getAll()
		{
			return questionService.get();
		}
		
		//get 
		@GetMapping("/get/{qid}")
		public Question get(@PathVariable("qid") long qid) 
		{
			return questionService.getOne(qid);
		}
		
		
		//get question of specific quiz 
		
		@GetMapping("/quiz/{qid}")
		public List<Question> getQuestionsOfQuiz(@PathVariable("qid") long qid)
		{
			return this.questionService.getQuestionsOfQuiz(qid);
			
		}
}

