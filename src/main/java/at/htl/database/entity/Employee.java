package at.htl.database.entity;

import at.htl.database.converter.LocalDateConverter;
import at.htl.database.entity.contract.IEmployee;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@NamedQuery(name = "Employee.findAll", query = "select e from Employee e")
public class Employee implements IEmployee {
    @Id
    @SequenceGenerator(name = "employee_seq", sequenceName = "employee_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
    private Long id;
    private String firstName;
    private String lastName;
    @Convert(converter = LocalDateConverter.class)
    private LocalDate birthday;
    private Float salary;
    @ManyToOne
    private Team team;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<Vacation> vacations;

    public Employee(String firstName, String lastName, LocalDate birthday, float salary, Team team) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.salary = salary;
        this.team = team;
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    @Override
    public void update(IEmployee entity) {
        IEmployee.merge(this, entity);
    }

    public List<Vacation> getVacations() {
        return vacations;
    }

    @Override
    public void setId(Long id){
        this.id = id;
    }
    @Override
    public Long getId() {
        return id;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
