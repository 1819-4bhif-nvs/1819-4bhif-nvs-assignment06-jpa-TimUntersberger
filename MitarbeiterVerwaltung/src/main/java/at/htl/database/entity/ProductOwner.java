package at.htl.database.entity;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import java.util.Optional;

@Entity

@NamedQuery(name="ProductOwner.findAll", query = "select x from ProductOwner x")
public class ProductOwner extends Employee{
    @OneToOne
    private Product product;

    public ProductOwner(Product product) {
        this.product = product;
    }

    public ProductOwner() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void update(ProductOwner changeset) {
        super.update(changeset);
        setIfPresent(this::setProduct, changeset::getProduct);
    }

    public JsonObjectBuilder toJsonObjectBuilder(){
        return super.toJsonObjectBuilder()
                .add("product_id", product == null
                        ? JsonValue.NULL
                        : Json.createValue(product.getId())
                );
    }

    public JsonObject toJsonObject(){
        return toJsonObjectBuilder().build();
    }
}
