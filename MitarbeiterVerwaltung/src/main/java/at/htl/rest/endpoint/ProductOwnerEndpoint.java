package at.htl.rest.endpoint;

import at.htl.database.dao.AbstractDao;
import at.htl.database.dao.ProductOwnerDao;
import at.htl.database.entity.ProductOwner;
import at.htl.rest.adapter.AbstractAdapter;
import at.htl.rest.adapter.ProductOwnerAdapter;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("productowner")
@Stateless
public class ProductOwnerEndpoint extends AbstractCrudEndpoint<ProductOwner>{
    @Inject
    ProductOwnerDao productOwnerDao;
    @Inject
    ProductOwnerAdapter productOwnerAdapter;

    @Override
    protected AbstractDao<ProductOwner> getDao() {
        return productOwnerDao;
    }

    @Override
    protected AbstractAdapter<ProductOwner> getAdapter() {
        return productOwnerAdapter;
    }
}
