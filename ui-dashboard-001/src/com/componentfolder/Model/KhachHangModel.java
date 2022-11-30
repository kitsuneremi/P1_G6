
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author lilyp
 */
public class KhachHangModel {
    private String id ,ten, sdt, cccd;
    private int gioitinh;
    private String makh;

    public KhachHangModel() {
    }

    public KhachHangModel(String id, String ten, String sdt, String cccd, int gioitinh, String makh) {
        this.id = id;
        this.ten = ten;
        this.sdt = sdt;
        this.cccd = cccd;
        this.gioitinh = gioitinh;
        this.makh = makh;
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