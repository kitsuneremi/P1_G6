
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.componentfolder.Model;

/**
 *
 * @author lilyp
 */
public class KhachHangModel {
    private String email ,ten, sdt, cccd;
    private int gioitinh;
    private String makh;

    public KhachHangModel() {
    }

    public KhachHangModel(String email, String ten, String sdt, String cccd, int gioitinh, String makh) {
        this.email = email;
        this.ten = ten;
        this.sdt = sdt;
        this.cccd = cccd;
        this.gioitinh = gioitinh;
        this.makh = makh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public int getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(int gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    
    
}