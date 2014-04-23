package com.company.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.joda.time.DateTime;

import com.company.connection.ProjetConnection;
import com.company.om.Company;
import com.company.om.Computer;

public class ComputerDAO {

	public static ComputerDAO cdao = null;
	
	private ComputerDAO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Retourne l'unique instance de ComputerDAO
	 * @return
	 */
	public static ComputerDAO getInstance(){
		if(cdao == null)
			cdao = new ComputerDAO();
		return cdao;
	}

	/**
	 * Liste tous les ordinateurs/computers repertorié dans la base
	 * @return
	 */
	public List<Computer> getListComputers() {
		ArrayList<Computer> al = new ArrayList<Computer>();

		// ajoutez ici le code de r�cup�ration des produits
		String query = "SELECT pc.id, pc.name, pc.introduced, pc.discontinued, comp.id, comp.name FROM computer AS pc LEFT JOIN company AS comp ON pc.company_id=comp.id ORDER BY pc.name;";
		ResultSet results = null;
		Statement stmt = null;
		
		Connection c = ProjetConnection.getInstance();

		if(c != null){

			try {
				stmt = c.createStatement();
				results = stmt.executeQuery(query);

				while(results.next()){
					// Recuperation des donnéees de Computer
					int id = results.getInt("id");
					String name = results.getString("name");
					DateTime introduced = new DateTime(results.getTimestamp("introduced"));
					DateTime discontinued = new DateTime(results.getTimestamp("discontinued"));
					
					// Creation de la company à associer
					Company cpy = new Company();
					cpy.setId(results.getInt("comp.id"));
					cpy.setName(results.getString("comp.name"));

					al.add(new Computer(id, name, introduced, discontinued, cpy));

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Problème dans la requete de listing...");
			} finally{
				try {

					if(results != null)
						results.close();
					if(stmt != null)
						stmt.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else{
			System.out.println("La connection est null...");
		}

		return al;
	}
	
	/**
	 * Liste tous les ordinateurs/computers repertorié dans la base par ordre décroissant
	 * @return
	 */
	public List<Computer> getListComputersOrderByNameDesc() {
		ArrayList<Computer> al = new ArrayList<Computer>();

		// ajoutez ici le code de r�cup�ration des produits
		String query = "SELECT pc.id, pc.name, pc.introduced, pc.discontinued, comp.id, comp.name FROM computer AS pc LEFT JOIN company AS comp ON pc.company_id=comp.id ORDER BY pc.name DESC;";
		ResultSet results = null;
		Statement stmt = null;
		
		Connection c = ProjetConnection.getInstance();

		if(c != null){

			try {
				stmt = c.createStatement();
				results = stmt.executeQuery(query);

				while(results.next()){
					// Recuperation des donnéees de Computer
					int id = results.getInt("id");
					String name = results.getString("name");
					DateTime introduced = new DateTime(results.getTimestamp("introduced"));
					DateTime discontinued = new DateTime(results.getTimestamp("discontinued"));
					
					// Creation de la company à associer
					Company cpy = new Company();
					cpy.setId(results.getInt("comp.id"));
					cpy.setName(results.getString("comp.name"));

					al.add(new Computer(id, name, introduced, discontinued, cpy));

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Problème dans la requete de listing...");
			} finally{
				try {

					if(results != null)
						results.close();
					if(stmt != null)
						stmt.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else{
			System.out.println("La connection est null...");
		}

		return al;
	}
	
	/**
	 * Liste tous les ordinateurs/computers repertorié dans la base par introducedDate d'ordre croissant
	 * @return
	 */
	public List<Computer> getListComputersOrderByIntroducedDateAsc() {
		ArrayList<Computer> al = new ArrayList<Computer>();

		// ajoutez ici le code de r�cup�ration des produits
		String query = "SELECT pc.id, pc.name, pc.introduced, pc.discontinued, comp.id, comp.name FROM computer AS pc LEFT JOIN company AS comp ON pc.company_id=comp.id ORDER BY pc.introduced ASC;";
		ResultSet results = null;
		Statement stmt = null;
		
		Connection c = ProjetConnection.getInstance();

		if(c != null){

			try {
				stmt = c.createStatement();
				results = stmt.executeQuery(query);

				while(results.next()){
					// Recuperation des donnéees de Computer
					int id = results.getInt("id");
					String name = results.getString("name");
					DateTime introduced = new DateTime(results.getTimestamp("introduced"));
					DateTime discontinued = new DateTime(results.getTimestamp("discontinued"));
					
					// Creation de la company à associer
					Company cpy = new Company();
					cpy.setId(results.getInt("comp.id"));
					cpy.setName(results.getString("comp.name"));

					al.add(new Computer(id, name, introduced, discontinued, cpy));

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Problème dans la requete de listing...");
			} finally{
				try {

					if(results != null)
						results.close();
					if(stmt != null)
						stmt.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else{
			System.out.println("La connection est null...");
		}

		return al;
	}
	
	/**
	 * Liste tous les ordinateurs/computers repertorié dans la base par introducedDate d'ordre croissant
	 * @return
	 */
	public List<Computer> getListComputersOrderByIntroducedDateDesc() {
		ArrayList<Computer> al = new ArrayList<Computer>();

		// ajoutez ici le code de r�cup�ration des produits
		String query = "SELECT pc.id, pc.name, pc.introduced, pc.discontinued, comp.id, comp.name FROM computer AS pc LEFT JOIN company AS comp ON pc.company_id=comp.id ORDER BY pc.introduced DESC;";
		ResultSet results = null;
		Statement stmt = null;
		
		Connection c = ProjetConnection.getInstance();

		if(c != null){

			try {
				stmt = c.createStatement();
				results = stmt.executeQuery(query);

				while(results.next()){
					// Recuperation des donnéees de Computer
					int id = results.getInt("id");
					String name = results.getString("name");
					DateTime introduced = new DateTime(results.getTimestamp("introduced"));
					DateTime discontinued = new DateTime(results.getTimestamp("discontinued"));
					
					// Creation de la company à associer
					Company cpy = new Company();
					cpy.setId(results.getInt("comp.id"));
					cpy.setName(results.getString("comp.name"));

					al.add(new Computer(id, name, introduced, discontinued, cpy));

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Problème dans la requete de listing...");
			} finally{
				try {

					if(results != null)
						results.close();
					if(stmt != null)
						stmt.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else{
			System.out.println("La connection est null...");
		}

		return al;
	}
	
	/**
	 * Liste tous les ordinateurs/computers repertorié dans la base par DiscontinuedDate d'ordre croissant
	 * @return
	 */
	public List<Computer> getListComputersOrderByDiscontinuedDateAsc() {
		ArrayList<Computer> al = new ArrayList<Computer>();

		// ajoutez ici le code de r�cup�ration des produits
		String query = "SELECT pc.id, pc.name, pc.introduced, pc.discontinued, comp.id, comp.name FROM computer AS pc LEFT JOIN company AS comp ON pc.company_id=comp.id ORDER BY pc.discontinued ASC;";
		ResultSet results = null;
		Statement stmt = null;
		
		Connection c = ProjetConnection.getInstance();

		if(c != null){

			try {
				stmt = c.createStatement();
				results = stmt.executeQuery(query);

				while(results.next()){
					// Recuperation des donnéees de Computer
					int id = results.getInt("id");
					String name = results.getString("name");
					DateTime introduced = new DateTime(results.getTimestamp("introduced"));
					DateTime discontinued = new DateTime(results.getTimestamp("discontinued"));
					
					// Creation de la company à associer
					Company cpy = new Company();
					cpy.setId(results.getInt("comp.id"));
					cpy.setName(results.getString("comp.name"));

					al.add(new Computer(id, name, introduced, discontinued, cpy));

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Problème dans la requete de listing...");
			} finally{
				try {

					if(results != null)
						results.close();
					if(stmt != null)
						stmt.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else{
			System.out.println("La connection est null...");
		}

		return al;
	}
	
	/**
	 * Liste tous les ordinateurs/computers repertorié dans la base par DiscontinuedDate d'ordre croissant
	 * @return
	 */
	public List<Computer> getListComputersOrderByDiscontinuedDateDesc() {
		ArrayList<Computer> al = new ArrayList<Computer>();

		// ajoutez ici le code de r�cup�ration des produits
		String query = "SELECT pc.id, pc.name, pc.introduced, pc.discontinued, comp.id, comp.name FROM computer AS pc LEFT JOIN company AS comp ON pc.company_id=comp.id ORDER BY pc.discontinued DESC;";
		ResultSet results = null;
		Statement stmt = null;
		
		Connection c = ProjetConnection.getInstance();

		if(c != null){

			try {
				stmt = c.createStatement();
				results = stmt.executeQuery(query);

				while(results.next()){
					// Recuperation des donnéees de Computer
					int id = results.getInt("id");
					String name = results.getString("name");
					DateTime introduced = new DateTime(results.getTimestamp("introduced"));
					DateTime discontinued = new DateTime(results.getTimestamp("discontinued"));
					
					// Creation de la company à associer
					Company cpy = new Company();
					cpy.setId(results.getInt("comp.id"));
					cpy.setName(results.getString("comp.name"));

					al.add(new Computer(id, name, introduced, discontinued, cpy));

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Problème dans la requete de listing...");
			} finally{
				try {

					if(results != null)
						results.close();
					if(stmt != null)
						stmt.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else{
			System.out.println("La connection est null...");
		}

		return al;
	}
	
	/**
	 * Liste tous les ordinateurs/computers repertorié dans la base par Company d'ordre croissant
	 * @return
	 */
	public List<Computer> getListComputersOrderByCompanyAsc() {
		ArrayList<Computer> al = new ArrayList<Computer>();

		// ajoutez ici le code de r�cup�ration des produits
		String query = "SELECT pc.id, pc.name, pc.introduced, pc.discontinued, comp.id, comp.name FROM computer AS pc LEFT JOIN company AS comp ON pc.company_id=comp.id ORDER BY comp.name ASC;";
		ResultSet results = null;
		Statement stmt = null;
		
		Connection c = ProjetConnection.getInstance();

		if(c != null){

			try {
				stmt = c.createStatement();
				results = stmt.executeQuery(query);

				while(results.next()){
					// Recuperation des donnéees de Computer
					int id = results.getInt("id");
					String name = results.getString("name");
					DateTime introduced = new DateTime(results.getTimestamp("introduced"));
					DateTime discontinued = new DateTime(results.getTimestamp("discontinued"));
					
					// Creation de la company à associer
					Company cpy = new Company();
					cpy.setId(results.getInt("comp.id"));
					cpy.setName(results.getString("comp.name"));

					al.add(new Computer(id, name, introduced, discontinued, cpy));

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Problème dans la requete de listing...");
			} finally{
				try {

					if(results != null)
						results.close();
					if(stmt != null)
						stmt.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else{
			System.out.println("La connection est null...");
		}

		return al;
	}
	
	/**
	 * Liste tous les ordinateurs/computers repertorié dans la base par Company d'ordre croissant
	 * @return
	 */
	public List<Computer> getListComputersOrderByCompanyDesc() {
		ArrayList<Computer> al = new ArrayList<Computer>();

		// ajoutez ici le code de r�cup�ration des produits
		String query = "SELECT pc.id, pc.name, pc.introduced, pc.discontinued, comp.id, comp.name FROM computer AS pc LEFT JOIN company AS comp ON pc.company_id=comp.id ORDER BY comp.name DESC;";
		ResultSet results = null;
		Statement stmt = null;
		
		Connection c = ProjetConnection.getInstance();

		if(c != null){

			try {
				stmt = c.createStatement();
				results = stmt.executeQuery(query);

				while(results.next()){
					// Recuperation des donnéees de Computer
					int id = results.getInt("id");
					String name = results.getString("name");
					DateTime introduced = new DateTime(results.getTimestamp("introduced"));
					DateTime discontinued = new DateTime(results.getTimestamp("discontinued"));
					
					// Creation de la company à associer
					Company cpy = new Company();
					cpy.setId(results.getInt("comp.id"));
					cpy.setName(results.getString("comp.name"));

					al.add(new Computer(id, name, introduced, discontinued, cpy));

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Problème dans la requete de listing...");
			} finally{
				try {

					if(results != null)
						results.close();
					if(stmt != null)
						stmt.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else{
			System.out.println("La connection est null...");
		}

		return al;
	}
	
	/**
	 * Liste tous les ordinateurs/computers repertorié dans la base
	 * @param rang le rang
	 * @return
	 */
	public List<Computer> getListComputersWithRange(int rang, int interval) {
		ArrayList<Computer> al = new ArrayList<Computer>();

		// ajoutez ici le code de r�cup�ration des produits
		String query = "SELECT pc.id, pc.name, pc.introduced, pc.discontinued, comp.id, comp.name FROM computer AS pc LEFT JOIN company AS comp ON pc.company_id=comp.id ORDER BY pc.name LIMIT ?, ?;";
		ResultSet results = null;
		PreparedStatement pstmt = null;
		
		Connection c = ProjetConnection.getInstance();

		if(c != null){

			try {
				pstmt = c.prepareStatement(query);
				pstmt.setInt(1, rang*interval);
				pstmt.setInt(2, interval);
				results = pstmt.executeQuery();

				while(results.next()){
					// Recuperation des donnéees de Computer
					int id = results.getInt("id");
					String name = results.getString("name");
					DateTime introduced = new DateTime(results.getTimestamp("introduced"));
					DateTime discontinued = new DateTime(results.getTimestamp("discontinued"));
					
					// Creation de la company à associer
					Company cpy = new Company();
					cpy.setId(results.getInt("comp.id"));
					cpy.setName(results.getString("comp.name"));

					al.add(new Computer(id, name, introduced, discontinued, cpy));

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Problème dans la requete de listing...");
			} finally{
				try {

					if(results != null)
						results.close();
					if(pstmt != null)
						pstmt.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else{
			System.out.println("La connection est null...");
		}

		return al;
	}
	
	/**
	 * Liste tous les ordinateurs/computers repertorié dans la base trié par nom décroissant
	 * @param rang le rang
	 * @return
	 */
	public List<Computer> getListComputersOrderByNameDescWithRange(int rang, int interval) {
		ArrayList<Computer> al = new ArrayList<Computer>();

		// ajoutez ici le code de r�cup�ration des produits
		String query = "SELECT pc.id, pc.name, pc.introduced, pc.discontinued, comp.id, comp.name FROM computer AS pc LEFT JOIN company AS comp ON pc.company_id=comp.id ORDER BY pc.name DESC LIMIT ?, ?;";
		ResultSet results = null;
		PreparedStatement pstmt = null;
		
		Connection c = ProjetConnection.getInstance();

		if(c != null){

			try {
				pstmt = c.prepareStatement(query);
				pstmt.setInt(1, rang*interval);
				pstmt.setInt(2, interval);
				results = pstmt.executeQuery();

				while(results.next()){
					// Recuperation des donnéees de Computer
					int id = results.getInt("id");
					String name = results.getString("name");
					DateTime introduced = new DateTime(results.getTimestamp("introduced"));
					DateTime discontinued = new DateTime(results.getTimestamp("discontinued"));
					
					// Creation de la company à associer
					Company cpy = new Company();
					cpy.setId(results.getInt("comp.id"));
					cpy.setName(results.getString("comp.name"));

					al.add(new Computer(id, name, introduced, discontinued, cpy));

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Problème dans la requete de listing...");
			} finally{
				try {

					if(results != null)
						results.close();
					if(pstmt != null)
						pstmt.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else{
			System.out.println("La connection est null...");
		}

		return al;
	}
	
	/**
	 * Liste tous les ordinateurs/computers repertorié dans la base trié par IntroducedDate croissant
	 * @param rang le rang
	 * @return
	 */
	public List<Computer> getListComputersOrderByIntroducedDateAscWithRange(int rang, int interval) {
		ArrayList<Computer> al = new ArrayList<Computer>();

		// ajoutez ici le code de r�cup�ration des produits
		String query = "SELECT pc.id, pc.name, pc.introduced, pc.discontinued, comp.id, comp.name FROM computer AS pc LEFT JOIN company AS comp ON pc.company_id=comp.id ORDER BY pc.introduced ASC LIMIT ?, ?;";
		ResultSet results = null;
		PreparedStatement pstmt = null;
		
		Connection c = ProjetConnection.getInstance();

		if(c != null){

			try {
				pstmt = c.prepareStatement(query);
				pstmt.setInt(1, rang*interval);
				pstmt.setInt(2, interval);
				results = pstmt.executeQuery();

				while(results.next()){
					// Recuperation des donnéees de Computer
					int id = results.getInt("id");
					String name = results.getString("name");
					DateTime introduced = new DateTime(results.getTimestamp("introduced"));
					DateTime discontinued = new DateTime(results.getTimestamp("discontinued"));
					
					// Creation de la company à associer
					Company cpy = new Company();
					cpy.setId(results.getInt("comp.id"));
					cpy.setName(results.getString("comp.name"));

					al.add(new Computer(id, name, introduced, discontinued, cpy));

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Problème dans la requete de listing...");
			} finally{
				try {

					if(results != null)
						results.close();
					if(pstmt != null)
						pstmt.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else{
			System.out.println("La connection est null...");
		}

		return al;
	}
	
	/**
	 * Liste tous les ordinateurs/computers repertorié dans la base trié par IntroducedDate décroissant
	 * @param rang le rang
	 * @param interval le nb d'element par page
	 * @return
	 */
	public List<Computer> getListComputersOrderByIntroducedDateDescWithRange(int rang, int interval) {
		ArrayList<Computer> al = new ArrayList<Computer>();

		// ajoutez ici le code de r�cup�ration des produits
		String query = "SELECT pc.id, pc.name, pc.introduced, pc.discontinued, comp.id, comp.name FROM computer AS pc LEFT JOIN company AS comp ON pc.company_id=comp.id ORDER BY pc.introduced DESC LIMIT ?, ?;";
		ResultSet results = null;
		PreparedStatement pstmt = null;
		
		Connection c = ProjetConnection.getInstance();

		if(c != null){

			try {
				pstmt = c.prepareStatement(query);
				pstmt.setInt(1, rang*interval);
				pstmt.setInt(2, interval);
				results = pstmt.executeQuery();

				while(results.next()){
					// Recuperation des donnéees de Computer
					int id = results.getInt("id");
					String name = results.getString("name");
					DateTime introduced = new DateTime(results.getTimestamp("introduced"));
					DateTime discontinued = new DateTime(results.getTimestamp("discontinued"));
					
					// Creation de la company à associer
					Company cpy = new Company();
					cpy.setId(results.getInt("comp.id"));
					cpy.setName(results.getString("comp.name"));

					al.add(new Computer(id, name, introduced, discontinued, cpy));

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Problème dans la requete de listing...");
			} finally{
				try {

					if(results != null)
						results.close();
					if(pstmt != null)
						pstmt.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else{
			System.out.println("La connection est null...");
		}

		return al;
	}
	
	/**
	 * Liste tous les ordinateurs/computers repertorié dans la base trié par DiscontinuedDate croissant
	 * @param rang le rang
	 * @return
	 */
	public List<Computer> getListComputersOrderByDiscontinuedDateAscWithRange(int rang, int interval) {
		ArrayList<Computer> al = new ArrayList<Computer>();

		// ajoutez ici le code de r�cup�ration des produits
		String query = "SELECT pc.id, pc.name, pc.introduced, pc.discontinued, comp.id, comp.name FROM computer AS pc LEFT JOIN company AS comp ON pc.company_id=comp.id ORDER BY pc.discontinued ASC LIMIT ?, ?;";
		ResultSet results = null;
		PreparedStatement pstmt = null;
		
		Connection c = ProjetConnection.getInstance();

		if(c != null){

			try {
				pstmt = c.prepareStatement(query);
				pstmt.setInt(1, rang*interval);
				pstmt.setInt(2, interval);
				results = pstmt.executeQuery();

				while(results.next()){
					// Recuperation des donnéees de Computer
					int id = results.getInt("id");
					String name = results.getString("name");
					DateTime introduced = new DateTime(results.getTimestamp("introduced"));
					DateTime discontinued = new DateTime(results.getTimestamp("discontinued"));
					
					// Creation de la company à associer
					Company cpy = new Company();
					cpy.setId(results.getInt("comp.id"));
					cpy.setName(results.getString("comp.name"));

					al.add(new Computer(id, name, introduced, discontinued, cpy));

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Problème dans la requete de listing...");
			} finally{
				try {

					if(results != null)
						results.close();
					if(pstmt != null)
						pstmt.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else{
			System.out.println("La connection est null...");
		}

		return al;
	}
	
	/**
	 * Liste tous les ordinateurs/computers repertorié dans la base trié par DiscontinuedDate décroissant
	 * @param rang le rang
	 * @param interval le nb d'element par page
	 * @return
	 */
	public List<Computer> getListComputersOrderByDiscontinuedDateDescWithRange(int rang, int interval) {
		ArrayList<Computer> al = new ArrayList<Computer>();

		// ajoutez ici le code de r�cup�ration des produits
		String query = "SELECT pc.id, pc.name, pc.introduced, pc.discontinued, comp.id, comp.name FROM computer AS pc LEFT JOIN company AS comp ON pc.company_id=comp.id ORDER BY pc.discontinued DESC LIMIT ?, ?;";
		ResultSet results = null;
		PreparedStatement pstmt = null;
		
		Connection c = ProjetConnection.getInstance();

		if(c != null){

			try {
				pstmt = c.prepareStatement(query);
				pstmt.setInt(1, rang*interval);
				pstmt.setInt(2, interval);
				results = pstmt.executeQuery();

				while(results.next()){
					// Recuperation des donnéees de Computer
					int id = results.getInt("id");
					String name = results.getString("name");
					DateTime introduced = new DateTime(results.getTimestamp("introduced"));
					DateTime discontinued = new DateTime(results.getTimestamp("discontinued"));
					
					// Creation de la company à associer
					Company cpy = new Company();
					cpy.setId(results.getInt("comp.id"));
					cpy.setName(results.getString("comp.name"));

					al.add(new Computer(id, name, introduced, discontinued, cpy));

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Problème dans la requete de listing...");
			} finally{
				try {

					if(results != null)
						results.close();
					if(pstmt != null)
						pstmt.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else{
			System.out.println("La connection est null...");
		}

		return al;
	}
	
	/**
	 * Liste tous les ordinateurs/computers repertorié dans la base trié par Company croissant
	 * @param rang le rang
	 * @return
	 */
	public List<Computer> getListComputersOrderByCompanyAscWithRange(int rang, int interval) {
		ArrayList<Computer> al = new ArrayList<Computer>();

		// ajoutez ici le code de r�cup�ration des produits
		String query = "SELECT pc.id, pc.name, pc.introduced, pc.discontinued, comp.id, comp.name FROM computer AS pc LEFT JOIN company AS comp ON pc.company_id=comp.id ORDER BY comp.name ASC LIMIT ?, ?;";
		ResultSet results = null;
		PreparedStatement pstmt = null;
		
		Connection c = ProjetConnection.getInstance();

		if(c != null){

			try {
				pstmt = c.prepareStatement(query);
				pstmt.setInt(1, rang*interval);
				pstmt.setInt(2, interval);
				results = pstmt.executeQuery();

				while(results.next()){
					// Recuperation des donnéees de Computer
					int id = results.getInt("id");
					String name = results.getString("name");
					DateTime introduced = new DateTime(results.getTimestamp("introduced"));
					DateTime discontinued = new DateTime(results.getTimestamp("discontinued"));
					
					// Creation de la company à associer
					Company cpy = new Company();
					cpy.setId(results.getInt("comp.id"));
					cpy.setName(results.getString("comp.name"));

					al.add(new Computer(id, name, introduced, discontinued, cpy));

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Problème dans la requete de listing...");
			} finally{
				try {

					if(results != null)
						results.close();
					if(pstmt != null)
						pstmt.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else{
			System.out.println("La connection est null...");
		}

		return al;
	}
	
	/**
	 * Liste tous les ordinateurs/computers repertorié dans la base trié par Company décroissant
	 * @param rang le rang
	 * @param interval le nb d'element par page
	 * @return
	 */
	public List<Computer> getListComputersOrderByCompanyDescWithRange(int rang, int interval) {
		ArrayList<Computer> al = new ArrayList<Computer>();

		// ajoutez ici le code de r�cup�ration des produits
		String query = "SELECT pc.id, pc.name, pc.introduced, pc.discontinued, comp.id, comp.name FROM computer AS pc LEFT JOIN company AS comp ON pc.company_id=comp.id ORDER BY comp.name DESC LIMIT ?, ?;";
		ResultSet results = null;
		PreparedStatement pstmt = null;
		
		Connection c = ProjetConnection.getInstance();

		if(c != null){

			try {
				pstmt = c.prepareStatement(query);
				pstmt.setInt(1, rang*interval);
				pstmt.setInt(2, interval);
				results = pstmt.executeQuery();

				while(results.next()){
					// Recuperation des donnéees de Computer
					int id = results.getInt("id");
					String name = results.getString("name");
					DateTime introduced = new DateTime(results.getTimestamp("introduced"));
					DateTime discontinued = new DateTime(results.getTimestamp("discontinued"));
					
					// Creation de la company à associer
					Company cpy = new Company();
					cpy.setId(results.getInt("comp.id"));
					cpy.setName(results.getString("comp.name"));

					al.add(new Computer(id, name, introduced, discontinued, cpy));

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Problème dans la requete de listing...");
			} finally{
				try {

					if(results != null)
						results.close();
					if(pstmt != null)
						pstmt.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else{
			System.out.println("La connection est null...");
		}

		return al;
	}

	/**
	 * retourne le nombre de computer/ordinateur dans la base
	 * @return
	 */
	public int getNbComputer(){
		// nombre de computer
		int nb = -99;

		// requete
		String query = "SELECT COUNT(*) AS nb FROM computer;";
		ResultSet results = null;
		Statement stmt = null;

		Connection c = ProjetConnection.getInstance();

		if(c != null){

			try {
				stmt = c.createStatement();
				results = stmt.executeQuery(query);

				while(results.next()){
					// Recuperation des donnéees de la ligne
					nb = results.getInt("nb");					
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Problème dans la requete de comptage de computer...");
			} finally{
				try {

					if(results != null)
						results.close();
					if(stmt != null)
						stmt.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else{
			System.out.println("La connection est null...");
		}

		return nb;
	}

	/**
	 * Insert un ordinateur/computer dans la base
	 */
	public void insertComputer(Computer cp) {

		// ajoutez ici le code d'insertion d'un produit
		String query = "INSERT INTO computer(name,introduced,discontinued,company_id) VALUES(?,?,?,?);";
		int results = 0;
		PreparedStatement pstmt = null;
		
		Connection c = ProjetConnection.getInstance();

		try {
			pstmt = c.prepareStatement(query);
			pstmt.setString(1, cp.getName());
			pstmt.setTimestamp(2, new Timestamp(cp.getIntroducedDate().getMillis()));
			pstmt.setTimestamp(3, new Timestamp(cp.getDiscontinuedDate().getMillis()));
			pstmt.setInt(4, cp.getCompany().getId());
			System.out.println("La requete: " + pstmt.toString());

			results = pstmt.executeUpdate();

			System.out.println("Insertion bien effectué...");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Probleme dans la requete d'insertion...");
		}finally{
			try {

				if(pstmt != null)
					pstmt.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * Supprime l'ordinateur identifié en paramètre de la base de donnée
	 * @param id
	 */
	public void deleteComputer(int id){
		// la requete
		String query = "DELETE FROM computer WHERE id=?;";
		int results = 0;
		PreparedStatement pstmt = null;
		
		Connection c = ProjetConnection.getInstance();

		try {
			pstmt = c.prepareStatement(query);
			pstmt.setInt(1, id);
			System.out.println("La requete: " + pstmt.toString());

			results = pstmt.executeUpdate();

			System.out.println("Suppression bien effectué...");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Probleme dans la requete de suppression...");
		}finally{
			try {

				if(pstmt != null)
					pstmt.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Liste tous les ordinateurs/computers repertorié dans la base correspondant au motif
	 * @return
	 */
	public List<Computer> searchComputers(String word) {
		ArrayList<Computer> al = new ArrayList<Computer>();

		// requete de recherche du pattern
		String query = "SELECT pc.id, pc.name, pc.introduced, pc.discontinued, comp.id, comp.name FROM computer AS pc LEFT JOIN company AS comp ON pc.company_id=comp.id WHERE pc.name LIKE ? ;";
		
		ResultSet results = null;
		PreparedStatement pstmt = null;
		
		Connection c = ProjetConnection.getInstance();

		if(c != null){

			try {
				pstmt = c.prepareStatement(query);
				pstmt.setString(1, "%"+ word + "%");
				
				results = pstmt.executeQuery();

				while(results.next()){
					// Recuperation des donnéees de Computer
					int id = results.getInt("id");
					String name = results.getString("name");
					DateTime introduced = new DateTime(results.getTimestamp("introduced"));
					DateTime discontinued = new DateTime(results.getTimestamp("discontinued"));
					
					// Creation de la company à associer
					Company cpy = new Company();
					cpy.setId(results.getInt("comp.id"));
					cpy.setName(results.getString("comp.name"));

					al.add(new Computer(id, name, introduced, discontinued, cpy));

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Problème dans la requete de recherche...");
			} finally{
				try {

					if(results != null)
						results.close();
					if(pstmt != null)
						pstmt.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else{
			System.out.println("La connection est null...");
		}

		return al;
	}
	
	/**
	 * Fonction de recherche par filtre
	 * @param word le mot ou schema à rechercher
	 * @param filter le mode de tri (0 => name, 1 => introducedDate, 2 => discontinuedDate, 3 => company)
	 * @param isAsc true => ascendant / false => descendant
	 * @return
	 */
	public List<Computer> searchComputersByFilteringAndOrdering(String word, int filter, boolean isAsc) {
		ArrayList<Computer> al = new ArrayList<Computer>();
		
		String sFilter;
		switch(filter){
		case 0: // par nom de Computer
			sFilter = "pc.name"; break;
		case 1: // par introducedDate
			sFilter = "pc.introduced"; break;
		case 2: // par discontinuedDate
			sFilter = "pc.discontinued"; break;
		case 3: // par nom de Company
			sFilter = "comp.name"; break;
		default:
			sFilter = "pc.name"; break;
		}

		String query;
		
		// requete de recherche du pattern
		if(isAsc)
			query = "SELECT pc.id, pc.name, pc.introduced, pc.discontinued, comp.id, comp.name FROM computer AS pc LEFT JOIN company AS comp ON pc.company_id=comp.id WHERE pc.name LIKE ? ORDER BY " + sFilter + ";";
		else
			query = "SELECT pc.id, pc.name, pc.introduced, pc.discontinued, comp.id, comp.name FROM computer AS pc LEFT JOIN company AS comp ON pc.company_id=comp.id WHERE pc.name LIKE ? ORDER BY " + sFilter + " DESC;";
		
		ResultSet results = null;
		PreparedStatement pstmt = null;
		
		Connection c = ProjetConnection.getInstance();

		if(c != null){

			try {
				pstmt = c.prepareStatement(query);
				pstmt.setString(1, "%"+ word + "%");
				
				results = pstmt.executeQuery();

				while(results.next()){
					// Recuperation des donnéees de Computer
					int id = results.getInt("id");
					String name = results.getString("name");
					DateTime introduced = new DateTime(results.getTimestamp("introduced"));
					DateTime discontinued = new DateTime(results.getTimestamp("discontinued"));
					
					// Creation de la company à associer
					Company cpy = new Company();
					cpy.setId(results.getInt("comp.id"));
					cpy.setName(results.getString("comp.name"));

					al.add(new Computer(id, name, introduced, discontinued, cpy));

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Problème dans la requete de recherche...");
			} finally{
				try {

					if(results != null)
						results.close();
					if(pstmt != null)
						pstmt.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else{
			System.out.println("La connection est null...");
		}

		return al;
	}
	
	/**
	 * Liste tous les ordinateurs/computers repertorié dans la base correspondant au motif avec intervalle de resultat
	 * @return
	 */
	public List<Computer> searchComputersWithRange(String word, int rang, int interval) {
		ArrayList<Computer> al = new ArrayList<Computer>();

		// requete de recherche du pattern
		String query = "SELECT pc.id, pc.name, pc.introduced, pc.discontinued, comp.id, comp.name FROM computer AS pc LEFT JOIN company AS comp ON pc.company_id=comp.id WHERE pc.name LIKE ? ORDER BY pc.name LIMIT ?, ?;";
		
		ResultSet results = null;
		PreparedStatement pstmt = null;
		
		Connection c = ProjetConnection.getInstance();

		if(c != null){

			try {
				pstmt = c.prepareStatement(query);
				pstmt.setString(1, "%"+ word + "%");
				pstmt.setInt(2, rang);
				pstmt.setInt(3, interval);
				
				results = pstmt.executeQuery();

				System.out.println(pstmt.toString());
				
				while(results.next()){
					// Recuperation des donnéees de Computer
					int id = results.getInt("id");
					String name = results.getString("name");
					DateTime introduced = new DateTime(results.getTimestamp("introduced"));
					DateTime discontinued = new DateTime(results.getTimestamp("discontinued"));
					
					// Creation de la company à associer
					Company cpy = new Company();
					cpy.setId(results.getInt("comp.id"));
					cpy.setName(results.getString("comp.name"));

					al.add(new Computer(id, name, introduced, discontinued, cpy));

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Problème dans la requete de recherche...");
			} finally{
				try {

					if(results != null)
						results.close();
					if(pstmt != null)
						pstmt.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else{
			System.out.println("La connection est null...");
		}

		return al;
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
	public List<Computer> searchComputersByFilteringAndOrderingWithRange(String word, int rang, int interval, int filter, boolean isAsc) {
		ArrayList<Computer> al = new ArrayList<Computer>();

		String sFilter;
		switch(filter){
		case 0: // par nom de Computer
			sFilter = "pc.name"; break;
		case 1: // par introducedDate
			sFilter = "pc.introduced"; break;
		case 2: // par discontinuedDate
			sFilter = "pc.discontinued"; break;
		case 3: // par nom de Company
			sFilter = "comp.name"; break;
		default:
			sFilter = "pc.name"; break;
		}
		
		if(!isAsc)
			sFilter = sFilter + " DESC";
		
		// requete de recherche du pattern
		String query = "SELECT pc.id, pc.name, pc.introduced, pc.discontinued, comp.id, comp.name FROM computer AS pc LEFT JOIN company AS comp ON pc.company_id=comp.id WHERE pc.name LIKE ? ORDER BY " + sFilter + " LIMIT ?, ?;";
		
		
		
		ResultSet results = null;
		PreparedStatement pstmt = null;
		
		Connection c = ProjetConnection.getInstance();

		if(c != null){

			try {
				pstmt = c.prepareStatement(query);
				pstmt.setString(1, "%"+ word + "%");
				pstmt.setInt(2, rang);
				pstmt.setInt(3, interval);
				
				results = pstmt.executeQuery();

				System.out.println(pstmt.toString());
				
				while(results.next()){
					// Recuperation des donnéees de Computer
					int id = results.getInt("id");
					String name = results.getString("name");
					DateTime introduced = new DateTime(results.getTimestamp("introduced"));
					DateTime discontinued = new DateTime(results.getTimestamp("discontinued"));
					
					// Creation de la company à associer
					Company cpy = new Company();
					cpy.setId(results.getInt("comp.id"));
					cpy.setName(results.getString("comp.name"));

					al.add(new Computer(id, name, introduced, discontinued, cpy));

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Problème dans la requete de recherche...");
			} finally{
				try {

					if(results != null)
						results.close();
					if(pstmt != null)
						pstmt.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else{
			System.out.println("La connection est null...");
		}

		return al;
	}
	
	/**
	 * Liste tous les ordinateurs/computers repertorié dans la base avec les critères de filtrage et d'ordre
	 * @param filter le mode de tri (0 => name, 1 => introducedDate, 2 => discontinuedDate, 3 => company)
	 * @param isAsc true => ascendant / false => descendant
	 * @return
	 */
	public List<Computer> getListComputersByFilteringAndOrdering(int filter, boolean isAsc) {
		ArrayList<Computer> al = new ArrayList<Computer>();

		String sFilter;
		switch(filter){
		case 0: // par nom de Computer
			sFilter = "pc.name"; break;
		case 1: // par introducedDate
			sFilter = "pc.introduced"; break;
		case 2: // par discontinuedDate
			sFilter = "pc.discontinued"; break;
		case 3: // par nom de Company
			sFilter = "comp.name"; break;
		default:
			sFilter = "pc.name"; break;
		}
		
		if(!isAsc)
			sFilter = sFilter + " DESC";
		
		// ajoutez ici le code de r�cup�ration des produits
		String query = "SELECT pc.id, pc.name, pc.introduced, pc.discontinued, comp.id, comp.name FROM computer AS pc LEFT JOIN company AS comp ON pc.company_id=comp.id ORDER BY " + sFilter + ";";
		ResultSet results = null;
		Statement stmt = null;
		
		Connection c = ProjetConnection.getInstance();

		if(c != null){

			try {
				stmt = c.createStatement();
				results = stmt.executeQuery(query);

				while(results.next()){
					// Recuperation des donnéees de Computer
					int id = results.getInt("id");
					String name = results.getString("name");
					DateTime introduced = new DateTime(results.getTimestamp("introduced"));
					DateTime discontinued = new DateTime(results.getTimestamp("discontinued"));
					
					// Creation de la company à associer
					Company cpy = new Company();
					cpy.setId(results.getInt("comp.id"));
					cpy.setName(results.getString("comp.name"));

					al.add(new Computer(id, name, introduced, discontinued, cpy));

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Problème dans la requete de listing...");
			} finally{
				try {

					if(results != null)
						results.close();
					if(stmt != null)
						stmt.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else{
			System.out.println("La connection est null...");
		}

		return al;
	}

}
