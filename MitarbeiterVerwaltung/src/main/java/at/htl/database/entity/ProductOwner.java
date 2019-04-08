package at.htl.database.entity;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity

@NamedQuery(name="ProductOwner.findAll", query = "select x from ProductOwner x")
@NamedQuery(name="ProductOwner.findById", query = "select x from ProductOwner x where x.id = :ID")
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
        setNonNull(this::setProduct, changeset::getProduct);
    }

    public JsonObject serialize(){
        return Json.createObjectBuilder()
                .add("id", getId())
                .add("product_id", product == null? JsonValue.NULL : Json.createValue(product.getId()))
                .build();
    }
}
