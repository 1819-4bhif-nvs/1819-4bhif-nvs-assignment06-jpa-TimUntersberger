package at.htl.database.entity;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;
import java.util.Optional;

@Entity
@NamedQuery(name="Team.findAll", query = "select x from Team x")
public class Team extends BaseEntity {
    private String name;
    @OneToOne
    private Product product;
    @OneToMany(mappedBy = "team")
    private List<Developer> developers;

    public Team(String name, Product product, List<Developer> developers) {
        this.name = name;
        this.product = product;
        this.developers = developers;
    }

    public Team() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Developer> getDevelopers() {
        return developers;
    }

    public void addDevelopers(Developer developer) {
        this.developers.add(developer);
    }

    public void update(Team changeset) {
        super.update(changeset);
        setIfPresent(this::setName, changeset::getName);
        setIfPresent(this::setProduct, changeset::getProduct);
    }

    public JsonObjectBuilder toJsonObjectBuilder(){
        return super.toJsonObjectBuilder()
                .add("name", name)
                .add("product_id", product == null
                        ? JsonValue.NULL
                        : Json.createValue(product.getId())
                );
    }

    public JsonObject toJsonObject(){
        return toJsonObjectBuilder().build();
    }
}
