package at.htl.rest.adapter;

import at.htl.database.dao.ProductDao;
import at.htl.database.entity.ProductOwner;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;

@Stateless
public class ProductOwnerAdapter extends AbstractAdapter<ProductOwner> {
    @Inject
    ProductDao productDao;

    @Override
    public JsonObject marshall(ProductOwner entity) {
        return Json.createObjectBuilder()
                .add("id", entity.getId())
                .add("firstName", entity.getFirstName())
                .add("lastName", entity.getLastName())
                .add("salary", entity.getSalary())
                .add("product_id", entity.getProduct().getId())
                .build();
    }

    @Override
    public ProductOwner unmarshall(JsonObject json) {
        ProductOwner productOwner = new ProductOwner();

        productOwner.setFirstName(json.getString("firstName"));
        productOwner.setLastName(json.getString("lastName"));
        productOwner.setSalary((double) json.getInt("salary"));
        productOwner.setProduct(productDao.findById((long) json.getInt("product_id")));

        return productOwner;
    }
}
