package at.htl.database.entity;

import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.persistence.*;
import java.util.Optional;

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
        setIfPresent(this::setTeam, changeset::getTeam);
    }

    public JsonObjectBuilder toJsonObjectBuilder(){
        return super.toJsonObjectBuilder()
                .add("team_id", Optional
                        .of(team)
                        .map(Team::getId)
                        .orElse(null)
                );
    }

    public JsonObject toJsonObject(){
        return toJsonObjectBuilder().build();
    }
}
