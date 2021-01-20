package jpa.Dao;

import jpa.EntityManagerHelper;
import kanban.Fiche;

import javax.persistence.EntityTransaction;
import java.util.List;

public class FicheDao {

    public void saveFiche(Fiche fiche) {
        EntityTransaction t = EntityManagerHelper.getEntityManager().getTransaction();

       // t.begin();
        EntityManagerHelper.getEntityManager().persist(fiche);
        //t.commit();
    }


        public  List <Fiche> listFiche()

        {
            String query="Select a From Fiche a";
            return EntityManagerHelper.getEntityManager().createQuery(query, Fiche.class).getResultList();

        }
    }

