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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author FRH
 */
@Named(value = "kisiMB")
@SessionScoped
public class kisiMB implements Serializable {

    @EJB
    private KisiFacade kisiFacade;

    private int no;
    private String ad;
    private String soyad;
    private BigDecimal maas;
    private Date dogtar;

    private List<Kisi> kisiListesi;

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

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public List<Kisi> listele() {
        if (kisiListesi == null) {
            kisiListesi = kisiFacade.findAll();
            return kisiListesi;
        } else {
            return kisiListesi;
        }
    }

    public String ekle() {

        Kisi k = new Kisi();
        k.setAd(ad);
        k.setSoyad(soyad);
        k.setMaas(maas);
        k.setDogtar(dogtar);

        kisiFacade.create(k);

        kisiListesi = kisiFacade.findAll();

        return "kisiListele.xhtml?faces-redirect=true";
    }

    public String sil() {

        Kisi k = kisiFacade.find(no);
        kisiFacade.remove(k);
        kisiListesi = kisiFacade.findAll();
        return "kisiListele.xhtml?faces-redirect=true";
    }

    public String getir() {
        Kisi k = kisiFacade.find(no);
        ad = k.getAd();
        soyad = k.getSoyad();
        maas = k.getMaas();
        dogtar = k.getDogtar();

        return "";
    }

    public String temizle() {
        no = 0;
        ad = "";
        soyad = "";
        maas = null ;
        dogtar = null ;
        return "";
    }

    public String guncelle(){
        
        Kisi k = new Kisi() ;
        
        k.setNo(no);
        k.setAd(ad);
        k.setSoyad(soyad);
        k.setMaas(maas);
        k.setDogtar(dogtar);
        
        kisiFacade.edit(k);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Güncellendi", no + " numaralı kayıt başarıyla güncellendi."));
        
        temizle();
        
        
       return ""; 
    }
    
}
