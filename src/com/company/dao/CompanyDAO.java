package com.company.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.company.connection.ProjetConnection;
import com.company.om.Company;

/**
 * Classe de DAO pour Company
 * @author hrandr
 *
 */
public class CompanyDAO {

	public static CompanyDAO cdao = null;
	
	private CompanyDAO() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Sert à obtenir l'unique instance de CompanyDAO
	 * @return
	 */
	public static CompanyDAO getInstance(){
		if(cdao==null)
			cdao = new CompanyDAO();
		return cdao;
	}

	/**
	 * Liste toute les companies répertorié
	 * @return
	 */
	public List<Company> getListCompany() {
		ArrayList<Company> al = new ArrayList<Company>();

		// requete de recuperation des companies répertorié dans la base
		String query = "SELECT * FROM company;";
		ResultSet results = null;
		Statement stmt = null;

		//Connection c = getConnectionJNDI();
		Connection c = ProjetConnection.getInstance();

		if(c != null){

			try {
				stmt = c.createStatement();
				results = stmt.executeQuery(query);

				while(results.next()){
					// Recuperation des donnéees de la ligne
					int id = results.getInt("id");
					String name = results.getString("name");

					al.add(new Company(id, name));

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
					/*
					if(c != null)
						c.close();
					 */

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
	 * Insert une companie dans la base
	 * @param cp
	 */
	public void insereCompany(Company cp) {

		// ajoutez ici le code d'insertion d'un produit
		String query = "INSERT INTO company(name) VALUES(?);";
		int results = 0;
		PreparedStatement pstmt = null;

		Connection c = ProjetConnection.getInstance();

		try {
			pstmt = c.prepareStatement(query);
			pstmt.setString(1, cp.getName());
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
				/*
				if(c != null)
					c.close();
				 */

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * Recherche la company dans la base de donnée
	 * @param paramId l'id à rechercher
	 * @return L'objet Company
	 */
	public Company findCompanyById(int paramId){
		Company company = new Company();

		// requete de recuperation des companies répertorié dans la base
		String query = "SELECT * FROM company WHERE id=?;";
		ResultSet results = null;
		PreparedStatement pstmt = null;

		Connection c = ProjetConnection.getInstance();

		if(c != null){

			try {
				pstmt = c.prepareStatement(query);
				pstmt.setInt(1, paramId);
				results = pstmt.executeQuery();

				while(results.next()){
					// Recuperation des donnéees de la ligne
					int id = results.getInt("id");
					String name = results.getString("name");
					company.setId(id);
					company.setName(name);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Problème dans la requete de recherche de company...");
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

		return company;
	}

}
