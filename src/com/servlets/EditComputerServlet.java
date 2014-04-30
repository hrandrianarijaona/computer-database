package com.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;

import com.company.dao.ComputerDAO;
import com.company.dto.ComputerDTO;
import com.company.om.Company;
import com.company.om.Computer;
import com.company.om.Page;
import com.company.services.CompanyService;
import com.company.services.ComputerService;
import com.company.validator.ComputerValidator;

/**
 * Servlet implementation class EditComputerServlet
 */
@WebServlet("/EditComputerServlet")
public class EditComputerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditComputerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// On recupère le Computer à éditer
		Computer computer = ComputerService.getInstance().findComputerById(Long.parseLong(request.getParameter("id")));
		request.setAttribute("computer", computer);

		// On recupere la liste des Company
		List<Company> companyList = CompanyService.getInstance().getListCompany();		
		request.setAttribute("companyList", companyList);

		this.getServletContext().getRequestDispatcher( "/WEB-INF/editComputer.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		DateTime introducedDate = null;
		DateTime discontinuedDate = null;
		StringBuilder msg = new StringBuilder();

		try{
			introducedDate = new DateTime(request.getParameter("introducedDate"));
			discontinuedDate = new DateTime(request.getParameter("discontinuedDate"));
		}catch(IllegalArgumentException iae){
			msg.append("La date doit être dans le bon format (YYYY-MM-DD).<br/>");
		}

		Long idCompany = Long.parseLong(request.getParameter("company"));

		// Verification des paramètres
		ComputerDTO cdto = new ComputerDTO();
		cdto.setName(name);
		cdto.setIntroducedDate(request.getParameter("introducedDate"));
		cdto.setDiscontinuedDate(request.getParameter("discontinuedDate"));
		cdto.setIdCompany(request.getParameter("company"));
		HashMap<Integer, Integer> errorList = ComputerValidator.validate(cdto);





		// empty si aucune erreur
		if(errorList.isEmpty()){
			int code;
			int page = 0, interval = 20;
			// recupere les paramètres de page
			String sPage = request.getParameter("page");
			String sInterval = request.getParameter("interval");
			String sFiltre = request.getParameter("filter");
			
			// vérifie les paramètres et les initialise sinon
			if(sPage!=null)
				page = Integer.parseInt(sPage);
			if(sInterval!=null)
				interval = Integer.parseInt(sInterval);
			if(sFiltre==null)
				sFiltre = "";
			if(request.getParameter("codeTri")!=null)
				code = Integer.parseInt(request.getParameter("codeTri"));
			else
				code = 0;
			
			// On crée le Computer
			Computer c = new Computer();
			c.setId(Long.parseLong(request.getParameter("id")));
			c.setName(name);
			c.setIntroducedDate(introducedDate);
			c.setDiscontinuedDate(discontinuedDate);
			// On récupère la Company correspondante
			c.setCompany(CompanyService.getInstance().findCompanyById(idCompany));

			// On update le computer dans la base
			ComputerService.getInstance().updateComputer(c);

			// compte le nb de Computer dans la base
			int nbComputer = ComputerService.getInstance().getNbComputer();
//			request.setAttribute("nbComputer", nbComputer);

			// liste les Computers
			List<Computer> computerList = ComputerService.getInstance().searchComputersByFilteringAndOrderingWithRange(sFiltre, page, interval, code, true);
//			request.setAttribute("computerList", computerList);
			
			int nbPage = (int) Math.ceil(ComputerService.getInstance().getListComputers().size()/interval);

			Page<Computer> laPage = new Page<>(nbComputer, page, interval, code, nbPage, sFiltre, computerList);
			request.setAttribute("pageComputer", laPage);

			this.getServletContext().getRequestDispatcher( "/WEB-INF/dashboard.jsp" ).forward( request, response );
		}
		else{ // on envoi les messages d'erreur
			for(Entry<Integer, Integer> entry : errorList.entrySet()) {
				Integer cle = entry.getKey();
				Integer valeur = entry.getValue();

				/*
				 * champ 1 => name
				 * champ 2 => introducedDate
				 * champ 3 => discontinuedDate
				 * champ 4 => idCompany
				 * Code d'erreur:
				 * 1 => Champ vide
				 * 2 => Valeur erroné
				 * 3 => Date doit être supérieur
				 */
				// traitements
				switch(cle){
				case 1:
					switch(valeur){
					case 1:
						msg.append("Le nom ne doit pas être vide.<br/>");
						break;
					default:
						msg.append("Valeur inattendu<br/>");
					}
					break;
				case 2:
					switch(valeur){
					case 1:
						msg.append("Introduced date ne doit pas être vide.<br/>");
						break;
					case 2:
						msg.append("Introduced date est mal ecrit. (YYYY-MM-DD)<br/>");
						break;
					default:
						msg.append("Valeur inattendu<br/>");
					}
					break;
				case 3:
					switch(valeur){
					case 1:
						msg.append("Discontinued date ne doit pas être vide.<br/>");
						break;
					case 2:
						msg.append("Discontinued date est mal ecrit. (YYYY-MM-DD)<br/>");
						break;
					case 3:
						msg.append("Discontinued date doit être postérieur à Introduced date.<br/>");
						break;
					default:
						msg.append("Valeur inattendu<br/>");
					}
					break;
				default:
					msg.append("Clé inattendu<br/>");
				}
			}
			// On envoi le message d'erreur
			request.setAttribute("msg", msg.toString());
			List<Company> companyList = CompanyService.getInstance().getListCompany();
			request.setAttribute("companyList", companyList);
			this.getServletContext().getRequestDispatcher( "/WEB-INF/editComputer.jsp" ).forward( request, response );
		}




		// Mis à jour

		// Redirection vers le dashboard
	}

}
