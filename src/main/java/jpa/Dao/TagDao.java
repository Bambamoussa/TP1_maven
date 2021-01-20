package jpa.Dao;

import jpa.EntityManagerHelper;
import kanban.Fiche;
import kanban.Tag;

import javax.persistence.EntityTransaction;
import java.util.List;

public class TagDao {

    public void saveTag(Tag tag) {
        EntityTransaction t = EntityManagerHelper.getEntityManager().getTransaction();

        //t.begin();
        EntityManagerHelper.getEntityManager().persist(tag);
        //t.commit();
    }


    public List <Tag> listTags()
    {
        return  EntityManagerHelper.getEntityManager().createQuery("Select T From Tag T", Tag.class).getResultList();

    }

}
