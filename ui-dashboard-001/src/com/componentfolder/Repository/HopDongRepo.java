/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.ChiTietHopDongModel;
import Model.ChiTietXeModel;
import Model.HopDongModel;
import Model.KhachHangModel;
import Model.NhanVienModel;
import Utilities.DBConnections;
import ViewModel.ChiTietHopDongViewModel;
import ViewModel.HopDongViewModel;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author User
 */
public class HopDongRepo {
    private DBConnections connections;
    public ArrayList<HopDongViewModel> getList(){
        ArrayList<HopDongViewModel> listHopDongViewModels = new ArrayList<>();
        String sql = "Select id,idnv,idkh,ngaytao,ngayhethan,tinhtrang \n"
                + "From hopdong";
        try(Connection con = connections.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                HopDongViewModel hopDongViewModel = new HopDongViewModel();
                hopDongViewModel.setId(rs.getString(1));
                hopDongViewModel.setIdnv(rs.getString(2));
                hopDongViewModel.setIdkh(rs.getString(3));
                hopDongViewModel.setNgayTao(rs.getDate(4));
                hopDongViewModel.setNgayHetHan(rs.getDate(5));
                hopDongViewModel.setTinhTrangXe(rs.getInt(6));
                listHopDongViewModels.add(hopDongViewModel);
                
            }
        } catch (Exception e) {
        }
        return listHopDongViewModels;
    }
    public ArrayList<NhanVienModel> getCbNhanVien(){
        ArrayList<NhanVienModel> list = new ArrayList<>();
        String sql = "Select id,ten"
                + "From nhanvien";
        try (Connection con = connections.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                NhanVienModel nhanVienModel = new NhanVienModel();
                nhanVienModel.setId(rs.getString(1));
                nhanVienModel.setTen(rs.getString(2));
                list.add(nhanVienModel);
            }
            
        } catch (Exception e) {
        }
        return list;
}
    public ArrayList<KhachHangModel> getCbKhachHang(){
        ArrayList<KhachHangModel> list = new ArrayList<>();
        String sql = "Select id,ten"
                + "From khachhang";
        try (Connection con = connections.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                KhachHangModel khachHangModel = new KhachHangModel();
                khachHangModel.setId(rs.getString(1));
                khachHangModel.setTen(rs.getString(2));
                list.add(khachHangModel);
            }
            
        } catch (Exception e) {
        }
        return list;
    }
    public ArrayList<ChiTietHopDongViewModel> getListChiTiet(){
        ArrayList<ChiTietHopDongViewModel> listHopDongViewModels = new ArrayList<>();
        String sql = "SELECT idHopDong,idxe,dongia,soluong,tiencoc from chitiethopdong";
        try(Connection con = connections.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ChiTietHopDongViewModel chiTietHopDongViewModel = new ChiTietHopDongViewModel();
                chiTietHopDongViewModel.setIdhd(rs.getString(1));
                chiTietHopDongViewModel.setIdxe(rs.getString(2));
                chiTietHopDongViewModel.setDonGia(rs.getFloat(3));
                chiTietHopDongViewModel.setSoLuong(rs.getInt(4));
                chiTietHopDongViewModel.setTiencoc(rs.getFloat(5));
                listHopDongViewModels.add(chiTietHopDongViewModel);
                
            }
        } catch (Exception e) {
        }
        return listHopDongViewModels;
    }
    public Boolean addChiTiet(ChiTietHopDongModel chiTietHopDongModel){
        String sql ="INSERT INTO chitiethopdong(idHopDong,idxe,dongia,soluong,tiencoc) values (CONVERT(uniqueidentifier,?),CONVERT(uniqueidentifier,?),?,?,?)";
        try (Connection con = connections.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
           ps.setObject(1,chiTietHopDongModel.getIdhd());
           ps.setObject(2, chiTietHopDongModel.getIdxe());
           ps.setObject(3, chiTietHopDongModel.getDongGia());
           ps.setObject(4, chiTietHopDongModel.getSoLuong());
           ps.setObject(5, chiTietHopDongModel.getTienCoc());
           return true;
            
        } catch (Exception e) {
        }
        return false;
    }
    public String tenNhanVien(String id){
        String sql ="SELECT ten from nhanvien where id = CONVERT(uniqueidentifier,?)";
        try(Connection con = connections.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return rs.getString(1);
                
            }
            return null;
        } catch (Exception e) {
        }
        return null;
    }
    public String tenKhachHang(String id){
         String sql ="SELECT ten from khachhang where id = CONVERT(uniqueidentifier,?)";
         try(Connection con = connections.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return rs.getString(1);
                
            }
            return null;
        } catch (Exception e) {
        }
        return null;
    }
    public ArrayList<ChiTietXeModel> getCbid(){
        ArrayList<ChiTietXeModel> list = new ArrayList<>();
        String sql ="Select id from chitietxe";
          try(Connection con = connections.getConnection();
                    PreparedStatement ps = con.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    ChiTietXeModel chiTietXeModel = new ChiTietXeModel();
                    chiTietXeModel.setId(rs.getString(1));
                    list.add(chiTietXeModel);
                }
                
            } catch (Exception e) {
            }
            return list;
        
    }
    public ArrayList<HopDongModel> getCbHD(){
         ArrayList<HopDongModel> list = new ArrayList<>();
        String sql ="Select id from hopdong";
          try(Connection con = connections.getConnection();
                    PreparedStatement ps = con.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    HopDongModel hopDongModel = new HopDongModel();
                    hopDongModel.setId(rs.getString(1));
                    list.add(hopDongModel);
                }
                
            } catch (Exception e) {
            }
            return list;
}
}
