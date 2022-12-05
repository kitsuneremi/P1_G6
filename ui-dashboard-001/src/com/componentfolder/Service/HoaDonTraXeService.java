/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.componentfolder.Service;

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

    public KhachHangViewModel getkh(String idhd);

    public ArrayList<HopDongViewModel> getlisthd();

    public boolean insert(HoaDonTraXeModel hdhtm);

    public boolean update(HoaDonTraXeModel hdhtm);

    public boolean delete(HoaDonTraXeModel hdhtm);
}
