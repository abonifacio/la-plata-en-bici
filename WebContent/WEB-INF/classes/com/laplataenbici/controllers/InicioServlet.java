package com.laplataenbici.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laplataenbici.model.domain.Bicicleta;
import com.laplataenbici.model.repository.BicicletaRepository;
import com.laplataenbici.services.AppConfig;

/**
 * Servlet implementation class InicioServlet
 */
@WebServlet(urlPatterns = {"/inicio", ""})
public class InicioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InicioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher dispatcher= request.getServletContext().getRequestDispatcher(AppConfig.HTML_PATH+"index.html");
		if (dispatcher!=null){ 
			dispatcher.forward(request, response);
		}
//		BicicletaRepository br = new BicicletaRepository();
//		Optional<Bicicleta> b = br.findOneById((long) 1);
//		PrintWriter pw = response.getWriter();
//		if(b.isPresent()){
//			pw.println(b.get().getEstado().getValue());
//			pw.println(b.get().getFechaIngreso());
//			pw.println(b.get().getId());
//		}else{
//			pw.println("vacio");
//		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
