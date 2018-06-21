package fr.epita.quiz.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.epita.quiz.dao.AnswerDAO;
import fr.epita.quiz.dao.DetailAnswerDAO;
import fr.epita.quiz.dao.DetailAnswerDAOImpl;
import fr.epita.quiz.dao.MCQChoiceDAO;
import fr.epita.quiz.dao.QuestionDAO;
import fr.epita.quiz.dao.QuestionDAOImpl;
import fr.epita.quiz.model.DetailAnswer;
import fr.epita.quiz.model.Question;

public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	private QuestionDAO questionDAO;
	private DetailAnswerDAO detailAnswerDAO;
	
	@Autowired
	public void setQuestionDao(QuestionDAO questionDao){
		this.questionDAO = questionDao;
	}

	@Autowired
	public void setAnswerDao(DetailAnswerDAO detailAnswerDAO){
		this.detailAnswerDAO = detailAnswerDAO;
	}

	@Override
	public List<Question> loadQuestion() {
		return questionDAO.loadQuestion();
	}

	

	@Override
	public List<Question> loadNextQuestion(int questionId) {
		return questionDAO.loadNextQuestion(questionId);
	}

	@Override
	public List<Question> loadQuestion(int questionId) {
		return questionDAO.loadQuestion(questionId);
	}

	@Override
	public void getAnswer(DetailAnswer detailAnswer) {
		
		detailAnswerDAO.getAnswer(detailAnswer);
		
		
	}

}
