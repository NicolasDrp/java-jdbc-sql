# exercice java sql
Partir de la base de données sur l’entreprise (table emp et serv).
Toutes les requêtes demandées doivent être traitées en Java via JDBC.
Voici les tables et les données présentes dans la base

CREATE TABLE emp(
noemp NUMERIC NOT NULL,
nom varchar(150),
prenom varchar(150),
emploi varchar(50),
sup NUMERIC,
embauche date,
sal NUMERIC(9,2),
comm numeric(9,2),
noserv NUMERIC(2)
) ;

## altération de la table emp et ajout d'une contrainte de clé primaire

ALTER TABLE emp ADD CONSTRAINT pk_emp PRIMARY KEY (noemp) ;
create table serv
(
noserv numeric primary key,
service varchar(20),
ville varchar(20)
);
insert into emp values
(1000,'LEROY','PAUL','PRESIDENT',null,to_date('25/10/87','dd/MM/yy'),55005.
5,null,1);
insert into emp values
(1100,'DELPIERRE','DOROTHEE','SECRETAIRE',1000,to_date('25/10/87','dd/MM/yy
'),12351.24,null,1);
insert into emp values
(1101,'DUMONT','LOUIS','VENDEUR',1300,to_date('25/10/87','dd/MM/yy'),9047.9
,0,1);
insert into emp values
(1102,'MINET','MARC','VENDEUR',1300,to_date('25/10/87','dd/MM/yy'),8085.81,
17230,1);
insert into emp values
(1104,'NYS','ETIENNE','TECHNICIEN',1200,to_date('25/10/87','dd/MM/yy'),1234
2.23,null,1);
insert into emp values
(1105,'DENIMAL','JEROME','COMPTABLE',1600,to_date('25/10/87','dd/MM/yy'),15
746.57,null,1);
insert into emp values
(1200,'LEMAIRE','GUY','DIRECTEUR',1000,to_date('11/03/87','dd/MM/yy'),36303
.63,null,2);
insert into emp values
(1201,'MARTIN','JEAN','TECHNICIEN',1200,to_date('25/06/87','dd/MM/yy'),1123
5.12,null,2);
insert into emp values
(1202,'DUPONT','JACQUES','TECHNICIEN',1200,to_date('30/10/88','dd/MM/yy'),1
0313.03,null,2);
insert into emp values
(1300,'LENOIR','GERARD','DIRECTEUR',1000,to_date('02/04/87','dd/MM/yy'),313
53.14,13071,3);
insert into emp values
(1301,'GERARD','ROBERT','VENDEUR',1300,to_date('16/04/99','dd/MM/yy'),7694.
77,12430,3);
insert into emp values
(1303,'MASURE','EMILE','TECHNICIEN',1200,to_date('17/06/88','dd/MM/yy'),104
51.05,null,3);
insert into emp values
(1500,'DUPONT','JEAN','DIRECTEUR',1000,to_date('23/10/87','dd/MM/yy'),28434
.84,null,5);
insert into emp values
(1501,'DUPIRE','PIERRE','ANALYSTE',1500,to_date('24/10/84','dd/MM/yy'),2310
2.31,null,5);
insert into emp values
(1502,'DURAND','BERNARD','PROGRAMMEUR',1500,to_date('30/07/87','dd/MM/yy'),
13201.32,null,5);
insert into emp values
(1503,'DELNATTE','LUC','PUPITREUR',1500,to_date('15/01/99','dd/MM/yy'),8801
.01,null,5);
insert into emp values
(1600,'LAVARE','PAUL','DIRECTEUR',1000,to_date('13/12/91','dd/MM/yy'),31238
.12,null,6);
insert into emp values
(1601,'CARON','ALAIN','COMPTABLE',1600,to_date('16/09/85','dd/MM/yy'),33003
.3,null,6);
insert into emp values
(1602,'DUBOIS','JULES','VENDEUR',1300,to_date('20/12/90','dd/MM/yy'),9520.9
5,35535,6);
insert into emp values
(1603,'MOREL','ROBERT','COMPTABLE',1600,to_date('18/07/85','dd/MM/yy'),3300
3.3,null,6);
insert into emp values
(1604,'HAVET','ALAIN','VENDEUR',1300,to_date('01/01/91','dd/MM/yy'),9388.94
,33415,6);
insert into emp values
(1605,'RICHARD','JULES','COMPTABLE',1600,to_date('22/10/85','dd/MM/yy'),335
03.35,null,5);
insert into emp values
(1615,'DUPREZ','JEAN','BALAYEUR',1000,to_date('22/10/98','dd/MM/yy'),6000.6
,null,5);
insert into serv values (1,'DIRECTION','PARIS');
insert into serv values (2,'LOGISTIQUE','SECLIN');
insert into serv values (3,'VENTES','ROUBAIX');
insert into serv values (4,'FORMATION','VILLENEUVE D''ASCQ');
insert into serv values (5,'INFORMATIQUE','LILLE');
insert into serv values (6,'COMPTABILITE','LILLE');
insert into serv values (7,'TECHNIQUE','ROUBAIX');
REQUETE AVEC DES STATEMENTS

### EXERCICE 1

Connecter la base de données créée en Java

### EXERCICE 2

Afficher à l’écran la liste des employés

### EXERCICE 3

Afficher à l’écran la liste des employés du service 5

### EXERCICE 4

Afficher à l’écran la liste des employés du service INFORMATIQUE

### EXERCICE 5

Afficher à l’écran la liste des employés dont le nom est saisi par l’utilisateur

### EXERCICE 6

Afficher à l’écran la liste des employés dont la date d’embauche est comprise dans l’année saisie par

l’utilisateur

### EXERCICE 7

Afficher à l’écran la liste des employés dont le nom contient une chaîne de caractères saisie par l’utilisateur

### EXERCICE 8

Afficher à l’écran les noms, emploi, salaire, numéro de service de tous les employés du service saisi par

l’utilisateur et qui gagnent plus d’un salaire saisi par l’utilisateur

### EXERCICE 9

Créer un menu (Console Java) permettant de :
- Afficher la liste des employés
- Afficher le détail d’un employé
- Ajouter un employé
- Modifier un employé à partir de son nom et prénom
- Supprimer un employé à partir de son nom et prénom

Créer les traitements et les requêtes correspondantes pour que les données soient modifiées en base de
données selon les choix de l’utilisateur.

## REQUETES AVEC DES PREPARED STATEMENT

Reprendre les requêtes des exercices 3 à 9 en utilisant des Prepared Statement quand c’est possible
