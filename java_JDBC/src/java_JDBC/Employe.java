package java_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Employe {

	public void liste_emp() {
		try {
			//charger la classe de driver
			
			Class.forName("org.postgresql.Driver");
			
			//créer objet de connexion
			
			Connection connexion = DriverManager.getConnection( "jdbc:postgresql://localhost:5432/exo_JDBC","postgres","fcbarcelone");
			
			//créer l'objet statement
			
			Statement statement = connexion.createStatement();
			
			ResultSet requete = statement.executeQuery("SELECT * FROM emp"); 
			
			//executer la requete 
			
			while(requete.next())
		
				System.out.println(requete.getInt(1)+"  "+requete.getString(2) +"  "+requete.getString(3)); 
			
			//fermer la connexion
			
			connexion.close();
		
		} catch (Exception e) {
		
			System.out.println(e);
			System.out.println("ca marche pas");
		
		}
	}
		
	public void liste_emp_serv5() {
		try {
			//charger la classe de driver
			
			Class.forName("org.postgresql.Driver");
			
			//créer objet de connexion
			
			Connection connexion = DriverManager.getConnection( "jdbc:postgresql://localhost:5432/exo_JDBC","postgres","fcbarcelone");
			
			//créer l'objet statement
			
			Statement statement = connexion.createStatement();
			
			ResultSet requete = statement.executeQuery("SELECT * FROM emp where noserv=5"); 
			
			//executer la requete 
			
			while(requete.next()) {
				System.out.println(requete.getString(1)+"|"+requete.getString(2)+"|"+requete.getString(3)+"|"+requete.getString(4)+"|"+requete.getString(5));


			}
		
				
				
			//fermer la connexion
			
			connexion.close();
		
		} catch (Exception e) {
		
			System.out.println(e);
			System.out.println("ca marche pô");
		
		}
		
		
	}
	
}
