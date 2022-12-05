/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.componentfolder.Repository;

import Utilities.DBConnections;
import com.componentfolder.Utilities.DBConnections_Ha;
import com.componentfolder.Model.DangNhap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author HA NGUYEN
 */
public class DangNhapRepo {

    private DBConnections connections;

    public String get(String tk, String mk) {
        DangNhap g = new DangNhap();
        String sql = "Select chucvu from dangnhap where taikhoan = ? and matkhau = ?";
        try (Connection con = connections.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, tk);
            ps.setString(2, mk);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                
                g.setChucvu(rs.getString(1));
                
            }
            System.out.println(g.getChucvu());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return g.getChucvu();

    }
}
