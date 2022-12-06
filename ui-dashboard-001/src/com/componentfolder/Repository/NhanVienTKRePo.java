/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.componentfolder.Repository;

import Utilities.DBConnections;
import com.componentfolder.Model.DangNhap;
import com.componentfolder.Model.NhanVienModel;
import com.componentfolder.ViewModel.KhachHangViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class NhanVienTKRePo {
    private DBConnections connections_Ha;
    public ArrayList<NhanVienModel> getListKh(){
        ArrayList<NhanVienModel> listKH = new ArrayList<>();
        String Sql = "Select  idnv, Ten, sdt,gioitinh , taikhoan from NhanVien";
        try(Connection con = connections_Ha.getConnection();
                PreparedStatement ps = con.prepareStatement(Sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                NhanVienModel kh = new NhanVienModel();
                DangNhap dn = new DangNhap();
                 kh.setId(rs.getString(1));
                 kh.setTen(rs.getString(2));
                 kh.setSdt(rs.getString(3));
                 kh.setGioiTinh(rs.getInt(4));
                 dn.setTaikhoan(rs.getString(5));
                 kh.setTaikhoan(dn);
                 listKH.add(kh);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKH;
        
    }
    public Boolean add(NhanVienModel kh, DangNhap dn){
        String sql = "insert into NhanVien(idnv,ten,sdt,gioitinh,taikhoan) values(?,?,?,?,?)";
        String sql2 = "insert into dangnhap(taikhoan,matkhau,chucvu) values(?,?,?)";
         try (Connection con = connections_Ha.getConnection();){
           PreparedStatement ps = con.prepareStatement(sql2);
           ps.setObject(1, dn.getTaikhoan());
           ps.setObject(2, dn.getMatkhau());
           ps.setObject(3, dn.getChucvu());
           ps.executeUpdate();
           PreparedStatement ps2 = con.prepareStatement(sql);
           ps2.setObject(2, kh.getTen());
           ps2.setObject(3, kh.getSdt());
           ps2.setObject(4, kh.getGioiTinh());
           ps2.setObject(5, dn.getTaikhoan());
           ps2.setObject(1, kh.getId());
           ps2.executeUpdate();
           return true;
       } catch (Exception e) {
           e.printStackTrace();
           return false;
       }
            
    }
    public int getcountDB(){
        int he = 0;
        String Sql = "Select COUNT(idnv) from nhanvien";
        try(Connection con = connections_Ha.getConnection();
                PreparedStatement ps = con.prepareStatement(Sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               he = rs.getInt(1);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return he;
        
    }
    public Boolean update(NhanVienModel kh, DangNhap dn){
        String sql = "Update NhanVien Set Ten = ?, sdt = ?, gioitinh = ?, where maKh = ?";
        String sql2 = "Update dangnhap set matkhau = ?, chucvu =? where taikhoan = ?";
         try (Connection con = connections_Ha.getConnection();){
           PreparedStatement ps = con.prepareStatement(sql2);
           ps.setObject(3, dn.getTaikhoan());
           ps.setObject(1, dn.getMatkhau());
           ps.setObject(2, dn.getChucvu());
           ps.executeUpdate();
           PreparedStatement ps2 = con.prepareStatement(sql);
           ps2.setObject(1, kh.getTen());
           ps2.setObject(2, kh.getSdt());
           ps2.setObject(3, kh.getGioiTinh());
           ps2.setObject(4, kh.getId());
           ps2.executeUpdate();
           return true;
       } catch (Exception e) {
           e.printStackTrace();
           return false;
       }
            
    }
}
