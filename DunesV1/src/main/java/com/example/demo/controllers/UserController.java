package com.example.demo.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.daos.DAOFactory;
import com.example.demo.daos.UserDAO;
import com.example.demo.model.User;

@Controller
public class UserController {
	
	@Autowired
	private DAOFactory daoFactory;

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String handleLoginForm(HttpServletRequest request,  ModelMap map) {		
		
		UserDAO userdao = daoFactory.getUserDAO();
		
		HttpSession session = request.getSession(true);

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println(username + " " + password);
		
		try {
			User u = userdao.get(username, password);

			if (u != null) {
				session.setAttribute("currentuser", u);
				
				if(u.getRole().equals("Manager"))
					return "managerHome";	
				else if(u.getRole().equals("Engineer"))
					return "engineerHome";
				else if(u.getRole().equals("Supplier"))
					return "supplierHome";
			}
		} 
		catch (Exception e) {
			System.out.println("Could not login user "  +  e.getMessage());
		}
		return "allUserLoginFailed.jsp";
	}
	
	
	@RequestMapping(value = "register")
	public String register() {
		return "registerUser.jsp";
	}
	
	@RequestMapping(value = "registerUser")
	public String registerUser(HttpServletRequest request,  ModelMap map) {
		
		HttpSession session = request.getSession(true);
		
		UserDAO userdao = daoFactory.getUserDAO();

		String username = request.getParameter("newusername");
		String password = request.getParameter("newpassword");
		String name = request.getParameter("newname");
		String role = request.getParameter("role");
		
		User newuser = userdao.add(username, password, name, role);
		
		if(newuser!=null){
			return "userCreateSuccessfull.jsp";
		}
		
		return "registerUser.jsp";
		
	}
	
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logoutUser(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
        if(session!=null){
            session.invalidate();
        }
		return "home";
	}

}
