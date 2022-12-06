/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.componentfolder.ViewModel;

/**
 *
 * @author DELL
 */
public class Top10ViewModel {
    private String ma;
    private String ten;
    private int soLuong;
    private String moTa;

    public Top10ViewModel() {
    }

    public Top10ViewModel(String ma, String ten, int soLuong, String moTa) {
        this.ma = ma;
        this.ten = ten;
        this.soLuong = soLuong;
        this.moTa = moTa;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Override
    public String toString() {
        return "Top10ViewModel{" + "ma=" + ma + ", ten=" + ten + ", soLuong=" + soLuong + ", moTa=" + moTa + '}';
    }
    public Object[] toRowDataTop10(){
        return  new Object[]{ma,ten,soLuong,moTa};
    }
}
