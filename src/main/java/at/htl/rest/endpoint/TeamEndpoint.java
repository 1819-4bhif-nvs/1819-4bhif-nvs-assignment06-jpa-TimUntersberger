package at.htl.rest.endpoint;

import at.htl.database.dao.EmployeeDao;
import at.htl.database.dao.ICrudDao;
import at.htl.database.dao.TeamDao;
import at.htl.database.entity.Employee;
import at.htl.database.entity.Team;
import at.htl.database.entity.contract.ITeam;
import at.htl.rest.dto.TeamDto;
import at.htl.rest.dto.converter.TeamDtoConverter;

import javax.inject.Inject;

public class TeamEndpoint extends AbstractCrudEndpoint<Team , TeamDto, ITeam, TeamDtoConverter> {
    @Inject
    TeamDao teamDao;
    @Inject
    EmployeeDao employeeDao;

    TeamDtoConverter teamDtoConverter;

    @Override
    protected ICrudDao<Team> getDao() {
        return teamDao;
    }

    @Override
    protected TeamDtoConverter getDtoConverter() {
        if(teamDtoConverter == null)
            teamDtoConverter = new TeamDtoConverter(teamDao, employeeDao);
        return teamDtoConverter;
    }
}
