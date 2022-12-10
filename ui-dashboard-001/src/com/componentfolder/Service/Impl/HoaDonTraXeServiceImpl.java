/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.componentfolder.Service.Impl;

import com.componentfolder.Model.ChiTietHopDongModel;
import com.componentfolder.Model.ChiTietViPhamModel;
import com.componentfolder.Model.HoaDonTraXeModel;
import com.componentfolder.Model.ViPhamModel;
import com.componentfolder.Service.HoaDonTraXeService;
import com.componentfolder.ViewModel.HoaDonTraXeViewModel;
import com.componentfolder.ViewModel.HopDongViewModel;
import com.componentfolder.ViewModel.KhachHangViewModel;
import java.util.ArrayList;

/**
 *
 * @author lilyp
 */
public class HoaDonTraXeServiceImpl implements HoaDonTraXeService {
    @Override
    public ArrayList<HoaDonTraXeViewModel> getlistdata() {
        return repo.getlistdata();
    }

    @Override
    public KhachHangViewModel getkh(String idhd) {
        return repo.getkh(idhd);
    }

    @Override
    public ArrayList<HopDongViewModel> getlisthd() {
        return repo.getlisthd();
    }

    @Override
    public boolean insert(HoaDonTraXeModel hdhtm) {
        return repo.insert(hdhtm);
    }

    @Override
    public boolean update(HoaDonTraXeModel hdhtm) {
        return repo.update(hdhtm);
    }

    @Override
    public boolean delete(HoaDonTraXeModel hdhtm) {
        return repo.delete(hdhtm);
    }

    @Override
    public ArrayList<HoaDonTraXeViewModel> getemptylist() {
        return repo.getemptylist();
    }

    @Override
    public String getnv(String idnv) {
        return repo.getnv(idnv);
    }

    @Override
    public ArrayList<ChiTietHopDongModel> getdsbienso(String mahd) {
        return repo.getdsbienso(mahd);
    }

    @Override
    public boolean updatexe(String bienso) {
        return repo.updatexe(bienso);
    }

    @Override
    public double tienthuexe(String idhd) {
        return repo.tienthuexe(idhd);
    }

    @Override
    public String getemail(String makh) {
        return repo.getemail(makh);
    }

    @Override
    public String mota(String idhd) {
        return repo.mota(idhd);
    }

    @Override
    public HopDongViewModel gethdx(String idhd) {
        return repo.gethdx(idhd);
    }

    @Override
    public boolean updatevipham(ChiTietViPhamModel ctvpm) {
        return repo.updatevipham(ctvpm);
    }

    @Override
    public int getsovipham(String mahd) {
        return repo.getsovipham(mahd);
    }

    @Override
    public ArrayList<ViPhamModel> vipham() {
        return repo.vipham();
    }

}
