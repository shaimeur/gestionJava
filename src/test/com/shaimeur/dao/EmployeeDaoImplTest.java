package com.shaimeur.dao;

import com.shaimeur.entities.Employee;
import junit.framework.TestCase;

public class EmployeeDaoImplTest extends TestCase {

    public void testAdd() {
        Employee employee = new Employee();
        employee.setFirstName("saad");
        employee.setLastName("Haimeur");
        employee.setEmail("haimeursaad@gmail.com");
        employee.setPassword("password");

    }

    public void testFind() {
    }

    public void testGetAll() {
    }

    public void testUpdate() {
    }

    public void testDelete() {
    }
}