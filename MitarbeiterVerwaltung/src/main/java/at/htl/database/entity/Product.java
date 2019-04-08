package at.htl.database.entity;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQuery(name="Product.findAll", query = "select x from Product x")
@NamedQuery(name="Product.findById", query = "select x from Product x where x.id = :ID")
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
        setNonNull(this::setTeam, changeset::getTeam);
        setNonNull(this::setProductOwner, changeset::getProductOwner);
    }

    public JsonObject serialize(){
        return Json.createObjectBuilder()
                .add("id", getId())
                .add("productOwner_id", productOwner == null? JsonValue.NULL : Json.createValue(productOwner.getId()))
                .add("team_id", team == null? JsonValue.NULL : Json.createValue(team.getId()))
                .build();
    }
}
