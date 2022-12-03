/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.componentfolder.Model;

/**
 *
 * @author DELL
 */
public class LoaiXe {
    private String id;
    private String ma;
    private String tenLoaiXe;

    public LoaiXe() {
    }

    public LoaiXe(String id, String ma, String tenLoaiXe) {
        this.id = id;
        this.ma = ma;
        this.tenLoaiXe = tenLoaiXe;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTenLoaiXe() {
        return tenLoaiXe;
    }

    public void setTenLoaiXe(String tenLoaiXe) {
        this.tenLoaiXe = tenLoaiXe;
    }

    @Override
    public String toString() {
        return "Loaixe{" + "id=" + id + ", ma=" + ma + ", tenLoaiXe=" + tenLoaiXe + '}';
    }
    public Object[] toRowData(){
        return new Object[]{id,ma,tenLoaiXe};
    }
    
    
}
