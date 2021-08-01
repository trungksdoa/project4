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
@Table(name = "Price")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Price.findAll", query = "SELECT p FROM Price p"),
    @NamedQuery(name = "Price.findByCode", query = "SELECT p FROM Price p WHERE p.code = :code"),
    @NamedQuery(name = "Price.findByApplicationCode", query = "SELECT p FROM Price p WHERE p.applicationCode = :applicationCode"),
    @NamedQuery(name = "Price.findByPrice", query = "SELECT p FROM Price p WHERE p.price = :price")})
public class Price implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "code")
    private Integer code;
    @Column(name = "application_code")
    private String applicationCode;
    @Column(name = "price")
    private Integer price;
    @JoinColumn(name = "menu_code", referencedColumnName = "menu_code")
    @ManyToOne
    @JsonIgnore
    private Menu menuCode;

    public Price() {
    }

    public Price(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getApplicationCode() {
        return applicationCode;
    }

    public void setApplicationCode(String applicationCode) {
        this.applicationCode = applicationCode;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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
        if (!(object instanceof Price)) {
            return false;
        }
        Price other = (Price) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fptaptech.eproject4_RestfulAPI.model.Price[ code=" + code + " ]";
    }
    
}
