package at.htl.rest.endpoint;

import at.htl.database.dao.AbstractDao;
import at.htl.database.dao.VacationDao;
import at.htl.database.entity.Vacation;
import at.htl.rest.adapter.AbstractAdapter;
import at.htl.rest.adapter.VacationAdapter;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("vacation")
@Stateless
public class VacationEndpoint extends AbstractCrudEndpoint<Vacation>{
    @Inject
    VacationDao vacationDao;
    @Inject
    VacationAdapter vacationAdapter;

    @Override
    protected AbstractDao<Vacation> getDao() {
        return vacationDao;
    }

    @Override
    protected AbstractAdapter<Vacation> getAdapter() {
        return vacationAdapter;
    }
}
