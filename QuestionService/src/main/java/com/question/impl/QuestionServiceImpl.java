package com.question.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.question.entities.Question;
import com.question.repositories.QuestionRepository;
import com.question.services.QuestionService;

@Service
public class QuestionServiceImpl  implements QuestionService{
	
	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public Question create(Question question) {

		
		return this.questionRepository.save(question);
	}

	@Override
	public List<Question> get() {
		
		return this.questionRepository.findAll();
	}

	@Override
	public Question getOne(Long id) {
		
		return this.questionRepository.findById(id).orElseThrow(()-> new RuntimeException("question not found"));
	}

	@Override
	public List<Question> getQuestionsOfQuiz(Long quizId) {
		
		return this.questionRepository.findByQuizId(quizId);
	}

}
