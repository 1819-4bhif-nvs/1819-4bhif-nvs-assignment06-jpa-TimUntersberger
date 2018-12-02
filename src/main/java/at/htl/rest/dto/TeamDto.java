package at.htl.rest.dto;

import at.htl.database.entity.contract.ITeam;

public class TeamDto implements ITeam {
    private Long id;
    private String name;
    private Long leaderId;

    public TeamDto() {
    }

    public TeamDto(Long id, String name, Long leaderId) {
        this.id = id;
        this.name = name;
        this.leaderId = leaderId;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void update(ITeam iTeam) {
        ITeam.merge(this, iTeam);
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

    public Long getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(Long leaderId) {
        this.leaderId = leaderId;
    }
}
