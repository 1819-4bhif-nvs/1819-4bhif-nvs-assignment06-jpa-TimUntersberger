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
@NamedQuery(name="Product.findAll", query = "select x from Product x")
public class Product extends BaseEntity{
    @OneToOne
    private Team team;
    @OneToOne
    private ProductOwner productOwner;

    public Product(Team team, ProductOwner productOwner) {
        this.team = team;
        this.productOwner = productOwner;
    }

    public Product() {
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public ProductOwner getProductOwner() {
        return productOwner;
    }

    public void setProductOwner(ProductOwner productOwner) {
        this.productOwner = productOwner;
    }

    public void update(Product changeset) {
        super.update(changeset);
        setIfPresent(this::setTeam, changeset::getTeam);
        setIfPresent(this::setProductOwner, changeset::getProductOwner);
    }

    public JsonObjectBuilder toJsonObjectBuilder(){
        return super.toJsonObjectBuilder()
                .add("team_id", team == null
                        ? JsonValue.NULL
                        : Json.createValue(team.getId())
                )
                .add("productOwner_id", productOwner == null
                        ? JsonValue.NULL
                        : Json.createValue(productOwner.getId())
                );
    }

    public JsonObject toJsonObject(){
        return toJsonObjectBuilder().build();
    }
}
