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
@Table(name = "Seats")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seats.findAll", query = "SELECT s FROM Seats s"),
    @NamedQuery(name = "Seats.findBySeatCode", query = "SELECT s FROM Seats s WHERE s.seatCode = :seatCode"),
    @NamedQuery(name = "Seats.findBySeatName", query = "SELECT s FROM Seats s WHERE s.seatName = :seatName")})
public class Seats implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "seat_code")
    private Integer seatCode;
    @Column(name = "seat_name")
    private Integer seatName;
    @JoinColumn(name = "desk_code", referencedColumnName = "desk_code")
    @ManyToOne
    @JsonIgnore
    private DinnerTable deskCode;

    public Seats() {
    }

    public Seats(Integer seatCode) {
        this.seatCode = seatCode;
    }

    public Integer getSeatCode() {
        return seatCode;
    }

    public void setSeatCode(Integer seatCode) {
        this.seatCode = seatCode;
    }

    public Integer getSeatName() {
        return seatName;
    }

    public void setSeatName(Integer seatName) {
        this.seatName = seatName;
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
        hash += (seatCode != null ? seatCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seats)) {
            return false;
        }
        Seats other = (Seats) object;
        if ((this.seatCode == null && other.seatCode != null) || (this.seatCode != null && !this.seatCode.equals(other.seatCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fptaptech.eproject4_RestfulAPI.model.Seats[ seatCode=" + seatCode + " ]";
    }
    
}
