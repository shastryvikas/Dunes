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
import com.example.demo.daos.ProductDAO;
import com.example.demo.daos.ProjectDAO;
import com.example.demo.daos.TaskDAO;
import com.example.demo.daos.UserDAO;
import com.example.demo.model.Order;
import com.example.demo.model.Product;
import com.example.demo.model.Project;
import com.example.demo.model.Task;
import com.example.demo.model.User;

@Controller
public class ManagerController {
	
	@Autowired
	private DAOFactory daoFactory;
	
	@RequestMapping(value = "addProject", method = RequestMethod.POST)
	public String addProject(HttpServletRequest request,  ModelMap map) {	
		
		HttpSession session = request.getSession(false);

		String projectName = request.getParameter("projectName");
		Float projectBudget = Float.parseFloat(request.getParameter("projectBudget"));
		
		ProjectDAO projectDAO = daoFactory.getProjectDAO();
		
		try {
			User user = (User)session.getAttribute("currentuser");
			if (user != null) {
				
				Project project = new Project();
				project.setProjectBudget(projectBudget);
				project.setProjectManager(user);
				project.setProjectName(projectName);
				
				projectDAO.createProject(project);
				
				return "managerHome";
			}
		} 
		catch (Exception e) {
			System.out.println("Could not save project. Bad credentials. "  +  e.getMessage());
			return "error.jsp";
		}
		
		return "managerHome";
	}
	
	@RequestMapping(value = "placeOrder", method = RequestMethod.POST)
	public String placeOrder(HttpServletRequest request,  ModelMap map) {	
		
		UserDAO userDao = daoFactory.getUserDAO();
		ProductDAO productDao = daoFactory.getProductDAO();
		ProjectDAO projectDao = daoFactory.getProjectDAO();
		Product product = productDao.getProductById(Integer.parseInt(request.getParameter("product")));
		Project project = projectDao.getProjectById(Integer.parseInt(request.getParameter("project")));
		
		
		Order order = new Order();
		order.setStatus(request.getParameter("status"));
		order.setDate(request.getParameter("date"));
		order.setSupplier(userDao.get(Integer.parseInt(request.getParameter("supplier"))));
		order.setCost(Integer.parseInt(request.getParameter("orderQuantity"))*product.getPrice());
		order.setProduct(product);
		order.setProject(project);
		order.setQuantity(Integer.parseInt(request.getParameter("orderQuantity")));
		
		OrdersDAO orderDao = daoFactory.getOrderDAO();
		orderDao.createOrder(order);
		
		return "managerHome";
	}
	
	@RequestMapping(value = "addOrder", method = RequestMethod.POST)
	public ModelAndView addOrder(HttpServletRequest request,  ModelMap map) {
		
		UserDAO userDao = daoFactory.getUserDAO();
		
		ProductDAO productDao = daoFactory.getProductDAO();
		List<Product> products = productDao.getProductsForSupplier(userDao.get(Integer.parseInt(request.getParameter("supplier"))));
		
		ModelAndView MV = new ModelAndView("placeOrder.jsp");
	    MV.addObject("orderStatus", request.getParameter("orderStatus"));
	    MV.addObject("orderDate", request.getParameter("orderDate"));
	    MV.addObject("supplier", request.getParameter("supplier"));
	    MV.addObject("products", products);
	    MV.addObject("project", request.getParameter("project"));
	    
	    
		return MV;		
	}	
	
	@RequestMapping(value = "editTask", method = RequestMethod.POST)
	public ModelAndView editInventory(HttpServletRequest request,  ModelMap map) {	
		
		int taskID = Integer.parseInt(request.getParameter("taskID2"));
		
		Task task;
		TaskDAO taskDao = daoFactory.getTaskDAO();
		task = taskDao.getTaskById(taskID);	
		
		ModelAndView MV = new ModelAndView("editTask.jsp");	
	    MV.addObject("task", task);
	    
		return MV;
	}
	
