package at.htl.database.dao;

import at.htl.database.entity.contract.IEntity;

import javax.persistence.EntityManager;
import java.util.List;

public abstract class AbstractCrudDao<Entity extends IEntity> implements ICrudDao<Entity> {
    protected abstract EntityManager getEntityManager();
    protected abstract Class<Entity> getEntityClass();

    @Override
    public void create(Entity entity) {
        EntityManager em = getEntityManager();
        em.persist(entity);
        em.flush();
    }

    @Override
    public List<Entity> findAll() {
        return getEntityManager()
                .createNamedQuery(getEntityClass().getSimpleName() + ".findAll")
                .getResultList();
    }

    @Override
    public Entity findById(Long id) {
        return getEntityManager().find(getEntityClass(), id);
    }

    @Override
    public void update(Long id, Entity changeset) {
        EntityManager em = getEntityManager();

        Entity entity = em.getReference(getEntityClass(), id);
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
