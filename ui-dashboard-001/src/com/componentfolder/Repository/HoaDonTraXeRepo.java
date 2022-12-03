
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.componentfolder.Repository;

import Utilities.DBConnections1;
import ViewModel.HoaDonTraXeViewModel;
import ViewModel.ChiTietXeViewModel;
import ViewModel.KhachHangViewModel;
import com.componentfolder.Model.HoaDonTraXeModel;
import com.componentfolder.ViewModel.HopDongViewModel;
import java.util.ArrayList;
import java.sql.*;
import java.util.Date;

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

    public KhachHangViewModel getkh(String idhd) {
        try ( Connection conn = DBConnections1.getConnection()) {
            String sql = "select khachhang.makh,ten from khachhang join hopdong on khachhang.makh = hopdong.makh where hopdong.mahopdong = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idhd);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHangViewModel khvm = new KhachHangViewModel();
                khvm.setId(rs.getString(1));
                khvm.setTen(rs.getString(2));
                return khvm;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public String getnv(String idnv){
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
            String sql = "select hopdong.mahopdong,idnv,hopdong.makh,ngaytao,ngayhethan,tinhtrang,ten from hopdong join khachhang on hopdong.makh = khachhang.makh order by hopdong.mahopdong desc";
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
            String sql = "insert into hoadontraxe(mahoadon,mahopdong,ngaytra,mavipham,phiphatsinh,thanhtien,mota) values(?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hdhtm.getId());
            ps.setString(2, hdhtm.getHdm().getMahd());
            ps.setDate(3, new java.sql.Date(hdhtm.getNgaytra().getTime()));
            ps.setInt(4, hdhtm.getVipham().getMa());
            ps.setDouble(5, hdhtm.getPhiphatsinh());
            ps.setDouble(6, hdhtm.getTongtien());
            ps.setString(7, hdhtm.getMota());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean update(HoaDonTraXeModel hdhtm) {
        try ( Connection conn = DBConnections1.getConnection()) {
            String sql = "update hoadontraxe set mahopdong = convert(uniqueidentifier,?),ngaytra = ?, vipham = ?, phiphatsinh = ?, thanhtien = ?, mota = ? where mahoadon = ?";
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
        if(idhd == null || idhd.equalsIgnoreCase("")){
            return 0;
        }
        try ( Connection conn = DBConnections1.getConnection()) {
            double tienthuexe = 0;
            String sql = "select loaiXe.giaThue from hopdong join chitiethopdong on hopdong.mahopdong = chiTietHopDong.mahopdong join chiTietXe on chiTietHopDong.bienSo = chiTietXe.bienSo join loaiXe on loaiXe.maloaixe = chiTietXe.maloaixe where hopDong.mahopdong = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,idhd);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                tienthuexe += rs.getDouble(1);
            }
            return tienthuexe;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }
}
