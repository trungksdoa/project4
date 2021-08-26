/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptaptech.eproject4_RestfulAPI.repository;

import com.fptaptech.eproject4_RestfulAPI.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author trung
 */
public interface RoleseRepository extends JpaRepository<Roles, Integer> {

    @Query("SELECT r FROM Roles r WHERE r.roleid = :roleid")
    Roles findOne(@PathVariable("roleid") int roleid);
}
