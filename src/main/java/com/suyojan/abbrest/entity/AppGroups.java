/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suyojan.abbrest.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Suyojan
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "AppGroups.findAll", query = "SELECT a FROM AppGroups a")})
public class AppGroups implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "app_group_name", nullable = false, length = 45)
    private String appGroupName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupId")
    private Collection<AppUserGroup> appUserGroupCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "appGroup")
    private Collection<AppGroupParams> appGroupParamsCollection;

    public AppGroups() {
    }

    public AppGroups(Integer id) {
        this.id = id;
    }

    public AppGroups(Integer id, String appGroupName) {
        this.id = id;
        this.appGroupName = appGroupName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppGroupName() {
        return appGroupName;
    }

    public void setAppGroupName(String appGroupName) {
        this.appGroupName = appGroupName;
    }

    public Collection<AppUserGroup> getAppUserGroupCollection() {
        return appUserGroupCollection;
    }

    public void setAppUserGroupCollection(Collection<AppUserGroup> appUserGroupCollection) {
        this.appUserGroupCollection = appUserGroupCollection;
    }

    public Collection<AppGroupParams> getAppGroupParamsCollection() {
        return appGroupParamsCollection;
    }

    public void setAppGroupParamsCollection(Collection<AppGroupParams> appGroupParamsCollection) {
        this.appGroupParamsCollection = appGroupParamsCollection;
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
        if (!(object instanceof AppGroups)) {
            return false;
        }
        AppGroups other = (AppGroups) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.suyojan.abbrest.AppGroups[ id=" + id + " ]";
    }
    
}
