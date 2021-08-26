/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptaptech.eproject4_RestfulAPI.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author trung
 */
@Entity
@Table(name = "Role_s")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roles.findAll", query = "SELECT r FROM Roles r"),
    @NamedQuery(name = "Roles.findByDecentralizationid", query = "SELECT r FROM Roles r WHERE r.decentralizationid = :decentralizationid"),
    @NamedQuery(name = "Roles.findByName", query = "SELECT r FROM Roles r WHERE r.name = :name"),
    @NamedQuery(name = "Roles.findByCancelOrder", query = "SELECT r FROM Roles r WHERE r.cancelOrder = :cancelOrder"),
    @NamedQuery(name = "Roles.findByCrudPrintInvoice", query = "SELECT r FROM Roles r WHERE r.crudPrintInvoice = :crudPrintInvoice"),
    @NamedQuery(name = "Roles.findByViewReport", query = "SELECT r FROM Roles r WHERE r.viewReport = :viewReport"),
    @NamedQuery(name = "Roles.findByManagerRevenueandexpenditure", query = "SELECT r FROM Roles r WHERE r.managerRevenueandexpenditure = :managerRevenueandexpenditure"),
    @NamedQuery(name = "Roles.findByManagerEmploy", query = "SELECT r FROM Roles r WHERE r.managerEmploy = :managerEmploy"),
    @NamedQuery(name = "Roles.findByManagerCustomer", query = "SELECT r FROM Roles r WHERE r.managerCustomer = :managerCustomer"),
    @NamedQuery(name = "Roles.findByRoleid", query = "SELECT r FROM Roles r WHERE r.roleid = :roleid")})
public class Roles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "decentralizationid")
    @Id
    private int decentralizationid;
    @Column(name = "name")
    private String name;
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
    @Basic(optional = false)
    @Column(name = "roleid")
    private int roleid;

    public Roles() {
    }

    public int getDecentralizationid() {
        return decentralizationid;
    }

    public void setDecentralizationid(int decentralizationid) {
        this.decentralizationid = decentralizationid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }
    
}
