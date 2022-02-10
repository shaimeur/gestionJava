package com.shaimeur.dao;

import com.shaimeur.entities.Admin;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class AdminDaoImpl implements AdminDao {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");


    @Override
    public Admin add(Admin admin) {
        return null;
    }

    @Override
    public Admin find(long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Admin admin = em.getReference(Admin.class, id);


        em.getTransaction().commit();
        em.close();
        return admin;
    }

    @Override
    public ArrayList<Admin> getAll() {
        return null;
    }

    @Override
    public Admin update(Admin admin) {
        return null;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }


    @Override
    public Admin findByEmail(String email) {
        try {


        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT a from Admin a where a.email = :adminEmail");
        query.setMaxResults(1);
        query.setParameter("adminEmail",email);
        Admin admin = (Admin) query.getSingleResult();

        System.out.println("admin by email :"+admin);

      //  Admin admin = (Admin) em.createQuery("SELECT e from Admin e  WHERE e.email like :email").setParameter("email", email).getResultList();


        em.getTransaction().commit();
        em.close();

        return admin;
        } catch (NoResultException e){
            return  null;
        }
    }




}

