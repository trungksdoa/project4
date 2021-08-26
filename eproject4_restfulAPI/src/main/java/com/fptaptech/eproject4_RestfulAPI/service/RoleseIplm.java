/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptaptech.eproject4_RestfulAPI.service;

import com.fptaptech.eproject4_RestfulAPI.model.Role;
import com.fptaptech.eproject4_RestfulAPI.model.Roles;
import com.fptaptech.eproject4_RestfulAPI.repository.RoleseRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author trung
 */
@Service
public class RoleseIplm implements RolesService {

    @Autowired
    RoleseRepository roles;

    @Override
    public List<Roles> findALl() {
        return roles.findAll();
    }

    @Override
    public Roles findOneStaff(int id) {
        Roles option = roles.findOne(id);
        return option;
    }

    @Override
    public Roles Update(Roles roless) {
       return roles.save(roless);
    }

}
