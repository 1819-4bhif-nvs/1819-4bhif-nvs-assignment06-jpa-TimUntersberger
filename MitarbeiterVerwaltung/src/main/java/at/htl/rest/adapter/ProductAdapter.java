package at.htl.rest.adapter;

import at.htl.database.dao.ProductOwnerDao;
import at.htl.database.dao.TeamDao;
import at.htl.database.entity.Product;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;

@Stateless
public class ProductAdapter extends AbstractAdapter<Product> {
    @Inject
    ProductOwnerDao productOwnerDao;
    @Inject
    TeamDao teamDao;

    @Override
    public JsonObject marshall(Product entity) {
        return Json.createObjectBuilder()
                .add("id", entity.getId())
                .add("productOwner_id", entity.getProductOwner().getId())
                .add("team_id", entity.getTeam().getId())
                .build();
    }

    @Override
    public Product unmarshall(JsonObject json) {
        Product product = new Product();

        product.setTeam(teamDao.findById((long) json.getInt("team_id")));
        product.setProductOwner(productOwnerDao.findById((long) json.getInt("productOwner_id")));

        return product;
    }
}
