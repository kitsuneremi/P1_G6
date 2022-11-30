/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Impl;

import Model.Xe;
import Repository.XeRepository;
import Service.XeServices;
import java.util.List;

/**
 *
 * @author DELL
 */
public class XeServiceImpl implements XeServices{
    private XeRepository xeRepository = new XeRepository();

    @Override
    public List<Xe> getAll() {
        return xeRepository.getAll();
    }
    
}
