package at.htl.rest.endpoint;

import at.htl.database.dao.DeveloperDao;
import at.htl.database.dao.ICrudDao;
import at.htl.database.dao.VacationDao;
import at.htl.database.entity.Developer;
import at.htl.database.entity.Vacation;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("vacation")
@Stateless
public class VacationEndpoint extends AbstractCrudEndpoint<Vacation>{
    @Inject
    VacationDao vacationDao;

    @Override
    protected ICrudDao<Vacation> getDao() {
        return vacationDao;
    }
}
