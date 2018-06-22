package fr.epita.quiz.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.epita.quiz.dao.StudentDAOImpl;
import fr.epita.quiz.model.Students;
import fr.epita.quiz.services.StudentService;
import fr.epita.quiz.services.StudentServiceImpl;
/**
 * This method is for connect the new user registration model and view
 * @author Roshnee
 *
 */

@Controller
public class RegistrationController {
  @Autowired
  public StudentDAOImpl studentservice;
  /**
   * This method is used to load the registration page
   * @param request
   * @param response
   * @return
   */
  
  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("register");
    mav.addObject("student", new Students());
    return mav;
  }
  
  /**
   * This is to perform the action in the form to save the details in the database
   * @param request
   * @param response
   * @param student
   * @return
   */
  
  @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
  public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
  @ModelAttribute("student") Students student) {
	  
	  studentservice.savestudent(student);
 
	  
	  
  return new ModelAndView("success" ,"Name" , student.getName());
  }
}