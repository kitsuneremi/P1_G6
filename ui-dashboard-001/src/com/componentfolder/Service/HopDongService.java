/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Model.ChiTietHopDongModel;
import java.util.ArrayList;
import Model.ChiTietXeModel;
import Model.HopDongModel;
import Model.KhachHangModel;

import Model.NhanVienModel;
import ViewModel.ChiTietHopDongViewModel;

import ViewModel.HopDongViewModel;

/**
 *
 * @author User
 */
public interface HopDongService {
        public ArrayList<HopDongViewModel> getList();
        public ArrayList<NhanVienModel> getCbNhanVien();
        public ArrayList<KhachHangModel> getCbKhachHang();
        public String tenNhanVien(String id);
        public String tenKhachHang(String id);
        public Boolean add(HopDongModel hopDongModel);
        public Boolean delete(String id);
        public Boolean update (HopDongModel hopDongModel,String id);
        public Boolean findbyName(String ten);
        public ArrayList<ChiTietHopDongViewModel> getListChiTiet();
        public ArrayList<ChiTietXeModel> getCbid();
        public ArrayList<HopDongModel> getCbHd();
        public Boolean addChiTiet(ChiTietHopDongModel chiTietHopDongModel);
        public Boolean DeleteChiTiet(String id);
       
        public String tenXe(String id);
}
