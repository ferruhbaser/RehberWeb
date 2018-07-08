/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bilisimegitim.rehberweb.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FRH
 */
@Entity
@Table(name = "kisi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kisi.findAll", query = "SELECT k FROM Kisi k")
    , @NamedQuery(name = "Kisi.findByNo", query = "SELECT k FROM Kisi k WHERE k.no = :no")
    , @NamedQuery(name = "Kisi.findByAd", query = "SELECT k FROM Kisi k WHERE k.ad = :ad")
    , @NamedQuery(name = "Kisi.findBySoyad", query = "SELECT k FROM Kisi k WHERE k.soyad = :soyad")
    , @NamedQuery(name = "Kisi.findByMaas", query = "SELECT k FROM Kisi k WHERE k.maas = :maas")
    , @NamedQuery(name = "Kisi.findByDogtar", query = "SELECT k FROM Kisi k WHERE k.dogtar = :dogtar")})
public class Kisi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "no")
    private Integer no;
    @Size(max = 30)
    @Column(name = "ad")
    private String ad;
    @Size(max = 30)
    @Column(name = "soyad")
    private String soyad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "maas")
    private BigDecimal maas;
    @Column(name = "dogtar")
    @Temporal(TemporalType.DATE)
    private Date dogtar;

    public Kisi() {
    }

    public Kisi(Integer no) {
        this.no = no;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public BigDecimal getMaas() {
        return maas;
    }

    public void setMaas(BigDecimal maas) {
        this.maas = maas;
    }

    public Date getDogtar() {
        return dogtar;
    }

    public void setDogtar(Date dogtar) {
        this.dogtar = dogtar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (no != null ? no.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kisi)) {
            return false;
        }
        Kisi other = (Kisi) object;
        if ((this.no == null && other.no != null) || (this.no != null && !this.no.equals(other.no))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bilisimegitim.rehberweb.entity.Kisi[ no=" + no + " ]";
    }

}
