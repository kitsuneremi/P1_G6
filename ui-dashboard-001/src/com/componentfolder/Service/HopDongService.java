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
import ViewModel.InHopDongViewModel;

/**
 *
 * @author User
 */
public interface HopDongService {
    ///HopDong
        public ArrayList<HopDongViewModel> getList();
     //Combobox hopDong
        public ArrayList<String> getCbNhanVien();
        public ArrayList<String> getCbKhachHang();       
        public String tenNhanVien(String id);
        public String tenKhachHang(String id);
        public String idnhanvien(String ten);
        public String idkhachhang(String ten);
      //Crud hopdong
        public String bienso(String id);
        public String idchitietxe(String bienso);
        public Boolean add(HopDongModel hopDongModel);
        public Boolean delete(String id);
        public Boolean update (HopDongModel hopDongModel,String id);  
        public Boolean update2(HopDongModel hopDongModel,String id);
        //ChiTietHopDong  
        public ArrayList<ChiTietHopDongViewModel> getListChiTiet();
        //Combobox chitiethopdong
        public ArrayList<String> getCbid();
        public ArrayList<String> getCbHd();
        public ArrayList<String> getCbLoai();
        //Crud chitiethopdong
        public Boolean addChiTiet(ChiTietHopDongModel chiTietHopDongModel);
        public Boolean DeleteChiTiet(String idhd);
        public Boolean updateChiTiet(ChiTietHopDongModel chiTietHopDongModel,String idhd);
        
        public String tenXe(String id);
        //inhopdong 
        public ArrayList<InHopDongViewModel> getListIn();
}
