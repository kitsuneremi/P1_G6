/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.componentfolder.Service;

import ViewModel.PBDViewModel;
import com.componentfolder.Model.PBD;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface PBDService {

    public ArrayList<PBDViewModel> getListPhieu();

    public Boolean Them(PBD pbd);

    public Boolean Sua(PBD id);

    public ArrayList<PBDViewModel> timKiemPhieu(String bienSoXe);

}
