/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author User
 */
public class ChiTietHopDongModel {
        private String mahd;
        private String bienso;      
        private Float tienCoc;

    public ChiTietHopDongModel() {
    }

    public ChiTietHopDongModel(String mahd, String bienso, Float tienCoc) {
        this.mahd = mahd;
        this.bienso = bienso;
        this.tienCoc = tienCoc;
    }

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
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
