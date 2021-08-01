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
@Table(name = "Detail_Invoice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetailInvoice.findAll", query = "SELECT d FROM DetailInvoice d"),
    @NamedQuery(name = "DetailInvoice.findByCode", query = "SELECT d FROM DetailInvoice d WHERE d.code = :code"),
    @NamedQuery(name = "DetailInvoice.findByQuantity", query = "SELECT d FROM DetailInvoice d WHERE d.quantity = :quantity")})
public class DetailInvoice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "code")
    private Integer code;
    @Column(name = "quantity")
    private Integer quantity;
    @JoinColumn(name = "invoice_code", referencedColumnName = "invoice_code")
    @ManyToOne
    @JsonIgnore
    private Invoice invoiceCode;
    @JoinColumn(name = "menu_code", referencedColumnName = "menu_code")
    @ManyToOne
    @JsonIgnore
    private Menu menuCode;

    public DetailInvoice() {
    }

    public DetailInvoice(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Invoice getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(Invoice invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public Menu getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(Menu menuCode) {
        this.menuCode = menuCode;
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
        if (!(object instanceof DetailInvoice)) {
            return false;
        }
        DetailInvoice other = (DetailInvoice) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fptaptech.eproject4_RestfulAPI.model.DetailInvoice[ code=" + code + " ]";
    }
    
}
