package at.htl.database.dao;

import at.htl.database.entity.Vacation;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class VacationDao extends AbstractCrudDao<Vacation> {
    @PersistenceContext
    EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    protected Class<Vacation> getEntityClass() {
        return Vacation.class;
    }
}
