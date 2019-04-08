package at.htl.rest.endpoint;

import at.htl.database.dao.DeveloperDao;
import at.htl.database.dao.ICrudDao;
import at.htl.database.dao.TeamDao;
import at.htl.database.entity.Developer;
import at.htl.database.entity.Team;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("team")
@Stateless
public class TeamEndpoint extends AbstractCrudEndpoint<Team>{
    @Inject
    TeamDao teamDao;

    @Override
    protected ICrudDao<Team> getDao() {
        return teamDao;
    }
}
