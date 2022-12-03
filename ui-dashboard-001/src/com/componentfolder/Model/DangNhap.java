/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.componentfolder.Model;


public class DangNhap {
    private String taikhoan,matkhau,chucvu;

    public DangNhap() {
    }

    public DangNhap(String taikhoan, String matkhau, String chucvu) {
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
        this.chucvu = chucvu;
    }
    

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }
    
}
