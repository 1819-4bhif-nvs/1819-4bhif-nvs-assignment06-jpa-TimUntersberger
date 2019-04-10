package at.htl.business;

import at.htl.database.dao.*;
import at.htl.database.entity.Developer;
import at.htl.database.entity.Product;
import at.htl.database.entity.ProductOwner;
import at.htl.database.entity.Team;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class InitBean {
    @PersistenceContext
    EntityManager em;

    @Inject
    DeveloperDao developerDao;

    @Inject
    ProductDao productDao;

    @Inject
    ProductOwnerDao productOwnerDao;

    @Inject
    TeamDao teamDao;

    @Inject
    VacationDao vacationDao;

    private Double getRandomSalary(){
        return Math.floor(Math.random() * 400 + 1200);
    }

    @Transactional
    public void init(@Observes @Initialized(ApplicationScoped.class) Object object){
        for (int i = 0; i < 3; i++) {
            char letter = (char) (65 + i);
            ProductOwner productOwner = new ProductOwner();
            Product product = new Product();
            Team team = new Team();

            productOwner.setFirstName("Hans " + letter);
            productOwner.setLastName("Hochberg");
            productOwner.setSalary(getRandomSalary());
            productOwnerDao.create(productOwner);

            product.setProductOwner(productOwner);
            productDao.create(product);

            productOwner.setProduct(product);
            productOwnerDao.update(productOwner.getId(), productOwner);

            team.setProduct(product);
            team.setName("Team " + letter);
            teamDao.create(team);

            product.setTeam(team);
            productDao.update(product.getId(), product);

            Developer developerA = new Developer();
            developerA.setTeam(team);
            developerA.setFirstName("Julian " + letter);
            developerA.setLastName("Nobis");
            developerA.setSalary(getRandomSalary());
            developerDao.create(developerA);

            Developer developerB = new Developer();
            developerB.setTeam(team);
            developerB.setFirstName("Tim " + letter);
            developerB.setLastName("Untersberger");
            developerB.setSalary(getRandomSalary());
            developerDao.create(developerB);

            Developer developerC = new Developer();
            developerC.setTeam(team);
            developerC.setFirstName("Stefan " + letter);
            developerC.setLastName("Waldl");
            developerC.setSalary(getRandomSalary());
            developerDao.create(developerC);
        }
    }

}
