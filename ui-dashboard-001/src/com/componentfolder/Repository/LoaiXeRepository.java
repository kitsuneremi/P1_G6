/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.componentfolder.Repository;

import com.componentfolder.Utilities.DBConnections;
import com.componentfolder.Model.LoaiXe;
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
public class LoaiXeRepository {

    public List<LoaiXe> getAll() {
        String query = "SeLect * From LoaiXe";
        try ( Connection con = DBConnections.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            List<LoaiXe> listLoaiXe = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LoaiXe loaiXe = new LoaiXe(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getString(5));
                listLoaiXe.add(loaiXe);
            }
            return listLoaiXe;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean saveLoaiXe(LoaiXe loaiXe) {
        String query = "INSERT INTO [dbo].[loaiXe]\n"
                + "           ([maLx]\n"
                + "           ,[ten]\n"
                + "           ,[giaNhap]\n"
                + "           ,[dongxe]\n"
                + "           ,[theloaixe])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?)";
        int check = 0;
        try ( Connection con = DBConnections.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, loaiXe.getMaLoai());
            ps.setObject(2, loaiXe.getTen());
            ps.setObject(3, loaiXe.getGiaNhap());
            ps.setObject(4, loaiXe.getDongXe());
            ps.setObject(5, loaiXe.getTenTheLoai());
            check = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean updateLoaiXe(LoaiXe loaiXe, String ma) {
        String query = "UPDATE [dbo].[loaiXe]\n"
                + "   SET [ten] = ?\n"
                + "      ,[giaNhap] = ?\n"
                + "      ,[dongxe] = ?\n"
                + "      ,[theloaixe] = ?\n"
                + " WHERE maLx = ?";
        int check = 0;
        try ( Connection con = DBConnections.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(5, ma);
            ps.setObject(1, loaiXe.getTen());
            ps.setObject(2, loaiXe.getGiaNhap());
            ps.setObject(3, loaiXe.getDongXe());
            ps.setObject(4, loaiXe.getTenTheLoai());
            check = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean removeLoaiXe(String ma) {
        String query = "DELETE FROM [dbo].[loaiXe]\n"
                + "      WHERE maLx = ?";
        int check = 0;
        try ( Connection con = DBConnections.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, ma);
            check = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public static void main(String[] args) {
        List<LoaiXe> list = new LoaiXeRepository().getAll();
        for (LoaiXe xe : list) {
            System.out.println(xe.toString());
        }
    }

}
