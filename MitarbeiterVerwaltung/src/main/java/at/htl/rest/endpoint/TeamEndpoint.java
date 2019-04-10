package at.htl.rest.endpoint;

import at.htl.database.dao.AbstractDao;
import at.htl.database.dao.TeamDao;
import at.htl.database.entity.Team;
import at.htl.rest.adapter.AbstractAdapter;
import at.htl.rest.adapter.TeamAdapter;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("team")
@Stateless
public class TeamEndpoint extends AbstractCrudEndpoint<Team>{
    @Inject
    TeamDao teamDao;
    @Inject
    TeamAdapter teamAdapter;

    @Override
    protected AbstractDao<Team> getDao() {
        return teamDao;
    }

    @Override
    protected AbstractAdapter<Team> getAdapter() {
        return teamAdapter;
    }
}
