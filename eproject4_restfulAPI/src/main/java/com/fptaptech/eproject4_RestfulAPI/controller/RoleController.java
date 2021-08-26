/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptaptech.eproject4_RestfulAPI.controller;

import com.fptaptech.eproject4_RestfulAPI.model.Decentralization;
import com.fptaptech.eproject4_RestfulAPI.model.Staff;
import com.fptaptech.eproject4_RestfulAPI.service.IDecentralization;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author trung
 */
@Controller
@RequestMapping("/api/roles/")
public class RoleController {

    @Autowired
    IDecentralization service;

    @GetMapping
    public ResponseEntity<List<Decentralization>> findAll() {
        List<Decentralization> list = service.findAll();

        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> findOne(@PathVariable int id) {
        Decentralization staff = service.findOne(id);
        if (staff == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(staff, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Decentralization staff) {
        Decentralization st = service.findOne(staff.getId());

        if (st == null) {
            service.save(staff);
            return new ResponseEntity<>(staff, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @DeleteMapping("delete")
    public ResponseEntity<Object> delete(@RequestBody Decentralization staff) {
        Decentralization st = service.findOne(staff.getId());
        if (st != null) {
            service.delete(st);
            return new ResponseEntity<>(st, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @PutMapping("update/")
    public ResponseEntity<Decentralization> update(@RequestBody Decentralization staff) {
//        
        Decentralization st = service.findOne(staff.getId());
        if (st != null) {
            staff.setRoleId(st.getRoleId());
            service.save(staff);
            return new ResponseEntity<>(staff, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
