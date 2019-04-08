package at.htl.database.dao;

import at.htl.database.entity.Product;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ProductDao extends AbstractDao<Product> {
    @PersistenceContext
    EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    protected Class<Product> getEntityClass() {
        return Product.class;
    }
}
