/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suyojan.abbrest.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Suyojan
 */
@Entity
@Table(catalog = "abblog", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"reason_code"})})
@NamedQueries({
    @NamedQuery(name = "Failurecodes.findAll", query = "SELECT f FROM Failurecodes f")})
public class Failurecodes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "reason_code", nullable = false)
    private int reasonCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "reason_desc", nullable = false, length = 255)
    private String reasonDesc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "category_group", nullable = false, length = 45)
    private String categoryGroup;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fault_active", nullable = false)
    private short faultActive;

    public Failurecodes() {
    }

    public Failurecodes(Integer id) {
        this.id = id;
    }

    public Failurecodes(Integer id, int reasonCode, String reasonDesc, String categoryGroup, short faultActive) {
        this.id = id;
        this.reasonCode = reasonCode;
        this.reasonDesc = reasonDesc;
        this.categoryGroup = categoryGroup;
        this.faultActive = faultActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(int reasonCode) {
        this.reasonCode = reasonCode;
    }

    public String getReasonDesc() {
        return reasonDesc;
    }

    public void setReasonDesc(String reasonDesc) {
        this.reasonDesc = reasonDesc;
    }

    public String getCategoryGroup() {
        return categoryGroup;
    }

    public void setCategoryGroup(String categoryGroup) {
        this.categoryGroup = categoryGroup;
    }

    public short getFaultActive() {
        return faultActive;
    }

    public void setFaultActive(short faultActive) {
        this.faultActive = faultActive;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Failurecodes)) {
            return false;
        }
        Failurecodes other = (Failurecodes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.suyojan.abbrest.Failurecodes[ id=" + id + " ]";
    }
    
}
