package jaxrs.Dao;

import jaxrs.EntityManagerHelper;
import kanban.Fiche;
import kanban.TableauKanban;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class TablauKanbanDao {

    protected EntityManager entityManager;

    public TablauKanbanDao() {
        this.entityManager = EntityManagerHelper.getEntityManager();
    }


    public void saveTableau(TableauKanban tableau) {
        EntityTransaction t = this.entityManager.getTransaction();

        //t.begin();
        this.entityManager.persist(tableau);
       // t.commit();
    }

    public List <TableauKanban> listTableaux()
    {
        String query="Select t From TableauKanban t";
        return  EntityManagerHelper.getEntityManager().createQuery(query, TableauKanban.class).getResultList();

    }


    public TableauKanban update(final TableauKanban entity) {
        EntityTransaction t = this.entityManager.getTransaction();
        t.begin();
        TableauKanban res = this.entityManager.merge(entity);
        t.commit();
        return res;

    }

    public void delete(TableauKanban entity) {
        EntityTransaction t = this.entityManager.getTransaction();
        t.begin();
        this.entityManager.remove(entity);
        t.commit();

    }

    public TableauKanban findOne(Long id) {
        return this.entityManager.find(TableauKanban.class, id);
    }

    public void deleteById(Long entityId) {
        TableauKanban entity = findOne(entityId);
        delete(entity);
    }
}
