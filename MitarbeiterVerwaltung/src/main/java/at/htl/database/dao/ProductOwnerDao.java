package at.htl.database.dao;

import at.htl.database.entity.ProductOwner;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ProductOwnerDao extends AbstractDao<ProductOwner> {
    @PersistenceContext
    EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    protected Class<ProductOwner> getEntityClass() {
        return ProductOwner.class;
    }
}
