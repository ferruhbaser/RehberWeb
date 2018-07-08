/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bilisimegitim.rehberweb.entity;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FRH
 */
@Entity
@Table(name = "giris")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Giris.girisKontrol", query = "SELECT g FROM Giris g where g.kullanici = :kullanici and g.sifre = :sifre")
        ,@NamedQuery(name = "Giris.findAll", query = "SELECT g FROM Giris g")
    , @NamedQuery(name = "Giris.findByNo", query = "SELECT g FROM Giris g WHERE g.no = :no")
    , @NamedQuery(name = "Giris.findByKullanici", query = "SELECT g FROM Giris g WHERE g.kullanici = :kullanici")
    , @NamedQuery(name = "Giris.findBySifre", query = "SELECT g FROM Giris g WHERE g.sifre = :sifre")})
public class Giris implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "no")
    private Integer no;
    @Size(max = 30)
    @Column(name = "kullanici")
    private String kullanici;
    @Size(max = 30)
    @Column(name = "sifre")
    private String sifre;

    public Giris() {
    }

    public Giris(Integer no) {
        this.no = no;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getKullanici() {
        return kullanici;
    }

    public void setKullanici(String kullanici) {
        this.kullanici = kullanici;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
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
        if (!(object instanceof Giris)) {
            return false;
        }
        Giris other = (Giris) object;
        if ((this.no == null && other.no != null) || (this.no != null && !this.no.equals(other.no))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bilisimegitim.rehberweb.entity.Giris[ no=" + no + " ]";
    }

}
