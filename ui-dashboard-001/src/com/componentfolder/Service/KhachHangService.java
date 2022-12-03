/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.componentfolder.Service;

import com.componentfolder.ViewModel.KhachHangViewModel;
import com.componentfolder.Model.KhachHangModel;
import java.util.ArrayList;

/**
 *
 * @author HA NGUYEN
 */
public interface KhachHangService {
    public ArrayList<KhachHangViewModel> getListKH();
    public Boolean addKH(KhachHangModel kh);
    public Boolean updateKH(KhachHangModel kh);
    public int getcountDB();
    public ArrayList<KhachHangViewModel> search(String tenn);
}
