/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptaptech.eproject4_RestfulAPI.service;

import com.fptaptech.eproject4_RestfulAPI.model.Staff;
import java.util.List;

/**
 *
 * @author lenovo
 */
public interface StaffService {
    
    List<Staff>findAllStaff();
    void  saveStaff(Staff staff);
    void  delete(Staff staff);
    Staff findOneStaff(String id);
    
    Staff CheckLogin(String Code,String password);
}
