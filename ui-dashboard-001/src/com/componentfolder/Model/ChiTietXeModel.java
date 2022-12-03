/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.componentfolder.Model;

/**
 *
 * @author User
 */
public class ChiTietXeModel {
        private String id;
        private String idXe;
        private String idLoai;
        private String idPhieu;
        private Float giaNhap;
        private int tinhTrangXe;
        private String bienSo;

    public ChiTietXeModel() {
    }

    public ChiTietXeModel(String id, String idXe, String idLoai, String idPhieu, Float giaNhap, int tinhTrangXe, String bienSo) {
        this.id = id;
        this.idXe = idXe;
        this.idLoai = idLoai;
        this.idPhieu = idPhieu;
        this.giaNhap = giaNhap;
        this.tinhTrangXe = tinhTrangXe;
        this.bienSo = bienSo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdXe() {
        return idXe;
    }

    public void setIdXe(String idXe) {
        this.idXe = idXe;
    }

    public String getIdLoai() {
        return idLoai;
    }

    public void setIdLoai(String idLoai) {
        this.idLoai = idLoai;
    }

    public String getIdPhieu() {
        return idPhieu;
    }

    public void setIdPhieu(String idPhieu) {
        this.idPhieu = idPhieu;
    }

    public Float getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(Float giaNhap) {
        this.giaNhap = giaNhap;
    }

    public int getTinhTrangXe() {
        return tinhTrangXe;
    }

    public void setTinhTrangXe(int tinhTrangXe) {
        this.tinhTrangXe = tinhTrangXe;
    }

    public String getBienSo() {
        return bienSo;
    }

    public void setBienSo(String bienSo) {
        this.bienSo = bienSo;
    }

    @Override
    public String toString() {
        return id;
    }
        
        
}
