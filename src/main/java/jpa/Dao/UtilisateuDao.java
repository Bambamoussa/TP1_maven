package jpa.Dao;

import jpa.EntityManagerHelper;
import kanban.Fiche;
import kanban.Utilisateur;

import javax.persistence.EntityTransaction;
import java.util.List;

public class UtilisateuDao {

    public void saveUtilisater(Utilisateur utilisateur) {
        EntityTransaction t = EntityManagerHelper.getEntityManager().getTransaction();

       // t.begin();
        EntityManagerHelper.getEntityManager().persist(utilisateur);
       // t.commit();
    }

    public List <Utilisateur> listUtilisateurs(){
        String query="Select u From Utilisateur u";

        return EntityManagerHelper.getEntityManager().createQuery(query, Utilisateur.class).getResultList();
    }
}
