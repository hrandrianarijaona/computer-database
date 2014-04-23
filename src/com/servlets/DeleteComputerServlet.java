package com.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dao.ComputerDAO;
import com.company.om.Computer;
import com.company.services.ComputerService;

@WebServlet("/DeleteComputerServlet")
public class DeleteComputerServlet extends HttpServlet {

	public DeleteComputerServlet() {
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		StringBuilder sb = new StringBuilder();

		Integer id = Integer.parseInt(request.getParameter("id"));
		if((id==null)||(id==0)){
			sb.append("Accès à la page de manière illégal...");
			// On envoie le message d'erreur
			request.setAttribute("msg", sb.toString());

			// compte le nb de Computer dans la base
			int nbComputer = ComputerService.getInstance().getNbComputer();
			request.setAttribute("nbComputer", nbComputer);

			// liste les Computers
			List<Computer> computerList = ComputerService.getInstance().getListComputers();
			request.setAttribute("computerList", computerList);

			this.getServletContext().getRequestDispatcher( "/WEB-INF/dashboard.jsp" ).forward( request, response );
		}
		else{
			// On supprime le Computer de la base
			ComputerDAO.getInstance().deleteComputer(id);

			// compte le nb de Computer dans la base
			int nbComputer = ComputerService.getInstance().getNbComputer();
			request.setAttribute("nbComputer", nbComputer);

			// liste les Computers
			List<Computer> computerList = ComputerService.getInstance().getListComputers();
			request.setAttribute("computerList", computerList);

			this.getServletContext().getRequestDispatcher( "/index.jsp" ).forward( request, response );
		}

	}

}