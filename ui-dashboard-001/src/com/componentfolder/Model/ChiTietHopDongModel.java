/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.componentfolder.Model;

import com.componentfolder.Model.HopDongModel;

/**
 *
 * @author User
 */
public class ChiTietHopDongModel {
        private HopDongModel mahd;
        private String bienso;      
        private Float tienCoc;

    public ChiTietHopDongModel() {
    }

    public ChiTietHopDongModel(HopDongModel mahd, String bienso, Float tienCoc) {
        this.mahd = mahd;
        this.bienso = bienso;
        this.tienCoc = tienCoc;
    }

    public HopDongModel getMahd() {
        return mahd;
    }

    public void setMahd(HopDongModel mahd) {
        this.mahd = mahd;
    }

    public String getBienso() {
        return bienso;
    }

    public void setBienso(String bienso) {
        this.bienso = bienso;
    }

    public Float getTienCoc() {
        return tienCoc;
    }

    public void setTienCoc(Float tienCoc) {
        this.tienCoc = tienCoc;
    }

   
   
    
        
}
