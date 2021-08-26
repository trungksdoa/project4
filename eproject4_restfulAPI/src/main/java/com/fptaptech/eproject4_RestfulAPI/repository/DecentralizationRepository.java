/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptaptech.eproject4_RestfulAPI.repository;

import com.fptaptech.eproject4_RestfulAPI.model.Decentralization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author trung
 */
public interface DecentralizationRepository extends JpaRepository<Decentralization, Integer> {
 
}
