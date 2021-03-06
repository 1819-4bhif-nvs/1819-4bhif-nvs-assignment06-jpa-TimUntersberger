package at.htl.database.entity;

import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.persistence.*;
import java.util.List;

@Entity
@NamedQuery(name="Employee.findAll", query = "select x from Employee x")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Employee extends BaseEntity {
    private String firstName;
    private String lastName;
    private Double salary;
    @OneToMany(mappedBy = "employee")
    private List<Vacation> vacations;

    public Employee(String firstName, String lastName, Double salary, List<Vacation> vacations) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.vacations = vacations;
    }

    public Employee() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public List<Vacation> getVacations() {
        return vacations;
    }

    public void addVacation(Vacation vacation) {
        this.vacations.add(vacation);
    }

    public void update(Employee changeset) {
        super.update(changeset);
        setIfPresent(this::setFirstName, changeset::getFirstName);
        setIfPresent(this::setLastName, changeset::getLastName);
        setIfPresent(this::setSalary, changeset::getSalary);
    }

    public JsonObjectBuilder toJsonObjectBuilder(){
        return super.toJsonObjectBuilder()
                .add("firstName", firstName)
                .add("lastName", lastName)
                .add("salary", salary);
    }

    public JsonObject toJsonObject(){
        return toJsonObjectBuilder().build();
    }
}
