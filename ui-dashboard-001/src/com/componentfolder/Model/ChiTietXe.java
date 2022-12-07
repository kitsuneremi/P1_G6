/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.componentfolder.Model;

/**
 *
 * @author DELL
 */
public class ChiTietXe {
    private String bienSo;
    private LoaiXe loaiXe;
    private int tinhTrang;
    private double gia;
    private String moTa;

    public ChiTietXe() {
    }

    public ChiTietXe(String bienSo, LoaiXe loaiXe, int tinhTrang, double gia, String moTa) {
        this.bienSo = bienSo;
        this.loaiXe = loaiXe;
        this.tinhTrang = tinhTrang;
        this.gia = gia;
        this.moTa = moTa;
    }

    public String getBienSo() {
        return bienSo;
    }

    public void setBienSo(String bienSo) {
        this.bienSo = bienSo;
    }

    public LoaiXe getLoaiXe() {
        return loaiXe;
    }

    public void setLoaiXe(LoaiXe loaiXe) {
        this.loaiXe = loaiXe;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
    
    @Override
    public String toString() {
        return "ChiTietXe{" + "bienSo=" + bienSo + ", loaiXe=" + loaiXe + ", tinhTrang=" + tinhTrang + ", gia=" + gia + ", moTa=" + moTa + '}';
    }
    public Object[] toRowDataChiTietXe(){
        return new Object[]{
            bienSo,getLoaiXe().getMaLoai(),getLoaiXe().getDongXe(),getLoaiXe().getTen(),tinhTrang==0?"Có thể Thuê":tinhTrang==1?"Đang được thuê":tinhTrang==2?"Đang hỏng hóc":"Đang bảo dưỡng",gia,moTa
        };
    }

}
