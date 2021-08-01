/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.eproject4;

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
@Table(name = "Assign_work")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Assignwork.findAll", query = "SELECT a FROM Assignwork a"),
    @NamedQuery(name = "Assignwork.findByCode", query = "SELECT a FROM Assignwork a WHERE a.code = :code"),
    @NamedQuery(name = "Assignwork.findByAssignmentDate", query = "SELECT a FROM Assignwork a WHERE a.assignmentDate = :assignmentDate"),
    @NamedQuery(name = "Assignwork.findByShift", query = "SELECT a FROM Assignwork a WHERE a.shift = :shift"),
    @NamedQuery(name = "Assignwork.findByStaffCode", query = "SELECT a FROM Assignwork a WHERE a.staffCode = :staffCode")})
public class Assignwork implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "code")
    private Integer code;
    @Column(name = "assignment_date")
    private String assignmentDate;
    @Column(name = "shift")
    private Integer shift;
    @Column(name = "staff_code")
    private String staffCode;
    @JoinColumn(name = "desk_code", referencedColumnName = "desk_code")
    @ManyToOne
    @JsonIgnore
    private DinnerTable deskCode;

    public Assignwork() {
    }

    public Assignwork(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getAssignmentDate() {
        return assignmentDate;
    }

    public void setAssignmentDate(String assignmentDate) {
        this.assignmentDate = assignmentDate;
    }

    public Integer getShift() {
        return shift;
    }

    public void setShift(Integer shift) {
        this.shift = shift;
    }

    public String getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
    }

    public DinnerTable getDeskCode() {
        return deskCode;
    }

    public void setDeskCode(DinnerTable deskCode) {
        this.deskCode = deskCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Assignwork)) {
            return false;
        }
        Assignwork other = (Assignwork) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fptaptech.eproject4_RestfulAPI.model.Assignwork[ code=" + code + " ]";
    }
    
}
