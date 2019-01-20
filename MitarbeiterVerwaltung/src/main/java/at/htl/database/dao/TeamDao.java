package at.htl.database.dao;

import at.htl.database.entity.Developer;
import at.htl.database.entity.Team;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

@Stateless
public class TeamDao extends AbstractCrudDao<Team>{
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