	@RequestMapping(value = "saveEditTask", method = RequestMethod.POST)
	public String saveEditTask(HttpServletRequest request,  ModelMap map) {	
		
		String name = request.getParameter("name");
		String status = request.getParameter("status");
		int id = Integer.parseInt(request.getParameter("id"));
		
		Task task;
		TaskDAO taskDao = daoFactory.getTaskDAO();
		task = taskDao.getTaskById(id);	
		
		
		task.setTaskName(name);
		task.setTaskStatus(status);
		
		taskDao.update(task);
		
		
		try {
			HttpSession session = request.getSession(false);
			User user = (User)session.getAttribute("currentuser");
			if (user != null) {
				if(user.getRole().equals("Manager"))
					return "managerHome";
				else if(user.getRole().equals("Supplier"))
					return "supplierHome";
				else if(user.getRole().equals("Engineer"))
					return "engineerHome";
				
			}
		} 
		catch (Exception e) {
			System.out.println("Could not get projects"  +  e.getMessage());
		}
		
		return "managerHome";
		
	}
	
	@RequestMapping(value = "managerHome", method = RequestMethod.POST)
	public ModelAndView managerHome(HttpServletRequest request,  ModelMap map) {	
		
		HttpSession session = request.getSession(false);
		List<Project> projects = new ArrayList<Project>();
		
		try {
			User user = (User)session.getAttribute("currentuser");
			if (user != null) {
				
				ProjectDAO projectDAO = daoFactory.getProjectDAO();
				projects = projectDAO.getProjectsManagedBy(user);
				//request.setAttribute("projects", projects);
			}
		} 
		catch (Exception e) {
			System.out.println("Could not get projects"  +  e.getMessage());
		}
		
		ModelAndView MV = new ModelAndView("managerHome.jsp");
	    MV.addObject("projects", projects);
		
		return MV;
	}
	
	
	@RequestMapping(value = "addTask", method = RequestMethod.POST)
	public String addTask(HttpServletRequest request,  ModelMap map) {	
		
		UserDAO userDao = daoFactory.getUserDAO();
		ProjectDAO projectDao = daoFactory.getProjectDAO();
		
		Task task = new Task();
		task.setTaskName(request.getParameter("taskName"));
		task.setTaskStatus(request.getParameter("taskStatus"));
		task.setEngineer(userDao.get(Integer.parseInt(request.getParameter("engineer"))));
		task.setProject(projectDao.getProjectById(Integer.parseInt(request.getParameter("projectId"))));
				
		
		TaskDAO taskDao = daoFactory.getTaskDAO();
		
		taskDao.createTask(task);
		
		return "managerHome";
	}
	
	@RequestMapping(value = "viewProject", method = RequestMethod.POST)
	public ModelAndView viewProject(HttpServletRequest request,  ModelMap map) {	
		int projectId = Integer.parseInt(request.getParameter("projectID"));
		
		ProjectDAO projectDAO = daoFactory.getProjectDAO();
		Project project = projectDAO.getProjectById(projectId);
		

		UserDAO userDao = daoFactory.getUserDAO();
		List<User> engineers = userDao.getAllEngineers();
		List<User> suppliers = userDao.getAllSuppliers();
		
		HttpSession session = request.getSession(false);
		List<Task> tasks = new ArrayList<Task>();
		List<Order> orders = new ArrayList<Order>();
		
		try {
				TaskDAO taskDAO = daoFactory.getTaskDAO();
				tasks = taskDAO.getTasksForProject(project);
				//request.setAttribute("tasks", tasks);
		} 
		catch (Exception e) {
			System.out.println("Could not get tasks"  +  e.getMessage());
		}
		
		try {
			OrdersDAO orderDAO = daoFactory.getOrderDAO();
			orders = orderDAO.getOrdersForProject(project);
			//request.setAttribute("orders", orders);
		} 
		catch (Exception e) {
			System.out.println("Could not get orders"  +  e.getMessage());
		}
		
		ModelAndView MV = new ModelAndView("viewProject.jsp");
	    MV.addObject("orders", orders);
	    MV.addObject("tasks", tasks);
	    MV.addObject("project", project.getId());
		MV.addObject("engineers", engineers);
		MV.addObject("suppliers", suppliers);
	    
		return MV;
	}
	
}
