package jaxrs;

import jaxrs.Dao.FicheDao;
import jaxrs.EntityManagerHelper;
import kanban.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class JpaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		EntityManager manager = EntityManagerHelper.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		FicheDao ficheDao = new FicheDao();

		// creation de tag



		Tag tag1=new  Tag();
		tag1.setLibelle("front-end");

		Tag tag2=new  Tag();
		tag2.setLibelle("back-end");

		Tag tag3=new  Tag();
		tag3.setLibelle("reunion");

		Tag tag4=new  Tag();
		tag4.setLibelle("explication");

		Tag tag5=new  Tag();
		tag5.setLibelle("exercices");

		Tag tag6=new  Tag();
		tag6.setLibelle("programmation");

		Tag tag7=new  Tag();
		tag7.setLibelle("execution");

		Tag tag8=new  Tag();
		tag8.setLibelle("deboggage");

		Tag tag9=new  Tag();
		tag9.setLibelle("passer à table");

		Tag tag10=new  Tag();
		tag10.setLibelle("repos");

		//creation de fiche
		Fiche fiche1 =new Fiche();
		fiche1.setLibelle("fiche1");
		fiche1.addTag(tag4);
		fiche1.addTag(tag1);
		fiche1.addTag(tag2);
		fiche1.addTag(tag3);
		fiche1.setLieu("rennes");
		fiche1.setNote("bien");
		fiche1.setTemps(50L);
		fiche1.setUrl("https://www.jmdoudoux.fr/java/dej/chap-utilisation_dates.htm");
		Date aujourdhui = new Date();
		SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yy");
		fiche1.setDate_buttoir(aujourdhui);

		Utilisateur utilisateur11=new Utilisateur();
		utilisateur11.setNom("MAURICE");
		utilisateur11.setPrenom("AKA");

		utilisateur11.addFiches(fiche1);
		Fiche fiche2 =new Fiche();
		fiche2.setLibelle("fiche2");
		fiche2.addTag(tag4);
		fiche2.addTag(tag1);
		fiche2.addTag(tag3);
		fiche2.setLieu("paris");
		fiche2.setTemps(40L);
		fiche2.setUrl("https://www.youtube.com/results?search_query=exemple+de+tableau+kanban");
		fiche2.setNote("moyen");

		fiche2.setDate_buttoir(aujourdhui);

		Fiche fiche3=new Fiche();
		fiche3.setLibelle("fiche3");
		fiche3.addTag(tag6);
		fiche3.addTag(tag10);
		fiche3.addTag(tag1);
		fiche3.setLieu("paris");
		fiche3.setTemps(40L);
		fiche3.setUrl("https://www.youtube.com/results?search_query=exemple+de+tableau+kanban");
		fiche3.setNote("mediocre");
		fiche3.setDate_buttoir(aujourdhui);
		fiche3.setUtilisateur(utilisateur11);


		Fiche fiche4=new Fiche();
		fiche4.setLibelle("fiche4");
		fiche4.addTag(tag9);
		fiche4.addTag(tag8);
		fiche4.addTag(tag10);
		fiche4.setLieu("lyon");
		fiche4.setTemps(60L);
		fiche4.setUrl("https://drive.google.com/file/d/1C_OOCPh-tCFvKz9QQDbmrt7IULA5vYZ6/preview");
		fiche4.setNote("bien");
		fiche2.setDate_buttoir(aujourdhui);



		//creation de section
		Section attente = new Section();
		attente.setLibelle_section("attente");
		attente.addFiches(fiche1);
		attente.addFiches(fiche2);
		attente.addFiches(fiche3);

		Section enCours= new Section();
		enCours.setLibelle_section("en cours");
		enCours.addFiches(fiche2);
		enCours.addFiches(fiche1);
		enCours.addFiches(fiche4);

		Section realise= new Section();
		realise.setLibelle_section("terminée");
		realise.addFiches(fiche1);
		realise.addFiches(fiche2);
		realise.addFiches(fiche4);



		//creation d'un utilisateur

		Utilisateur utilisateur1=new Utilisateur();
		 utilisateur1.setNom("bamba");
		 utilisateur1.setPrenom("Moussa");
		 utilisateur1.addFiches(fiche1);
		 utilisateur1.addFiches(fiche3);

		Utilisateur utilisateur2=new Utilisateur();
		utilisateur2.setNom("Kone");
		utilisateur2.setPrenom("Moussa");
		utilisateur2.addFiches(fiche2);
		utilisateur2.addFiches(fiche1);

		Utilisateur utilisateur3=new Utilisateur();
		utilisateur3.setNom("bamba");
		utilisateur3.setPrenom("Ibrahim");
		utilisateur3.addFiches(fiche1);
		utilisateur3.addFiches(fiche4);

		Utilisateur utilisateur4=new Utilisateur();
		utilisateur4.setNom("bamba");
		utilisateur4.setPrenom("Youssef");
		utilisateur4.addFiches(fiche3);
		utilisateur4.addFiches(fiche1);

		Utilisateur utilisateur5=new Utilisateur();
		utilisateur5.setNom("bamba");
		utilisateur5.setPrenom("Affou");
		utilisateur5.addFiches(fiche2);
		utilisateur5.addFiches(fiche3);

		Utilisateur utilisateur6=new Utilisateur();
		utilisateur6.setNom("bamba");
		utilisateur6.setPrenom("Aicha");
		utilisateur6.addFiches(fiche4);
		utilisateur6.addFiches(fiche2);

		Utilisateur utilisateur7=new Utilisateur();
		utilisateur7.setNom("bamba");
		utilisateur7.setPrenom("Ali");
		utilisateur7.addFiches(fiche3);

		Utilisateur utilisateur8=new Utilisateur();
		utilisateur8.setNom("gbe");
		utilisateur8.setPrenom("bonaventure");
		utilisateur8.addFiches(fiche2);

		Utilisateur utilisateur9=new Utilisateur();
		utilisateur9.setNom("sehi");
		utilisateur9.setPrenom("kelasemae");
		utilisateur9.addFiches(fiche4);
		utilisateur9.addFiches(fiche1);

		Utilisateur utilisateur10=new Utilisateur();
		utilisateur10.setNom("soboro");
		utilisateur10.setPrenom("jean marie");
		utilisateur10.addFiches(fiche3);
		utilisateur10.addFiches(fiche4);

		/*Utilisateur utilisateur11=new Utilisateur();
		utilisateur11.setNom("MAURICE");
		utilisateur11.setPrenom("AKA");
		utilisateur11.addFiches(fiche3);
		utilisateur11.addFiches(fiche1);*/



		//creation d'un tableau KanBan
		TableauKanban tableauKanban1 =new TableauKanban();
		tableauKanban1.setLibelle_tableau("tableau1");
		tableauKanban1.addFiches(fiche1);
		tableauKanban1.addFiches(fiche2);
		TableauKanban tableauKanban2 =new TableauKanban();
		tableauKanban2.setLibelle_tableau("tableau2");
		tableauKanban2.addFiches(fiche4);
		TableauKanban tableauKanban3 =new TableauKanban();
		tableauKanban3.setLibelle_tableau("tableau3");
		tableauKanban3.addFiches(fiche4);
		TableauKanban tableauKanban4 =new TableauKanban();
		tableauKanban4.setLibelle_tableau("tableau4");
		tableauKanban4.addFiches(fiche2);
		tableauKanban4.addFiches(fiche3);
		TableauKanban tableauKanban5 =new TableauKanban();
		tableauKanban5.setLibelle_tableau("tableau5");
		tableauKanban5.addFiches(fiche3);
		tableauKanban5.addFiches(fiche1);
		TableauKanban tableauKanban6 =new TableauKanban();
		tableauKanban6.setLibelle_tableau("tableau6");
		tableauKanban6.addFiches(fiche2);
		tableauKanban6.addFiches(fiche4);
		TableauKanban tableauKanban7 =new TableauKanban();
		tableauKanban7.setLibelle_tableau("tableau7");

		tableauKanban7.addFiches(fiche3);
		TableauKanban tableauKanban8 =new TableauKanban();
		tableauKanban8.setLibelle_tableau("tableau8");
		tableauKanban8.addFiches(fiche2);
		TableauKanban tableauKanban9 =new TableauKanban();
		tableauKanban9.setLibelle_tableau("tableau9");
		tableauKanban9.addFiches(fiche3);
		tableauKanban9.addFiches(fiche4);
		TableauKanban tableauKanban10 =new TableauKanban();
		tableauKanban10.setLibelle_tableau("tableau10");
		tableauKanban10.addFiches(fiche4);



		tx.begin();


		try {




			manager.persist(tag1);
			manager.persist(tag2);
			manager.persist(tag3);
			manager.persist(tag4);
			manager.persist(tag5);
			manager.persist(tag6);
			manager.persist(tag7);
			manager.persist(tag8);
			manager.persist(tag9);
			manager.persist(tag10);

			manager.persist(utilisateur1);
			manager.persist(utilisateur2);
			manager.persist(utilisateur3);
			manager.persist(utilisateur4);
			manager.persist(utilisateur5);
			manager.persist(utilisateur6);
			manager.persist(utilisateur7);
			manager.persist(utilisateur8);
			manager.persist(utilisateur9);
			manager.persist(utilisateur10);
			manager.persist(utilisateur11);
            manager.persist(attente);
            manager.persist(realise);
            manager.persist(enCours);
			manager.persist(tableauKanban1);
			manager.persist(tableauKanban2);
			manager.persist(tableauKanban3);
			manager.persist(tableauKanban4);
			manager.persist(tableauKanban5);
			manager.persist(tableauKanban6);
			manager.persist(tableauKanban7);
			manager.persist(tableauKanban8);
			manager.persist(tableauKanban9);
			manager.persist(tableauKanban10);




    manager.persist(attente);
    manager.persist(enCours);
    manager.persist(realise);
   manager.persist(fiche1);
    manager.persist(fiche2);
    manager.persist(fiche3);
    manager.persist(fiche4);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();


		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		//		factory.close();
	}


}