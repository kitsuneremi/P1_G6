/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.componentfolder.Repository;

import com.componentfolder.Model.ChiTietHopDongModel;
import com.componentfolder.Model.ChiTietXeModel;
import com.componentfolder.Model.HopDongModel;
import com.componentfolder.Model.KhachHangModel;
import com.componentfolder.Model.NhanVienModel;
import com.componentfolder.Utilities.DBConnections;
import com.componentfolder.ViewModel.ChiTietHopDongViewModel;
import com.componentfolder.ViewModel.HopDongViewModel;
import com.componentfolder.ViewModel.InHopDongViewModel;
import java.awt.Image;
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
        String sql = "Select mahopdong,idNv,makh,ngaytao,ngayhethan,tinhtrang,sourceAnh \n"
                + "From hopdong";
        try(Connection con = connections.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                HopDongViewModel hopDongViewModel = new HopDongViewModel();
                hopDongViewModel.setMahd(rs.getString(1));
                hopDongViewModel.setIdnv(rs.getString(2));
                hopDongViewModel.setIdkh(rs.getString(3));
                hopDongViewModel.setNgayTao(rs.getDate(4));
                hopDongViewModel.setNgayHetHan(rs.getDate(5));
                hopDongViewModel.setTinhTrangXe(rs.getInt(6));
                hopDongViewModel.setSourceAnh(rs.getString(7));
                ;
                listHopDongViewModels.add(hopDongViewModel);
                
            }
        } catch (Exception e) {
        }
        return listHopDongViewModels;
    }
    public Boolean deleteHopDong(String id){
        String sql = "DELETE From hopdong where mahopdong = ?";
        try(Connection con = connections.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1,id);
            ps.executeUpdate();
            return true;
            
        } catch (Exception e) {
        }
        return false;
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
                khachHangModel.setMakh(rs.getString(1));
                khachHangModel.setTen(rs.getString(2));
                list.add(khachHangModel);
            }
            
        } catch (Exception e) {
        }
        return list;
    }
    public Boolean add(HopDongModel hopDongModel){
        int checkInsert = 0;
        String sql = "INSERT INTO hopdong(mahopdong,idnv,maKh,ngaytao,ngayhethan,tinhtrang,sourceAnh) values (?,?,?,?,?,?,?)";
        try (Connection con = connections.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
            ps.setObject(1, hopDongModel.getMahd());           
            ps.setObject(2, hopDongModel.getIdnv().getId());
            ps.setObject(3, hopDongModel.getIdkh().getMakh());
            ps.setDate(4, new java.sql.Date(hopDongModel.getNgayTao().getTime()));
            ps.setDate(5, new java.sql.Date(hopDongModel.getNgayHetHan().getTime()));
            ps.setInt(6, hopDongModel.getTinhTrang());
            ps.setObject(7, hopDongModel.getSourceAnh());
            
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }
    public Boolean update(HopDongModel hopDongModel,String id){
        String sql ="update hopdong set tinhtrang = ? where mahopdong =?" ;
        try(Connection con = connections.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, hopDongModel.getTinhTrang());
            ps.setObject(2, id);
            ps.executeUpdate();
            return true;
            
        } catch (Exception e) {
            return false;
        }
        
    }
    public Boolean update2(HopDongModel hopDongModel,String id){
        String sql ="update hopdong set idNv =?,makh =?,ngayTao = ?,ngayHetHan = ?,tinhtrang = ?,sourceAnh = ? where mahopdong =?" ;
        try(Connection con = connections.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, hopDongModel.getIdnv().getId());
            ps.setObject(2, hopDongModel.getIdkh().getMakh());
            ps.setObject(3, hopDongModel.getNgayTao());
            ps.setObject(4, hopDongModel.getNgayHetHan());
            ps.setObject(5, hopDongModel.getTinhTrang());
            ps.setObject(6, hopDongModel.getSourceAnh());
            ps.setObject(7, id);
            
            ps.executeUpdate();
            return true;
            
        } catch (Exception e) {
            return false;
        }
        
    }
    public ArrayList<ChiTietHopDongViewModel> getListChiTiet(){
        ArrayList<ChiTietHopDongViewModel> listHopDongViewModels = new ArrayList<>();
        String sql = "SELECT mahopdong,bienso,tiencoc from chitiethopdong";
        try(Connection con = connections.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ChiTietHopDongViewModel chiTietHopDongViewModel = new ChiTietHopDongViewModel();
                chiTietHopDongViewModel.setMahd(rs.getString(1));
                chiTietHopDongViewModel.setBienso(rs.getString(2));
                chiTietHopDongViewModel.setTiencoc(rs.getFloat(3));
                listHopDongViewModels.add(chiTietHopDongViewModel);
                
            }
        } catch (Exception e) {
        }
        return listHopDongViewModels;
    }
    public Boolean addChiTiet(ChiTietHopDongModel chiTietHopDongModel){
        String sql ="INSERT INTO chitiethopdong(mahopdong,bienso,tiencoc) values (?,?,?)";
        try (Connection con = connections.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
           ps.setObject(1,chiTietHopDongModel.getMahd().getMahd());
           ps.setObject(2, chiTietHopDongModel.getBienso());       
           ps.setObject(3, chiTietHopDongModel.getTienCoc());
           ps.executeUpdate();
           return true;
            
        } catch (Exception e) {
            return false;
        }
        
    }
    public String bienso(String id){
        String sql ="Select bienso from chitietxe where id = convert(uniqueidentifier,?)";
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
    public String idchitietxe(String bienso){
        String sql = "Select id from chitietxe where bienso = ?";
         try(Connection con = connections.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, bienso);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return rs.getString(1);
                
            }
            return null;
        } catch (Exception e) {
        }
        return null;
    }
    public Boolean DeleteChiTiet(String idhd){
        String sql = "DELETE FROM chitiethopdong where mahopdong = ?";
        try (Connection con = connections.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
            ps.setObject(1, idhd);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public Boolean updateChiTiet(ChiTietHopDongModel chiTietHopDongModel,String idhd){
        String sql = "UPDATE chitiethopdong set bienso = ?, tiencoc = ? where mahopdong = ?";
        try(Connection con = connections.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
           ps.setObject(1, chiTietHopDongModel.getBienso());
           ps.setObject(2, chiTietHopDongModel.getTienCoc());
           
           ps.setObject(3, idhd);
           ps.executeUpdate();
           return true;
            
        } catch (Exception e) {
            return false;
        }
    }
    public String tenNhanVien(String id){
        String sql ="SELECT ten from nhanvien where idnv = ?";
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
    public String idnhanvien(String ten){
        String sql = "Select idnv from nhanvien where ten = ?";
        try(Connection con = connections.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return rs.getString(1);
                
            }
            return null;
        } catch (Exception e) {
        }
        return null;
    }
    public String idkhachhang(String ten){
        String sql = "Select maKH from khachhang where ten = ?";
        try(Connection con = connections.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ten);
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
         String sql ="SELECT ten from khachhang where makh = ?";
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
    public ArrayList<String> getCbid(){
        ArrayList<String> list = new ArrayList<>();
        String sql ="Select bienso from chitietxe where (tinhTrangXe = 0) or (tinhTrangXe = 1) ";
          try(Connection con = connections.getConnection();
                    PreparedStatement ps = con.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    String a = rs.getString(1);
                    list.add(a);
                }
                
            } catch (Exception e) {
            }
            return list;
        
    }
    public ArrayList<String> getCbHD(){
         ArrayList<String> list = new ArrayList<>();
        String sql ="Select mahopdong from hopdong ";
          try(Connection con = connections.getConnection();
                    PreparedStatement ps = con.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    String a = rs.getString(1);
                    list.add(a);
                }
                
            } catch (Exception e) {
            }
            return list;
}
    public ArrayList<String> getCbLoai(){
        ArrayList<String> list = new ArrayList<>();
        String sql = "Select ma from loaixe ";
        try(Connection con = connections.getConnection();
                    PreparedStatement ps = con.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    String a = rs.getString(1);
                    list.add(a);
                }
                
            } catch (Exception e) {
            }
            return list;
    }
    public ArrayList<String> getCbNV(){
        ArrayList<String> list = new ArrayList<>();
        String sql = "select ten from nhanvien";
         try(Connection con = connections.getConnection();
                    PreparedStatement ps = con.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    String a = rs.getString(1);
                    list.add(a);
                }
                
            } catch (Exception e) {
            }
            return list;
}
      public ArrayList<String> getCbKH(){
        ArrayList<String> list = new ArrayList<>();
        String sql = "select ten from khachhang";
         try(Connection con = connections.getConnection();
                    PreparedStatement ps = con.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    String a = rs.getString(1);
                    list.add(a);
                }
                
            } catch (Exception e) {
            }
            return list;
}
       public ArrayList<InHopDongViewModel> getListIn(){
        ArrayList<InHopDongViewModel> listHopDongViewModels = new ArrayList<>();
        String sql = "Select khachhang.ten,khachhang.cCCD,chitiethopdong.bienso,chitiethopdong.tiencoc,hopdong.ngayTao,hopdong.ngayHetHan from chitiethopdong join hopdong \n" +
"on chitiethopdong.mahopdong = hopDong.mahopdong join khachhang on khachhang.makh = hopdong.makh";
                
        try(Connection con = connections.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                InHopDongViewModel inHopDongViewModel = new InHopDongViewModel();
                inHopDongViewModel.setTen(rs.getString(1));
                inHopDongViewModel.setCccd(rs.getString(2));
                inHopDongViewModel.setBienso(rs.getString(3));
                inHopDongViewModel.setTiencoc(rs.getFloat(4));
                inHopDongViewModel.setNgaytao(rs.getDate(5));
                inHopDongViewModel.setNgayhethan(rs.getDate(6));
                listHopDongViewModels.add(inHopDongViewModel);
                
            }
        } catch (Exception e) {
        }
        return listHopDongViewModels;
    }
       public Boolean update3(ChiTietXeModel chiTietXeModel,String bienso){
           String sql ="UPDATE chitietxe set tinhTrangXe = ? where bienso =?";
           try(Connection con = connections.getConnection();
                   PreparedStatement ps = con.prepareStatement(sql)) {
               ps.setObject(1, chiTietXeModel.getTinhTrangXe());
               ps.setObject(2, bienso);
               ps.executeUpdate();
               return true;
               
           } catch (Exception e) {
               return false;
           }
       }
    
    
    
}
