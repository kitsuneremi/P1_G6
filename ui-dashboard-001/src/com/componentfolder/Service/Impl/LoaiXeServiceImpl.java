/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import Model.LoaiXe;
import Repository.LoaiXeRepository;
import Service.LoaiXeServices;
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
