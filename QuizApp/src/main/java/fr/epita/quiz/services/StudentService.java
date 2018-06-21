package fr.epita.quiz.services;

import fr.epita.quiz.model.Students;

public interface StudentService {
	
	public void savestudent(Students student);
	public Students loginStudent(Students student);

}
