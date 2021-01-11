package jpa;

import kanban.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

public class JpaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		EntityManager manager = EntityManagerHelper.getEntityManager();
		EntityTransaction tx = manager.getTransaction();

		//creation de tag
		ArrayList tags = new ArrayList();
		Tag tag=new  Tag();
		tag.setLibelle("les donnés");
		tags.add(tag);

		//creation de tag

		Tag tag1=new  Tag();
		tag1.setLibelle("bon produit");
		tags.add(tag1);

		//creation de section
		ArrayList sections = new ArrayList();
		Section  attente = Section.Attente;
		 sections.add(attente);




		Date aujourdhui = new Date();

		//creation de fiche
		Fiche fiche =new Fiche();
		fiche.setLibelle("preparation 2");
		fiche.setLieu("rennes");

		fiche.setTag(tags);
		fiche.setUrl("le lien ");
		fiche.setNote("bonne fiche");
		fiche.setTemps(40L);
		fiche.setDate_buttoir((aujourdhui));
        // creation de fiche
		Fiche fiche1 =new Fiche();
		fiche1.setLibelle("preparation 3");
		fiche1.setLieu("rennes");
		fiche.setTag(tags);
		fiche1.setUrl("le lien de url");
		fiche1.setNote("fiche");
		fiche1.setTemps(40L);
		fiche1.setDate_buttoir((aujourdhui));
		fiche1.setSections(sections);


		//creation d'un utilisateur

		Utilisateur utilisateur=new Utilisateur();
		ArrayList fiches = new ArrayList();
		fiches.add(fiche);
		fiches.add(fiche1);
		 utilisateur.setFiches(fiches);

		 //creation d'un tableau KanBan
		TableauKanban tableauKanban =new TableauKanban();

		tableauKanban.setFiches(fiches);
		tableauKanban.setSections(sections);


		tx.begin();


		try {

          manager.persist(tableauKanban);
          manager.persist(tag);
          manager.persist(tag1);
          manager.persist(utilisateur);
          manager.persist(fiche);
          manager.persist(fiche1);

		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();


		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		//		factory.close();
	}


}
