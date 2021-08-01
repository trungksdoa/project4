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
@Table(name = "Menu_Type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MenuType.findAll", query = "SELECT m FROM MenuType m"),
    @NamedQuery(name = "MenuType.findByTypeCode", query = "SELECT m FROM MenuType m WHERE m.typeCode = :typeCode"),
    @NamedQuery(name = "MenuType.findByGroupMenu", query = "SELECT m FROM MenuType m WHERE m.groupMenu = :groupMenu"),
    @NamedQuery(name = "MenuType.findByTypeName", query = "SELECT m FROM MenuType m WHERE m.typeName = :typeName")})
public class MenuType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "type_code")
    private String typeCode;
    @Column(name = "group_menu")
    private String groupMenu;
    @Column(name = "type_name")
    private String typeName;
    @OneToMany(mappedBy = "typeCode")
    private Collection<Menu> menuCollection;

    public MenuType() {
    }

    public MenuType(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getGroupMenu() {
        return groupMenu;
    }

    public void setGroupMenu(String groupMenu) {
        this.groupMenu = groupMenu;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @XmlTransient
    public Collection<Menu> getMenuCollection() {
        return menuCollection;
    }

    public void setMenuCollection(Collection<Menu> menuCollection) {
        this.menuCollection = menuCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (typeCode != null ? typeCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MenuType)) {
            return false;
        }
        MenuType other = (MenuType) object;
        if ((this.typeCode == null && other.typeCode != null) || (this.typeCode != null && !this.typeCode.equals(other.typeCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fptaptech.eproject4_RestfulAPI.model.MenuType[ typeCode=" + typeCode + " ]";
    }
    
}
