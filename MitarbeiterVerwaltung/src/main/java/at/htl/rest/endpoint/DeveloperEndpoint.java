package at.htl.rest.endpoint;

import at.htl.database.dao.AbstractDao;
import at.htl.database.dao.DeveloperDao;
import at.htl.database.entity.Developer;
import at.htl.rest.adapter.AbstractAdapter;
import at.htl.rest.adapter.DeveloperAdapter;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("developer")
@Stateless
public class DeveloperEndpoint extends AbstractCrudEndpoint<Developer>{
    @Inject
    DeveloperDao developerDao;
    @Inject
    DeveloperAdapter developerAdapter;

    @Override
    protected AbstractDao<Developer> getDao() {
        return developerDao;
    }

    @Override
    protected AbstractAdapter<Developer> getAdapter() {
        return developerAdapter;
    }
}
