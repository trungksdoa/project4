/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.eproject4;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "Dinner_Table")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DinnerTable.findAll", query = "SELECT d FROM DinnerTable d"),
    @NamedQuery(name = "DinnerTable.findByDeskCode", query = "SELECT d FROM DinnerTable d WHERE d.deskCode = :deskCode"),
    @NamedQuery(name = "DinnerTable.findByDeskName", query = "SELECT d FROM DinnerTable d WHERE d.deskName = :deskName")})
public class DinnerTable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "desk_code")
    private Integer deskCode;
    @Column(name = "desk_name")
    private String deskName;
    @OneToMany(mappedBy = "deskCode")
    private Collection<Assignwork> assignworkCollection;
    @OneToMany(mappedBy = "deskCode")
    private Collection<Invoice> invoiceCollection;
    @OneToMany(mappedBy = "deskCode")
    private Collection<Seats> seatsCollection;

    public DinnerTable() {
    }

    public DinnerTable(Integer deskCode) {
        this.deskCode = deskCode;
    }

    public Integer getDeskCode() {
        return deskCode;
    }

    public void setDeskCode(Integer deskCode) {
        this.deskCode = deskCode;
    }

    public String getDeskName() {
        return deskName;
    }

    public void setDeskName(String deskName) {
        this.deskName = deskName;
    }

    @XmlTransient
    public Collection<Assignwork> getAssignworkCollection() {
        return assignworkCollection;
    }

    public void setAssignworkCollection(Collection<Assignwork> assignworkCollection) {
        this.assignworkCollection = assignworkCollection;
    }

    @XmlTransient
    public Collection<Invoice> getInvoiceCollection() {
        return invoiceCollection;
    }

    public void setInvoiceCollection(Collection<Invoice> invoiceCollection) {
        this.invoiceCollection = invoiceCollection;
    }

    @XmlTransient
    public Collection<Seats> getSeatsCollection() {
        return seatsCollection;
    }

    public void setSeatsCollection(Collection<Seats> seatsCollection) {
        this.seatsCollection = seatsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deskCode != null ? deskCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DinnerTable)) {
            return false;
        }
        DinnerTable other = (DinnerTable) object;
        if ((this.deskCode == null && other.deskCode != null) || (this.deskCode != null && !this.deskCode.equals(other.deskCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fptaptech.eproject4_RestfulAPI.model.DinnerTable[ deskCode=" + deskCode + " ]";
    }
    
}
