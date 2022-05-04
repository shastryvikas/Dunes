package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.daos.DAOFactory;
import com.example.demo.daos.OrdersDAO;
import com.example.demo.daos.TaskDAO;
import com.example.demo.model.Order;
import com.example.demo.model.Task;
import com.example.demo.model.User;

@Controller
public class EngineerController {
	
	@Autowired
	private DAOFactory daoFactory;
	
	@RequestMapping(value = "engineerHome", method = RequestMethod.POST)
	public ModelAndView managerHome(HttpServletRequest request,  ModelMap map) {	
		
		List<Task> tasks = new ArrayList<Task>();
		
		HttpSession session = request.getSession(false);
		User user = (User)session.getAttribute("currentuser");
		
		try {
				TaskDAO taskDAO = daoFactory.getTaskDAO();
				tasks = taskDAO.getTasksForEngineer(user);
				//request.setAttribute("tasks", tasks);
		} 
		catch (Exception e) {
			System.out.println("Could not get tasks"  +  e.getMessage());
		}
		
		
		
		ModelAndView MV = new ModelAndView("engineerHome.jsp");
	    MV.addObject("tasks", tasks);
	    
		return MV;
		
	}
	
}
