package at.htl.database.entity;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQuery(name="Team.findAll", query = "select x from Team x")
@NamedQuery(name="Team.findById", query = "select x from Team x where x.id = :ID")
public class Team extends BaseEntity {
    private String name;
    @OneToOne
    private Product product;
    @OneToMany(mappedBy = "team")
    private List<Developer> developers;

    public Team(String name, Product product, List<Developer> developers) {
        this.name = name;
        this.product = product;

        if(developers == null)
            this.developers = new ArrayList<>();
        else
            this.developers = developers;
    }

    public Team() {
        this.developers = new ArrayList<>();
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

    public void addDeveloper(Developer developer) {
        this.developers.add(developer);
    }

    public void update(Team changeset) {
        super.update(changeset);
        setNonNull(this::setName, changeset::getName);
        setNonNull(this::setProduct, changeset::getProduct);
    }

    public JsonObject serialize(){
        return Json.createObjectBuilder()
                .add("id", getId())
                .add("name", name)
                .add("product_id", product == null? JsonValue.NULL : Json.createValue(product.getId()))
                .build();
    }
}
