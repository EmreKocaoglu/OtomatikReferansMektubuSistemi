package com.baskent.OtomatikReferansMektubu.web.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Emre Kocaoðlu
 */
@Entity
@Table(name="ogrenci")
public class Ogrenci extends BaseEntity{
    
 private String ad;
 private String soyad;
 private Long id;
 private Date dogumTarihi;
 private double derece;
 private String program;
 private String adres;
 private String sehir;
 private int postaKodu;
 private String password;

 public Ogrenci()
 {
     super();
 }
    public Ogrenci(String ad, String soyad, Long id, Date dogumTarihi, double derece, String program, String adres, String sehir, int postaKodu, String password, String ekleyen, Date eklemeTarihi, String guncelleyen, Date guncellemeTarihi, Boolean durum) {
        super();
        this.ad = ad;
        this.soyad = soyad;
        this.id = id;
        this.dogumTarihi = dogumTarihi;
        this.derece = derece;
        this.program = program;
        this.adres = adres;
        this.sehir = sehir;
        this.postaKodu = postaKodu;
        this.password = password;
    }

   

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Id
    @SequenceGenerator(allocationSize = 1, name = "seq_ogrenci", sequenceName = "seq_ogrenci")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ogrenci")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Temporal(TemporalType.DATE)
    public Date getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(Date dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public double getDerece() {
        return derece;
    }

    public void setDerece(double derece) {
        this.derece = derece;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getSehir() {
        return sehir;
    }

    public void setSehir(String sehir) {
        this.sehir = sehir;
    }

    public int getPostaKodu() {
        return postaKodu;
    }

    public void setPostaKodu(int postaKodu) {
        this.postaKodu = postaKodu;
    }
   
}