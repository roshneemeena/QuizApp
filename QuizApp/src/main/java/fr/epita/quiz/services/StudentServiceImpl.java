package fr.epita.quiz.services;

import org.springframework.beans.factory.annotation.Autowired;

import fr.epita.quiz.dao.StudentDAO;
import fr.epita.quiz.model.Students;

public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentDAO studentDAO;
	
	
	public void setStudentDao(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	

	@Override
	public void savestudent(Students student) {
		studentDAO.savestudent(student);
		
		
	}

	@Override
	public Students loginStudent(Students student) {
		return studentDAO.loginStudent(student);
	}
	
	
	
	

}
