package fr.epita.quiz.services;
import java.util.List;

import fr.epita.quiz.model.*;

public interface MCQService {
	
		public List<MCQChoice> loadQuestion();
		public String getAnswer(int questionId);
		public List<MCQChoice> loadNextQuestion(int questionId);
		public List<MCQChoice> loadQuestion(int questionId);
	}


