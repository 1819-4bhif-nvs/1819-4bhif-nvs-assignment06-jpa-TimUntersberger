package at.htl.rest.adapter;

import at.htl.database.dao.ProductDao;
import at.htl.database.entity.Team;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;

@Stateless
public class TeamAdapter extends AbstractAdapter<Team> {
    @Inject
    ProductDao productDao;

    @Override
    public JsonObject marshall(Team entity) {
        return Json.createObjectBuilder()
                .add("id", entity.getId())
                .add("name", entity.getName())
                .add("product_id", entity.getProduct().getId())
                .build();
    }

    @Override
    public Team unmarshall(JsonObject json) {
        Team team = new Team();

        team.setName(json.getString("name"));
        team.setProduct(productDao.findById((long) json.getInt("product_id")));

        return team;
    }
}
