package at.htl.database.entity;

import at.htl.database.entity.contract.IProject;

import javax.persistence.*;

@Entity
@NamedQuery(name = "Project.findAll", query = "select p from Project p")
public class Project implements IProject {
    @Id
    @SequenceGenerator(name = "project_seq", sequenceName = "project_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_seq")
    private Long id;
    private String name;
    private String description;
    @OneToOne(fetch = FetchType.LAZY)
    private Employee owner;
    @OneToOne(fetch = FetchType.LAZY)
    private Team team;

    public Project() {
    }

    public Project(String name, String description, Employee owner, Team team) {
        this.name = name;
        this.description = description;
        this.owner = owner;
        this.team = team;
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

    public Employee getOwner() {
        return owner;
    }

    public void setOwner(Employee owner) {
        this.owner = owner;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }
}
