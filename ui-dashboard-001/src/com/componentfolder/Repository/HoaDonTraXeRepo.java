package com.componentfolder.Repository;

import Utilities.DBConnections1;
import com.componentfolder.Model.ChiTietHopDongModel;
import com.componentfolder.ViewModel.HoaDonTraXeViewModel;
import com.componentfolder.ViewModel.KhachHangViewModel;
import com.componentfolder.Model.HoaDonTraXeModel;
import com.componentfolder.Model.HopDongModel;
import com.componentfolder.ViewModel.HopDongViewModel;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author lilyp
 */
public class HoaDonTraXeRepo {

    public ArrayList<HoaDonTraXeViewModel> getlistdata() {
        try {
            ArrayList<HoaDonTraXeViewModel> list = new ArrayList<>();
            String sql = "select hoadontraxe.mahoadon,hopdong.mahopdong,ngaytra,hoadontraxe.mavipham,phiphatsinh,thanhtien,hopdong.makh from hoadontraxe join hopdong on hoadontraxe.mahopdong = hopdong.mahopdong";
            Connection conn = DBConnections1.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonTraXeViewModel hdhtvm = new HoaDonTraXeViewModel();
                hdhtvm.setId(rs.getString(1));
                hdhtvm.setIdhd(rs.getString(2));
                hdhtvm.setNgaytra(rs.getDate(3));
                hdhtvm.setVipham(rs.getInt(4));
                hdhtvm.setPhiphatsinh(rs.getDouble(5));
                hdhtvm.setTongtien(rs.getDouble(6));
                hdhtvm.setIdkh(rs.getString(7));
                list.add(hdhtvm);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<HoaDonTraXeViewModel> getemptylist() {
        try {
            ArrayList<HoaDonTraXeViewModel> list = new ArrayList<>();
            String sql = "select hoadontraxe.mahoadon from hoadontraxe where ngayTra = '2099-12-30'";
            Connection conn = DBConnections1.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonTraXeViewModel hdhtvm = new HoaDonTraXeViewModel();
                hdhtvm.setId(rs.getString(1));
                list.add(hdhtvm);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public KhachHangViewModel getkh(String idhd) {
        try ( Connection conn = DBConnections1.getConnection()) {
            String sql = "select khachhang.makh,ten,email from khachhang join hopdong on khachhang.makh = hopdong.makh where hopdong.mahopdong = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idhd);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHangViewModel khvm = new KhachHangViewModel();
                khvm.setMakh(rs.getString(1));
                khvm.setTen(rs.getString(2));
                khvm.setEmail(rs.getString(3));
                return khvm;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public String getnv(String idnv) {
        try ( Connection conn = DBConnections1.getConnection()) {
            String sql = "select ten from nhanvien where idnv = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idnv);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public ArrayList<HopDongViewModel> getlisthd() {
        try ( Connection conn = DBConnections1.getConnection()) {
            ArrayList<HopDongViewModel> list = new ArrayList<>();
            String sql = "select hopdong.mahopdong,idnv,hopdong.makh,ngaytao,ngayhethan,tinhtrang,ten,email from hopdong join khachhang on hopdong.makh = khachhang.makh order by hopdong.mahopdong desc";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HopDongViewModel hdvm = new HopDongViewModel();
                hdvm.setMahd(rs.getString(1));
                hdvm.setIdnv(rs.getString(2));
                hdvm.setIdkh(rs.getString(3));
                hdvm.setNgayTao(rs.getDate(4));
                hdvm.setNgayHetHan(rs.getDate(5));
                hdvm.setTinhTrangXe(rs.getInt(6));
                list.add(hdvm);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public boolean insert(HoaDonTraXeModel hdhtm) {
        try ( Connection conn = DBConnections1.getConnection()) {
            String sql = "insert into hoadontraxe(mahoadon,ngaytra,mavipham,phiphatsinh,thanhtien,mota) values(?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hdhtm.getId());
            ps.setDate(2, new java.sql.Date(hdhtm.getNgaytra().getTime()));
            ps.setInt(3, hdhtm.getVipham().getMa());
            ps.setDouble(4, hdhtm.getPhiphatsinh());
            ps.setDouble(5, hdhtm.getTongtien());
            ps.setString(6, hdhtm.getMota());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean update(HoaDonTraXeModel hdhtm) {
        try ( Connection conn = DBConnections1.getConnection()) {
            String sql = "update hoadontraxe set mahopdong = ?,ngaytra = ?, mavipham = ?, phiphatsinh = ?, thanhtien = ?, mota = ? where mahoadon = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hdhtm.getHdm().getMahd());
            ps.setDate(2, new java.sql.Date(hdhtm.getNgaytra().getTime()));
            ps.setInt(3, hdhtm.getVipham().getMa());
            ps.setDouble(4, hdhtm.getPhiphatsinh());
            ps.setDouble(5, hdhtm.getTongtien());
            ps.setString(6, hdhtm.getMota());
            ps.setString(7, hdhtm.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public ArrayList<ChiTietHopDongModel> getdsbienso(String mahd) {
        try ( Connection conn = DBConnections1.getConnection()) {
            ArrayList<ChiTietHopDongModel> list = new ArrayList<>();
            String sql = "select mahopdong,bienso from chitiethopdong where mahopdong = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, mahd);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HopDongModel hdm = new HopDongModel();
                hdm.setMahd(mahd);
                list.add(new ChiTietHopDongModel(hdm, rs.getString(2), Float.parseFloat(String.valueOf(0))));
            }
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public boolean updatexe(String bienso) {
        try ( Connection conn = DBConnections1.getConnection()) {
            String sql = "update chitietxe set tinhtrangxe = ? where bien so = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, bienso);
            return ps.executeUpdate() > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean delete(HoaDonTraXeModel hdhtm) {
        try ( Connection conn = DBConnections1.getConnection()) {
            String sql = "delete from hoadontraxe where id = convert(uniqueidentifier,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hdhtm.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public double tienthuexe(String idhd) {
        if (idhd == null || idhd.equalsIgnoreCase("")) {
            return 0;
        }
        try ( Connection conn = DBConnections1.getConnection()) {
            double tienthuexe = 0;
            String sql = "select chitietxe.giathuetrenngay from hopdong join chitiethopdong on hopdong.mahopdong = chiTietHopDong.mahopdong join chiTietXe on chiTietHopDong.bienSo = chiTietXe.bienSo where hopDong.mahopdong = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idhd);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tienthuexe += rs.getDouble(1);
            }
            return tienthuexe;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    public String getemail(String makh) {
        String sql = "select email from khachhang join hopdong on khachhang.makh = hopdong.makh where hopdong.mahopdong = ?";
        try ( Connection conn = DBConnections1.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, makh);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString(1);
            }
            return "";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }

    public ArrayList<String> vipham() {
        String sql = "select ten from vipham";
        ArrayList<String> list = new ArrayList<>();
        try ( Connection conn = DBConnections1.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public String mota(String idhd) {
        String sql = "select mota from hoadontraxe where mahoadon = ?";
        try ( Connection conn = DBConnections1.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idhd);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString(1);
            }
            return "";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }

    public HopDongViewModel gethdx(String idhd) {

        String sql = "select ngaytao,ngayhethan from hopdong where mahopdong = ?";
        try ( Connection conn = DBConnections1.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idhd);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HopDongViewModel hdvm = new HopDongViewModel();
                hdvm.setNgayTao(rs.getDate(1));
                hdvm.setNgayHetHan(rs.getDate(2));
                return hdvm;
            }
            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }
}
