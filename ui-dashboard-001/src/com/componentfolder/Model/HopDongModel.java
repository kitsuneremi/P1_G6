/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author User
 */
public class HopDongModel {

    private String id;
    private Date ngayTao;
    private Date ngayHetHan;
    private int tinhTrang;
    private KhachHangModel khm;
    private NhanVienModel nvm;

    public HopDongModel() {
    }

    public HopDongModel(String id, Date ngayTao, Date ngayHetHan, int tinhTrang, KhachHangModel khm, NhanVienModel nvm) {
        this.id = id;
        this.ngayTao = ngayTao;
        this.ngayHetHan = ngayHetHan;
        this.tinhTrang = tinhTrang;
        this.khm = khm;
        this.nvm = nvm;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public KhachHangModel getKhm() {
        return khm;
    }

    public void setKhm(KhachHangModel khm) {
        this.khm = khm;
    }

    public NhanVienModel getNvm() {
        return nvm;
    }

    public void setNvm(NhanVienModel nvm) {
        this.nvm = nvm;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(Date ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    @Override
    public String toString() {
        return id;
    }

}
