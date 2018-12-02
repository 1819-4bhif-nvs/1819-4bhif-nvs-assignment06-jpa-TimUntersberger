package at.htl.database.entity.contract;

import java.time.LocalDate;

public interface IEmployee extends IEntity<IEmployee> {
    void setFirstName(String firstName);
    String getFirstName();
    void setLastName(String lastName);
    String getLastName();
    void setBirthday(LocalDate birthday);
    LocalDate getBirthday();
    void setSalary(Float salary);
    Float getSalary();

    static void merge(IEmployee e1, IEmployee e2){
        if(e2.getFirstName() != null)
            e1.setFirstName(e2.getFirstName());
        if(e2.getLastName() != null)
            e1.setLastName(e2.getLastName());
        if(e2.getBirthday() != null)
            e1.setBirthday(e2.getBirthday());
        if(e2.getSalary() != null)
            e1.setSalary(e2.getSalary());
    }
}
