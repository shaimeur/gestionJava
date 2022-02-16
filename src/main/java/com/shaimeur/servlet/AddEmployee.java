package com.shaimeur.servlet;

import com.shaimeur.dao.AdminDaoImpl;
import com.shaimeur.dao.EmployeeDao;
import com.shaimeur.dao.EmployeeDaoImpl;
import com.shaimeur.entities.Admin;
import com.shaimeur.entities.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet({"/AddEmployee"})
public class AddEmployee extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/WEB-INF/AddEmployee.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String password = req.getParameter("password");

        if ((email == null) || (password == null) || (firstName == null) || (lastName == null) ){
            resp.sendRedirect("AddEmployee");
        }else {

            EmployeeDao employeeDao = new EmployeeDaoImpl();

            Employee employee = new Employee();
            employee.setEmail(email);
            employee.setFirstName(firstName);
            employee.setLastName(lastName);
            employee.setPassword(password);
            employeeDao.add(employee);

            resp.sendRedirect(req.getContextPath() + "/Dashboard");
        }








    }
}
