/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.componentfolder.Model;

import java.util.BitSet;
import java.util.Date;

/**
 *
 * @author User
 */
public class NhanVienModel {
    private String id;
    private String ten;
    private Date ngaySinh;
    private String sdt;
    private int gioiTinh;

    public DangNhap getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(DangNhap taikhoan) {
        this.taikhoan = taikhoan;
    }
    private DangNhap taikhoan;

    public NhanVienModel() {
    }

    public NhanVienModel(String id, String ten, Date ngaySinh, String sdt, int gioiTinh, DangNhap taikhoan) {
        this.id = id;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.sdt = sdt;
        this.gioiTinh = gioiTinh;
        this.taikhoan = taikhoan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public DangNhap taikhoan() {
        return taikhoan;
    }

    public void taikhoan(DangNhap taikhoan) {
        this.taikhoan = taikhoan;
    }

    @Override
    public String toString() {
        return ten;
    }
    
    
}
