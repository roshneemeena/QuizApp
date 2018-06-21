package fr.epita.quiz.services;

import java.util.List;

import fr.epita.quiz.dao.DetailAnswerDAO;
import fr.epita.quiz.model.DetailAnswer;
import fr.epita.quiz.model.MCQChoice;
import fr.epita.quiz.model.Question;

public interface QuestionService {
	
	public List<Question> loadQuestion();
	public void getAnswer(DetailAnswer detailAnswer);
	public List<Question> loadNextQuestion(int questionId);
	public List<Question> loadQuestion(int questionId);

}
