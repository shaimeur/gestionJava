package com.shaimeur.dao;

import com.shaimeur.entities.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
    @Override
    public Employee add(Employee employee) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Employee employee1 = new Employee(employee.getId(), employee.getEmail(), employee.getPassword(), employee.getFirstName(), employee.getLastName());
        em.persist(employee1);

        em.getTransaction().commit();
        em.close();
        return employee1 ;
    }

    @Override
    public Employee find(long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Employee employee = em.getReference(Employee.class,id);


        em.getTransaction().commit();
        em.close();
        return employee ;
    }

    @Override
    public ArrayList<Employee> getAll() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        ArrayList<Employee> employees =  new ArrayList<Employee>(em.createQuery("from  Employee ").getResultList()) ;

        em.getTransaction().commit();
        em.close();
        return employees ;
    }

    @Override
    public Employee update(Employee employee) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Employee employee1 = new Employee(employee.getId(), employee.getEmail(), employee.getPassword(), employee.getFirstName(), employee.getLastName());
        em.merge(employee1);

        em.getTransaction().commit();
        em.close();
        return employee1 ;
    }

    @Override
    public boolean delete(long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Employee employee = em.getReference(Employee.class,id);
        em.remove(employee);

        em.getTransaction().commit();
        em.close();
        return true ;
    }
}


