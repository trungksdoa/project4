/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptaptech.eproject4_RestfulAPI.service;

import com.fptaptech.eproject4_RestfulAPI.model.Staff;
import com.fptaptech.eproject4_RestfulAPI.repository.StaffRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lenovo
 */
@Service
public class StaffServiceIpml implements StaffService {

    @Autowired
    StaffRepository repository;

    @Override
    public List<Staff> findAllStaff() {
        return repository.findAll();
    }

    @Override
    public void saveStaff(Staff staff) {
        repository.save(staff);
    }

    @Override
    public Staff findOneStaff(int id) {
        return repository.findBycode(id);
    }

    @Override
    public void delete(Staff staff) {
        repository.delete(staff);
    }

    @Override
    public Staff Checklogin(Staff staff) {
      return  repository.CheckLogin(staff);
    }

 

}
