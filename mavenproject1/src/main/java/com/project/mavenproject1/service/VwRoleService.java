/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.mavenproject1.service;

import com.project.mavenproject1.model.Decentralization;
import com.project.mavenproject1.model.Roles;
import java.util.List;

/**
 *
 * @author trung
 */
public interface VwRoleService {

    public List<Roles> findAll();

    public Roles findByRoleId(int id);

    Decentralization Update(Decentralization decentralization);
}
