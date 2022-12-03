/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.componentfolder.Service.Impl;


import com.componentfolder.ViewModel.HoaDonTraXeViewModel;
import com.componentfolder.ViewModel.KhachHangViewModel;
import com.componentfolder.Model.HoaDonTraXeModel;
import com.componentfolder.Service.HoaDonTraXeService;
import com.componentfolder.ViewModel.HopDongViewModel;
import java.util.ArrayList;

/**
 *
 * @author lilyp
 */
public class HoaDonTraXeServiceImpl implements HoaDonTraXeService{

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
    
}
