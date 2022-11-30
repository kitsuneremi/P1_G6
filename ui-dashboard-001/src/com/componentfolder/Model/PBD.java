/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class PBD {

    private String id;

    private Date ngayBaoDuong;

    private Date ngayHoanThanh;

    private Float chiPhi;

    private String bienSoXe;

    public PBD() {
    }

    public PBD(String id, Date ngayBaoDuong, Date ngayHoanThanh, Float chiPhi, String bienSoXe) {
        this.id = id;
        this.ngayBaoDuong = ngayBaoDuong;
        this.ngayHoanThanh = ngayHoanThanh;
        this.chiPhi = chiPhi;
        this.bienSoXe = bienSoXe;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getNgayBaoDuong() {
        return ngayBaoDuong;
    }

    public void setNgayBaoDuong(Date ngayBaoDuong) {
        this.ngayBaoDuong = ngayBaoDuong;
    }

    public Date getNgayHoanThanh() {
        return ngayHoanThanh;
    }

    public void setNgayHoanThanh(Date ngayHoanThanh) {
        this.ngayHoanThanh = ngayHoanThanh;
    }

    public Float getChiPhi() {
        return chiPhi;
    }

    public void setChiPhi(Float chiPhi) {
        this.chiPhi = chiPhi;
    }

    public String getBienSoXe() {
        return bienSoXe;
    }

    public void setBienSoXe(String bienSoXe) {
        this.bienSoXe = bienSoXe;
    }

    @Override
    public String toString() {
        return "PBD{" + "id=" + id + ", ngayBaoDuong=" + ngayBaoDuong + ", ngayHoanThanh=" + ngayHoanThanh + ", chiPhi=" + chiPhi + ", bienSoXe=" + bienSoXe + '}';
    }

}
