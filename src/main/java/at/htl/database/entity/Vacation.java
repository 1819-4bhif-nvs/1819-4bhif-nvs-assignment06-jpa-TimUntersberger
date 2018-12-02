package at.htl.database.entity;

import at.htl.database.converter.LocalDateConverter;
import at.htl.database.entity.contract.IVacation;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NamedQuery(name = "Vacation.findAll", query = "select v from Vacation v")
public class Vacation implements IVacation {
    @Id
    @SequenceGenerator(name="vacation_seq", sequenceName = "vacation_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vacation_seq")
    private Long id;
    @Convert(converter = LocalDateConverter.class)
    private LocalDate start;
    @Convert(converter = LocalDateConverter.class)
    private LocalDate end;
    private Boolean isApproved;
    private Boolean isPaid;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Vacation(LocalDate start, LocalDate end, Boolean isApproved, Boolean isPaid, Employee employee) {
        this.start = start;
        this.end = end;
        this.isApproved = isApproved;
        this.isPaid = isPaid;
        this.employee = employee;
    }

    public Vacation() {
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public Boolean getApproved() {
        return isApproved;
    }

    public void setApproved(Boolean approved) {
        isApproved = approved;
    }

    public Boolean getPaid() {
        return isPaid;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public void update(IVacation vacation) {
        IVacation.merge(this, vacation);
    }

    @Override
    public void setId(Long id){
        this.id = id;
    }
    @Override
    public Long getId() {
        return id;
    }
}
