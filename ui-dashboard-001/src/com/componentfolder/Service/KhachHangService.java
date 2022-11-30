/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.KhachHangModel;
import ViewModel.KhachHangViewModel;
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
}
