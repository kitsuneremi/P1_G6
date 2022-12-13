/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.componentfolder.Repository;


import com.componentfolder.Utilities.DBConnections;
import com.componentfolder.Utilities.DBConnections_Ha;
import com.componentfolder.ViewModel.KhachHangViewModel;
import com.componentfolder.Model.KhachHangModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class KhachHangRepo {
    private DBConnections connections_Ha;
    public ArrayList<KhachHangViewModel> getListKh(){
        ArrayList<KhachHangViewModel> listKH = new ArrayList<>();
        String Sql = "Select  makh, Ten, sdt,gioitinh , cccd,email from KhachHang";
        try(Connection con = connections_Ha.getConnection();
                PreparedStatement ps = con.prepareStatement(Sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                KhachHangViewModel kh = new KhachHangViewModel();
                 kh.setMakh(rs.getString(1));
                 kh.setTen(rs.getString(2));
                 kh.setSdt(rs.getString(3));
                 kh.setGioitinh(rs.getInt(4));
                 kh.setCccd(rs.getString(5));
                 kh.setEmail(rs.getString(6));
                 listKH.add(kh);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKH;
        
    }
    public Boolean add(KhachHangModel kh){
        String sql = "insert into khachhang(makh,ten,sdt,gioitinh,cccd,email) values(?,?,?,?,?,?)";
         try (Connection con = connections_Ha.getConnection();){
           PreparedStatement ps2 = con.prepareStatement(sql);
           ps2.setObject(2, kh.getTen());
           ps2.setObject(3, kh.getSdt());
           ps2.setObject(4, kh.getGioitinh());
           ps2.setObject(5, kh.getCccd());
           ps2.setObject(1, kh.getMakh());
           ps2.setObject(6, kh.getEmail());
           ps2.executeUpdate();
           return true;
       } catch (Exception e) {
           e.printStackTrace();
           return false;
       }
            
    }
    public Boolean update(KhachHangModel kh){
        String sql = "Update khachhang set ten = ?,sdt = ? ,gioitinh = ?,cccd =?, email = ? Where MaKh = ?";
         try (Connection con = connections_Ha.getConnection();PreparedStatement ps2 = con.prepareStatement(sql);){          
           ps2.setObject(1, kh.getTen());
           ps2.setObject(2, kh.getSdt());
           ps2.setObject(3, kh.getGioitinh());
           ps2.setObject(4, kh.getCccd());
           ps2.setObject(5, kh.getEmail());
           ps2.setObject(6, kh.getMakh());
           ps2.executeUpdate();
             System.out.println(kh.getMakh());
           return true;
       } catch (Exception e) {
           e.printStackTrace();
           return false;
       }
            
    }
    public int getcountDB(){
        int mkh = 0;
        String Sql = "Select COUNT(makh) from KhachHang";
        try(Connection con = connections_Ha.getConnection();
                PreparedStatement ps = con.prepareStatement(Sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                mkh = rs.getInt(1);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mkh;
        
    }
    public ArrayList<KhachHangViewModel> search(String ten){
        String sql = "Select makh, Ten, sdt,gioitinh,cccd,email from khachhang where makh Like ? or ten like ? or sdt = ? or cccd = ? or email = ?";
        ArrayList<KhachHangViewModel> listKH = new ArrayList<>();
        try (Connection con = connections_Ha.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, "%"+ten+"%");
            ps.setString(2, "%"+ten+"%");
            ps.setString(3, ten);
            ps.setString(4, ten);
            ps.setString(5, ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHangViewModel g = new KhachHangViewModel();
                g.setMakh(rs.getString(1));
                g.setTen(rs.getString(2));
                g.setSdt(rs.getString(3));
                g.setGioitinh(rs.getInt(4));
                g.setCccd(rs.getString(5));
                g.setEmail(rs.getString(6));
                listKH.add(g);

            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKH;
    }
}
