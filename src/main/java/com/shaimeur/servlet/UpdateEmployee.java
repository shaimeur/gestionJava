package com.shaimeur.servlet;

import com.shaimeur.dao.EmployeeDao;
import com.shaimeur.dao.EmployeeDaoImpl;
import com.shaimeur.entities.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet({"/UpdateEmployee"})
public class UpdateEmployee extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        Employee e = employeeDao.find(id);
        System.out.println(e);
        req.setAttribute("employee", e);
        req.getServletContext().getRequestDispatcher("/WEB-INF/UpdateEmployee.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        String email = req.getParameter("email");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String password = req.getParameter("password");

        if ((email == null) || (password == null) || (firstName == null) || (lastName == null)   ){
            resp.sendRedirect("UpdateEmployee");
        }else {

            EmployeeDao employeeDao = new EmployeeDaoImpl();

            Employee employee = new Employee();
            employee.setId(id);
            employee.setEmail(email);
            employee.setFirstName(firstName);
            employee.setLastName(lastName);
            employee.setPassword(password);
            employeeDao.update(employee);

            resp.sendRedirect(req.getContextPath() + "/Dashboard");
        }
    }
}
