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

    private String id;
    private String idnv;
    private String idkh;
    private Date ngaytao;
    private Date ngayhethan;
    private int tinhTrangXe;

    public HopDongViewModel() {
    }

    public HopDongViewModel(String id, String idnv, String idkh, Date ngaytao, Date ngayhethan, int tinhTrangXe) {
        this.id = id;
        this.idnv = idnv;
        this.idkh = idkh;
        this.ngaytao = ngaytao;
        this.ngayhethan = ngayhethan;
        this.tinhTrangXe = tinhTrangXe;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Date getNgaytao() {
        return ngaytao;
    }

    public Date getNgayhethan() {
        return ngayhethan;
    }

    public int getTinhTrangXe() {
        return tinhTrangXe;
    }

    public void setTinhTrangXe(int tinhTrangXe) {
        this.tinhTrangXe = tinhTrangXe;
    }

    public String hienThiTinhTrang() {
        if (tinhTrangXe == 0) {
            return "chưa ký";
        } else {
            return "đã ký";
        }
    }

    public void setNgayTao(Date ngayTao) {
        this.ngaytao = ngayTao;
    }

    public void setNgayHetHan(Date ngayHetHan) {
        this.ngayhethan = ngayHetHan;
    }

}
