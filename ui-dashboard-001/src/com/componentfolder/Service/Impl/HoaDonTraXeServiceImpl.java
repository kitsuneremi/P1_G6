/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import Model.HoaDonTraXeModel;
import ViewModel.HoaDonTraXeViewModel;
import ViewModel.HopDongViewModel;
import ViewModel.KhachHangViewModel;
import java.util.ArrayList;
import Service.HoaDonTraXeService;

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
