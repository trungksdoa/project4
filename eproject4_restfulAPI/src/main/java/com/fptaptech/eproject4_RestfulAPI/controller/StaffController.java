/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptaptech.eproject4_RestfulAPI.controller;

import com.fptaptech.eproject4_RestfulAPI.model.Staff;
import com.fptaptech.eproject4_RestfulAPI.service.StaffService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lenovo
 */
@RestController
@RequestMapping("/api/staff/")
public class StaffController {

    @Autowired
    StaffService service;

    @GetMapping
    public ResponseEntity<List<Staff>> findAll() {
        List<Staff> list = service.findAllStaff();

        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> findOne(@PathVariable String id) {
        Staff staff = service.findOneStaff(id);
        if (staff == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(staff, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Staff staff) {
        Staff st = service.findOneStaff(staff.getStaffCode());

        if (st == null) {
            service.saveStaff(staff);
            return new ResponseEntity<>(staff, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @PostMapping("delete")
    public ResponseEntity<Object> delete(@RequestBody Staff staff) {
        Staff st = service.findOneStaff(staff.getStaffCode());
        if (st != null) {
            service.delete(st);
            return new ResponseEntity<>(st, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @PostMapping("update")
    public ResponseEntity<Object> update(@RequestBody Staff staff) {

        Staff st = service.findOneStaff(staff.getStaffCode());
        if (st != null) {
            service.saveStaff(staff);
            return new ResponseEntity<>(staff, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("login")
    public ResponseEntity<Object> login(@ModelAttribute Staff staff) {

        Staff st = service.CheckLogin(staff.getStaffCode(),staff.getPassword());
//         System.out.println(staff);
        if (st != null) {
            System.out.println(st);
            return new ResponseEntity<>(st, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
