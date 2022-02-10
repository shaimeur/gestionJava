package com.shaimeur.servlet;

import com.shaimeur.dao.AdminDaoImpl;
import com.shaimeur.entities.Admin;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/WEB-INF/Login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
            AdminDaoImpl adminDao = new AdminDaoImpl();
            Admin admin = adminDao.findByEmail(email);
            if (admin != null && admin.getPassword().equals(password)){

                HttpSession session = req.getSession();

                session.setAttribute("isLoggedIn",true);

                session.setAttribute("email",email);
                session.setAttribute("password",password);

                resp.sendRedirect("Dashboard");
            }else {
                resp.sendRedirect("Login/error=true");
            }



       /*
        if ("admin@email.com".equalsIgnoreCase(email) && "123".equalsIgnoreCase(password)){
            HttpSession session = req.getSession();
            session.setAttribute("isLoggedIn",true);

            session.setAttribute("email",email);
            session.setAttribute("password",password);
            resp.sendRedirect("Dashboard");
        }else {
            resp.sendRedirect("Login/error=true");
        }*/
    }
}
