package com.aditya.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aditya.springdemo.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Employee> getEmployees() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query ... sort by last name
		Query<Employee> theQuery = currentSession.createQuery("from Employee order by id", Employee.class);

		// execute query and get result list
		List<Employee> Employees = theQuery.getResultList();

		// return the results
		return Employees;
	}

	@Override
	@Transactional
	public void saveEmployee(Employee theEmployee) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save/upate the Employee ... finally LOL
		currentSession.saveOrUpdate(theEmployee);

	}

	@Override
	@Transactional
	public Employee getEmployee(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using the primary key
		Employee theEmployee = currentSession.get(Employee.class, theId);

		return theEmployee;
	}

	@Override
	@Transactional
	public void deleteEmployee(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Employee where id=:EmployeeId");
		theQuery.setParameter("EmployeeId", theId);

		theQuery.executeUpdate();
	}

	@Override
	@Transactional
	public List<Employee> getEmployeeByLoginId(String theLoginId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query ... sort by last name
		Query<Employee> theQuery = currentSession.createQuery("from Employee where loginid=:theLoginId", Employee.class);
		theQuery.setParameter("theLoginId", theLoginId);

		// execute query and get result list
		List<Employee> Employees = theQuery.getResultList();

		// return the results
		return Employees;
	}

}
