package com.example.demo.dao;

import com.example.demo.entity.Employee;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import org.hibernate.query.Query;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

    // define field for entityManager
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }
    @Override
    @Transactional
    public List<Employee> findAll() {
        // get the current session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);

        // execute query and get results
        List<Employee> employees = theQuery.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);

        Employee theEmployee = currentSession.get(Employee.class, theId);

        return theEmployee;
    }

    @Override
    public void save(Employee theEmployee) {

        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(theEmployee);

    }

    @Override
    public void deleteById(int Id) {

        Session currentSession = entityManager.unwrap(Session.class);

        Query theQuery = currentSession.createQuery("delete from Employee where id=:theId");
        theQuery.setParameter("theId", Id);
        theQuery.executeUpdate();

    }
}
