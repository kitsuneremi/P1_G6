/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author DELL
 */
public class ChiTietXe {
    private String id;
    private Xe xe;
    private LoaiXe loaiXe;
    private PBD phieuBaoDuong;
    private float giaNhap;
    private String ngayNhap;
    private int tinhTrangXe;
    private String bienSo;

    public ChiTietXe() {
    }

    public ChiTietXe(String id, Xe xe, LoaiXe loaiXe, PBD phieuBaoDuong, float giaNhap, String ngayNhap, int tinhTrangXe, String bienSo) {
        this.id = id;
        this.xe = xe;
        this.loaiXe = loaiXe;
        this.phieuBaoDuong = phieuBaoDuong;
        this.giaNhap = giaNhap;
        this.ngayNhap = ngayNhap;
        this.tinhTrangXe = tinhTrangXe;
        this.bienSo = bienSo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Xe getXe() {
        return xe;
    }

    public void setXe(Xe xe) {
        this.xe = xe;
    }

    public LoaiXe getLoaiXe() {
        return loaiXe;
    }

    public void setLoaiXe(LoaiXe loaiXe) {
        this.loaiXe = loaiXe;
    }

    public PBD getPhieuBaoDuong() {
        return phieuBaoDuong;
    }

    public void setPhieuBaoDuong(PBD phieuBaoDuong) {
        this.phieuBaoDuong = phieuBaoDuong;
    }

    public float getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(float giaNhap) {
        this.giaNhap = giaNhap;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
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
        return "ChiTietXe{" + "id=" + id + ", xe=" + xe + ", loaiXe=" + loaiXe + ", phieuBaoDuong=" + phieuBaoDuong + ", giaNhap=" + giaNhap + ", ngayNhap=" + ngayNhap + ", tinhTrangXe=" + tinhTrangXe + ", bienSo=" + bienSo + '}';
    }
    public Object[] toRowData(){
        return new Object[]{id,xe.getId(),loaiXe.getId(),phieuBaoDuong.getId(),giaNhap,ngayNhap,tinhTrangXe,bienSo};
    }
}
