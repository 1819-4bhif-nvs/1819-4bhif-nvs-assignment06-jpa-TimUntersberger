package at.htl.database.dao;

import at.htl.database.entity.Project;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ProjectDao extends AbstractCrudDao<Project>{
    @PersistenceContext
    EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    protected Class<Project> getEntityClass() {
        return Project.class;
    }
}
