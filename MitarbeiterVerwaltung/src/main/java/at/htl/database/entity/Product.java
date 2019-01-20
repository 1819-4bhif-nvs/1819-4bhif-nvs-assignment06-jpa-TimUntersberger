package at.htl.database.entity;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

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
        setNonNull(this::setTeam, changeset::getTeam);
        setNonNull(this::setProductOwner, changeset::getProductOwner);
    }
}
