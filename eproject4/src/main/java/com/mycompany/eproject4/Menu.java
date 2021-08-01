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
@Table(name = "Menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m"),
    @NamedQuery(name = "Menu.findByMenuCode", query = "SELECT m FROM Menu m WHERE m.menuCode = :menuCode"),
    @NamedQuery(name = "Menu.findByName", query = "SELECT m FROM Menu m WHERE m.name = :name"),
    @NamedQuery(name = "Menu.findByUnit", query = "SELECT m FROM Menu m WHERE m.unit = :unit")})
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "menu_code")
    private String menuCode;
    @Column(name = "name")
    private String name;
    @Column(name = "unit")
    private String unit;
    @OneToMany(mappedBy = "menuCode")
    private Collection<DetailInvoice> detailInvoiceCollection;
    @OneToMany(mappedBy = "menuCode")
    private Collection<Price> priceCollection;
    @JoinColumn(name = "type_code", referencedColumnName = "type_code")
    @ManyToOne
    @JsonIgnore
    private MenuType typeCode;

    public Menu() {
    }

    public Menu(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @XmlTransient
    public Collection<DetailInvoice> getDetailInvoiceCollection() {
        return detailInvoiceCollection;
    }

    public void setDetailInvoiceCollection(Collection<DetailInvoice> detailInvoiceCollection) {
        this.detailInvoiceCollection = detailInvoiceCollection;
    }

    @XmlTransient
    public Collection<Price> getPriceCollection() {
        return priceCollection;
    }

    public void setPriceCollection(Collection<Price> priceCollection) {
        this.priceCollection = priceCollection;
    }

    public MenuType getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(MenuType typeCode) {
        this.typeCode = typeCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (menuCode != null ? menuCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.menuCode == null && other.menuCode != null) || (this.menuCode != null && !this.menuCode.equals(other.menuCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fptaptech.eproject4_RestfulAPI.model.Menu[ menuCode=" + menuCode + " ]";
    }
    
}
