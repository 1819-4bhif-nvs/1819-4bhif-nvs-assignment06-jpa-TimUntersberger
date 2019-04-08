package at.htl.database.dao;

import at.htl.database.entity.Developer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DeveloperDao extends AbstractDao<Developer> {
    @PersistenceContext
    EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    protected Class<Developer> getEntityClass() {
        return Developer.class;
    }
}
