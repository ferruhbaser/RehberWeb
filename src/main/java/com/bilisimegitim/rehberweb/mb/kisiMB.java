/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bilisimegitim.rehberweb.mb;

import com.bilisimegitim.rehberweb.entity.Kisi;
import com.bilisimegitim.rehberweb.session.KisiFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.ejb.EJB;

/**
 *
 * @author FRH
 */
@Named(value = "kisiMB")
@SessionScoped
public class kisiMB implements Serializable {

    @EJB
    private KisiFacade kisiFacade;

    
  private String ad;
  private String soyad;
  private BigDecimal maas;
  private Date dogtar;
  
  
  
    public kisiMB() {
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
    
    public String ekle(){
        
        Kisi k = new Kisi();
        k.setAd(ad);
        k.setSoyad(soyad);
        k.setMaas(maas);
        k.setDogtar(dogtar);
        
        kisiFacade.create(k);
        
        return "kisiListele.xhtml";
    }
    
}
