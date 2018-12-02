package at.htl.database.entity;

import at.htl.database.converter.LocalDateConverter;
import at.htl.database.entity.contract.ITeam;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@NamedQuery(name = "Team.findAll", query = "select t from Team t")
public class Team implements ITeam {
    @Id
    @SequenceGenerator(name = "team_seq", sequenceName = "team_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_seq")
    private Long id;
    private String name;
    @OneToOne
    private Employee leader;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "team")
    private List<Employee> employees;

    public Team() {
    }

    public Team(String name, Employee leader) {
        this.name = name;
        this.leader = leader;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void update(ITeam team) {
        ITeam.merge(this, team);
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

    public Employee getLeader() {
        return leader;
    }

    public void setLeader(Employee leader) {
        this.leader = leader;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
