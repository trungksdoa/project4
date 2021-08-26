/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptaptech.eproject4_RestfulAPI.controller;

import com.fptaptech.eproject4_RestfulAPI.model.Decentralization;
import com.fptaptech.eproject4_RestfulAPI.model.Roles;
import com.fptaptech.eproject4_RestfulAPI.service.RolesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author trung
 */
@RestController
@RequestMapping("/api/vwRoles/")
public class ViewRoleseController {

    @Autowired
    RolesService service;

    @GetMapping
    public ResponseEntity<List<Roles>> findAll() {
        List<Roles> list = service.findALl();

        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Roles> findOne(@PathVariable int id) {
        Roles roles = service.findOneStaff(id);

        if (roles == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @PostMapping("update")
    public ResponseEntity<Roles> Update(@RequestBody Roles roles) {
        Roles rolessd = service.findOneStaff(roles.getRoleid());
        if (rolessd == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            service.Update(roles);
            return new ResponseEntity<>(roles, HttpStatus.OK);
        }

    }
}
