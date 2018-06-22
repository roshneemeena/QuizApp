package fr.epita.quiz.controllers;

import java.util.List;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.epita.quiz.dao.DetailAnswerDAO;
import fr.epita.quiz.model.DetailAnswer;
import fr.epita.quiz.model.MCQChoice;
import fr.epita.quiz.model.Students;
import fr.epita.quiz.services.MCQService;
import fr.epita.quiz.services.MCQServiceImpl;
import fr.epita.quiz.services.QuestionService;
import fr.epita.quiz.services.QuestionServiceImpl;
import fr.epita.quiz.validation.StudentValidation;

/**
 * This class is for connecting the quiz module model and view
 * @author Roshnee
 *
 */

@Controller
public class QuizController {

	@Autowired
	private MCQServiceImpl McqService;
	private QuestionServiceImpl questionService;
	public static int points;
	
	@Autowired
	public void setService(MCQServiceImpl McqService) {
		this.McqService = McqService;
		
	}
	
	@Autowired
	public void setService(QuestionServiceImpl questionService) {
		this.questionService = questionService;
	}
		
		
		/**
		 * This method is for loading the home page
		 */
		
	
	
	
	
	@RequestMapping(value = "/load-home-page")
	public String loadHomePage(Map model){
		return "home";
	}
	

	/**
	 * This method is load the exam page with the first question
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/load-exam-page")
	public String loadExamPage(Map model, HttpServletRequest request){
		request.removeAttribute("error");
		model.put("questionForm", McqService.loadQuestion());
		
	
		return "exam-page";
	}
	
	
	@RequestMapping(value = "/load-detail-page")
	public String loadDetailPage(Map model, HttpServletRequest request){
		request.removeAttribute("error");
		model.put("dquestionform", questionService.loadQuestion());
		
	
		return "detail-page";
	}
	
	

	@RequestMapping(value = "/process-answer")
	public String processAnswer(Map model, HttpServletRequest request){
		int id=0;
		String userOption = "";

		if(request.getParameter("id") != null){
			id = Integer.parseInt(request.getParameter("id"));
		}
		if(request.getParameter("option") != null){
			userOption = request.getParameter("option");
		}else{
			/* Loading the Same Option */		
			model.put("questionForm", McqService.loadQuestion(id));
			request.setAttribute("error", "Please Choose Any Option");
			return "exam-page";
		}
		String answer = McqService.getAnswer(id);
		if(userOption.equals(answer)){
			points = points + 1;
			request.removeAttribute("error");
			model.put("questionForm", McqService.loadNextQuestion(id));
		}
		else{			
			System.out.println("InCorrect");			
			request.removeAttribute("error");
			model.put("questionForm", McqService.loadNextQuestion(id));
			//request.setAttribute("error", "Incorrect Answer");			
		}
		return "exam-page";
	}
/**
 * This method is for the action which wants to skip a question and go to next question
 * @param model
 * @param request
 * @return
 */
	@RequestMapping(value = "/skip-question")
	public String skipQuestion(Map model, HttpServletRequest request){
		if(request.getParameter("id") !=null){
			request.removeAttribute("error");
			int id = Integer.parseInt(request.getParameter("id"));
			List<MCQChoice> questions = McqService.loadNextQuestion(id);
			if(questions.size() > 0){
				model.put("questionForm", questions);
				return "exam-page";
			}
		}
		return "success";
	}
	
	@RequestMapping(value="/detail-answer", method = RequestMethod.POST)
	public String saveForm(ModelMap model, @ModelAttribute("detail") @Valid DetailAnswer detailAnswer, BindingResult br, HttpSession session) 
	{
		
			questionService.getAnswer(detailAnswer);
			session.setAttribute("detail",detailAnswer);
			return "redirect:result-page";
		}
		
	
	
	/**
	 * This methos is to load the result page
	 * @param model
	 * @return
	 */

	@RequestMapping(value = "/show-result")
	public String skipQuestion(Map model){
		model.put("result", points);
		return "result-page";
	}
}
	

