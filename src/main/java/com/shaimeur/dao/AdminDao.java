package com.shaimeur.dao;

import com.shaimeur.entities.Admin;

import java.util.ArrayList;
import java.util.List;

public interface AdminDao {
    Admin add(Admin admin);
    Admin find(long id);
    ArrayList<Admin> getAll();
    Admin update(Admin admin);
    boolean delete(long id);
    Admin findByEmail(String email);

}
