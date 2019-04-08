package at.htl.database.entity;

import at.htl.database.converter.LocalDateConverter;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import java.time.LocalDate;

@Entity
@NamedQuery(name="Vacation.findAll", query = "select x from Vacation x")
@NamedQuery(name="Vacation.findById", query = "select x from Vacation x where x.id = :ID")
public class Vacation extends BaseEntity{
    @ManyToOne
    private Employee employee;
    @Convert(converter = LocalDateConverter.class)
    private LocalDate startDate;
    @Convert(converter = LocalDateConverter.class)
    private LocalDate endDate;

    public Vacation(Employee employee, LocalDate start, LocalDate end) {
        this.employee = employee;
        this.startDate = start;
        this.endDate = end;
    }

    public Vacation() {
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate beginning) {
        this.startDate = beginning;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate end) {
        this.endDate = end;
    }

    public void update(Vacation changeset) {
        super.update(changeset);
        setNonNull(this::setEmployee, changeset::getEmployee);
        setNonNull(this::setStartDate, changeset::getStartDate);
        setNonNull(this::setEndDate, changeset::getEndDate);
    }

    public JsonObject serialize(){
        return Json.createObjectBuilder()
                .add("id", getId())
                .add("employee_id", employee == null? JsonValue.NULL : Json.createValue(employee.getId()))
                .add("startDate", startDate.toString())
                .add("endDate", endDate.toString())
                .build();
    }
}
