/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suyojan.abbrest.entity;

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
import javax.validation.constraints.Size;

/**
 *
 * @author Suyojan
 */
@Entity
@Table(name = "chart_type", catalog = "abblog", schema = "")
@NamedQueries({
    @NamedQuery(name = "ChartType.findAll", query = "SELECT c FROM ChartType c")})
public class ChartType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Size(max = 50)
    @Column(name = "chart_name", length = 50)
    private String chartName;
    @OneToMany(mappedBy = "chartTypeNo")
    private Collection<ChartParamnames> chartParamnamesCollection;

    public ChartType() {
    }

    public ChartType(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChartName() {
        return chartName;
    }

    public void setChartName(String chartName) {
        this.chartName = chartName;
    }

    public Collection<ChartParamnames> getChartParamnamesCollection() {
        return chartParamnamesCollection;
    }

    public void setChartParamnamesCollection(Collection<ChartParamnames> chartParamnamesCollection) {
        this.chartParamnamesCollection = chartParamnamesCollection;
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
        if (!(object instanceof ChartType)) {
            return false;
        }
        ChartType other = (ChartType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.suyojan.abbrest.ChartType[ id=" + id + " ]";
    }
    
}
