package at.htl.database.dao;


import at.htl.database.entity.BaseEntity;

import javax.persistence.EntityManager;
import java.util.List;

public abstract class AbstractDao<TEntity extends BaseEntity> implements ICrudDao<TEntity> {
    protected abstract EntityManager getEntityManager();
    protected abstract Class<TEntity> getEntityClass();

    @Override
    public void create(TEntity entity, Boolean manualFlush) {
        EntityManager em = getEntityManager();
        em.persist(entity);
        if(!manualFlush)
            em.flush();
    }

    @Override
    public void create(TEntity entity){
        this.create(entity, false);
    }

    @Override
    public List<TEntity> findAll() {
        return getEntityManager()
                .createNamedQuery(getEntityClass().getSimpleName() + ".findAll", getEntityClass())
                .getResultList();
    }

    @Override
    public TEntity findById(Long id) {
        return getEntityManager()
                .createNamedQuery(getEntityClass().getSimpleName() + ".findById", getEntityClass())
                .setParameter("ID", id)
                .getSingleResult();
    }

    @Override
    public void update(Long id, TEntity changeset) {
        EntityManager em = getEntityManager();

        TEntity entity = em.getReference(getEntityClass(), id);
        entity.update(changeset);

        em.flush();
    }

    @Override
    public void delete(Long id) {
        EntityManager em = getEntityManager();
        em.remove(
                em.getReference(getEntityClass(), id)
        );
        em.flush();
    }
}
