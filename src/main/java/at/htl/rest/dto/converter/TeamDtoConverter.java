package at.htl.rest.dto.converter;

import at.htl.database.dao.AbstractCrudDao;
import at.htl.database.dao.EmployeeDao;
import at.htl.database.dao.TeamDao;
import at.htl.database.entity.Team;
import at.htl.database.entity.contract.ITeam;
import at.htl.rest.dto.TeamDto;

public class TeamDtoConverter extends AbstractDtoConverter<Team, TeamDto, ITeam>{
    private TeamDao teamDao;
    private EmployeeDao employeeDao;

    public TeamDtoConverter(TeamDao teamDao, EmployeeDao employeeDao) {
        this.teamDao = teamDao;
        this.employeeDao = employeeDao;
    }

    @Override
    protected AbstractCrudDao<Team> getDao() {
        return teamDao;
    }

    @Override
    protected Class<Team> getEntityClass() {
        return Team.class;
    }

    @Override
    protected Class<TeamDto> getEntityDtoClass() {
        return TeamDto.class;
    }

    @Override
    protected void updateEntity(ITeam e1, ITeam e2) {
        ITeam.merge(e1, e2);
    }

    @Override
    public Team toEntity(TeamDto teamDto) {
        Team t = super.toEntity(teamDto);

        if(teamDto.getLeaderId() != null)
            t.setLeader(employeeDao.findById(teamDto.getLeaderId()));

        return t;
    }

    @Override
    public TeamDto toDto(Team entity) {
        TeamDto t = super.toDto(entity);

        if(entity.getLeader() != null)
            t.setLeaderId(entity.getLeader().getId());

        return t;
    }
}
