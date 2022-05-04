package com.example.demo.controllers;

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
import com.example.demo.model.Order;
import com.example.demo.model.Product;
import com.example.demo.model.Project;
import com.example.demo.model.Task;
import com.example.demo.model.User;

@Controller
public class SupplierController {

	@Autowired
	private DAOFactory daoFactory;
	
	@RequestMapping(value = "addProduct", method = RequestMethod.POST)
	public String addProduct(HttpServletRequest request,  ModelMap map) {	
		
		HttpSession session = request.getSession(false);

		String productName = request.getParameter("productName");
		int productStock = Integer.parseInt(request.getParameter("productStock"));
		int productPrice = Integer.parseInt(request.getParameter("productPrice"));
		
		ProductDAO productDao = daoFactory.getProductDAO();
		
		try {
			User user = (User)session.getAttribute("currentuser");
			if (user != null) {
				
				Product product = new Product();
				product.setProductName(productName);
				product.setStock(productStock);
				product.setSupplier(user);
				product.setPrice(productPrice);
				
				productDao.createProduct(product);
				
				return "supplierHome";
			}
		} 
		catch (Exception e) {
			System.out.println("Could not save project. Bad credentials. "  +  e.getMessage());
			return "error.jsp";
		}
		return "managerHome.jsp";
		
	}
	
	@RequestMapping(value = "editOrder", method = RequestMethod.POST)
	public ModelAndView editOrder(HttpServletRequest request,  ModelMap map) {	
		
		int orderId = Integer.parseInt(request.getParameter("orderID"));
		
		Order order;
		OrdersDAO orderDAO = daoFactory.getOrderDAO();
		order = orderDAO.getOrderById(orderId);	
		
		ModelAndView MV = new ModelAndView("editOrder.jsp");
	    MV.addObject("order", order);
	    
		return MV;
		
	}
	
	
	@RequestMapping(value = "confirmOrderDelivery", method = RequestMethod.POST)
	public String confirmOrderDelivery(HttpServletRequest request,  ModelMap map) {	
		
		int orderId = Integer.parseInt(request.getParameter("id"));
		
		Order order;
		OrdersDAO orderDAO = daoFactory.getOrderDAO();
		order = orderDAO.getOrderById(orderId);	
		
		order.setStatus("Delivered");
		order.getProduct().setStock(order.getProduct().getStock()-order.getQuantity());
		
		orderDAO.update(order);
		
		return "supplierHome";
		
	}
	
	
	@RequestMapping(value = "editInventory", method = RequestMethod.POST)
	public ModelAndView editInventory(HttpServletRequest request,  ModelMap map) {	
		
		int productId = Integer.parseInt(request.getParameter("productID"));
		
		Product product;
		ProductDAO orderDAO = daoFactory.getProductDAO();
		product = orderDAO.getProductById(productId);	
		
		ModelAndView MV = new ModelAndView("editProduct.jsp");
	    MV.addObject("product", product);
	    
		return MV;
		
	}
	
	@RequestMapping(value = "saveEditOrder", method = RequestMethod.POST)
	public String saveEditOrder(HttpServletRequest request,  ModelMap map) {	
		
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int cost = Integer.parseInt(request.getParameter("cost"));
		String status = request.getParameter("status");
		int id = Integer.parseInt(request.getParameter("id"));
		
		Order order;
		OrdersDAO orderDAO = daoFactory.getOrderDAO();
		order = orderDAO.getOrderById(id);	
		
		order.setQuantity(quantity);
		order.setCost(cost);
		order.setStatus(status);
		
		orderDAO.update(order);
		
		return "supplierHome";
		
	}
	
	@RequestMapping(value = "saveEditProduct", method = RequestMethod.POST)
	public String saveEditProduct(HttpServletRequest request,  ModelMap map) {	
		
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int cost = Integer.parseInt(request.getParameter("cost"));
		String name = request.getParameter("name");
		int id = Integer.parseInt(request.getParameter("id"));
		
		Product product;
		ProductDAO orderDAO = daoFactory.getProductDAO();
		product = orderDAO.getProductById(id);	
		
		product.setStock(quantity);
		product.setPrice(cost);
		product.setProductName(name);
		
		orderDAO.update(product);
		
		return "supplierHome";
		
	}
	
	@RequestMapping(value = "supplierHome", method = RequestMethod.POST)
	public ModelAndView supplierHome(HttpServletRequest request,  ModelMap map) {	
		
		OrdersDAO orderDAO = daoFactory.getOrderDAO();
		List<Order> orders = orderDAO.getOrdersForSupplier((User)request.getSession().getAttribute("currentuser"));
		
		ProductDAO productDao = daoFactory.getProductDAO();
		List<Product> products = productDao.getProductsForSupplier((User)request.getSession().getAttribute("currentuser"));
		
		ModelAndView MV = new ModelAndView("supplierHome.jsp");
	    MV.addObject("orders", orders);
	    MV.addObject("products", products);
	    
		return MV;
		
	}
	
}
