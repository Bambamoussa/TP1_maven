package jaxrs.Dao;

import jaxrs.EntityManagerHelper;
import kanban.Section;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class SectionDao {
    protected EntityManager entityManager;

    public SectionDao() {
        this.entityManager = EntityManagerHelper.getEntityManager();
    }


    public void saveSection(Section section) {
        this.entityManager.getTransaction().begin();
        try {
            this.entityManager.persist(section);

        } catch (Exception e) {
            e.printStackTrace();
        }
        this.entityManager.getTransaction().commit();

    }


    public List<Section> listSection()

    {
        String query="Select a From Section a";
        return this.entityManager.createQuery(query, Section.class).getResultList();

    }



    public Section update(final Section entity) {
        EntityTransaction t = this.entityManager.getTransaction();
        t.begin();
        Section res = entityManager.merge(entity);
        t.commit();
        return res;

    }

    public void delete(Section entity) {
        EntityTransaction t = this.entityManager.getTransaction();
        t.begin();
        entityManager.remove(entity);
        t.commit();

    }

    public Section findOne(Long id) {
        return entityManager.find(Section.class, id);
    }

    public void deleteById(Long entityId) {
        Section entity = findOne(entityId);
        delete(entity);
    }
}
