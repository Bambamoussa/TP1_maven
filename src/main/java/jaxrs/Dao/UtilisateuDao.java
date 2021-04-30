package jaxrs.Dao;

import jaxrs.EntityManagerHelper;
import kanban.Fiche;
import kanban.Utilisateur;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class UtilisateuDao {

    protected EntityManager entityManager;

    public UtilisateuDao() {
        this.entityManager = EntityManagerHelper.getEntityManager();
    }

    public Utilisateur findOne(Long id) {
        return entityManager.find(Utilisateur.class, id);
    }



    public void saveUtilisater(Utilisateur utilisateur) {
        this.entityManager.getTransaction().begin();
        try {
            this.entityManager.persist(utilisateur);

        } catch (Exception e) {
            e.printStackTrace();
        }
        this.entityManager.getTransaction().commit();

    }

    public List <Utilisateur> listUtilisateurs(){
        String query="Select u From Utilisateur u";

        return EntityManagerHelper.getEntityManager().createQuery(query, Utilisateur.class).getResultList();
    }


    public Utilisateur update( Utilisateur utilisateur ) {
        EntityTransaction t = this.entityManager.getTransaction();
        t.begin();
        Utilisateur res = entityManager.merge(utilisateur);
        t.commit();
        return res;

    }

    public void delete(Utilisateur entity) {
        EntityTransaction t = this.entityManager.getTransaction();
        t.begin();
        entityManager.remove(entity);
        t.commit();

    }

    public void deleteById(Long entityId) {
        Utilisateur entity = findOne(entityId);
        delete(entity);
    }
}
