package at.htl.rest.dto.converter;

import at.htl.database.dao.AbstractCrudDao;
import at.htl.database.dao.EmployeeDao;
import at.htl.database.dao.VacationDao;
import at.htl.database.entity.contract.IVacation;
import at.htl.database.entity.Vacation;
import at.htl.rest.dto.VacationDto;

public class VacationDtoConverter extends AbstractDtoConverter<Vacation, VacationDto, IVacation> {
    VacationDao vacationDao;
    EmployeeDao employeeDao;

    public VacationDtoConverter(VacationDao vacationDao, EmployeeDao employeeDao) {
        this.vacationDao = vacationDao;
        this.employeeDao = employeeDao;
    }

    @Override
    protected AbstractCrudDao<Vacation> getDao() {
        return vacationDao;
    }

    @Override
    protected Class<Vacation> getEntityClass() {
        return Vacation.class;
    }

    @Override
    protected Class<VacationDto> getEntityDtoClass() {
        return VacationDto.class;
    }

    @Override
    protected void updateEntity(IVacation e1, IVacation e2) {
        IVacation.merge(e1, e2);
    }

    @Override
    public Vacation toEntity(VacationDto dto) {
        Vacation v = super.toEntity(dto);

        if(dto.getEmployeeId() != null)
            v.setEmployee(employeeDao.findById(dto.getId()));

        return v;
    }

    @Override
    public VacationDto toDto(Vacation entity) {
        VacationDto dto = super.toDto(entity);

        if(entity.getEmployee() != null)
            dto.setEmployeeId(entity.getEmployee().getId());

        return dto;
    }
}
