package at.htl.rest.endpoint;

import at.htl.database.dao.AbstractDao;
import at.htl.database.dao.ProductDao;
import at.htl.database.entity.Product;
import at.htl.rest.adapter.AbstractAdapter;
import at.htl.rest.adapter.ProductAdapter;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("product")
@Stateless
public class ProductEndpoint extends AbstractCrudEndpoint<Product>{
    @Inject
    ProductDao productDao;
    @Inject
    ProductAdapter productAdapter;

    @Override
    protected AbstractDao<Product> getDao() {
        return productDao;
    }

    @Override
    protected AbstractAdapter<Product> getAdapter() {
        return productAdapter;
    }
}
