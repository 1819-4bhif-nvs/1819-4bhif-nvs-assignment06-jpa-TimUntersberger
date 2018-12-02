package at.htl.rest.dto;

import at.htl.database.entity.contract.IProject;

public class ProjectDto implements IProject {
    private Long id;
    private String name;
    private String description;
    private Long ownerId;
    private Long teamId;

    public ProjectDto(Long id, String name, String description, Long ownerId, Long teamId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ownerId = ownerId;
        this.teamId = teamId;
    }

    public ProjectDto() {
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void update(IProject iProject) {
        IProject.merge(this, iProject);
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }
}
