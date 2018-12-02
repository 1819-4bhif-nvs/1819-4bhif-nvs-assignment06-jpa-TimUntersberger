package at.htl.rest.endpoint;

import at.htl.database.dao.EmployeeDao;
import at.htl.database.dao.ICrudDao;
import at.htl.database.dao.VacationDao;
import at.htl.database.entity.contract.IVacation;
import at.htl.database.entity.Vacation;
import at.htl.rest.dto.VacationDto;
import at.htl.rest.dto.converter.VacationDtoConverter;

import javax.inject.Inject;

public class VacationEndpoint extends AbstractCrudEndpoint<Vacation, VacationDto, IVacation, VacationDtoConverter>{

    @Inject
    VacationDao vacationDao;

    @Inject
    EmployeeDao employeeDao;

    VacationDtoConverter vacationDtoConverter;

    @Override
    protected ICrudDao<Vacation> getDao() {
        return vacationDao;
    }

    @Override
    protected VacationDtoConverter getDtoConverter() {
        if(vacationDtoConverter == null)
            vacationDtoConverter = new VacationDtoConverter(vacationDao, employeeDao);
        return vacationDtoConverter;
    }
}
