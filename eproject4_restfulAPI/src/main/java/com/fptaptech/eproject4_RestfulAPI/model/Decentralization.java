/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptaptech.eproject4_RestfulAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author trung
 */
@Entity
@Table(name = "decentralization")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Decentralization.findAll", query = "SELECT d FROM Decentralization d"),
    @NamedQuery(name = "Decentralization.findById", query = "SELECT d FROM Decentralization d WHERE d.id = :id"),
    @NamedQuery(name = "Decentralization.findByCancelOrder", query = "SELECT d FROM Decentralization d WHERE d.cancelOrder = :cancelOrder"),
    @NamedQuery(name = "Decentralization.findByCrudPrintInvoice", query = "SELECT d FROM Decentralization d WHERE d.crudPrintInvoice = :crudPrintInvoice"),
    @NamedQuery(name = "Decentralization.findByViewReport", query = "SELECT d FROM Decentralization d WHERE d.viewReport = :viewReport"),
    @NamedQuery(name = "Decentralization.findByManagerRevenueandexpenditure", query = "SELECT d FROM Decentralization d WHERE d.managerRevenueandexpenditure = :managerRevenueandexpenditure"),
    @NamedQuery(name = "Decentralization.findByManagerEmploy", query = "SELECT d FROM Decentralization d WHERE d.managerEmploy = :managerEmploy"),
    @NamedQuery(name = "Decentralization.findByManagerCustomer", query = "SELECT d FROM Decentralization d WHERE d.managerCustomer = :managerCustomer")})
public class Decentralization implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "cancel_order")
    private Boolean cancelOrder;
    @Column(name = "crud_print_invoice")
    private Boolean crudPrintInvoice;
    @Column(name = "view_report")
    private Boolean viewReport;
    @Column(name = "manager_revenueandexpenditure")
    private Boolean managerRevenueandexpenditure;
    @Column(name = "manager_employ")
    private Boolean managerEmploy;
    @Column(name = "manager_customer")
    private Boolean managerCustomer;
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    @ManyToOne
    @JsonIgnore
    private Role roleId;

    public Decentralization() {
    }

    public Decentralization(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getCancelOrder() {
        return cancelOrder;
    }

    public void setCancelOrder(Boolean cancelOrder) {
        this.cancelOrder = cancelOrder;
    }

    public Boolean getCrudPrintInvoice() {
        return crudPrintInvoice;
    }

    public void setCrudPrintInvoice(Boolean crudPrintInvoice) {
        this.crudPrintInvoice = crudPrintInvoice;
    }

    public Boolean getViewReport() {
        return viewReport;
    }

    public void setViewReport(Boolean viewReport) {
        this.viewReport = viewReport;
    }

    public Boolean getManagerRevenueandexpenditure() {
        return managerRevenueandexpenditure;
    }

    public void setManagerRevenueandexpenditure(Boolean managerRevenueandexpenditure) {
        this.managerRevenueandexpenditure = managerRevenueandexpenditure;
    }

    public Boolean getManagerEmploy() {
        return managerEmploy;
    }

    public void setManagerEmploy(Boolean managerEmploy) {
        this.managerEmploy = managerEmploy;
    }

    public Boolean getManagerCustomer() {
        return managerCustomer;
    }

    public void setManagerCustomer(Boolean managerCustomer) {
        this.managerCustomer = managerCustomer;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Decentralization)) {
            return false;
        }
        Decentralization other = (Decentralization) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fptaptech.eproject4_RestfulAPI.model.Decentralization[ id=" + id + " ]";
    }
    
}
