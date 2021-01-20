package jpa.Dao;

import jpa.EntityManagerHelper;
import kanban.Fiche;
import kanban.TableauKanban;

import javax.persistence.EntityTransaction;
import java.util.List;

public class TablauKanbanDao {

    public void saveTableau(TableauKanban tableau) {
        EntityTransaction t = EntityManagerHelper.getEntityManager().getTransaction();

        //t.begin();
        EntityManagerHelper.getEntityManager().persist(tableau);
       // t.commit();
    }

    public List <TableauKanban> listTableaux()
    {
        String query="Select t From TableauKanban t";
        return  EntityManagerHelper.getEntityManager().createQuery(query, TableauKanban.class).getResultList();

    }
}
