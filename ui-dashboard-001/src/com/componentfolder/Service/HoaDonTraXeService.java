/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.componentfolder.Service;

import com.componentfolder.Model.ChiTietHopDongModel;
import com.componentfolder.Repository.HoaDonTraXeRepo;
import com.componentfolder.Model.HoaDonTraXeModel;
import com.componentfolder.ViewModel.HoaDonTraXeViewModel;
import com.componentfolder.ViewModel.HopDongViewModel;
import com.componentfolder.ViewModel.KhachHangViewModel;
import java.util.ArrayList;

/**
 *
 * @author lilyp
 */
public interface HoaDonTraXeService {
    public HoaDonTraXeRepo repo = new HoaDonTraXeRepo();

    public ArrayList<HoaDonTraXeViewModel> getlistdata();

    public ArrayList<HoaDonTraXeViewModel> getemptylist();

    public KhachHangViewModel getkh(String idhd);

    public String getnv(String idnv);

    public ArrayList<HopDongViewModel> getlisthd();

    public boolean insert(HoaDonTraXeModel hdhtm);

    public boolean update(HoaDonTraXeModel hdhtm);

    public ArrayList<ChiTietHopDongModel> getdsbienso(String mahd);

    public boolean updatexe(String bienso);

    public boolean delete(HoaDonTraXeModel hdhtm);

    public double tienthuexe(String idhd);

    public String getemail(String makh);

    public ArrayList<String> vipham();

    public String mota(String idhd);

    public HopDongViewModel gethdx(String idhd);
}
