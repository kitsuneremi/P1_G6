/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.componentfolder.Service;

import Utilities.DBConnections;
import com.componentfolder.Model.ChiTietHopDongModel;
import com.componentfolder.Model.ChiTietViPhamModel;
import com.componentfolder.Repository.HoaDonTraXeRepo;
import com.componentfolder.Model.HoaDonTraXeModel;
import com.componentfolder.Model.HopDongModel;
import com.componentfolder.Model.ViPhamModel;
import com.componentfolder.ViewModel.HoaDonTraXeViewModel;
import com.componentfolder.ViewModel.HopDongViewModel;
import com.componentfolder.ViewModel.KhachHangViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author lilyp
 */
public interface HoaDonTraXeService {
    HoaDonTraXeRepo repo = new HoaDonTraXeRepo();

    public ArrayList<HoaDonTraXeViewModel> getlistdata();

    public ArrayList<HoaDonTraXeViewModel> getemptylist();

    public KhachHangViewModel getkh(String idhd);

    public String getnv(String idnv);

    public ArrayList<HopDongViewModel> getlisthd();

    public boolean insert(HoaDonTraXeModel hdtxm);

    public boolean update(HoaDonTraXeModel hdtxm);

    public boolean updatevipham(ChiTietViPhamModel ctvpm);

    public ArrayList<ChiTietHopDongModel> getdsbienso(String mahd);

    public boolean updatexe(String bienso);

    public boolean delete(HoaDonTraXeModel hdhtm);

    public double tienthuexe(String idhd);

    public String getemail(String makh);

    public ArrayList<ViPhamModel> vipham();

    public String mota(String mahd);

    public HopDongViewModel gethdx(String mahd);

    public int getsovipham(String mahd);
}
