package at.htl.rest.endpoint;

import at.htl.database.dao.DeveloperDao;
import at.htl.database.dao.ICrudDao;
import at.htl.database.entity.Developer;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("developer")
@Stateless
public class DeveloperEndpoint extends AbstractCrudEndpoint<Developer>{
    @Inject
    DeveloperDao developerDao;

    @Override
    protected ICrudDao<Developer> getDao() {
        return developerDao;
    }
}
