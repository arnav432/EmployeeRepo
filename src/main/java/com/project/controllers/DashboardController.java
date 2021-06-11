package com.project.controllers;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.entities.Employee;
import com.project.services.EmployeeService;
import com.project.services.EmployeeServiceImpl;

@Controller
//@Validated
public class DashboardController {
	
	@Autowired
	private EmployeeService employeeService;
	
	public static Logger logger = LoggerFactory.getLogger(DashboardController.class);

	@RequestMapping("/")
	public String started() {

		return "Dashboard.html";
	}

	

	
	@PostMapping("/addEmployee")
	public String addEmployee(Employee employee) throws IOException{
		
		return "AddEmployeePage.html";
	}
	
	@RequestMapping(value="/employeeAdded", method = RequestMethod.POST)
	public ModelAndView employeeAdded( @Valid Employee employee, BindingResult bindingResult, ModelMap modelMap) throws IOException{
		logger.info("New emplyee being added : {}",employee);
		ModelAndView modelAndView = new ModelAndView();
		try {
			//validation check
			if(bindingResult.hasErrors()) {
				// if errors are there, we display the error message on screen to prompt user to rectify them
				modelAndView.addObject("resultingMessage", "Please correct the errors in the form !!!");
				modelMap.addAttribute("bindingResult", bindingResult);
			}
			else {
				// if no errors are there, we continue with persisting the employee data in database
				modelAndView.addObject("resultingMessage", "Emlpoyee Addition success !!!");
				modelAndView.setViewName("EmployeeAdditionSuccessPage");
				employeeService.addEmployee(employee);
				return modelAndView;
			}
		}
		catch(Exception e) {
			logger.info(""+e);
		}
		
		// to empty the form fields
		modelAndView.addObject("employee", new Employee());
		
		// keeping the view page constant as before
		modelAndView.setViewName("AddEmployeePage");
		return modelAndView;
	}
	
	@RequestMapping(value="/getAllEmployees", method = RequestMethod.POST)
	public ModelAndView getAllEmployees( @Valid Employee employee, BindingResult bindingResult, ModelMap modelMap) throws IOException{
		logger.info("Fetching employee data ");
		
		List<Employee> listOfAllEmployees = employeeService.getAllEmployees();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("employeeList", listOfAllEmployees);
		modelAndView.setViewName("EmployeesDisplayPage");
		return modelAndView;
	}
	
	@RequestMapping(value="/returnToHome")
	public ModelAndView returnToHome() {
		logger.info("Returing Home");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("Dashboard");
		return modelAndView;
	}
	
	@PostMapping("/kill")
	public void killApplication() throws IOException{
		logger.info("Sending application kill message !!!");

		System.exit(1);
		
		
	}

}
