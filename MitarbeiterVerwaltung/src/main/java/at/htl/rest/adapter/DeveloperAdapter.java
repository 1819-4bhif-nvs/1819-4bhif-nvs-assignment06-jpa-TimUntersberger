package at.htl.rest.adapter;

import at.htl.database.dao.TeamDao;
import at.htl.database.entity.Developer;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonValue;

@Stateless
public class DeveloperAdapter extends AbstractAdapter<Developer>{
    @Inject
    TeamDao teamDao;

    @Override
    public JsonObject marshall(Developer entity) {
        return Json.createObjectBuilder()
                .add("id", entity.getId())
                .add("firstName", entity.getFirstName())
                .add("lastName", entity.getLastName())
                .add("salary", entity.getSalary())
                .add("team_id", entity.getTeam() == null
                        ? JsonValue.NULL
                        : Json.createValue(entity.getTeam().getId())
                )
                .build();
    }

    @Override
    public Developer unmarshall(JsonObject json) {
        Developer developer = new Developer();

        developer.setTeam(teamDao.findById((long) json.getInt("team_id")));
        developer.setFirstName(json.getString("firstName"));
        developer.setLastName(json.getString("lastName"));
        developer.setSalary((double) json.getInt("salary"));

        return developer;
    }
}
