package com.shaimeur.dao;

import com.shaimeur.entities.Employee;

import java.util.ArrayList;
import java.util.List;

public interface EmployeeDao {
    Employee add(Employee employee);
    Employee find(long id);
    ArrayList<Employee> getAll();
    Employee update(Employee employee);
    boolean delete(Long id);
}
