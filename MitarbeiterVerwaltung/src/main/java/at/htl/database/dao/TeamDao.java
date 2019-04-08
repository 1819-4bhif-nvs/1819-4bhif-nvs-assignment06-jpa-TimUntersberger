package at.htl.database.dao;

import at.htl.database.entity.Team;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TeamDao extends AbstractDao<Team> {
    @PersistenceContext
    EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    protected Class<Team> getEntityClass() {
        return Team.class;
    }
}
