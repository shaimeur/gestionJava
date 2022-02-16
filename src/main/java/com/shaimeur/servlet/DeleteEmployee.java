package com.shaimeur.servlet;

import com.shaimeur.dao.EmployeeDao;
import com.shaimeur.dao.EmployeeDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet({"/DeleteEmployee"})
public class DeleteEmployee extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        System.out.println(id);
        EmployeeDao employeeDao = new EmployeeDaoImpl() ;
        employeeDao.delete(id);
        resp.sendRedirect("Dashboard");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
