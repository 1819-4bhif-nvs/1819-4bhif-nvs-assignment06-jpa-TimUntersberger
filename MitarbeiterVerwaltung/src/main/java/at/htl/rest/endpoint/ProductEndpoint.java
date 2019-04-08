package at.htl.rest.endpoint;

import at.htl.database.dao.ICrudDao;
import at.htl.database.dao.ProductDao;
import at.htl.database.entity.Developer;
import at.htl.database.entity.Product;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("product")
@Stateless
public class ProductEndpoint extends AbstractCrudEndpoint<Product>{
    @Inject
    ProductDao productDao;

    @Override
    protected ICrudDao<Product> getDao() {
        return productDao;
    }
}
