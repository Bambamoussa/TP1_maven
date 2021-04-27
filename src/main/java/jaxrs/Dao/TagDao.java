package jaxrs.Dao;

import jaxrs.EntityManagerHelper;
import kanban.Fiche;
import kanban.TableauKanban;
import kanban.Tag;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class TagDao {

    protected EntityManager entityManager;

    public TagDao() {
        this.entityManager = EntityManagerHelper.getEntityManager();
    }


    public void saveTag(Tag tag) {
        this.entityManager.getTransaction().begin();
        try {
            this.entityManager.persist(tag);

        } catch (Exception e) {
            e.printStackTrace();
        }
        this.entityManager.getTransaction().commit();

    }


    public List <Tag> listTags()
    {
        return  EntityManagerHelper.getEntityManager().createQuery("Select T From Tag T", Tag.class).getResultList();

    }

    public Tag update(final Tag entity) {
        EntityTransaction t = this.entityManager.getTransaction();
        t.begin();
        Tag res = this.entityManager.merge(entity);
        t.commit();
        return res;

    }

    public void delete(Tag entity) {
        EntityTransaction t = this.entityManager.getTransaction();
        t.begin();
        entityManager.remove(entity);
        t.commit();

    }

    public Tag findOne(Long id) {
        return entityManager.find(Tag.class, id);
    }

    public void deleteById(Long entityId) {
        Tag entity = findOne(entityId);
        delete(entity);
    }

}
