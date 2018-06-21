package fr.epita.quiz.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.epita.quiz.dao.*;
import fr.epita.quiz.model.MCQChoice;
public class MCQServiceImpl implements MCQService {
	
	@Autowired
	private MCQChoiceDAO MCQChoiceDao;
	private AnswerDAO answerDao;
	
	@Autowired
	public void setQuestionDao(MCQChoiceDAO MCQChoiceDao){
		this.MCQChoiceDao = MCQChoiceDao;
	}

	@Autowired
	public void setAnswerDao(AnswerDAO answerDao){
		this.answerDao = answerDao;
	}

	public List<MCQChoice> loadQuestion(){
		return MCQChoiceDao.loadQuestion();
	}
	
	public String getAnswer(int questionId){
		return answerDao.getAnswer(questionId);
	}
	
	public List<MCQChoice> loadNextQuestion(int questionId){
		return MCQChoiceDao.loadNextQuestion(questionId);
	}

	public List<MCQChoice> loadQuestion(int questionId){
		return MCQChoiceDao.loadQuestion(questionId);
	}
}


