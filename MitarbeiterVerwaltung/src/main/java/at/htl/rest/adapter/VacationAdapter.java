package at.htl.rest.adapter;

import at.htl.database.dao.EmployeeDao;
import at.htl.database.entity.Vacation;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import java.time.LocalDate;

@Stateless
public class VacationAdapter extends AbstractAdapter<Vacation>{
    @Inject
    EmployeeDao employeeDao;

    @Override
    public JsonObject marshall(Vacation entity) {
        return Json.createObjectBuilder()
                .add("id", entity.getId())
                .add("startDate", entity.getStartDate().toString())
                .add("endDate", entity.getEndDate().toString())
                .add("employee_id", entity.getEmployee().getId())
                .build();
    }

    @Override
    public Vacation unmarshall(JsonObject json) {
        Vacation vacation = new Vacation();

        vacation.setStartDate(LocalDate.parse(json.getString("startDate")));
        vacation.setEndDate(LocalDate.parse(json.getString("endDate")));
        vacation.setEmployee(employeeDao.findById((long) json.getInt("employee_id")));

        return vacation;
    }
}
