package com.company.services;

import java.util.List;

import com.company.dao.ComputerDAO;
import com.company.om.Computer;

/**
 * Classe Service de Computer
 * @author hrandr
 *
 */
public class ComputerService {

	public static ComputerService cs = null;
	
	private ComputerService() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * retourne l'unique instance de ComputerService
	 * @return
	 */
	public static ComputerService getInstance(){
		if(cs==null)
			cs = new ComputerService();
		return cs;
	}
	
	/**
	 * Liste tous les ordinateurs/computers repertorié dans la base
	 * @return
	 */
	public List<Computer> getListComputers() {
		return ComputerDAO.getInstance().getListComputers();
	}
	
	/**
	 * Liste tous les ordinateurs/computers repertorié dans la base avec les critères de filtrage et d'ordre
	 * @param filter le mode de tri (0 => name, 1 => introducedDate, 2 => discontinuedDate, 3 => company)
	 * @param isAsc true => ascendant / false => descendant
	 * @return
	 */
	public List<Computer> getListComputersByFilteringAndOrdering(int filter, boolean isAsc) {
		return ComputerDAO.getInstance().getListComputersByFilteringAndOrdering(filter, isAsc);
	}
	
	/**
	 * Liste tous les ordinateurs/computers repertorié dans la base par ordre décroissant
	 * @return
	 */
	public List<Computer> getListComputersOrderByNameDesc() {
		return ComputerDAO.getInstance().getListComputersOrderByNameDesc();
	}
	
	/**
	 * Liste tous les ordinateurs/computers repertorié dans la base par introducedDate d'ordre croissant
	 * @return
	 */
	public List<Computer> getListComputersOrderByIntroducedDateAsc() {
		return ComputerDAO.getInstance().getListComputersOrderByIntroducedDateAsc();
	}
	
	/**
	 * Liste tous les ordinateurs/computers repertorié dans la base par introducedDate d'ordre croissant
	 * @return
	 */
	public List<Computer> getListComputersOrderByIntroducedDateDesc() {
		return ComputerDAO.getInstance().getListComputersOrderByIntroducedDateDesc();
	}
	
	/**
	 * Liste tous les ordinateurs/computers repertorié dans la base par DiscontinuedDate d'ordre croissant
	 * @return
	 */
	public List<Computer> getListComputersOrderByDiscontinuedDateAsc() {
		return ComputerDAO.getInstance().getListComputersOrderByDiscontinuedDateAsc();
	}
	
	/**
	 * Liste tous les ordinateurs/computers repertorié dans la base par DiscontinuedDate d'ordre croissant
	 * @return
	 */
	public List<Computer> getListComputersOrderByDiscontinuedDateDesc() {
		return ComputerDAO.getInstance().getListComputersOrderByDiscontinuedDateDesc();
	}
	
	/**
	 * Liste tous les ordinateurs/computers repertorié dans la base
	 * @param rang le rang
	 * @return
	 */
	public List<Computer> getListComputersWithRange(int rang, int interval) {
		return ComputerDAO.getInstance().getListComputersWithRange(rang, interval);
	}
	
	/**
	 * Liste tous les ordinateurs/computers repertorié dans la base par Company d'ordre croissant
	 * @return
	 */
	public List<Computer> getListComputersOrderByCompanyAsc() {
		return ComputerDAO.getInstance().getListComputersOrderByCompanyAsc();
	}
	
	/**
	 * Liste tous les ordinateurs/computers repertorié dans la base par Company d'ordre croissant
	 * @return
	 */
	public List<Computer> getListComputersOrderByCompanyDesc() {
		return ComputerDAO.getInstance().getListComputersOrderByCompanyDesc();
	}
	
	/**
	 * Liste tous les ordinateurs/computers repertorié dans la base trié par nom décroissant
	 * @param rang le rang
	 * @return
	 */
	public List<Computer> getListComputersOrderByNameDescWithRange(int rang, int interval) {
		return ComputerDAO.getInstance().getListComputersOrderByNameDescWithRange(rang, interval);
	}
	
	/**
	 * Liste tous les ordinateurs/computers repertorié dans la base trié par IntroducedDate croissant
	 * @param rang le rang
	 * @return
	 */
	public List<Computer> getListComputersOrderByIntroducedDateAscWithRange(int rang, int interval) {
		return ComputerDAO.getInstance().getListComputersOrderByIntroducedDateAscWithRange(rang, interval);
	}
	
