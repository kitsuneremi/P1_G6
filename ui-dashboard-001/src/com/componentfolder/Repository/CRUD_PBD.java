/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.componentfolder.Repository;


import Utilities.DBConnections;
import ViewModel.PBDViewModel;
import com.componentfolder.Model.PBD;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author Admin
 */
public class CRUD_PBD {

    private DBConnections connections_PBD;

    public ArrayList<PBDViewModel> getListFromDB() {

        ArrayList<PBDViewModel> getListPBD = new ArrayList<>();

        String sql = "select id, ngayBaoDuong, ngayHoanThanh, chiPhi, bienSoXe \n"
                + "from phieuBaoDuong";

        try ( Connection con = connections_PBD.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                PBDViewModel listPBDViewModel = new PBDViewModel();

                listPBDViewModel.setId(rs.getString(1));
                listPBDViewModel.setNgayBaoDuong(rs.getDate(2));
                listPBDViewModel.setNgayHoanThanh(rs.getDate(3));
                listPBDViewModel.setChiPhi(rs.getFloat(4));
                listPBDViewModel.setBienSoXe(rs.getString(5));

                getListPBD.add(listPBDViewModel);
            }
        } catch (Exception e) {
        }

        return getListPBD;
    }

    public Boolean Them(PBD pbd) {

        String sql = "insert into phieuBaoDuong(id, ngayBaoDuong, ngayHoanThanh, chiPhi, bienSoXe) \n"
                + "values(newid(), ?, ?, ?, ?)";

        try ( Connection con = connections_PBD.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setObject(1, pbd.getNgayBaoDuong());
            ps.setObject(2, pbd.getNgayHoanThanh());
            ps.setObject(3, pbd.getChiPhi());
            ps.setObject(4, pbd.getBienSoXe());

            ps.executeUpdate();

            return true;
        } catch (Exception e) {
        }

        return false;
    }

    public Boolean Sua(PBD id) {

        String sql = "update phieuBaoDuong\n"
                + "set ngayBaoDuong = ?, ngayHoanThanh = ?, chiPhi = ?, bienSoXe = ?\n"
                + "where phieuBaoDuong.id = ?";

        try ( Connection con = connections_PBD.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setObject(1, id.getNgayBaoDuong());
            ps.setObject(2, id.getNgayHoanThanh());
            ps.setObject(4, id.getBienSoXe());
            ps.setObject(3, id.getChiPhi());
            ps.setObject(5, id.getId());

            ps.executeUpdate();

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<PBDViewModel> timKiemPhieu(String bienSoXe) {

        ArrayList<PBDViewModel> searchListPBD = new ArrayList<>();

        String sql = "select id, ngayBaoDuong, ngayHoanThanh, chiPhi, bienSoXe \n"
                + "from phieuBaoDuong where bienSoXe = ?";

        try ( Connection con = connections_PBD.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setObject(1, bienSoXe);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                PBDViewModel listPBDViewModel = new PBDViewModel();

                listPBDViewModel.setId(rs.getString(1));
                listPBDViewModel.setNgayBaoDuong(rs.getDate(2));
                listPBDViewModel.setNgayHoanThanh(rs.getDate(3));
                listPBDViewModel.setChiPhi(rs.getFloat(4));
                listPBDViewModel.setBienSoXe(rs.getString(5));

                searchListPBD.add(listPBDViewModel);

            }
        } catch (Exception e) {
        }

        return searchListPBD;
    }

    public static void main(String[] args) {

        ArrayList<PBDViewModel> mainPBD = new CRUD_PBD().getListFromDB();

        for (PBDViewModel pBDViewModel : mainPBD) {

            System.out.println(pBDViewModel.toString());
        }
    }
}
