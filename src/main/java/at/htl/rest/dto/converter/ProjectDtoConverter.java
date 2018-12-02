package at.htl.rest.dto.converter;

import at.htl.database.dao.AbstractCrudDao;
import at.htl.database.dao.EmployeeDao;
import at.htl.database.dao.ProjectDao;
import at.htl.database.dao.TeamDao;
import at.htl.database.entity.Employee;
import at.htl.database.entity.Project;
import at.htl.database.entity.contract.IProject;
import at.htl.rest.dto.ProjectDto;

public class ProjectDtoConverter extends AbstractDtoConverter<Project, ProjectDto, IProject> {
    ProjectDao projectDao;
    TeamDao teamDao;
    EmployeeDao employeeDao;

    public ProjectDtoConverter(ProjectDao projectDao, TeamDao teamDao, EmployeeDao employeeDao) {
        this.projectDao = projectDao;
        this.teamDao = teamDao;
        this.employeeDao = employeeDao;
    }

    @Override
    protected AbstractCrudDao<Project> getDao() {
        return projectDao;
    }

    @Override
    protected Class<Project> getEntityClass() {
        return Project.class;
    }

    @Override
    protected Class<ProjectDto> getEntityDtoClass() {
        return ProjectDto.class;
    }

    @Override
    protected void updateEntity(IProject e1, IProject e2) {
        IProject.merge(e1, e2);
    }

    @Override
    public Project toEntity(ProjectDto projectDto) {
        Project p = super.toEntity(projectDto);

        if(projectDto.getOwnerId() != null)
            p.setOwner(employeeDao.findById(projectDto.getOwnerId()));

        if(projectDto.getTeamId() != null)
            p.setTeam(teamDao.findById(projectDto.getTeamId()));

        return p;
    }

    @Override
    public ProjectDto toDto(Project entity) {
        ProjectDto p = super.toDto(entity);

        if(entity.getOwner() != null)
            p.setOwnerId(entity.getOwner().getId());

        if(entity.getTeam() != null)
            p.setTeamId(entity.getTeam().getId());

        return p;
    }
}
