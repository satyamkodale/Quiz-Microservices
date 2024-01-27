package com.quiz.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.entities.Quiz;
import com.quiz.services.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	
	@Autowired
	private QuizService quizService;

	
	//create 
	@PostMapping("/create")
	public Quiz create(@RequestBody Quiz quiz) 
	{
		return quizService.add(quiz);
	}
	
	//getall
	@GetMapping("/get")
	public List<Quiz> getAll()
	{
		return quizService.get();
	}
	
	//get 
	@GetMapping("/get/{qid}")
	public Quiz get(@PathVariable("qid") long qid) 
	{
		return quizService.get(qid);
	}
}
