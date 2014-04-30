package com.company.connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public enum PoolConnection {
	INSTANCE;
	
	private static final String PROPERTY_URL             = "jdbc:mysql://localhost:3306/computer-database-db?zeroDateTimeBehavior=convertToNull";
	private static final String PROPERTY_DRIVER          = "com.mysql.jdbc.Driver";
	private static final String PROPERTY_NOM_UTILISATEUR = "root";
	private static final String PROPERTY_MOT_DE_PASSE    = "root";
	BoneCP connectionPool = null;
	
	public Logger log = null;
	
	private void load(){
		try {
			log = LoggerFactory.getLogger(this.getClass());
			Class.forName( PROPERTY_DRIVER );
		} catch ( ClassNotFoundException e ) {
			throw new RuntimeException( "Le driver est introuvable dans le classpath.", e );
		}
		try {
			/*
			 * Création d'une configuration de pool de connexions via l'objet
			 * BoneCPConfig et les différents setters associés.
			 */
			BoneCPConfig config = new BoneCPConfig();
			/* Mise en place de l'URL, du nom et du mot de passe */
			config.setJdbcUrl( PROPERTY_URL );
			config.setUsername( PROPERTY_NOM_UTILISATEUR );
			config.setPassword( PROPERTY_MOT_DE_PASSE );
			/* Paramétrage de la taille du pool */
			config.setMinConnectionsPerPartition( 5 );
			config.setMaxConnectionsPerPartition( 10 );
			config.setPartitionCount( 2 );
			/* Création du pool à partir de la configuration, via l'objet BoneCP */
			connectionPool = new BoneCP( config );
		} catch ( SQLException e ) {
			e.printStackTrace();
			throw new RuntimeException( "Erreur de configuration du pool de connexions.", e );
		}
	}
	
	
	
	
	
	private PoolConnection() {
		// TODO Auto-generated constructor stub
		
	}






//	PoolConnection( BoneCP connectionPool ) {
//		this.connectionPool = connectionPool;
//	}

	/*
	 * Méthode chargée de récupérer les informations de connexion à la base de
	 * données, charger le driver JDBC et retourner une instance de la Factory
	 */
	public static PoolConnection getInstance(){
		return INSTANCE;
	}

	/* Méthode chargée de fournir une connexion à la base de données */
	public Connection getConnection() throws SQLException {
		if(connectionPool==null)
			load();
		return connectionPool.getConnection();
	}
	
	/**
	 * Méthode de fermeture de connection
	 * @param connection
	 */
	public void disconnect(Connection connection){
		if(connection!=null){
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error("Probleme de fermeture de connection");
			}
		}
	}
	
	/**
	 * Methode de fermeture des objets utilisé par les DAOs
	 * @param obj
	 */
	public void closeObject(Object... obj){
		for(Object o : obj){
			if(o instanceof Connection){
				if(o!=null){
					try {
						((Connection) o).close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						log.error("Probleme de fermeture de connection");
					}
				}
			}
			else if(o instanceof ResultSet){
				if(o!=null){
					try {
						((ResultSet) o).close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						log.error("Probleme de fermeture du ResultSet");
					}
				}
			}
			else if(o instanceof PreparedStatement){
				if(o!=null){
					try {
						((PreparedStatement) o).close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						log.error("Probleme de fermeture du prepardedStatement");
					}
				}
			}
			else if(o instanceof Statement){
				if(o!=null){
					try {
						((Statement) o).close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						log.error("Probleme de fermeture du Statement");
					}
				}
			}
				
		}
	}

}
