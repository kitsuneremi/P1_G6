/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.componentfolder.Repository;

import Utilities.DBConnections;
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
                LoaiXe loaiXe = new LoaiXe();
                loaiXe.setId(rs.getString(1));
                loaiXe.setMa(rs.getString(2));
                loaiXe.setTenLoaiXe(rs.getString(3));
                listLoaiXe.add(loaiXe);
            }
            return listLoaiXe;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    public static void main(String[] args) {
        List<LoaiXe> list = new LoaiXeRepository().getAll();
        for(LoaiXe xe : list){
            System.out.println(xe.toString());
        }
    }
    
}
