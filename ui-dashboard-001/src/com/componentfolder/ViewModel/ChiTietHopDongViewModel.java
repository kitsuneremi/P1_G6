/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author User
 */
public class ChiTietHopDongViewModel {
        private String mahd;
        private String bienso;
        private Float tiencoc;

    public ChiTietHopDongViewModel() {
    }

    public ChiTietHopDongViewModel(String mahd, String bienso, Float tiencoc) {
        this.mahd = mahd;
        this.bienso = bienso;
        this.tiencoc = tiencoc;
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

    public Float getTiencoc() {
        return tiencoc;
    }

    public void setTiencoc(Float tiencoc) {
        this.tiencoc = tiencoc;
    }

    

    
   
        
}
