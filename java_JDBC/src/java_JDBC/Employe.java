package java_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Employe {

	//exercice 2
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
		
				System.out.println(requete.getInt("noemp")+"  "+requete.getString("nom") +"  "+requete.getString("prenom")+"  "+requete.getString("emploi")+"  "+requete.getInt("sup")+"  "+requete.getDate("embauche")+"  "+requete.getDouble("sal")+"  "+requete.getDouble("comm")+"  "+requete.getInt("noserv")); 
			
			//fermer la connexion
			
			connexion.close();
		
		} catch (Exception e) {
		
			System.out.println(e);
			System.out.println("ca marche pas");
		
		}
	}
		
	//exercice 3
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
				
				System.out.println(requete.getInt("noemp")+"  "+requete.getString("nom") +"  "+requete.getString("prenom")+"  "+requete.getString("emploi")+"  "+requete.getInt("sup")+"  "+requete.getDate("embauche")+"  "+requete.getDouble("sal")+"  "+requete.getDouble("comm")+"  "+requete.getInt("noserv"));
				
			}
		
			//fermer la connexion
			
			connexion.close();
		
		} catch (Exception e) {
		
			System.out.println(e);
			System.out.println("ca marche pô");
		
		}	
	}
	
	//exercice 4
	public void liste_emp_serv_inf() {
		try {
			//charger la classe de driver
			
			Class.forName("org.postgresql.Driver");
			
			//créer objet de connexion
			
			Connection connexion = DriverManager.getConnection( "jdbc:postgresql://localhost:5432/exo_JDBC","postgres","fcbarcelone");
			
			//créer l'objet statement
			
			Statement statement = connexion.createStatement();
			
			ResultSet requete = statement.executeQuery("select * \r\n"
					+ "from emp\r\n"
					+ "inner join serv on emp.noserv=serv.noserv\r\n"
					+ "where service='INFORMATIQUE'"); 
			
			//executer la requete 
			
			while(requete.next()) {
				
				System.out.println(requete.getInt("noemp")+"  "+requete.getString("nom") +"  "+requete.getString("prenom")+"  "+requete.getString("emploi")+"  "+requete.getInt("sup")+"  "+requete.getDate("embauche")+"  "+requete.getDouble("sal")+"  "+requete.getDouble("comm")+"  "+requete.getInt("noserv"));
				
			}
		
			//fermer la connexion
			
			connexion.close();
		
		} catch (Exception e) {
		
			System.out.println(e);
			System.out.println("ca marche pô");
		
		}	
	}

	//exercice 5
		public void nom_scan() {
			try {
				//charger la classe de driver
				
				Class.forName("org.postgresql.Driver");
				
				//créer objet de connexion
				
				Connection connexion = DriverManager.getConnection( "jdbc:postgresql://localhost:5432/exo_JDBC","postgres","fcbarcelone");
				
				//créer l'objet statement
				
				Scanner scan = new Scanner(System.in);
				System.out.println("qui voulez-vous rechercher?");
				String nom = scan.nextLine();
				
				Statement statement = connexion.createStatement();
				 
				
				ResultSet requete = statement.executeQuery("select * \r\n"
						+ "from emp\r\n"
						+ "where lower(nom)=lower('"+nom+"')");
				
				//executer la requete 
				
				while(requete.next()) {
					
					System.out.println(requete.getInt("noemp")+"  "+requete.getString("nom") +"  "+requete.getString("prenom")+"  "+requete.getString("emploi")+"  "+requete.getInt("sup")+"  "+requete.getDate("embauche")+"  "+requete.getDouble("sal")+"  "+requete.getDouble("comm")+"  "+requete.getInt("noserv"));
					
				}
			
				//fermer la connexion
				
				connexion.close();
				scan.close();
			} catch (Exception e) {
			
				System.out.println(e);
				System.out.println("ca marche pô");
			
			}	
		}

	//exercice 6
		public void emp_embauche() {
			try {
				//charger la classe de driver
				
				Class.forName("org.postgresql.Driver");
				
				//créer objet de connexion
				
				Connection connexion = DriverManager.getConnection( "jdbc:postgresql://localhost:5432/exo_JDBC","postgres","fcbarcelone");
				
				//créer l'objet statement
				
				Scanner scan = new Scanner(System.in);
				System.out.println("entrez une date");
				int date = scan.nextInt();
				
				Statement statement = connexion.createStatement();
				 
				
				ResultSet requete = statement.executeQuery("select *\r\n"
						+ "from emp\r\n"
						+ "where extract(years from embauche)='"+date+"'");
				
				//executer la requete 
				
				while(requete.next()) {
					
					System.out.println(requete.getInt("noemp")+"  "+requete.getString("nom") +"  "+requete.getString("prenom")+"  "+requete.getString("emploi")+"  "+requete.getInt("sup")+"  "+requete.getDate("embauche")+"  "+requete.getDouble("sal")+"  "+requete.getDouble("comm")+"  "+requete.getInt("noserv"));
					
				}
			
				//fermer la connexion
				
				connexion.close();
				scan.close();
			} catch (Exception e) {
			
				System.out.println(e);
				System.out.println("ca marche pô");
			
			}	
		}

	//exercice 7
		public void liste_emp_scan() {
			try {
				//charger la classe de driver
				
				Class.forName("org.postgresql.Driver");
				
				//créer objet de connexion
				
				Connection connexion = DriverManager.getConnection( "jdbc:postgresql://localhost:5432/exo_JDBC","postgres","fcbarcelone");
				
				//créer l'objet statement
				
				Scanner scan = new Scanner(System.in);
				System.out.println("qui recherchez vous?");
				String nom = scan.nextLine();
				
				Statement statement = connexion.createStatement();
				 
				
				ResultSet requete = statement.executeQuery("select *\r\n"
						+ "from emp\r\n"
						+ "where lower(nom) like lower('%"+nom+"%')");
				
				//executer la requete 
				
				while(requete.next()) {
					
					System.out.println(requete.getInt("noemp")+"  "+requete.getString("nom") +"  "+requete.getString("prenom")+"  "+requete.getString("emploi")+"  "+requete.getInt("sup")+"  "+requete.getDate("embauche")+"  "+requete.getDouble("sal")+"  "+requete.getDouble("comm")+"  "+requete.getInt("noserv"));
					
				}
			
				//fermer la connexion
				
				connexion.close();
				scan.close();
			} catch (Exception e) {
			
				System.out.println(e);
				System.out.println("ca marche pô");
			
			}	
		}

	//exercice 8
		public void liste_emp_sal() {
			try {
				//charger la classe de driver
				
				Class.forName("org.postgresql.Driver");
				
				//créer objet de connexion
				
				Connection connexion = DriverManager.getConnection( "jdbc:postgresql://localhost:5432/exo_JDBC","postgres","fcbarcelone");
				
				//créer l'objet statement
				
				Scanner scan = new Scanner(System.in);
				System.out.println("combien gagnez vous?");
				String sal = scan.nextLine();
				
				Statement statement = connexion.createStatement();
				 
				
				ResultSet requete = statement.executeQuery("select *\r\n"
						+ "from emp\r\n"
						+ "where sal > "+sal+"");
				
				//executer la requete 
				System.out.println("voici la liste des gens plus riche que vous:");
				while(requete.next()) {
					
					System.out.println(requete.getString("nom")+"  "+requete.getString("emploi")+"  "+requete.getDouble("sal")+"  "+requete.getInt("noserv"));
					
				}
			
				//fermer la connexion
				
				connexion.close();
				scan.close();
			} catch (Exception e) {
			
				System.out.println(e);
				System.out.println("ca marche pô");
			
			}	
		}

	//exercice 9
		public void exo9() {			
				Scanner scan = new Scanner(System.in);
				System.out.println("Que voulez vous? \r"
						+ "1-Afficher la liste des employés\r"
						+ "2-Ajouter un employé\r"
						+ "3-Afficher le détail d'un employé\r"
						+ "4-Modifier un employé\r"
						+ "5-Supprimer un employé\r");
				try {
					int nom = scan.nextInt();
					 switch(nom){
					   
				       case 1: 
				           liste_emp();
				           break;
				   
				       case 2:
				           nom_scan();
				           break;
				   
				       case 3:
				           System.out.println("Buenos dias");
				           break;
				           
				       case 4:
				           System.out.println("Buenos dias");
				           break;
				          
				       case 5:
				           System.out.println("Buenos dias");
				           break;
				       default:
				           System.out.println("Choix incorrect");
				           exo9();
				           break;
				   }
				} catch (InputMismatchException e) {
					
					System.out.println("Entrée invalide,entrez un chiffre en 1 et 5");
					exo9();
				}
				
			scan.close();
		}
		
	//Ajouter un employer
		private void exo9_ajout_emp() {
			try {
				//charger la classe de driver
				
				Class.forName("org.postgresql.Driver");
				
				//créer objet de connexion
				
				Connection connexion = DriverManager.getConnection( "jdbc:postgresql://localhost:5432/exo_JDBC","postgres","fcbarcelone");
				
				//créer l'objet statement
				
				Scanner scan = new Scanner(System.in);
				System.out.println("combien gagnez vous?");
				String sal = scan.nextLine();
				
				Statement statement = connexion.createStatement();
				 
				
				ResultSet requete = statement.executeQuery("select *\r\n"
						+ "from emp\r\n"
						+ "where sal > "+sal+"");
				
				//executer la requete 
				System.out.println("voici la liste des gens plus riche que vous:");
				while(requete.next()) {
					
					System.out.println(requete.getString("nom")+"  "+requete.getString("emploi")+"  "+requete.getDouble("sal")+"  "+requete.getInt("noserv"));
					
				}
			
				//fermer la connexion
				
				connexion.close();
				scan.close();
			} catch (Exception e) {
			
				System.out.println(e);
				System.out.println("ca marche pô");
			
			}	
		
		}
	
	
//fin
}
