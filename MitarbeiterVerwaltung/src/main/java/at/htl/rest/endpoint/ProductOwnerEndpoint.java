package at.htl.rest.endpoint;

import at.htl.database.dao.DeveloperDao;
import at.htl.database.dao.ICrudDao;
import at.htl.database.dao.ProductOwnerDao;
import at.htl.database.entity.Developer;
import at.htl.database.entity.ProductOwner;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("productowner")
@Stateless
public class ProductOwnerEndpoint extends AbstractCrudEndpoint<ProductOwner>{
    @Inject
    ProductOwnerDao productOwnerDao;

    @Override
    protected ICrudDao<ProductOwner> getDao() {
        return productOwnerDao;
    }
}
