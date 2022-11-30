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
        private String idhd;
        private String idxe;
        private Float donGia;
        private int soLuong;
        private Float tiencoc;

    public ChiTietHopDongViewModel() {
    }

    public ChiTietHopDongViewModel(String idhd, String idxe, Float donGia, int soLuong, Float tiencoc) {
        this.idhd = idhd;
        this.idxe = idxe;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.tiencoc = tiencoc;
    }

    public String getIdhd() {
        return idhd;
    }

    public void setIdhd(String idhd) {
        this.idhd = idhd;
    }

    public String getIdxe() {
        return idxe;
    }

    public void setIdxe(String idxe) {
        this.idxe = idxe;
    }

    public Float getDonGia() {
        return donGia;
    }

    public void setDonGia(Float donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Float getTiencoc() {
        return tiencoc;
    }

    public void setTiencoc(Float tiencoc) {
        this.tiencoc = tiencoc;
    }
    
   
        
}
