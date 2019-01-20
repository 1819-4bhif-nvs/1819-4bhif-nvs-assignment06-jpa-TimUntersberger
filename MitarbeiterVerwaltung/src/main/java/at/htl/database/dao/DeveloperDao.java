package at.htl.database.dao;

import at.htl.database.entity.Developer;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

@Stateless
public class DeveloperDao extends AbstractCrudDao<Developer>{
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
