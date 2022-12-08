package com.componentfolder.Repository;

import Utilities.DBConnections;
import com.componentfolder.Model.ChiTietHopDongModel;
import com.componentfolder.Model.ChiTietViPhamModel;
import com.componentfolder.ViewModel.HoaDonTraXeViewModel;
import com.componentfolder.ViewModel.KhachHangViewModel;
import com.componentfolder.Model.HoaDonTraXeModel;
import com.componentfolder.Model.HopDongModel;
import com.componentfolder.Model.ViPhamModel;
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
            String sql = "select hoadontraxe.mahoadon,hopdong.mahopdong,ngaytra,chitietvipham.mavipham,phiphatsinh,thanhtien,hopdong.makh from hoadontraxe join hopdong on hoadontraxe.mahopdong = hopdong.mahopdong join chitietvipham on chitietvipham.mahoadon = hoadontraxe.mahoadon";
            Connection conn = DBConnections.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonTraXeViewModel hdtxvm = new HoaDonTraXeViewModel();
                hdtxvm.setId(rs.getString(1));
                hdtxvm.setIdhd(rs.getString(2));
                hdtxvm.setNgaytra(rs.getDate(3));
                hdtxvm.setVpm(new ViPhamModel(rs.getInt(4), ""));
                hdtxvm.setPhiphatsinh(rs.getDouble(5));
                hdtxvm.setTongtien(rs.getDouble(6));
                hdtxvm.setIdkh(rs.getString(7));
                list.add(hdtxvm);
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
            Connection conn = DBConnections.getConnection();
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
        try ( Connection conn = DBConnections.getConnection()) {
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
        try ( Connection conn = DBConnections.getConnection()) {
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
        try ( Connection conn = DBConnections.getConnection()) {
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

    public boolean insert(HoaDonTraXeModel hdtxm) {
        try ( Connection conn = DBConnections.getConnection()) {
            String sql = "insert into hoadontraxe(mahoadon,ngaytra,phiphatsinh,thanhtien,mota) values(?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hdtxm.getId());
            ps.setDate(2, new java.sql.Date(hdtxm.getNgaytra().getTime()));
            ps.setDouble(3, hdtxm.getPhiphatsinh());
            ps.setDouble(4, hdtxm.getTongtien());
            ps.setString(5, hdtxm.getMota());
            ps.executeUpdate();
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean update(HoaDonTraXeModel hdtxm) {
        try ( Connection conn = DBConnections.getConnection()) {
            String sql = "update hoadontraxe set mahopdong = ?,ngaytra = ?, phiphatsinh = ?, thanhtien = ?, mota = ? where mahoadon = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hdtxm.getHdm().getMahd());
            ps.setDate(2, new java.sql.Date(hdtxm.getNgaytra().getTime()));
            ps.setDouble(3, hdtxm.getPhiphatsinh());
            ps.setDouble(4, hdtxm.getTongtien());
            ps.setString(5, hdtxm.getMota());
            ps.setString(6, hdtxm.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean updatevipham(ChiTietViPhamModel ctvpm) {
        try ( Connection conn = DBConnections.getConnection()) {
            String sql = "insert into chitietvipham(mahoadon,mavipham) values(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ctvpm.getMahoadon());
            ps.setInt(2, ctvpm.getVpm().getMa());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public ArrayList<ChiTietHopDongModel> getdsbienso(String mahd) {
        try ( Connection conn = DBConnections.getConnection()) {
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
        try ( Connection conn = DBConnections.getConnection()) {
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
        try ( Connection conn = DBConnections.getConnection()) {
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
        try ( Connection conn = DBConnections.getConnection()) {
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
        try ( Connection conn = DBConnections.getConnection()) {
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

    public ArrayList<ViPhamModel> vipham() {
        String sql = "select mavipham,ten from vipham";
        ArrayList<ViPhamModel> list = new ArrayList<>();
        try ( Connection conn = DBConnections.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ViPhamModel(rs.getInt(1), rs.getString(2)));
            }
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public String mota(String mahd) {
        String sql = "select mota from hoadontraxe where mahoadon = ?";
        try ( Connection conn = DBConnections.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, mahd);
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

    public HopDongViewModel gethdx(String mahd) {

        String sql = "select ngaytao,ngayhethan from hopdong where mahopdong = ?";
        try ( Connection conn = DBConnections.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, mahd);
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

    public int getsovipham(String mahd) {
        String sql = "select count(mavipham) from chitietvipham where mahoadon = ?";
        try ( Connection conn = DBConnections.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, mahd);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
            return 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }

    }
}
