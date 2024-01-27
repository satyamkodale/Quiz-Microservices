package com.quiz.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.entities.Quiz;
import com.quiz.repositories.QuizRepository;
import com.quiz.services.QuestionClient;
import com.quiz.services.QuizService;

@Service
public class QuizServiceImpl implements QuizService
{
	@Autowired
	private QuizRepository quizRepository;
	
//	or you can do
	
//	public QuizServiceImpl(QuizRepository quizRepository) 
//	{
//		this.quizRepository= quizRepository;
//	}
	
	@Autowired
	private QuestionClient questionClient;

	@Override
	public Quiz add(Quiz quiz) {
		// TODO Auto-generated method stub
		return this.quizRepository.save(quiz);
	}

	@Override
	public List<Quiz> get() {
		
		List<Quiz> quizes = this.quizRepository.findAll();
		
		List<Quiz> newQuizList= quizes.stream().map(quiz->{
			quiz.setQuestion(questionClient.getQuestionOfQuiz(quiz.getId()));
			return quiz;
		}).collect(Collectors.toList());
		
		return newQuizList;
	}

	@Override
	public Quiz get(Long id) {
		
		Quiz quiz = quizRepository.findById(id).orElseThrow(()-> new RuntimeException("quiz not found"));
		quiz.setQuestion(questionClient.getQuestionOfQuiz(quiz.getId()));
		return quiz;
	}
	
	

}
