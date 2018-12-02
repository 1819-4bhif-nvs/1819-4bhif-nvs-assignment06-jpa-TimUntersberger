package at.htl.rest.endpoint;

import at.htl.database.dao.EmployeeDao;
import at.htl.database.dao.ICrudDao;
import at.htl.database.dao.ProjectDao;
import at.htl.database.dao.TeamDao;
import at.htl.database.entity.Project;
import at.htl.database.entity.contract.IProject;
import at.htl.rest.dto.ProjectDto;
import at.htl.rest.dto.converter.ProjectDtoConverter;

import javax.inject.Inject;

public class ProjectEndpoint extends AbstractCrudEndpoint<Project, ProjectDto, IProject, ProjectDtoConverter> {
    @Inject
    ProjectDao projectDao;
    @Inject
    TeamDao teamDao;
    @Inject
    EmployeeDao employeeDao;

    ProjectDtoConverter projectDtoConverter;

    @Override
    protected ICrudDao<Project> getDao() {
        return projectDao;
    }

    @Override
    protected ProjectDtoConverter getDtoConverter() {
        if(projectDtoConverter == null)
            projectDtoConverter = new ProjectDtoConverter(projectDao, teamDao, employeeDao);

        return projectDtoConverter;
    }
}
