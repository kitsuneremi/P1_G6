/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.componentfolder.Model;

import java.util.Date;

/**
 *
 * @author lilyp
 */
public class HoaDonTraXeModel {

    private String id;
    private Date Ngaytra;
    private double phiphatsinh, tongtien;
    private ChiTietViPhamModel ctvpm;
    private HopDongModel hdm;
    private String mota;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getNgaytra() {
        return Ngaytra;
    }

    public void setNgaytra(Date Ngaytra) {
        this.Ngaytra = Ngaytra;
    }

    public double getTongtien() {
        return tongtien;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

    public double getPhiphatsinh() {
        return phiphatsinh;
    }

    public void setPhiphatsinh(double phiphatsinh) {
        this.phiphatsinh = phiphatsinh;
    }

    public ChiTietViPhamModel getCtvpm() {
        return ctvpm;
    }

    public void setCtvpm(ChiTietViPhamModel ctvpm) {
        this.ctvpm = ctvpm;
    }

    public HopDongModel getHdm() {
        return hdm;
    }

    public void setHdm(HopDongModel hdm) {
        this.hdm = hdm;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

}
