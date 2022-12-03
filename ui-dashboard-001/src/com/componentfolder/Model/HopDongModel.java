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
    private String mahd;
    private NhanVienModel idnv;
    private KhachHangModel idkh;
    private Date ngayTao;
    private Date ngayHetHan;
    private int tinhTrang;
    private String sourceAnh;
    ;

    public HopDongModel() {
    }

    public HopDongModel(String mahd, NhanVienModel idnv, KhachHangModel idkh, Date ngayTao, Date ngayHetHan, int tinhTrang, String sourceAnh) {
        this.mahd = mahd;
        this.idnv = idnv;
        this.idkh = idkh;
        this.ngayTao = ngayTao;
        this.ngayHetHan = ngayHetHan;
        this.tinhTrang = tinhTrang;
        this.sourceAnh = sourceAnh;
    }

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public NhanVienModel getIdnv() {
        return idnv;
    }

    public void setIdnv(NhanVienModel idnv) {
        this.idnv = idnv;
    }

    public KhachHangModel getIdkh() {
        return idkh;
    }

    public void setIdkh(KhachHangModel idkh) {
        this.idkh = idkh;
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

    public String getSourceAnh() {
        return sourceAnh;
    }

    public void setSourceAnh(String sourceAnh) {
        this.sourceAnh = sourceAnh;
    }

   

    

   

    
   

    

    
    
}
