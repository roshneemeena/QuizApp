package fr.epita.quiz.dao;

import java.util.List;

import fr.epita.quiz.model.MCQChoice;
import fr.epita.quiz.model.Question;

public interface QuestionDAO {
	public List<Question> loadQuestion();
	public List<Question> loadNextQuestion(int questionId);
	public List<Question> loadQuestion(int questionId);

}


