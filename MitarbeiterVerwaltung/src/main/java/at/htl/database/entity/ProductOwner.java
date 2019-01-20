package at.htl.database.entity;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

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
        setNonNull(this::setProduct, changeset::getProduct);
    }
}
