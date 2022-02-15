package com.shaimeur.servlet;

import com.shaimeur.dao.EmployeeDao;
import com.shaimeur.dao.EmployeeDaoImpl;
import com.shaimeur.entities.Admin;
import com.shaimeur.entities.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet({"/Dashboard"})
public class Dashboard extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        EmployeeDao employeeDao = new EmployeeDaoImpl();
        List<Employee> employees = employeeDao.getAll();
        req.setAttribute("employees", employees);
        req.getServletContext().getRequestDispatcher("/WEB-INF/Dashboard.jsp").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath()+"/AddEmployee");
    }
}
