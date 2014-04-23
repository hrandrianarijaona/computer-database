package com.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.om.Computer;
import com.company.services.ComputerService;

/**
 * Servlet implementation class RedirectIndexServlet
 */
@WebServlet("/RedirectIndexServlet")
public class RedirectIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RedirectIndexServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// verif sur le parametre page
		String sPage = request.getParameter("page");
		int page = 1;
		if(sPage!=null)
			page = Integer.parseInt(request.getParameter("page"));

		// verif sur le parametre interval
		String sInterval = request.getParameter("interval");
		int interval = 20;
		if(sInterval!=null)
			interval = Integer.parseInt(request.getParameter("interval"));


		// compte le nb de Computer dans la base
		int nbComputer = ComputerService.getInstance().getNbComputer();
		request.setAttribute("nbComputer", nbComputer);

		// liste les Computers
		List<Computer> computerList = null;
		computerList = ComputerService.getInstance().getListComputersWithRange(page, interval);
		request.setAttribute("computerList", computerList);

		// tous les Computer pour la navigation
		List<Computer> allComputerList = ComputerService.getInstance().getListComputers();
		request.setAttribute("allComputerList", allComputerList);

		// nombre de page
		int tailleRes = allComputerList.size()/interval;
		int nbPage = tailleRes;
		if(tailleRes%interval>0) // si il y a un reste, alors on ajoute une page supplémentaire
			nbPage++;
		request.setAttribute("nbPage", nbPage);


		this.getServletContext().getRequestDispatcher( "/WEB-INF/dashboard.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// compte le nb de Computer dans la base
		int nbComputer = ComputerService.getInstance().getNbComputer();
		request.setAttribute("nbComputer", nbComputer);

		// liste les Computers
		List<Computer> computerList = ComputerService.getInstance().getListComputers();
		request.setAttribute("computerList", computerList);
		this.getServletContext().getRequestDispatcher( "/WEB-INF/dashboard.jsp" ).forward( request, response );
	}

}
