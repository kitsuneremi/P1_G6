/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import java.util.Date;

/**
 *
 * @author User
 */
public class HopDongViewModel {
       
        private String idnv;
        private String idkh;
        private Date ngayTao;
        private Date ngayHetHan;
        private int tinhTrangXe;
        private String sourceAnh;
        private String mahd;
        

    public HopDongViewModel() {
    }

    public HopDongViewModel(String idnv, String idkh, Date ngayTao, Date ngayHetHan, int tinhTrangXe, String sourceAnh, String mahd) {
        this.idnv = idnv;
        this.idkh = idkh;
        this.ngayTao = ngayTao;
        this.ngayHetHan = ngayHetHan;
        this.tinhTrangXe = tinhTrangXe;
        this.sourceAnh = sourceAnh;
        this.mahd = mahd;
    }

    public String getIdnv() {
        return idnv;
    }

    public void setIdnv(String idnv) {
        this.idnv = idnv;
    }

    public String getIdkh() {
        return idkh;
    }

    public void setIdkh(String idkh) {
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

    public int getTinhTrangXe() {
        return tinhTrangXe;
    }

    public void setTinhTrangXe(int tinhTrangXe) {
        this.tinhTrangXe = tinhTrangXe;
    }

    public String getSourceAnh() {
        return sourceAnh;
    }

    public void setSourceAnh(String sourceAnh) {
        this.sourceAnh = sourceAnh;
    }

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

   
    
    
  

  
    
    public String hienThiTinhTrang(){
        if (tinhTrangXe == 0) {
            return "chưa ký";
        }else
            return "đã ký";
    }
        
}
