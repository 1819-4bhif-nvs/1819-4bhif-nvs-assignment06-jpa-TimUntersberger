package at.htl.database.entity;

import at.htl.rest.serializer.EntityReferenceSerializer;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.json.bind.annotation.JsonbTypeSerializer;
import javax.persistence.*;

@Entity
@NamedQuery(name="Developer.findAll", query = "select x from Developer x")
@NamedQuery(name="Developer.findById", query = "select x from Developer x where x.id = :ID")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Developer extends Employee{
    @ManyToOne
    @JsonbTypeSerializer(value = EntityReferenceSerializer.class)
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

    public JsonObject serialize(){
        return Json.createObjectBuilder()
                .add("id", getId())
                .add("firstName", getFirstName())
                .add("lastName", getLastName())
                .add("salary", getSalary())
                .add("team_id", team == null? JsonValue.NULL : Json.createValue(team.getId()))
                .build();
    }

}
