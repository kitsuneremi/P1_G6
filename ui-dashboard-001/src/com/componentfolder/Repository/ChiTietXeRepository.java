/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.ChiTietXe;
import Model.LoaiXe;
import Model.PBD;
import Model.Xe;
import Utilities.DBConnections;
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
        String query = "SeLect * From ChiTietXe";
        try ( Connection con = DBConnections.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            List<ChiTietXe> listChiTietXe = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Xe xe = new Xe();
                xe.setId(rs.getString(2));
                LoaiXe loaiXe = new LoaiXe();
                loaiXe.setId(rs.getString(3));
                PBD phieuBD = new PBD();
                phieuBD.setId(rs.getString(4));
                ChiTietXe ctXe = new ChiTietXe(rs.getString(1), xe, loaiXe, con, rs.getFloat(5), rs.getString(6), rs.getInt(7), rs.getString(8));
                listChiTietXe.add(ctXe);
                
            }
            return listChiTietXe;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
}
