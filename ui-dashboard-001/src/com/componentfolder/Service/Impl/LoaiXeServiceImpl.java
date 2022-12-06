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

    @Override
    public String saveLoaiXe(LoaiXe loaiXe) {
        if(loaiXe.getMaLoai().isEmpty()){
            return "không được bỏ trống";
        }
        if(loaiXe.getTen().isEmpty()){
            return "không được bỏ trống";
        }
        if(loaiXe.getDongXe().isEmpty()){
            return "không được bỏ trống";
        }
        if(loaiXe.getTenTheLoai().isEmpty()){
            return "không được bỏ trống";
        }
        boolean save = loaiXeRepository.saveLoaiXe(loaiXe);
        if(save){
            return "Thành công";
        }else{
            return "Không thành công";
        }
    }

    @Override
    public String updateLoaiXe(LoaiXe loaiXe, String ma) {
        if(ma.isEmpty()){
            return "không được bỏ trống";
        }
        if(loaiXe.getTen().isEmpty()){
            return "không được bỏ trống";
        }
        if(loaiXe.getDongXe().isEmpty()){
            return "không được bỏ trống";
        }
        if(loaiXe.getTenTheLoai().isEmpty()){
            return "không được bỏ trống";
        }
        boolean update = loaiXeRepository.updateLoaiXe(loaiXe, ma);
        if(update){
            return "Thành công";
        }else{
            return "Không thành công";
        }
    }

    @Override
    public String removeLoaiXe(String ma) {
        if(ma.isEmpty()){
            return "không được bỏ trống";
        }
        boolean remove = loaiXeRepository.removeLoaiXe(ma);
        if(remove){
            return "Thành công";
        }else{
            return "Không thành công";
        }
    }
}
