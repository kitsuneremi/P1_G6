/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import Model.ChiTietXe;
import Repository.ChiTietXeRepository;
import Service.CTXeSevices;
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
    
}
