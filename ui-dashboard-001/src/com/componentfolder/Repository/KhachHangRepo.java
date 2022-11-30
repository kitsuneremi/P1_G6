/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Model.KhachHangModel;
import Utilities.DBConnections_Ha;
import ViewModel.KhachHangViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class KhachHangRepo {
    private DBConnections_Ha connections_Ha;
    public ArrayList<KhachHangViewModel> getListKh(){
        ArrayList<KhachHangViewModel> listKH = new ArrayList<>();
        String Sql = "Select  makh, Ten, sdt,gioitinh , cccd from KhachHang";
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
                 listKH.add(kh);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKH;
        
    }
    public Boolean add(KhachHangModel kh){
        String sql = "insert into khachhang(id,ten,sdt,gioitinh,cccd,makh) values(NEWID(),?,?,?,?,?)";
         try (Connection con = connections_Ha.getConnection();){
           PreparedStatement ps2 = con.prepareStatement(sql);
           ps2.setObject(1, kh.getTen());
           ps2.setObject(2, kh.getSdt());
           ps2.setObject(3, kh.getGioitinh());
           ps2.setObject(4, kh.getCccd());
           ps2.setObject(5, kh.getMakh());
           ps2.executeUpdate();
           return true;
       } catch (Exception e) {
           e.printStackTrace();
           return false;
       }
            
    }
    public Boolean update(KhachHangModel kh){
        String sql = "Update khachhang set ten = ?,sdt = ? ,gioitinh = ?,cccd =?,Where MaKh = ?";
         try (Connection con = connections_Ha.getConnection();){
           PreparedStatement ps2 = con.prepareStatement(sql);
           ps2.setObject(1, kh.getTen());
           ps2.setObject(2, kh.getSdt());
           ps2.setObject(3, kh.getGioitinh());
           ps2.setObject(4, kh.getCccd());
           ps2.setObject(5, kh.getMakh());
           ps2.executeUpdate();
           return true;
       } catch (Exception e) {
           e.printStackTrace();
           return false;
       }
            
    }
    public int getcountDB(){
        int mkh = 0;
        String Sql = "Select  COUNT(id) from KhachHang";
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
}
