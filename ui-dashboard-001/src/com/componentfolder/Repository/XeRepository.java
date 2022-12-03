/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.componentfolder.Repository;

import Utilities.DBConnections;
import com.componentfolder.Model.Xe;
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
public class XeRepository {
    public List<Xe> getAll() {
        String query = "SeLect * From Xe";
        try ( Connection con = DBConnections.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            List<Xe> listLoaiXe = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Xe xe = new Xe();
                xe.setId(rs.getString(1));
                xe.setMa(rs.getString(2));
                xe.setTenXe(rs.getString(3));
                listLoaiXe.add(xe);
            }
            return listLoaiXe;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
}
