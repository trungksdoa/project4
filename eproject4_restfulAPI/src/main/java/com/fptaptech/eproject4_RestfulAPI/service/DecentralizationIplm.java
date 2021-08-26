/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptaptech.eproject4_RestfulAPI.service;

import com.fptaptech.eproject4_RestfulAPI.model.Decentralization;
import com.fptaptech.eproject4_RestfulAPI.model.Staff;
import com.fptaptech.eproject4_RestfulAPI.repository.DecentralizationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author trung
 */
@Service
public class DecentralizationIplm implements IDecentralization {

    @Autowired
    DecentralizationRepository servic;

    @Override
    public List<Decentralization> findAll() {
        return servic.findAll();
    }

    @Override
    public void save(Decentralization staff) {
        servic.save(staff);
    }

    @Override
    public void delete(Decentralization staff) {
        servic.delete(staff);
    }

    @Override
    public Decentralization findOne(int id) {
        Optional<Decentralization> option = servic.findById(id);
        Decentralization object = option.get();
        return object;
    }

}
