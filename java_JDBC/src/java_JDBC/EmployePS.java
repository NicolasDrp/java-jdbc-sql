package java_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployePS {

	// exercice 3
	public void liste_emp_serv5() {
		try {
			// charger la classe de driver

			Class.forName("org.postgresql.Driver");

			// créer objet de connexion

			Connection connexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/exo_JDBC", "postgres",
					"fcbarcelone");

			// créer l'objet statement

			PreparedStatement statement = connexion.prepareStatement("SELECT * FROM emp where noserv=?");

			statement.setInt(1, 5);

			// executer la requete

			ResultSet requete = statement.executeQuery();

			while (requete.next()) {

				System.out.println(requete.getInt("noemp") + "  " + requete.getString("nom") + "  "
						+ requete.getString("prenom") + "  " + requete.getString("emploi") + "  "
						+ requete.getInt("sup") + "  " + requete.getDate("embauche") + "  " + requete.getDouble("sal")
						+ "  " + requete.getDouble("comm") + "  " + requete.getInt("noserv"));

			}

			// fermer la connexion

			connexion.close();

		} catch (Exception e) {

			System.out.println(e);
			System.out.println("ca marche pô");

		}
	}

	// exercice 4
	public void liste_emp_serv_inf() {

		try {
			// charger la classe de driver

			Class.forName("org.postgresql.Driver");

			// créer objet de connexion

			Connection connexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/exo_JDBC", "postgres",
					"fcbarcelone");

			// créer l'objet statement

			PreparedStatement statement = connexion
					.prepareStatement("select * from emp inner join serv on emp.noserv=serv.noserv where service=?");

			statement.setString(1, "INFORMATIQUE");

			ResultSet requete = statement.executeQuery();

			// executer la requete

			while (requete.next()) {

				System.out.println(requete.getInt("noemp") + "  " + requete.getString("nom") + "  "
						+ requete.getString("prenom") + "  " + requete.getString("emploi") + "  "
						+ requete.getInt("sup") + "  " + requete.getDate("embauche") + "  " + requete.getDouble("sal")
						+ "  " + requete.getDouble("comm") + "  " + requete.getInt("noserv"));

			}

			// fermer la connexion

			connexion.close();

		} catch (Exception e) {

			System.out.println(e);
			System.out.println("ca marche pô");

		}
	}

	// exercice 5
	public void nom_scan() {
		try {
			// charger la classe de driver

			Class.forName("org.postgresql.Driver");

			// créer objet de connexion

			Connection connexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/exo_JDBC", "postgres",
					"fcbarcelone");

			// créer l'objet statement

			Scanner scan = new Scanner(System.in);
			System.out.println("qui voulez-vous rechercher?");
			String nom = scan.nextLine();

			PreparedStatement statement = connexion.prepareStatement("select * from emp where lower(nom)=lower(?)");

			statement.setString(1, nom);

			ResultSet requete = statement.executeQuery();

			// executer la requete

			while (requete.next()) {

				System.out.println(requete.getInt("noemp") + "  " + requete.getString("nom") + "  "
						+ requete.getString("prenom") + "  " + requete.getString("emploi") + "  "
						+ requete.getInt("sup") + "  " + requete.getDate("embauche") + "  " + requete.getDouble("sal")
						+ "  " + requete.getDouble("comm") + "  " + requete.getInt("noserv"));

			}

			// fermer la connexion

			connexion.close();
			scan.close();
		} catch (Exception e) {

			System.out.println(e);
			System.out.println("ca marche pô");

		}
	}

	// exercice 6
	public void emp_embauche() {
		try {
			// charger la classe de driver

			Class.forName("org.postgresql.Driver");

			// créer objet de connexion

			Connection connexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/exo_JDBC", "postgres",
					"fcbarcelone");

			// créer l'objet statement

			Scanner scan = new Scanner(System.in);
			System.out.println("entrez une date");
			int date = scan.nextInt();

			PreparedStatement statement = connexion
					.prepareStatement("select * from emp where extract(years from embauche)=?");

			statement.setInt(1, date);

			ResultSet requete = statement.executeQuery();

			// executer la requete

			while (requete.next()) {

				System.out.println(requete.getInt("noemp") + "  " + requete.getString("nom") + "  "
						+ requete.getString("prenom") + "  " + requete.getString("emploi") + "  "
						+ requete.getInt("sup") + "  " + requete.getDate("embauche") + "  " + requete.getDouble("sal")
						+ "  " + requete.getDouble("comm") + "  " + requete.getInt("noserv"));

			}

			// fermer la connexion

			connexion.close();
			scan.close();
		} catch (Exception e) {

			System.out.println(e);
			System.out.println("ca marche pô");

		}
	}

	// exercice 7
	public void liste_emp_scan() {
		try {
			// charger la classe de driver

			Class.forName("org.postgresql.Driver");

			// créer objet de connexion

			Connection connexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/exo_JDBC", "postgres",
					"fcbarcelone");

			// créer l'objet statement

			Scanner scan = new Scanner(System.in);
			System.out.println("qui recherchez vous?");
			String nom = scan.nextLine();
			String chaine = "%" + nom + "%";

			PreparedStatement statement = connexion
					.prepareStatement("select * from emp where lower(nom) like lower(?);");

			statement.setString(1, chaine);

			ResultSet requete = statement.executeQuery();

			// executer la requete

			while (requete.next()) {

				System.out.println(requete.getInt("noemp") + "  " + requete.getString("nom") + "  "
						+ requete.getString("prenom") + "  " + requete.getString("emploi") + "  "
						+ requete.getInt("sup") + "  " + requete.getDate("embauche") + "  " + requete.getDouble("sal")
						+ "  " + requete.getDouble("comm") + "  " + requete.getInt("noserv"));

			}

			// fermer la connexion

			connexion.close();
			scan.close();
		} catch (Exception e) {

			System.out.println(e);
			System.out.println("ca marche pô");

		}
	}

	// exercice 8
	public void liste_emp_sal() {
		try {
			// charger la classe de driver

			Class.forName("org.postgresql.Driver");

			// créer objet de connexion

			Connection connexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/exo_JDBC", "postgres",
					"fcbarcelone");

			// créer l'objet statement

			Scanner scan = new Scanner(System.in);
			System.out.println("combien gagnez vous?");
			double sal = scan.nextDouble();

			PreparedStatement statement = connexion.prepareStatement("select * from emp where sal > ?");

			statement.setDouble(1, sal);

			ResultSet requete = statement.executeQuery();

			// executer la requete
			System.out.println("voici la liste des gens plus riche que vous:");
			while (requete.next()) {

				System.out.println(requete.getString("nom") + "  " + requete.getString("emploi") + "  "
						+ requete.getDouble("sal") + "  " + requete.getInt("noserv"));

			}

			// fermer la connexion

			connexion.close();
			scan.close();
		} catch (Exception e) {

			System.out.println(e);
			System.out.println("ca marche pô");

		}
	}

	// exercice 9
	public void exo9() {
		Scanner scan = new Scanner(System.in);
		System.out.println("\rQue voulez vous? \r" + "1-Afficher la liste des employés\r" + "2-Ajouter un employé\r"
				+ "3-Afficher le détail d'un employé\r" + "4-Modifier un employé\r" + "5-Supprimer un employé\r");
		try {
			int choix = scan.nextInt();
			switch (choix) {

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
				exo9_modif_emp();
				;
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

	// liste de tout les employés
	public void liste_emp() {
		try {
			// charger la classe de driver

			Class.forName("org.postgresql.Driver");

			// créer objet de connexion

			Connection connexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/exo_JDBC", "postgres",
					"fcbarcelone");

			// créer l'objet statement

			Statement statement = connexion.createStatement();

			ResultSet requete = statement.executeQuery("SELECT * FROM emp");

			// executer la requete

			while (requete.next())

				System.out.println(requete.getInt("noemp") + "  " + requete.getString("nom") + "  "
						+ requete.getString("prenom") + "  " + requete.getString("emploi") + "  "
						+ requete.getInt("sup") + "  " + requete.getDate("embauche") + "  " + requete.getDouble("sal")
						+ "  " + requete.getDouble("comm") + "  " + requete.getInt("noserv"));

			// fermer la connexion

			connexion.close();

		} catch (Exception e) {

			System.out.println(e);
			System.out.println("ca marche pas");

		}
	}

	// Ajouter un employé
	private void exo9_ajout_emp() {
		try {
			// charger la classe de driver

			Class.forName("org.postgresql.Driver");

			// créer objet de connexion

			Connection connexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/exo_JDBC", "postgres",
					"fcbarcelone");

			// créer l'objet statement

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
			System.out.println("date d'embauche , entrez l'année:");
			int annee = scan.nextInt();
			System.out.println("date d'embauche , entrez le mois:");
			int mois = scan.nextInt();
			System.out.println("date d'embauche , entrez le jour:");
			int jour = scan.nextInt();
			LocalDate date = LocalDate.of(annee, mois, jour);

			System.out.println("salaire:");
			double sal = scan.nextDouble();

			System.out.println("commisison touché:");
			double comm = scan.nextDouble();

			System.out.println("numéro de service:");
			int noserv = scan.nextInt();

			PreparedStatement statement = connexion.prepareStatement("INSERT INTO emp (noemp,nom,prenom,emploi,sup,embauche,sal,comm,noserv) VALUES (?,?,?,?,?,?,?,?,?);");
			
			statement.setInt(1, noemp);
			statement.setString(2, nom.toUpperCase());
			statement.setString(3, prenom.toUpperCase());
			statement.setString(4, emploi.toUpperCase());
			statement.setInt(5, sup);
			statement.setDate(6, java.sql.Date.valueOf(date));
			statement.setDouble(7, sal);
			statement.setDouble(8, comm);
			statement.setInt(9, noserv);
			
			statement.executeUpdate();

			System.out.println("l'employer a bien été ajouter");
			// fermer la connexion

			connexion.close();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("entrée invalide , vérifier vos informations");
			exo9_ajout_emp();

		}

	}

	// Modifier un employé à partir de son nom et prénom
	private void exo9_modif_emp() {
		try {
			// charger la classe de driver

			Class.forName("org.postgresql.Driver");

			// créer objet de connexion

			Connection connexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/exo_JDBC", "postgres",
					"fcbarcelone");

			// créer l'objet statement


			Scanner scan = new Scanner(System.in);
			System.out.println("Entrez son nom");
			String nom = scan.nextLine();
			System.out.println("Entrez son prenom");
			String prenom = scan.nextLine();
			
			PreparedStatement statement = connexion.prepareStatement("SELECT * FROM emp WHERE lower(nom) = lower(?)AND lower(prenom) = lower(?);");

			statement.setString(1, nom);
			statement.setString(2, prenom);
			
			ResultSet requete = statement.executeQuery();

			while (requete.next()) {

				System.out.println(requete.getInt("noemp") + "  " + requete.getString("nom") + "  "
						+ requete.getString("prenom") + "  " + requete.getString("emploi") + "  "
						+ requete.getInt("sup") + "  " + requete.getDate("embauche") + "  " + requete.getDouble("sal")
						+ "  " + requete.getDouble("comm") + "  " + requete.getInt("noserv"));

			}

			modif_emp(nom, prenom);
			// fermer la connexion

			connexion.close();
			scan.close();
		} catch (Exception e) {
			System.out.println("entrée invalide , vérifier vos informations");

		}
	}

	private void modif_emp(String nom, String prenom) {

		try {
			// charger la classe de driver

			Class.forName("org.postgresql.Driver");

			// créer objet de connexion

			Connection connexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/exo_JDBC", "postgres",
					"fcbarcelone");

			// créer l'objet statement

			

			System.out.println("\r Que voulez vous modifier? \r" + "0-Rien, retour au menu \r" + "1-Nom\r"
					+ "2-Prenom\r" + "3-Emploi\r" + "4-numéro de sup\r" + "5-date d'embauche\r" + "6-Salaire\r"
					+ "7-Commission\r" + "8-Numéro d'employé\r" + "9-Numéro de service\r");
			Scanner scan = new Scanner(System.in);
			int choix = scan.nextInt();
			switch (choix) {

			case 0:
				exo9();
				break;

			case 1:
				System.out.println("Saisissez le nouveau nom");
				scan.nextLine();
				String nvnom = scan.nextLine();

				PreparedStatement statement1 = connexion.prepareStatement("update emp set nom = ? where lower(nom)=lower(?) and lower(prenom)=lower(?);");
				
				statement1.setString(1, nvnom);
				statement1.setString(2, nom);
				statement1.setString(3, prenom);
				
				
				statement1.executeUpdate();

				System.out.println("le nom a bien été modifier");
				break;

			case 2:
				System.out.println("Saisissez le nouveau prenom");
				scan.nextLine();
				String nvprenom = scan.nextLine();

				PreparedStatement statement2 = connexion.prepareStatement("update emp set prenom = ? where lower(nom)=lower(?) and lower(prenom)=lower(?);");
				
				statement2.setString(1, nvprenom);
				statement2.setString(2, nom);
				statement2.setString(3, prenom);
				
				
				statement2.executeUpdate();

				System.out.println("le prenom a bien été modifier");
				break;

			case 3:
				System.out.println("Saisissez le nouveau emploi");
				scan.nextLine();
				String nvemploi = scan.nextLine();

				PreparedStatement statement3 = connexion.prepareStatement("update emp set emploi = ? where lower(nom)=lower(?) and lower(prenom)=lower(?);");
				
				statement3.setString(1, nvemploi);
				statement3.setString(2, nom);
				statement3.setString(3, prenom);
				
				
				statement3.executeUpdate();

				System.out.println("l'emploi a bien été modifier");
				break;

			case 4:
				System.out.println("Saisissez le nouveau numéro de supérieur");
				scan.nextLine();
				int sup = scan.nextInt();

				PreparedStatement statement4 = connexion.prepareStatement("update emp set sup = ? where lower(nom)=lower(?) and lower(prenom)=lower(?);");

				statement4.setInt(1, sup);
				statement4.setString(2, nom);
				statement4.setString(3, prenom);
				
				statement4.executeUpdate();

				System.out.println("le numéro de supérieur a bien été modifier");
				break;

			case 5:
				System.out.println("Saisissez la nouvelle date d'embauche");
				scan.nextLine();
				System.out.println("Entrez l'année:");
				int annee = scan.nextInt();
				System.out.println("Entrez le mois:");
				int mois = scan.nextInt();
				System.out.println("Entrez le jour:");
				int jour = scan.nextInt();
				LocalDate nvembauche = LocalDate.of(annee, mois, jour);
				
				PreparedStatement statement5 = connexion.prepareStatement("update emp set embauche = ? where lower(nom)=lower(?) and lower(prenom)=lower(?);");
				
				statement5.setDate(1, java.sql.Date.valueOf(nvembauche));
				statement5.setString(2, nom);
				statement5.setString(3, prenom);
				
				statement5.executeUpdate();

				System.out.println("la date d'embauche a bien été modifier");
				break;

			case 6:
				System.out.println("Saisissez le nouveau salaire");
				scan.nextLine();
				double nvsal = scan.nextDouble();

				PreparedStatement statement6 = connexion.prepareStatement("update emp set sal = ? where lower(nom)=lower(?) and lower(prenom)=lower(?);");

				statement6.setDouble(1, nvsal);
				statement6.setString(2, nom);
				statement6.setString(3, prenom);
				
				statement6.executeUpdate();

				System.out.println("le salaire a bien été modifier");
				break;

			case 7:
				System.out.println("Saisissez la nouvelle commission");
				scan.nextLine();
				String nvcomm = scan.nextLine();

				PreparedStatement statement7 = connexion.prepareStatement("update emp set comm = ? where lower(nom)=lower(?) and lower(prenom)=lower(?);");
				
				statement7.setString(1, nvcomm);
				statement7.setString(2, nom);
				statement7.setString(3, prenom);
				
				statement7.executeUpdate();

				System.out.println("la commission a bien été modifier");
				break;

			case 8:
				System.out.println("Saisissez le nouveau numéro d'employé");
				scan.nextLine();
				int nvnoemp = scan.nextInt();

				PreparedStatement statement8 = connexion.prepareStatement("update emp set noemp = ? where lower(nom)=lower(?) and lower(prenom)=lower(?);");

				statement8.setInt(1, nvnoemp);
				statement8.setString(2, nom);
				statement8.setString(3, prenom);
				
				statement8.executeUpdate();

				System.out.println("le numéro d'employé a bien été modifier");
				break;

			case 9:
				System.out.println("Saisissez le nouveau numero de service");
				scan.nextLine();
				int nvnoserv = scan.nextInt();

				PreparedStatement statement9 = connexion.prepareStatement("update emp set noserv = ? where lower(nom)=lower(?) and lower(prenom)=lower(?);");

				statement9.setInt(1, nvnoserv);
				statement9.setString(2, nom);
				statement9.setString(3, prenom);
				
				statement9.executeUpdate();

				System.out.println("le numero de service a bien été modifier");
				break;

			default:
				System.out.println("Choix incorrect");
				modif_emp(nom, prenom);
				break;
			}

			
			PreparedStatement statement = connexion.prepareStatement("SELECT * FROM emp WHERE lower(nom) = lower(?) AND lower(prenom) = lower(?);");

			statement.setString(1, nom);
			statement.setString(2, prenom);
			
			ResultSet requete = statement.executeQuery();
			
			while (requete.next()) {

				System.out.println("\r" + requete.getInt("noemp") + "  " + requete.getString("nom") + "  "
						+ requete.getString("prenom") + "  " + requete.getString("emploi") + "  "
						+ requete.getInt("sup") + "  " + requete.getDate("embauche") + "  " + requete.getDouble("sal")
						+ "  " + requete.getDouble("comm") + "  " + requete.getInt("noserv"));

			}

			modif_emp(nom, prenom);
			// fermer la connexion

			connexion.close();
			scan.close();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("ça marche pas");
		}

	}

	// Supprimer un employé à partir de son nom et prénom
	private void exo_supprimer_emp() {
		try {
			// charger la classe de driver

			Class.forName("org.postgresql.Driver");

			// créer objet de connexion

			Connection connexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/exo_JDBC", "postgres",
					"fcbarcelone");

			// créer l'objet statement

			Scanner scan = new Scanner(System.in);
			System.out.println("Entrez son nom");
			String nom = scan.nextLine();
			System.out.println("Entrez son prenom");
			String prenom = scan.nextLine();

			PreparedStatement statement = connexion.prepareStatement("SELECT * FROM emp WHERE lower(nom) = lower(?) AND lower(prenom) = lower(?);");
			
			statement.setString(1, nom);
			statement.setString(2, prenom);
			
			ResultSet requete = statement.executeQuery();

			while (requete.next()) {

				System.out.println("\r"+requete.getInt("noemp") + "  " + requete.getString("nom") + "  "
						+ requete.getString("prenom") + "  " + requete.getString("emploi") + "  "
						+ requete.getInt("sup") + "  " + requete.getDate("embauche") + "  " + requete.getDouble("sal")
						+ "  " + requete.getDouble("comm") + "  " + requete.getInt("noserv"));

			}

			System.out.println("\r Voulez vous vraiment supprimer cet employé\n" + "1: NON\n" + "2: OUI");
			int choix = scan.nextInt();
			switch (choix) {
			case 1:
				exo9();
				break;
			case 2:	
				PreparedStatement statement2 = connexion.prepareStatement("DELETE FROM emp WHERE lower(nom) = lower(?) AND lower(prenom) = lower(?);");
				
				statement2.setString(1, nom);
				statement2.setString(2, prenom);

				statement2.executeUpdate();
				
				System.out.println("l'employé a bien été supprimé");
				break;

			default:
				exo9();
				break;
			}

			// fermer la connexion

			connexion.close();
			scan.close();
		} catch (Exception e) {
			System.out.println("entrée invalide , vérifier vos informations");
			System.out.println(e);
			exo_supprimer_emp();

		}
	}

	// FIN
}
