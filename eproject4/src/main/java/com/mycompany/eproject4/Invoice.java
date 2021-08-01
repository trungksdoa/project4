/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.eproject4;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Invoice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invoice.findAll", query = "SELECT i FROM Invoice i"),
    @NamedQuery(name = "Invoice.findByInvoiceCode", query = "SELECT i FROM Invoice i WHERE i.invoiceCode = :invoiceCode"),
    @NamedQuery(name = "Invoice.findByCreateDate", query = "SELECT i FROM Invoice i WHERE i.createDate = :createDate"),
    @NamedQuery(name = "Invoice.findByGuestNumber", query = "SELECT i FROM Invoice i WHERE i.guestNumber = :guestNumber"),
    @NamedQuery(name = "Invoice.findByTotalPrice", query = "SELECT i FROM Invoice i WHERE i.totalPrice = :totalPrice")})
public class Invoice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "invoice_code")
    private String invoiceCode;
    @Column(name = "create_date")
    private String createDate;
    @Column(name = "guest_number")
    private Integer guestNumber;
    @Column(name = "total_price")
    private Integer totalPrice;
    @OneToMany(mappedBy = "invoiceCode")
    private Collection<DetailInvoice> detailInvoiceCollection;
    @JoinColumn(name = "desk_code", referencedColumnName = "desk_code")
    @ManyToOne
    @JsonIgnore
    private DinnerTable deskCode;
    @JoinColumn(name = "staff_code", referencedColumnName = "staff_code")
    @ManyToOne
    @JsonIgnore
    private Staff staffCode;

    public Invoice() {
    }

    public Invoice(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Integer getGuestNumber() {
        return guestNumber;
    }

    public void setGuestNumber(Integer guestNumber) {
        this.guestNumber = guestNumber;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    @XmlTransient
    public Collection<DetailInvoice> getDetailInvoiceCollection() {
        return detailInvoiceCollection;
    }

    public void setDetailInvoiceCollection(Collection<DetailInvoice> detailInvoiceCollection) {
        this.detailInvoiceCollection = detailInvoiceCollection;
    }

    public DinnerTable getDeskCode() {
        return deskCode;
    }

    public void setDeskCode(DinnerTable deskCode) {
        this.deskCode = deskCode;
    }

    public Staff getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(Staff staffCode) {
        this.staffCode = staffCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invoiceCode != null ? invoiceCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invoice)) {
            return false;
        }
        Invoice other = (Invoice) object;
        if ((this.invoiceCode == null && other.invoiceCode != null) || (this.invoiceCode != null && !this.invoiceCode.equals(other.invoiceCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fptaptech.eproject4_RestfulAPI.model.Invoice[ invoiceCode=" + invoiceCode + " ]";
    }
    
}
