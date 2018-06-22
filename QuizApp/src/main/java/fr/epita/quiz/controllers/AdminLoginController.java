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
import fr.epita.quiz.model.Admin;

/**
 * This class is to connect the admin login view and admin login model
 * @author sushant
 *
 */
@Controller

public class AdminLoginController {
	/**
	 * This class is for loading the admin login page
	 */
	
	@Autowired
	  
	  AdminDAOImpl adminService;
	  
	  @RequestMapping(value = "/AdminLogin", method = RequestMethod.GET)
	  
	  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("AdminLogin");
	    mav.addObject("AdminLogin", new Admin());
	    return mav;
	  }
	  
	  /**
	   * This class is for the request by the form to validate the admin login credentials
	   * @param request
	   * @param response
	   * @param admin
	   * @return
	   */
	  @RequestMapping(value = "/AdminLoginProcess", method = RequestMethod.POST)
	  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("AdminLogin") Admin admin) {
	    ModelAndView mav = null;
	    Admin admin1 = adminService.loginAdmin(admin);
	    if (null != admin1) {
	    mav = new ModelAndView("Adminpage");
	    mav.addObject("email", admin.getEmail());
	    } else {
	    mav = new ModelAndView("AdminLogin");
	    mav.addObject("message", "Username or Password is wrong!!");
	    }
	    return mav;
	  }
	  
	  

}
