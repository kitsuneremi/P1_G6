/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import Model.PBD;
import Repository.CRUD_PBD;
import Service.PBDService;
import ViewModel.PBDViewModel;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class PBDImplement implements PBDService {

    private CRUD_PBD getListPBD = new CRUD_PBD();

    @Override
    public ArrayList<PBDViewModel> getListPhieu() {

        return getListPBD.getListFromDB();
    }

    @Override
    public Boolean Them(PBD pbd) {

        return getListPBD.Them(pbd);
    }

    @Override
    public Boolean Sua(PBD id) {

        return getListPBD.Sua(id);
    }

    @Override
    public ArrayList<PBDViewModel> timKiemPhieu(String bienSoXe) {

        return getListPBD.timKiemPhieu(bienSoXe);
    }

}
