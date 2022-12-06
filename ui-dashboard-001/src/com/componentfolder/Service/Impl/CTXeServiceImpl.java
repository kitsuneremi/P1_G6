/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.componentfolder.Service.Impl;

import com.componentfolder.Model.ChiTietXe;
import com.componentfolder.Repository.ChiTietXeRepository;
import com.componentfolder.Service.CTXeSevices;
import com.componentfolder.ViewModel.Top10ViewModel;
import java.util.List;

/**
 *
 * @author DELL
 */
public class CTXeServiceImpl implements CTXeSevices{
    private ChiTietXeRepository chiTietXeRepository = new ChiTietXeRepository();

    @Override
    public List<ChiTietXe> getAll() {
        return chiTietXeRepository.getAll();
    }

    @Override
    public List<Top10ViewModel> getTop10ThueXe() {
        return chiTietXeRepository.getTop10ThueXe();
    }
    
}
