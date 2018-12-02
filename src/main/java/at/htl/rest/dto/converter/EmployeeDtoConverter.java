package at.htl.rest.dto.converter;

import at.htl.database.dao.AbstractCrudDao;
import at.htl.database.dao.EmployeeDao;
import at.htl.database.dao.TeamDao;
import at.htl.database.entity.Employee;
import at.htl.database.entity.contract.IEmployee;
import at.htl.rest.dto.EmployeeDto;

public class EmployeeDtoConverter extends AbstractDtoConverter<Employee, EmployeeDto, IEmployee> {
    private EmployeeDao employeeDao;
    private TeamDao teamDao;

    public EmployeeDtoConverter(EmployeeDao employeeDao, TeamDao teamDao) {
        this.employeeDao = employeeDao;
        this.teamDao = teamDao;
    }

    @Override
    protected AbstractCrudDao<Employee> getDao() {
        return employeeDao;
    }

    @Override
    protected Class<Employee> getEntityClass() {
        return Employee.class;
    }

    @Override
    protected Class<EmployeeDto> getEntityDtoClass() {
        return EmployeeDto.class;
    }

    @Override
    protected void updateEntity(IEmployee e1, IEmployee e2) {
        IEmployee.merge(e1, e2);
    }

    @Override
    public EmployeeDto toDto(Employee entity) {
        EmployeeDto e = super.toDto(entity);

        if(entity.getTeam() != null)
            e.setTeamId(entity.getTeam().getId());

        return e;
    }

    @Override
    public Employee toEntity(EmployeeDto employeeDto) {
        Employee e = super.toEntity(employeeDto);

        if(employeeDto.getTeamId() != null)
            e.setTeam(teamDao.findById(employeeDto.getTeamId()));

        return e;
    }
}
