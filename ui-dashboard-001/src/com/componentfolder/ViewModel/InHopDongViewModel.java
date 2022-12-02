/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import java.util.Date;

/**
 *
 * @author User
 */
public class InHopDongViewModel {
        private String ten;
        private String cccd;
        private String bienso;
        private Float tiencoc;
        private Date ngaytao;
        private Date ngayhethan;

    public InHopDongViewModel() {
    }

    public InHopDongViewModel(String ten, String cccd, String bienso, Float tiencoc, Date ngaytao, Date ngayhethan) {
        this.ten = ten;
        this.cccd = cccd;
        this.bienso = bienso;
        this.tiencoc = tiencoc;
        this.ngaytao = ngaytao;
        this.ngayhethan = ngayhethan;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
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

    public Date getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(Date ngaytao) {
        this.ngaytao = ngaytao;
    }

    public Date getNgayhethan() {
        return ngayhethan;
    }

    public void setNgayhethan(Date ngayhethan) {
        this.ngayhethan = ngayhethan;
    }
        
}
