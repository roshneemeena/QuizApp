package fr.epita.quiz.dao;

import fr.epita.quiz.model.Students;

public interface StudentDAO {
	
	public void savestudent(Students student);
	public Students loginStudent(Students student);

}
