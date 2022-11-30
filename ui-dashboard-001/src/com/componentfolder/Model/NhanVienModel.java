/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

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
    private BitSet gioiTinh;
    private String idcv;

    public NhanVienModel() {
    }

    public NhanVienModel(String id, String ten, Date ngaySinh, String sdt, BitSet gioiTinh, String idcv) {
        this.id = id;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.sdt = sdt;
        this.gioiTinh = gioiTinh;
        this.idcv = idcv;
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

    public BitSet getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(BitSet gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getIdcv() {
        return idcv;
    }

    public void setIdcv(String idcv) {
        this.idcv = idcv;
    }

    @Override
    public String toString() {
        return ten;
    }
    
    
}
