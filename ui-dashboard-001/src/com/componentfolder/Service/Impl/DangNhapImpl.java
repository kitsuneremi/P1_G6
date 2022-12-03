/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.componentfolder.Service.Impl;

import com.componentfolder.Model.DangNhap;
import com.componentfolder.Repository.DangNhapRepo;
import com.componentfolder.Service.DangNhapService;
import java.util.ArrayList;


public class DangNhapImpl implements DangNhapService{
    DangNhapRepo he = new DangNhapRepo();

    @Override
    public String get(String tk, String mk) {
        return he.get(tk, mk);//To change body of generated methods, choose Tools | Templates.
    }
    
}
