package com.quiz.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.quiz.entities.Quiz;


public interface QuizService {
	
	Quiz add(Quiz quiz);
	
	List<Quiz> get();
	
	Quiz get(Long id);
	
	

}
