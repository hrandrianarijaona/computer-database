package com.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;

import com.company.dao.ComputerDAO;
import com.company.om.Company;
import com.company.om.Computer;
import com.company.services.CompanyService;
import com.company.services.ComputerService;
@WebServlet("/AddComputerServlet")
public class AddComputerServlet extends HttpServlet {

	public AddComputerServlet() {
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// on récupère les attributs du formulaire
		String name = request.getParameter("name");
		DateTime introducedDate = null;
		DateTime discontinuedDate = null;
		StringBuilder msg = new StringBuilder();
		
		try{
			introducedDate = new DateTime(request.getParameter("introducedDate"));
			discontinuedDate = new DateTime(request.getParameter("introducedDate"));
		}catch(IllegalArgumentException iae){
			msg.append("La date doit être dans le bon format (YYYY-MM-DD).<br/>");
		}
		
		
		int idCompany = Integer.parseInt(request.getParameter("company"));
		
		
		// Vérification des paramètres du formulaire
		if((name.length() > 0)&&(idCompany != 0)&&(introducedDate != null)&&(discontinuedDate != null)){
			// On crée le Computer
			Computer c = new Computer();
			c.setName(name);
			c.setIntroducedDate(introducedDate);
			c.setDiscontinuedDate(discontinuedDate);
			// On récupère la Company correspondante
			c.setCompany(CompanyService.getInstance().findCompanyById(idCompany));
			
			// On insère le computer dans la base
			ComputerDAO.getInstance().insertComputer(c);
			
			// compte le nb de Computer dans la base
			int nbComputer = ComputerService.getInstance().getNbComputer();
			request.setAttribute("nbComputer", nbComputer);

			// liste les Computers
			List<Computer> computerList = ComputerService.getInstance().getListComputers();
			request.setAttribute("computerList", computerList);
			
			this.getServletContext().getRequestDispatcher( "/WEB-INF/dashboard.jsp" ).forward( request, response );
			
		}
		else{
			
			if(name.length()==0)
				msg.append("Le nom ne doit pas être vide.<br/>");
			
			String smsg = msg.toString();
			// On envoie le message d'erreur
			request.setAttribute("msg", smsg);
			List<Company> companyList = CompanyService.getInstance().getListCompany();
			request.setAttribute("companyList", companyList);
			this.getServletContext().getRequestDispatcher( "/WEB-INF/addComputer.jsp" ).forward( request, response );
		}
		
	}
	
}
