/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.componentfolder.Model;

/**
 *
 * @author DELL
 */
public class LoaiXe {

    private String maLoai;
    private String ten;
    private double giaNhap;
    private String dongXe;
    private String tenTheLoai;

    public LoaiXe() {
    }

    public LoaiXe(String maLoai) {
        this.maLoai = maLoai;
    }
    

    public LoaiXe(String maLoai, String ten) {
        this.maLoai = maLoai;
        this.ten = ten;
    }

    public LoaiXe(String maLoai, String ten, double giaNhap, String dongXe, String tenTheLoai) {
        this.maLoai = maLoai;
        this.ten = ten;
        this.giaNhap = giaNhap;
        this.dongXe = dongXe;
        this.tenTheLoai = tenTheLoai;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public String getDongXe() {
        return dongXe;
    }

    public void setDongXe(String dongXe) {
        this.dongXe = dongXe;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    @Override
    public String toString() {
        return "LoaiXe{" + "maLoai=" + maLoai + ", ten=" + ten + ", giaNhap=" + giaNhap + ", dongXe=" + dongXe + ", tenTheLoai=" + tenTheLoai + '}';
    }

    public Object[] toRowData() {
        return new Object[]{maLoai, ten, giaNhap, dongXe, tenTheLoai};
    }
}
