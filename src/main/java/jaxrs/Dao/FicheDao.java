package jaxrs.Dao;

import jaxrs.EntityManagerHelper;
import kanban.Fiche;
import kanban.Utilisateur;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class FicheDao {


    protected EntityManager entityManager;

    public FicheDao() {
        this.entityManager = EntityManagerHelper.getEntityManager();
    }


    public void saveFiche(Fiche fiche) {
        this.entityManager.getTransaction();

       // t.begin();
        this.entityManager.persist(fiche);
        //t.commit();
    }


        public  List <Fiche> listFiche()

        {
            String query="Select a From Fiche a";
            return this.entityManager.createQuery(query, Fiche.class).getResultList();

        }



    public Fiche update(final Fiche entity) {
        EntityTransaction t = this.entityManager.getTransaction();
        t.begin();
        Fiche res = entityManager.merge(entity);
        t.commit();
        return res;

    }

    public void delete(Fiche entity) {
        EntityTransaction t = this.entityManager.getTransaction();
        t.begin();
        entityManager.remove(entity);
        t.commit();

    }

    public Fiche findOne(Long id) {
        return entityManager.find(Fiche.class, id);
    }

    public void deleteById(Long entityId) {
        Fiche entity = findOne(entityId);
        delete(entity);
    }

    }

