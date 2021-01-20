package jpa;

import jpa.Dao.FicheDao;
import jpa.Dao.TablauKanbanDao;
import jpa.Dao.TagDao;
import jpa.Dao.UtilisateuDao;
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
import java.util.List;

public class JpaTest {
	private  EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}




	/**
	 * @param args
	 */
	public static void main(String[] args) {

		EntityManager manager = EntityManagerHelper.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		JpaTest test = new JpaTest(manager);


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
		Section  encours= Section.EnCours;
		Section  realise = Section.Realise;
		 sections.add(realise);
		 sections.add(attente);
		 sections.add(encours);




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
		    FicheDao ficheDao=new FicheDao();
		    ficheDao.saveFiche(fiche);
            ficheDao.saveFiche(fiche1);

            TablauKanbanDao tableau=new  TablauKanbanDao();
            tableau.saveTableau(tableauKanban);

            TagDao tagDao=new TagDao();
            tagDao.saveTag(tag);
            tagDao.saveTag(tag1);

            UtilisateuDao utilisateuDao= new UtilisateuDao();
            utilisateuDao.saveUtilisater(utilisateur);
         /*
          manager.persist(tableauKanban);
          manager.persist(tag);
          manager.persist(tag1);
          manager.persist(utilisateur);
          manager.persist(fiche);
          manager.persist(fiche1);*/

		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
        // la liste des fiches
		test.listFiche();
		//la liste des utilisateurs;
		test.listUtilisateurs();
		//la liste des tableaux
		test.listTableaux();
		//la liste des tags
		test.listTags();
		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		//		factory.close();


	}

	//la liste des fichiers

	    private   void listFiche()
	{
        FicheDao ficheDao = new FicheDao();
        List<Fiche> FicheList = ficheDao.listFiche();
		System.out.println("numbre de fiche:" + FicheList.size());
		for (Fiche fichier : FicheList) {
			System.out.println("le libelle: " + fichier.getLibelle());
		}
	}

	//la liste des utilisateurs
	private   void listUtilisateurs()
	{
        UtilisateuDao utilisateurDao=new UtilisateuDao();
		List <Utilisateur> UtilisateurList =utilisateurDao.listUtilisateurs();
		System.out.println("numbre de utilisateur:" + UtilisateurList.size());
		for (Utilisateur utilisateur : UtilisateurList) {
			System.out.println("le numero de  l'utilisateur : " + utilisateur.getId_utilisateur());
		}
	}


	//la liste des tableaux
	private   void listTableaux()
	{
	    TablauKanbanDao tableauKanbanDao =new TablauKanbanDao();
	    List <TableauKanban> TableauList =  tableauKanbanDao.listTableaux();
		System.out.println("numbre de tableau:" + TableauList.size());
		for (TableauKanban tableau : TableauList) {
			System.out.println("le numero du tableau : " + tableau.getId_Kanban());
		}
	}

	//la liste des tags
	private   void listTags()
	{
        TagDao tagDao= new TagDao();
		List <Tag> TagList = tagDao.listTags();
		System.out.println("numbre de tag" + TagList.size());
		for (Tag tag : TagList) {
			System.out.println("le numero du tag : " + tag.getId_Tag());
		}
	}


}
