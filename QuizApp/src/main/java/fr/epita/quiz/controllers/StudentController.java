package fr.epita.quiz.controllers;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.ModelAttribute;

import fr.epita.quiz.model.Students;
import fr.epita.quiz.services.StudentService;
import fr.epita.quiz.validation.StudentValidation;

@Controller
@RequestMapping(value="/Student")

public class StudentController {
	@Autowired
	private StudentService studentService;
	
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		model.put("StudentData", new Students());
		return "register/register";
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String saveForm(ModelMap model, @ModelAttribute("StudentData") @Valid Students student, BindingResult br, HttpSession session) 
	{
		StudentValidation studentValidation = new StudentValidation();
		studentValidation.validate(studentValidation, br);
		if(br.hasErrors()) {
			return "register/register";
		}
		else {
			studentService.savestudent(student);
			session.setAttribute("student",student);
			return "redirect:success";
		}
		
	}
	
	@RequestMapping(value="/Login", method = RequestMethod.GET)
	public String showLogin(ModelMap model,HttpSession session) {
		if(session.getAttribute("student") == null) {
			model.put("StudentData", new Students());
			return "Login/Login";
		}
		else {
			return "redirect:success";
		}
	}
	
	@RequestMapping(value="/Login", method = RequestMethod.POST)
	public String doLogin(ModelMap model, @ModelAttribute("StudentData") @Valid Students student, BindingResult br, HttpSession session) 
	{
		if(student.getEmail() != null && student.getPassword() != null && session.getAttribute("student")==null) {
			student = studentService.loginStudent(student);
			if (student != null) {
				session.setAttribute("student", student);
				return "redirect:success";
			} else {
				model.put("failed", "Login Failed");
				return "login/login";
				
			}
		}
		else {
			return "redirect:success";
		}
	}
	
	@RequestMapping(value= "/logout" , method = RequestMethod.GET)
	public String logOut(ModelMap model , HttpSession session) {
		session.removeAttribute("student");
		return "redirect:login";
	}
	
	@RequestMapping(value= "/success" , method = RequestMethod.GET)
	public String showSuccess(ModelMap model , HttpSession session) {
		model.put("success", new Students());
		return "success";
	}
	


}
