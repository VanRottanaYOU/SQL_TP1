package fr.codevallee.formation.tp1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Connect {

	private Connection connect;
	// URL de connexion
	private String url = "jdbc:mysql://localhost:3306/immobilier";
	// Nom du user
	private String user = "root";
	// Mot de passe de l'utilisateur
	private String passwd = "root";
	// Objet Connection
	private ArrayList<Agence> listAgences = new ArrayList();
	private Agence monAgence;

	// Constructeur privé
	public Connect() {
		
	}
	
	public void getConnexion() throws Exception {
		try {
			connect = DriverManager.getConnection(url, user, passwd);
			listerAgences();
			chercherAgence("fnaim");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	// Méthode qui va nous retourner notre instance et la créer si elle n'existe pas
	public Connection getInstance() {
		if (connect == null) {
			new Connect();
		}
		return connect;
	}
	
	public ArrayList<Agence> getListAgences(){
		return listAgences;
	}
	
	public Agence getAgence(){
		return monAgence;
	}
	
	public void listerAgences() throws SQLException{
		// Step 2: Allocate a 'Statement' object in the Connection
		Statement stmt;
		try {
			stmt = connect.createStatement();

			 // Step 3: Execute a SQL SELECT query, the query result
			 //  is returned in a 'ResultSet' object.
			 String strSelect = "select * from agence";
			 System.out.println("The SQL query is: " + strSelect); // Echo For debugging
			 System.out.println();
 
			 ResultSet rset = stmt.executeQuery(strSelect);
 
			 // Step 4: Process the ResultSet by scrolling the cursor forward via next().
			 //  For each row, retrieve the contents of the cells with getXxx(columnName).
			 System.out.println("The records selected are:");
			 int rowCount = 0;
			 while(rset.next()) {   // Move the cursor to the next row, return false if no more row
			    String idAgence = rset.getString("idAgence");
			    String nom = rset.getString("nom");
			    String adresse = rset.getString("adresse");
			    System.out.println(idAgence + ", " + nom + ", " + adresse);
			    ++rowCount;
			    Agence monAgence = new Agence(idAgence,nom,adresse);
			    listAgences.add(monAgence);	          	            
			 }
			 stmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
	}
	
	public void chercherAgence(String nom) throws SQLException{
		Statement stmt;
		 try {
			
			 PreparedStatement recherchePersonne = 
			 connect.prepareStatement("SELECT * FROM Agence WHERE nom = ?");

			 recherchePersonne.setString(1, nom);
			              	
			 stmt = connect.createStatement();
			 ResultSet rset = recherchePersonne.executeQuery();

			 System.out.println("parcours des données retournées");

			 boolean encore = rset.next();

			 while (encore) {
			               System.out.print(rset.getString(1) + " :  "+rset.getString(2)+ " "+rset.getString(3));
			               System.out.println();
			               monAgence = new Agence(rset.getString(1),rset.getString(2),rset.getString(3));
			               encore = rset.next();	 	                 	 	                    	                   
			 }
			 stmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 	    
	}
}
