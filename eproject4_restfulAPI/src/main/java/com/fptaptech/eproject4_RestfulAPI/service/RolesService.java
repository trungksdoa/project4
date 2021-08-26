/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptaptech.eproject4_RestfulAPI.service;

import com.fptaptech.eproject4_RestfulAPI.model.Roles;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author trung
 */
public interface RolesService {
    List<Roles> findALl();
    
    Roles Update(Roles roles);
    Roles findOneStaff(int id);
}
