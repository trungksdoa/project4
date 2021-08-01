/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fptaptech.eproject4_RestfulAPI.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author trung
 */
@Entity
@Table(name = "Staff", catalog = "coffee_man", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Staff.findAll", query = "SELECT s FROM Staff s"),
    @NamedQuery(name = "Staff.findByStaffCode", query = "SELECT s FROM Staff s WHERE s.staffCode = :staffCode"),
    @NamedQuery(name = "Staff.findByFullName", query = "SELECT s FROM Staff s WHERE s.fullName = :fullName"),
    @NamedQuery(name = "Staff.findByBirthDay", query = "SELECT s FROM Staff s WHERE s.birthDay = :birthDay"),
    @NamedQuery(name = "Staff.findByUsername", query = "SELECT s FROM Staff s WHERE s.username = :username"),
    @NamedQuery(name = "Staff.findByPassword", query = "SELECT s FROM Staff s WHERE s.password = :password"),
    @NamedQuery(name = "Staff.findByRole", query = "SELECT s FROM Staff s WHERE s.role = :role")})
public class Staff implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "staff_code", nullable = false, length = 20)
    private String staffCode;
    @Column(name = "full_name", length = 50)
    private String fullName;
    @Column(name = "birth_day", length = 20)
    private String birthDay;
    @Column(name = "username", length = 20)
    private String username;
    @Column(name = "password", length = 20)
    private String password;
    @Column(name = "role")
    private Boolean role;
    @OneToMany(mappedBy = "staffId")
    private Collection<Decentralization> decentralizationCollection;

    public Staff() {
    }

    public Staff(String staffCode) {
        this.staffCode = staffCode;
    }

    public String getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getRole() {
        return role;
    }

    public void setRole(Boolean role) {
        this.role = role;
    }

    @XmlTransient
    public Collection<Decentralization> getDecentralizationCollection() {
        return decentralizationCollection;
    }

    public void setDecentralizationCollection(Collection<Decentralization> decentralizationCollection) {
        this.decentralizationCollection = decentralizationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (staffCode != null ? staffCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Staff)) {
            return false;
        }
        Staff other = (Staff) object;
        if ((this.staffCode == null && other.staffCode != null) || (this.staffCode != null && !this.staffCode.equals(other.staffCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fptaptech.eproject4_RestfulAPI.model.Staff[ staffCode=" + staffCode + " ]";
    }
    
}
