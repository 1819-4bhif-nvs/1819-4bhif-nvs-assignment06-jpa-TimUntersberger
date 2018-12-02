package at.htl.rest.dto;

import at.htl.database.entity.contract.IEmployee;
import at.htl.rest.adapter.LocalDateAdapter;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@XmlRootElement
public class EmployeeDto implements IEmployee{
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private Float salary;
    private Long teamId;

    public EmployeeDto(Long id, String firstName, String lastName, LocalDate birthday, Float salary, Long teamId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.salary = salary;
        this.teamId = teamId;
    }

    public EmployeeDto(){

    }

    @Override
    public void update(IEmployee employee) {
        IEmployee.merge(this, employee);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
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

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }
}
