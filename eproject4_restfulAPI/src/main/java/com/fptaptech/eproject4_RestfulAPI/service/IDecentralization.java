/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptaptech.eproject4_RestfulAPI.service;

import com.fptaptech.eproject4_RestfulAPI.model.Decentralization;
import com.fptaptech.eproject4_RestfulAPI.model.Staff;
import java.util.List;

/**
 *
 * @author trung
 */
public interface IDecentralization {
    List<Decentralization> findAll();

    void save(Decentralization staff);

    void delete(Decentralization staff);

    Decentralization findOne(int id);

}
