package at.htl.database.dao;

import at.htl.database.entity.Employee;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EmployeeDao extends AbstractDao<Employee> {
    @PersistenceContext
    EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    protected Class<Employee> getEntityClass() {
        return Employee.class;
    }
}
