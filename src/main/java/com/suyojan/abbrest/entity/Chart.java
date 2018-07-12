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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Suyojan
 */
@Entity
@Table(catalog = "abblog", schema = "")
@NamedQueries({
    @NamedQuery(name = "Chart.findAll", query = "SELECT c FROM Chart c")})
public class Chart implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "page_id", nullable = false)
    private int pageId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "chart_type", nullable = false)
    private int chartType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "chart_period", nullable = false, length = 10)
    private String chartPeriod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "grid_row_pos", nullable = false)
    private int gridRowPos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "grid_col_pos", nullable = false)
    private int gridColPos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "grid_rowspan_count", nullable = false)
    private int gridRowspanCount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "grid_colspan_count", nullable = false)
    private int gridColspanCount;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "chart_title", nullable = false, length = 80)
    private String chartTitle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "refresh_time", nullable = false)
    private int refreshTime;
    @Size(max = 50)
    @Column(name = "parameter_1", length = 50)
    private String parameter1;
    @Size(max = 50)
    @Column(name = "parameter_2", length = 50)
    private String parameter2;
    @Size(max = 50)
    @Column(name = "parameter_3", length = 50)
    private String parameter3;
    @Size(max = 50)
    @Column(name = "parameter_4", length = 50)
    private String parameter4;
    @Size(max = 50)
    @Column(name = "parameter_5", length = 50)
    private String parameter5;
    @Size(max = 50)
    @Column(name = "parameter_6", length = 50)
    private String parameter6;
    @Size(max = 50)
    @Column(name = "parameter_7", length = 50)
    private String parameter7;
    @Size(max = 50)
    @Column(name = "parameter_8", length = 50)
    private String parameter8;
    @Size(max = 50)
    @Column(name = "parameter_9", length = 50)
    private String parameter9;
    @Size(max = 50)
    @Column(name = "parameter_10", length = 50)
    private String parameter10;

    public Chart() {
    }

    public Chart(Integer id) {
        this.id = id;
    }

    public Chart(Integer id, int pageId, int chartType, String chartPeriod, int gridRowPos, int gridColPos, int gridRowspanCount, int gridColspanCount, String chartTitle, int refreshTime) {
        this.id = id;
        this.pageId = pageId;
        this.chartType = chartType;
        this.chartPeriod = chartPeriod;
        this.gridRowPos = gridRowPos;
        this.gridColPos = gridColPos;
        this.gridRowspanCount = gridRowspanCount;
        this.gridColspanCount = gridColspanCount;
        this.chartTitle = chartTitle;
        this.refreshTime = refreshTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPageId() {
        return pageId;
    }

    public void setPageId(int pageId) {
        this.pageId = pageId;
    }

    public int getChartType() {
        return chartType;
    }

    public void setChartType(int chartType) {
        this.chartType = chartType;
    }

    public String getChartPeriod() {
        return chartPeriod;
    }

    public void setChartPeriod(String chartPeriod) {
        this.chartPeriod = chartPeriod;
    }

    public int getGridRowPos() {
        return gridRowPos;
    }

    public void setGridRowPos(int gridRowPos) {
        this.gridRowPos = gridRowPos;
    }

    public int getGridColPos() {
        return gridColPos;
    }

    public void setGridColPos(int gridColPos) {
        this.gridColPos = gridColPos;
    }

    public int getGridRowspanCount() {
        return gridRowspanCount;
    }

    public void setGridRowspanCount(int gridRowspanCount) {
        this.gridRowspanCount = gridRowspanCount;
    }

    public int getGridColspanCount() {
        return gridColspanCount;
    }

    public void setGridColspanCount(int gridColspanCount) {
        this.gridColspanCount = gridColspanCount;
    }

    public String getChartTitle() {
        return chartTitle;
    }

    public void setChartTitle(String chartTitle) {
        this.chartTitle = chartTitle;
    }

    public int getRefreshTime() {
        return refreshTime;
    }

    public void setRefreshTime(int refreshTime) {
        this.refreshTime = refreshTime;
    }

    public String getParameter1() {
        return parameter1;
    }

    public void setParameter1(String parameter1) {
        this.parameter1 = parameter1;
    }

    public String getParameter2() {
        return parameter2;
    }

    public void setParameter2(String parameter2) {
        this.parameter2 = parameter2;
    }

    public String getParameter3() {
        return parameter3;
    }

    public void setParameter3(String parameter3) {
        this.parameter3 = parameter3;
    }

    public String getParameter4() {
        return parameter4;
    }

    public void setParameter4(String parameter4) {
        this.parameter4 = parameter4;
    }

    public String getParameter5() {
        return parameter5;
    }

    public void setParameter5(String parameter5) {
        this.parameter5 = parameter5;
    }

    public String getParameter6() {
        return parameter6;
    }

    public void setParameter6(String parameter6) {
        this.parameter6 = parameter6;
    }

    public String getParameter7() {
        return parameter7;
    }

    public void setParameter7(String parameter7) {
        this.parameter7 = parameter7;
    }

    public String getParameter8() {
        return parameter8;
    }

    public void setParameter8(String parameter8) {
        this.parameter8 = parameter8;
    }

    public String getParameter9() {
        return parameter9;
    }

    public void setParameter9(String parameter9) {
        this.parameter9 = parameter9;
    }

    public String getParameter10() {
        return parameter10;
    }

    public void setParameter10(String parameter10) {
        this.parameter10 = parameter10;
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
        if (!(object instanceof Chart)) {
            return false;
        }
        Chart other = (Chart) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.suyojan.abbrest.Chart[ id=" + id + " ]";
    }
    
}
