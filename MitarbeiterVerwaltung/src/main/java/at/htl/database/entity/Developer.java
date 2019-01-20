package at.htl.database.entity;

import javax.persistence.*;

@Entity
@NamedQuery(name="Developer.findAll", query = "select x from Developer x")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Developer extends Employee{
    @ManyToOne
    private Team team;

    public Developer(Team team) {
        this.team = team;
    }

    public Developer() {
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void update(Developer changeset) {
        super.update(changeset);
        setNonNull(this::setTeam, changeset::getTeam);
    }
}
