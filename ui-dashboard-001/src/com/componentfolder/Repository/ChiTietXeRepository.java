/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.componentfolder.Repository;

import Utilities.DBConnections;
import com.componentfolder.Model.ChiTietXe;
import com.componentfolder.Model.LoaiXe;
import com.componentfolder.ViewModel.Top10ViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class ChiTietXeRepository {

    public List<ChiTietXe> getAll() {
        String query = " SELECT dbo.chiTietXe.bienSo, dbo.loaiXe.maLx,dbo.loaiXe.dongXe, dbo.loaiXe.ten, dbo.chiTietXe.tinhTrangXe, dbo.chiTietXe.giathuetrenngay, dbo.chiTietXe.mota\n"
                + "FROM     dbo.loaiXe INNER JOIN\n"
                + "                  dbo.chiTietXe ON dbo.loaiXe.maLx = dbo.chiTietXe.maLx";
        try ( Connection con = DBConnections.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            List<ChiTietXe> listChiTietXe = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LoaiXe loaiXe = new LoaiXe(rs.getString(2), rs.getString(4), rs.getString(3));
                ChiTietXe ctXe = new ChiTietXe(rs.getString(1), loaiXe, rs.getInt(5), rs.getDouble(6), rs.getString(7));
                listChiTietXe.add(ctXe);
            }
            return listChiTietXe;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<Top10ViewModel> getTop10ThueXe() {
        String query = " SELECT top 10  dbo.loaiXe.maLx,Loaixe.ten, count(loaiXe.maLx) as soLuotThue, chitietXe.mota\n"
                + "FROM     dbo.loaiXe INNER JOIN\n"
                + "                  dbo.chiTietXe ON dbo.loaiXe.maLx = dbo.chiTietXe.maLx where tinhtrangxe  = 1 group by loaiXe.malx,Loaixe.ten,chiTietXe.mota order by soLuotThue Desc";
        try ( Connection con = DBConnections.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            List<Top10ViewModel> listTop10 = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Top10ViewModel top10 = new Top10ViewModel(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4));
                listTop10.add(top10);
            }
            return listTop10;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean saveChiTietXe(ChiTietXe chiTietXe) {
        String query = "INSERT INTO [dbo].[chiTietXe]\n"
                + "           ([bienSo]\n"
                + "           ,[maLx]\n"
                + "           ,[tinhTrangXe]\n"
                + "           ,[giathuetrenngay]\n"
                + "           ,[mota])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?)";
        int check = 0;
        try ( Connection con = DBConnections.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, chiTietXe.getBienSo());
            ps.setObject(2, chiTietXe.getLoaiXe().getMaLoai());
            ps.setObject(3, chiTietXe.getTinhTrang());
            ps.setObject(4, chiTietXe.getGia());
            ps.setObject(5, chiTietXe.getMoTa());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean updateChiTietXe(ChiTietXe chiTietXe, String bienSo) {
        String query = "UPDATE [dbo].[chiTietXe]\n"
                + "   SET [maLx] = ?\n"
                + "      ,[tinhTrangXe] = ?\n"
                + "      ,[giathuetrenngay] = ?\n"
                + "      ,[mota] = ?\n"
                + " WHERE bienSo = ?";
        int check = 0;
        try ( Connection con = DBConnections.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(5, bienSo);
            ps.setObject(1, chiTietXe.getLoaiXe().getMaLoai());
            ps.setObject(2, chiTietXe.getTinhTrang());
            ps.setObject(3, chiTietXe.getGia());
            ps.setObject(4, chiTietXe.getMoTa());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    
    public boolean insertloaixe(LoaiXe lxm){
        String sql = "insert into loaixe (malx,ten,gianhap,dongxe,theloaixe) values (?,?,?,?,?)";
        try(Connection con = DBConnections.getConnection();  PreparedStatement ps = con.prepareStatement(sql);){
            ps.setString(1, lxm.getMaLoai());
            ps.setString(2, lxm.getTen());
            ps.setDouble(3, lxm.getGiaNhap());
            ps.setString(4, lxm.getDongXe());
            ps.setString(5, lxm.getTenTheLoai());
            return ps.executeUpdate() > 0;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean updateloaixe(LoaiXe lxm){
        String sql = "update loaixe set ten = ?, gianhap = ?, dongxe = ?, theloaixe = ? where malx = ?";
        try(Connection con = DBConnections.getConnection();  PreparedStatement ps = con.prepareStatement(sql);){
            ps.setString(1, lxm.getTen());
            ps.setDouble(2, lxm.getGiaNhap());
            ps.setString(3, lxm.getDongXe());
            ps.setString(4, lxm.getTenTheLoai());
            ps.setString(5, lxm.getMaLoai());
            return ps.executeUpdate() > 0;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean updatechitietxe(ChiTietXe ctx){
        String sql = "update chitietxe set tinhtrangxe = ?, mota = ? where bienso = ?  ";
        try(Connection con = DBConnections.getConnection();  PreparedStatement ps = con.prepareStatement(sql);){
            ps.setInt(1, ctx.getTinhTrang());
            ps.setString(2, ctx.getMoTa());
            ps.setString(3, ctx.getBienSo());
            return ps.executeUpdate() > 0;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }
    
    public int countslxe(){
        String sql = "select count(*) from loaixe";
        try(Connection con = DBConnections.getConnection();  PreparedStatement ps = con.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return rs.getInt(1);
            }
            return 0;
        }catch(SQLException ex){
            ex.printStackTrace();
            return 0;
        }
    }
    
    
    public boolean insertchitietxe(ChiTietXe ctx){
        String sql = "insert into chitietxe(bienso, malx, tinhtrangxe, giathuetrenngay, mota) values (?,?,?,?,?)";
        try(Connection con = DBConnections.getConnection();  PreparedStatement ps = con.prepareStatement(sql);){
            ps.setString(1, ctx.getBienSo());
            ps.setString(2, ctx.getLoaiXe().getMaLoai());
            ps.setInt(3, ctx.getTinhTrang());
            ps.setDouble(4, ctx.getGia());
            ps.setString(5, ctx.getMoTa());
            return ps.executeUpdate() > 0;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }
}
