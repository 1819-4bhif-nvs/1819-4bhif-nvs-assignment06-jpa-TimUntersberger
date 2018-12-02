package at.htl.rest.endpoint;

import at.htl.database.dao.ICrudDao;
import at.htl.database.dao.EmployeeDao;
import at.htl.database.dao.TeamDao;
import at.htl.database.entity.Employee;
import at.htl.database.entity.contract.IEmployee;
import at.htl.rest.dto.EmployeeDto;
import at.htl.rest.dto.converter.EmployeeDtoConverter;

import javax.inject.Inject;
import javax.interceptor.ExcludeClassInterceptors;
import javax.ws.rs.Path;

@Path("employee")
public class EmployeeEndpoint extends AbstractCrudEndpoint<Employee, EmployeeDto, IEmployee, EmployeeDtoConverter> {

    @Inject
    EmployeeDao employeeDao;

    @Inject
    TeamDao teamDao;

    EmployeeDtoConverter employeeDtoConverter;

    @Override
    protected ICrudDao<Employee> getDao() {
        return employeeDao;
    }

    @Override
    protected EmployeeDtoConverter getDtoConverter() {
        if(employeeDtoConverter == null)
            employeeDtoConverter = new EmployeeDtoConverter(employeeDao, teamDao);

        return employeeDtoConverter;
    }
}
