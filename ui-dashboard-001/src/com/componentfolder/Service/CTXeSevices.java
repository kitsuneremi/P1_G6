package com.componentfolder.Service;



import com.componentfolder.Model.ChiTietXe;
import com.componentfolder.ViewModel.Top10ViewModel;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author DELL
 */
public interface CTXeSevices {
    List<ChiTietXe> getAll();
    List<Top10ViewModel> getTop10ThueXe();
}
