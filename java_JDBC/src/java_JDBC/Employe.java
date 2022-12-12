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
				System.out.println("\rQue voulez vous? \r"
						+ "1-Afficher la liste des employés\r"
						+ "2-Ajouter un employé\r"
						+ "3-Afficher le détail d'un employé\r"
						+ "4-Modifier un employé\r"
						+ "5-Supprimer un employé\r");
				try {
					int choix = scan.nextInt();
					 switch(choix){
					   
				       case 1: 
				           liste_emp();
				           exo9();
				           break;
				   
				       case 2:
				           exo9_ajout_emp();
				           exo9();
				           break;
				   
				       case 3:
				    	   nom_scan();
				    	   exo9();
				           break;
				           
				       case 4:
				           exo9_modif_emp();;
				           break;
				          
				       case 5:
				           exo_supprimer_emp();
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
		
	//Ajouter un employé
		private void exo9_ajout_emp(){
			try {
				//charger la classe de driver
				
				Class.forName("org.postgresql.Driver");
				
				//créer objet de connexion
				
				Connection connexion = DriverManager.getConnection( "jdbc:postgresql://localhost:5432/exo_JDBC","postgres","fcbarcelone");
				
				//créer l'objet statement
			
					Scanner scan = new Scanner(System.in);
				System.out.println("Veuillez rentrer les données de l'employé");
				System.out.println("numéro d'employé:");
				int noemp = scan.nextInt();
				
				System.out.println("nom:");
				scan.nextLine();
				String nom = scan.nextLine();
				
				System.out.println("prenom:");
				String prenom = scan.nextLine();
				
				System.out.println("emploi:");
				String emploi = scan.nextLine();
				
				System.out.println("numéro de son supérieur:");
				int sup = scan.nextInt();
				scan.nextLine();
				System.out.println("date d'embauche (AAAA/MM/JJ):");
				String embauche = scan.nextLine();
				
				System.out.println("salaire:");
				double sal = scan.nextDouble();
				
				System.out.println("commisison touché:");
				int comm = scan.nextInt();
				
				System.out.println("numéro de service:");
				int noserv = scan.nextInt();
			
				
		
				Statement statement = connexion.createStatement();
				 
				String insert = ("INSERT INTO emp (\r\n"
						+ "    noemp,\r\n"
						+ "    nom,\r\n"
						+ "    prenom,\r\n"
						+ "    emploi,\r\n"
						+ "    sup,\r\n"
						+ "    embauche,\r\n"
						+ "    sal,\r\n"
						+ "    comm,\r\n"
						+ "    noserv\r\n"
						+ ") VALUES (\r\n"
						+ "    '"+noemp+"',\r\n"
						+ "    '"+nom.toUpperCase()+"',\r\n"
						+ "    '"+prenom.toUpperCase()+"',\r\n"
						+ "    '"+emploi.toUpperCase()+"',\r\n"
						+ "    '"+sup+"',\r\n"
						+ "    '"+embauche+"',\r\n"
						+ "    '"+sal+"',\r\n"
						+ "    '"+comm+"',\r\n"
						+ "    '"+noserv+"'\r\n"
						+ ");");
				statement.executeUpdate(insert);
				
				System.out.println("l'employer a bien été ajouter");
				//fermer la connexion
				
				connexion.close();
				scan.close();
			} catch (Exception e) {
				System.out.println("entrée invalide , vérifier vos informations");
				exo9_ajout_emp();
			
			}	
		
		}

	//Modifier un employé à partir de son nom et prénom
		private void exo9_modif_emp() {
			try {
				//charger la classe de driver
				
				Class.forName("org.postgresql.Driver");
				
				//créer objet de connexion
				
				Connection connexion = DriverManager.getConnection( "jdbc:postgresql://localhost:5432/exo_JDBC","postgres","fcbarcelone");
				
				//créer l'objet statement
				
				Statement statement = connexion.createStatement();
			
					Scanner scan = new Scanner(System.in);
					System.out.println("Entrez son nom");
					String nom = scan.nextLine();
					System.out.println("Entrez son prenom");
					String prenom = scan.nextLine();
					
					ResultSet requete = statement.executeQuery("SELECT\r\n"
							+ "    *\r\n"
							+ "FROM\r\n"
							+ "    emp\r\n"
							+ "WHERE\r\n"
							+ "        lower(nom) = lower('"+nom+"')\r\n"
							+ "    AND lower(prenom) = lower('"+prenom+"');");
					
					
					while(requete.next()) {
						
						System.out.println(requete.getInt("noemp")+"  "+requete.getString("nom") +"  "+requete.getString("prenom")+"  "+requete.getString("emploi")+"  "+requete.getInt("sup")+"  "+requete.getDate("embauche")+"  "+requete.getDouble("sal")+"  "+requete.getDouble("comm")+"  "+requete.getInt("noserv"));
						
					}
					
					modif_emp(nom, prenom);
				//fermer la connexion
				
				connexion.close();
				scan.close();
			} catch (Exception e) {
				System.out.println("entrée invalide , vérifier vos informations");
		
			}
		}
	
		private void modif_emp(String nom,String prenom) {
			
			try {
				//charger la classe de driver
				
				Class.forName("org.postgresql.Driver");
				
				//créer objet de connexion
				
				Connection connexion = DriverManager.getConnection( "jdbc:postgresql://localhost:5432/exo_JDBC","postgres","fcbarcelone");
				
				//créer l'objet statement
				
				Statement statement = connexion.createStatement();
			
					
				System.out.println("\r Que voulez vous modifier? \r"
						+ "0-Rien, retour au menu \r"
						+ "1-Nom\r"
						+ "2-Prenom\r"
						+ "3-Emploi\r"
						+ "4-numéro de sup\r"
						+ "5-date d'embauche\r"
						+ "6-Salaire\r"
						+ "7-Commission\r"
						+ "8-Numéro d'employé\r"
						+ "9-Numéro de service\r");
				Scanner scan = new Scanner(System.in);
				int choix = scan.nextInt();
				switch(choix){
				   
			       case 0: 
			           exo9();
			           break;
			   
			       case 1:
			    	   System.out.println("Saisissez le nouveau nom");
			    	   scan.nextLine();
			    	   String nvnom = scan.nextLine();
			    	   
			    	   String insert = ("update emp\r\n"
			    	   		+ "set nom = '"+nvnom.toUpperCase()+"'\r\n"
			    	   		+ "where lower(nom)=lower('"+nom+"') and lower(prenom)=lower('"+prenom+"');");
						
			    	   statement.executeUpdate(insert);
						
						System.out.println("le nom a bien été modifier");
			           break;
			   
			       case 2:
			    	   System.out.println("Saisissez le nouveau prenom");
			    	   scan.nextLine();
			    	   String nvprenom = scan.nextLine();
			    	   
			    	   String insert2 = ("update emp\r\n"
			    	   		+ "set prenom = '"+nvprenom.toUpperCase()+"'\r\n"
			    	   		+ "where lower(nom)=lower('"+nom+"') and lower(prenom)=lower('"+prenom+"');");
						
			    	   statement.executeUpdate(insert2);
						
						System.out.println("le prenom a bien été modifier");
			           break;
			           
			       case 3:
			    	   System.out.println("Saisissez le nouveau emploi");
			    	   scan.nextLine();
			    	   String nvemploi = scan.nextLine();
			    	   
			    	   String insert3 = ("update emp\r\n"
			    	   		+ "set emploi = '"+nvemploi.toUpperCase()+"'\r\n"
			    	   		+ "where lower(nom)=lower('"+nom+"') and lower(prenom)=lower('"+prenom+"');");
						
			    	   statement.executeUpdate(insert3);
						
						System.out.println("l'emploi a bien été modifier");
			           break;
			          
			       case 4:
			    	   System.out.println("Saisissez le nouveau numéro de supérieur");
			    	   scan.nextLine();
			    	   int sup = scan.nextInt();
			    	   
			    	   String insert4 = ("update emp\r\n"
			    	   		+ "set sup = '"+sup+"'\r\n"
			    	   		+ "where lower(nom)=lower('"+nom+"') and lower(prenom)=lower('"+prenom+"');");
						
			    	   statement.executeUpdate(insert4);
						
						System.out.println("le numéro de supérieur a bien été modifier");
			           break;
			           
			       case 5:
			    	   System.out.println("Saisissez la nouvelle date d'embauche (AAAA-MM-JJ)");
			    	   scan.nextLine();
			    	   String nvembauche = scan.nextLine();
			    	   
			    	   String insert5 = ("update emp\r\n"
			    	   		+ "set embauche = '"+nvembauche+"'\r\n"
			    	   		+ "where lower(nom)=lower('"+nom+"') and lower(prenom)=lower('"+prenom+"');");
						
			    	   statement.executeUpdate(insert5);
						
						System.out.println("la date d'embauche a bien été modifier");
			           break;
			           
			       case 6:
			    	   System.out.println("Saisissez le nouveau salaire");
			    	   scan.nextLine();
			    	   String nvsal = scan.nextLine();
			    	   
			    	   String insert6 = ("update emp\r\n"
			    	   		+ "set sal = '"+nvsal+"'\r\n"
			    	   		+ "where lower(nom)=lower('"+nom+"') and lower(prenom)=lower('"+prenom+"');");
						
			    	   statement.executeUpdate(insert6);
						
						System.out.println("le salaire a bien été modifier");
			           break;
			           
			       case 7:
			    	   System.out.println("Saisissez la nouvelle commission");
			    	   scan.nextLine();
			    	   String nvcomm = scan.nextLine();
			    	   
			    	   String insert7 = ("update emp\r\n"
			    	   		+ "set comm = '"+nvcomm+"'\r\n"
			    	   		+ "where lower(nom)=lower('"+nom+"') and lower(prenom)=lower('"+prenom+"');");
						
			    	   statement.executeUpdate(insert7);
						
						System.out.println("la commission a bien été modifier");
			           break;
			           
			       case 8:
			    	   System.out.println("Saisissez le nouveau numéro d'employé");
			    	   scan.nextLine();
			    	   int nvnoemp = scan.nextInt();
			    	   
			    	   String insert8 = ("update emp\r\n"
			    	   		+ "set noemp = '"+nvnoemp+"'\r\n"
			    	   		+ "where lower(nom)=lower('"+nom+"') and lower(prenom)=lower('"+prenom+"');");
						
			    	   statement.executeUpdate(insert8);
						
						System.out.println("le numéro d'employé a bien été modifier");
			           break;
			           
			       case 9:
			    	   System.out.println("Saisissez le nouveau numero de service");
			    	   scan.nextLine();
			    	   int nvnoserv = scan.nextInt();
			    	   
			    	   String insert9 = ("update emp\r\n"
			    	   		+ "set noserv = '"+nvnoserv+"'\r\n"
			    	   		+ "where lower(nom)=lower('"+nom+"') and lower(prenom)=lower('"+prenom+"');");
						
			    	   statement.executeUpdate(insert9);
						
						System.out.println("le numero de service a bien été modifier");
			           break;
			           
			       default:
			           System.out.println("Choix incorrect");
			           modif_emp(nom, prenom);
			           break;
				}
				
				
				
					ResultSet requete = statement.executeQuery("SELECT\r\n"
							+ "    *\r\n"
							+ "FROM\r\n"
							+ "    emp\r\n"
							+ "WHERE\r\n"
							+ "        lower(nom) = lower('"+nom+"')\r\n"
							+ "    AND lower(prenom) = lower('"+prenom+"');");
					
					
					while(requete.next()) {
						
						System.out.println("\r"+requete.getInt("noemp")+"  "+requete.getString("nom") +"  "+requete.getString("prenom")+"  "+requete.getString("emploi")+"  "+requete.getInt("sup")+"  "+requete.getDate("embauche")+"  "+requete.getDouble("sal")+"  "+requete.getDouble("comm")+"  "+requete.getInt("noserv"));
						
					}
					
					modif_emp(nom, prenom);
				//fermer la connexion
				
				connexion.close();
				scan.close();
			} catch (Exception e) {
			
			}
			
		}

	//Supprimer un employé à partir de son nom et prénom
		private void exo_supprimer_emp() {
			try {
				//charger la classe de driver
				
				Class.forName("org.postgresql.Driver");
				
				//créer objet de connexion
				
				Connection connexion = DriverManager.getConnection( "jdbc:postgresql://localhost:5432/exo_JDBC","postgres","fcbarcelone");
				
				//créer l'objet statement
				
				Statement statement = connexion.createStatement();
			
					Scanner scan = new Scanner(System.in);
					System.out.println("Entrez son nom");
					String nom = scan.nextLine();
					System.out.println("Entrez son prenom");
					String prenom = scan.nextLine();
					
					ResultSet requete = statement.executeQuery("SELECT\r\n"
							+ "    *\r\n"
							+ "FROM\r\n"
							+ "    emp\r\n"
							+ "WHERE\r\n"
							+ "        lower(nom) = lower('"+nom+"')\r\n"
							+ "    AND lower(prenom) = lower('"+prenom+"');");
					
					
					while(requete.next()) {
						
						System.out.println(requete.getInt("noemp")+"  "+requete.getString("nom") +"  "+requete.getString("prenom")+"  "+requete.getString("emploi")+"  "+requete.getInt("sup")+"  "+requete.getDate("embauche")+"  "+requete.getDouble("sal")+"  "+requete.getDouble("comm")+"  "+requete.getInt("noserv"));
						
					}
					
					System.out.println("Voulez vous vraiment supprimer cet employé\n"
							+ "1: NON\n"
							+ "2: OUI");
					int choix = scan.nextInt();
					switch (choix) {
					case 1:
						exo9();
						break;
					case 2:
						String insert = ("DELETE FROM emp\r\n"
								+ "WHERE\r\n"
								+ "        lower(nom) = lower('"+nom+"')\r\n"
								+ "    AND lower(prenom) = lower('"+prenom+"');");
							
				    	   statement.executeUpdate(insert);
				    	   System.out.println("l'employé a bien été supprimé");
						break;

					default:
						exo9();
						break;
					}
					
				//fermer la connexion
				
				connexion.close();
				scan.close();
			} catch (Exception e) {
				System.out.println("entrée invalide , vérifier vos informations");
				exo_supprimer_emp();
		
			}
		}
//fin
}

