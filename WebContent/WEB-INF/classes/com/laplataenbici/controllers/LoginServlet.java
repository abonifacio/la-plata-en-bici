package com.laplataenbici.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laplataenbici.services.AppConfig;
import com.laplataenbici.services.AuthService;
import com.laplataenbici.services.UserEntity;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String tmpl = (request.getAttribute("error")==null) ? "login.html" : "login-error.html";
		
		RequestDispatcher dispatcher= request.getServletContext().getRequestDispatcher(AppConfig.HTML_PATH+tmpl);
		if (dispatcher!=null){ 
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");		
		
		try {
			UserEntity tmp = AuthService.getRegisteredUser(user, pass);
			request.getSession().setAttribute("loggedUser", tmp.getUsername());
			if(tmp.isAdmin()){
				response.sendRedirect(request.getContextPath()+"/admin");
			}else{				
				response.sendRedirect(request.getContextPath()+"/usuario");
			}
		} catch (Exception e) {
			request.setAttribute("error", true);
			this.doGet(request, response);
		}
		
		
	}

}
