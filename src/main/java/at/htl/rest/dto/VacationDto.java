package at.htl.rest.dto;

import at.htl.database.entity.contract.IVacation;
import at.htl.database.entity.Vacation;

import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@XmlRootElement
public class VacationDto implements IVacation {
    private Long id;
    private LocalDate start;
    private LocalDate end;
    private Boolean isPaid;
    private Boolean isApproved;
    private Long employeeId;

    public VacationDto() {
    }

    public VacationDto(Long id, LocalDate start, LocalDate end, Boolean isPaid, Boolean isApproved) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.isPaid = isPaid;
        this.isApproved = isApproved;
    }

    @Override
    public void update(IVacation vacation) {
        IVacation.merge(this, vacation);
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public LocalDate getStart() {
        return start;
    }

    @Override
    public void setStart(LocalDate start) {
        this.start = start;
    }

    @Override
    public LocalDate getEnd() {
        return end;
    }

    @Override
    public void setEnd(LocalDate end) {
        this.end = end;
    }

    @Override
    public Boolean getPaid() {
        return isPaid;
    }

    @Override
    public void setPaid(Boolean paid) {
        isPaid = paid;
    }

    @Override
    public Boolean getApproved() {
        return isApproved;
    }

    @Override
    public void setApproved(Boolean approved) {
        isApproved = approved;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
}
