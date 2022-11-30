/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Model.HoaDonTraXeModel;
import Repository.HoaDonTraXeRepo;

import ViewModel.HoaDonTraXeViewModel;
import ViewModel.HopDongViewModel;
import ViewModel.KhachHangViewModel;

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
