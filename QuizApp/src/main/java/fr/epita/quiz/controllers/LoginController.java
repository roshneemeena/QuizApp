package fr.epita.quiz.controllers;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.epita.quiz.dao.AdminDAOImpl;
import fr.epita.quiz.dao.StudentDAOImpl;
import fr.epita.quiz.model.Students;
import fr.epita.quiz.services.StudentServiceImpl;

/**
 * This class is for connecting the student login model and the student login view
 * @author Roshnee
 * This class is for connecting the user login model and the  user login model
 *
 */

@Controller
public class LoginController {
	
	/**
	 * This method is used for loading the student login page
	 */
  @Autowired
  StudentDAOImpl studentService;
  AdminDAOImpl adminService;
  
  @RequestMapping(value = "/login", method = RequestMethod.GET)
  
  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("login");
    mav.addObject("login", new Students());
    return mav;
  }
  /**
   * 
   * This method is to perform the form action to perform the login validation
   * 
   * @param request
   * @param response
   * @param student
   * @return
   */
  @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
  @ModelAttribute("login") Students student) {
    ModelAndView mav = null;
    Students student1 = studentService.loginStudent(student);
    if (null != student1) {
    mav = new ModelAndView("success");
    mav.addObject("name", student.getName());
    } else {
    mav = new ModelAndView("login");
    mav.addObject("message", "Username or Password is wrong!!");
    }
    return mav;
  }
  
  
}
