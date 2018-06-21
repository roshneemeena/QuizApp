package fr.epita.quiz.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import fr.epita.quiz.model.Students;

public class StudentValidation implements Validator {
	
   @Override
	public boolean supports(Class arg0) {
		return Students.class.equals(arg0);
	}




	@Override
	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
		
	}




	



	
	

	
	
	
}
