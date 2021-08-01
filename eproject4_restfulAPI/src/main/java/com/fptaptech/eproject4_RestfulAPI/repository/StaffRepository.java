/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptaptech.eproject4_RestfulAPI.repository;

import com.fptaptech.eproject4_RestfulAPI.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author lenovo
 */
public interface StaffRepository extends JpaRepository<Staff, String> {

    @Query("SELECT s FROM Staff s WHERE s.staffCode = :staffCode")
    Staff findBycode(@PathVariable("staffCode") String staffCode);

    @Query("SELECT s FROM Staff s WHERE s.staffCode = :staffCode AND s.password = :password")
    Staff CheckLogin(@PathVariable("staffCode") String staffCode, @PathVariable("password") String password);

//    default Staff CheckLogin(Staff staffCode) {
//        return CheckLoginQuery(staffCode.getUsername(), staffCode.getPassword());
//    }

}
