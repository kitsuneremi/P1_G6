/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.componentfolder.Service.Impl;


import com.componentfolder.Model.LoaiXe;
import com.componentfolder.Repository.LoaiXeRepository;
import com.componentfolder.Service.LoaiXeServices;
import java.util.List;

/**
 *
 * @author DELL
 */
public class LoaiXeServiceImpl implements LoaiXeServices{
    private LoaiXeRepository loaiXeRepository = new LoaiXeRepository();

    @Override
    public List<LoaiXe> getAll() {
        return loaiXeRepository.getAll();
    }
}
