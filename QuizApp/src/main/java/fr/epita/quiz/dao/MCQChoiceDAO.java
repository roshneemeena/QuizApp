package fr.epita.quiz.dao;

import java.util.List;

import fr.epita.quiz.model.*;

public interface MCQChoiceDAO {
	
	public List<MCQChoice> loadQuestion();
	public List<MCQChoice> loadNextQuestion(int questionId);
	public List<MCQChoice> loadQuestion(int questionId);

}