	/**
	 * Liste tous les ordinateurs/computers repertorié dans la base trié par IntroducedDate décroissant
	 * @param rang le rang
	 * @param interval le nb d'element par page
	 * @return
	 */
	public List<Computer> getListComputersOrderByIntroducedDateDescWithRange(int rang, int interval) {
		return ComputerDAO.getInstance().getListComputersOrderByIntroducedDateDescWithRange(rang, interval);
	}
	
	/**
	 * Liste tous les ordinateurs/computers repertorié dans la base trié par DiscontinuedDate croissant
	 * @param rang le rang
	 * @return
	 */
	public List<Computer> getListComputersOrderByDiscontinuedDateAscWithRange(int rang, int interval) {
		return ComputerDAO.getInstance().getListComputersOrderByDiscontinuedDateAscWithRange(rang, interval);
	}
	
	/**
	 * Liste tous les ordinateurs/computers repertorié dans la base trié par DiscontinuedDate décroissant
	 * @param rang le rang
	 * @param interval le nb d'element par page
	 * @return
	 */
	public List<Computer> getListComputersOrderByDiscontinuedDateDescWithRange(int rang, int interval) {
		return ComputerDAO.getInstance().getListComputersOrderByDiscontinuedDateDescWithRange(rang, interval);
	}
	
	/**
	 * Liste tous les ordinateurs/computers repertorié dans la base trié par Company croissant
	 * @param rang le rang
	 * @return
	 */
	public List<Computer> getListComputersOrderByCompanyAscWithRange(int rang, int interval) {
		return ComputerDAO.getInstance().getListComputersOrderByCompanyAscWithRange(rang, interval);
	}
	
	/**
	 * Liste tous les ordinateurs/computers repertorié dans la base trié par Company décroissant
	 * @param rang le rang
	 * @param interval le nb d'element par page
	 * @return
	 */
	public List<Computer> getListComputersOrderByCompanyDescWithRange(int rang, int interval) {
		return ComputerDAO.getInstance().getListComputersOrderByCompanyDescWithRange(rang, interval);
	}
	
	/**
	 * retourne le nombre de computer/ordinateur dans la base
	 * @return
	 */
	public int getNbComputer(){
		return ComputerDAO.getInstance().getNbComputer();
	}
	
	/**
	 * Insert un ordinateur/computer dans la base
	 */
	public void insertComputer(Computer cp) {
		ComputerDAO.getInstance().insertComputer(cp);
	}
	
	/**
	 * Supprime l'ordinateur identifié en paramètre de la base de donnée
	 * @param id
	 */
	public void deleteComputer(int id){
		ComputerDAO.getInstance().deleteComputer(id);
	}
	
	/**
	 * Liste tous les ordinateurs/computers repertorié dans la base correspondant au motif
	 * @return
	 */
	public List<Computer> searchComputers(String word) {
		return ComputerDAO.getInstance().searchComputers(word);
	}
	
	/**
	 * Fonction de recherche par filtre
	 * @param word le mot ou schema à rechercher
	 * @param filter le mode de tri (0 => name, 1 => introducedDate, 2 => discontinuedDate, 3 => company)
	 * @param isAsc true => ascendant / false => descendant
	 * @return
	 */
	public List<Computer> searchComputersByFilteringAndOrdering(String word, int filter, boolean isAsc) {
		return ComputerDAO.getInstance().searchComputersByFilteringAndOrdering(word, filter, isAsc);
	}
	
	/**
	 * Liste tous les ordinateurs/computers repertorié dans la base correspondant au motif avec intervalle de resultat et les critères de triage et d'ordre
	 * @param word le motif à chercher
	 * @param rang la page
	 * @param interval le nombre d'element à afficher
	 * @param filter le mode de tri (0 => name, 1 => introducedDate, 2 => discontinuedDate, 3 => company)
	 * @param isAsc true => ascendant / false => descendant
	 * @return
	 */
	public List<Computer> searchComputersWithRange(String word, int rang, int interval, int filter, boolean isAsc) {
		return ComputerDAO.getInstance().searchComputersByFilteringAndOrderingWithRange(word, rang, interval, filter, isAsc);
	}
	
	/**
	 * Liste tous les ordinateurs/computers repertorié dans la base correspondant au motif avec intervalle de resultat
	 * @return
	 */
	public List<Computer> searchComputersWithRange(String word, int rang, int interval) {
		return ComputerDAO.getInstance().searchComputersWithRange(word, rang, interval);
	}

}
