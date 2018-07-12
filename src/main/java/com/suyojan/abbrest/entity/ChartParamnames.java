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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Suyojan
 */
@Entity
@Table(name = "chart_paramnames", catalog = "abblog", schema = "")
@NamedQueries({
    @NamedQuery(name = "ChartParamnames.findAll", query = "SELECT c FROM ChartParamnames c")})
public class ChartParamnames implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Size(max = 50)
    @Column(name = "chart_param_index", length = 50)
    private String chartParamIndex;
    @Size(max = 50)
    @Column(name = "chart_param_name", length = 50)
    private String chartParamName;
    @JoinColumn(name = "chart_type_no", referencedColumnName = "id")
    @ManyToOne
    private ChartType chartTypeNo;

    public ChartParamnames() {
    }

    public ChartParamnames(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChartParamIndex() {
        return chartParamIndex;
    }

    public void setChartParamIndex(String chartParamIndex) {
        this.chartParamIndex = chartParamIndex;
    }

    public String getChartParamName() {
        return chartParamName;
    }

    public void setChartParamName(String chartParamName) {
        this.chartParamName = chartParamName;
    }

    public ChartType getChartTypeNo() {
        return chartTypeNo;
    }

    public void setChartTypeNo(ChartType chartTypeNo) {
        this.chartTypeNo = chartTypeNo;
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
        if (!(object instanceof ChartParamnames)) {
            return false;
        }
        ChartParamnames other = (ChartParamnames) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.suyojan.abbrest.ChartParamnames[ id=" + id + " ]";
    }
    
}
