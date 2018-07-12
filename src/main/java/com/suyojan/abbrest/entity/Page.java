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
@NamedQueries({
    @NamedQuery(name = "Page.findAll", query = "SELECT p FROM Page p")})
public class Page implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "time_to_display", nullable = false)
    private int timeToDisplay;
    @Size(max = 100)
    @Column(name = "page_title", length = 100)
    private String pageTitle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(nullable = false, length = 50)
    private String bgcolor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "page_priority", nullable = false)
    private int pagePriority;
    @Column(name = "total_gridrows")
    private Integer totalGridrows;
    @Column(name = "total_gridcols")
    private Integer totalGridcols;
    @Size(max = 50)
    @Column(name = "page_style", length = 50)
    private String pageStyle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "page_active", nullable = false)
    private short pageActive;

    public Page() {
    }

    public Page(Integer id) {
        this.id = id;
    }

    public Page(Integer id, int timeToDisplay, String bgcolor, int pagePriority, short pageActive) {
        this.id = id;
        this.timeToDisplay = timeToDisplay;
        this.bgcolor = bgcolor;
        this.pagePriority = pagePriority;
        this.pageActive = pageActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getTimeToDisplay() {
        return timeToDisplay;
    }

    public void setTimeToDisplay(int timeToDisplay) {
        this.timeToDisplay = timeToDisplay;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public String getBgcolor() {
        return bgcolor;
    }

    public void setBgcolor(String bgcolor) {
        this.bgcolor = bgcolor;
    }

    public int getPagePriority() {
        return pagePriority;
    }

    public void setPagePriority(int pagePriority) {
        this.pagePriority = pagePriority;
    }

    public Integer getTotalGridrows() {
        return totalGridrows;
    }

    public void setTotalGridrows(Integer totalGridrows) {
        this.totalGridrows = totalGridrows;
    }

    public Integer getTotalGridcols() {
        return totalGridcols;
    }

    public void setTotalGridcols(Integer totalGridcols) {
        this.totalGridcols = totalGridcols;
    }

    public String getPageStyle() {
        return pageStyle;
    }

    public void setPageStyle(String pageStyle) {
        this.pageStyle = pageStyle;
    }

    public short getPageActive() {
        return pageActive;
    }

    public void setPageActive(short pageActive) {
        this.pageActive = pageActive;
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
        if (!(object instanceof Page)) {
            return false;
        }
        Page other = (Page) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.suyojan.abbrest.Page[ id=" + id + " ]";
    }
    
}
