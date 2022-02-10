package com.shaimeur.servlet;

import com.shaimeur.entities.Admin;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet({"/Dashboard"})
public class Dashboard extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getServletContext().getRequestDispatcher("/WEB-INF/Dashboard.jsp").forward(req,resp);
        HttpSession session = req.getSession();
        session.setAttribute("isLoggedIn",true);
        Admin admin = (Admin) session.getAttribute(("admin"));
        if (admin != null){
            System.out.println(admin.getEmail() +" " + admin.getPassword() );

        }else {
            System.out.println("no user session attributed!!");
        }
    }

}
