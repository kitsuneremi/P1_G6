/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.javaswingdev.chart;

import Utilities.DBConnections;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class PieChartRepo {
    private DBConnections connection;
    public int XenTrong(){
        int he = 0;
        String sql = "Select count(*) From chiTietXe where tinhTrangXe = 0";
        try(Connection conn = connection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                he = rs.getInt(1);
            }
            System.out.println(he);
            return he;
            
        }catch(Exception e){ 
            e.printStackTrace(); 
            return 0;
        }   
    }
    public int XeDangChoThue(){
        int he = 0;
        String sql = "Select count(*) From chiTietXe where tinhTrangXe = 1";
        try(Connection conn = connection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                he = rs.getInt(1);
            }
            System.out.println(he);
            return he;
            
        }catch(Exception e){ 
            e.printStackTrace(); 
            return 0;
        }   
    }
    public int XeDangSua(){
        int he = 0;
        String sql = "Select count(*) From chiTietXe where tinhTrangXe = 3";
        try(Connection conn = connection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                he = rs.getInt(1);
            }
            System.out.println(he);
            return he;
            
        }catch(Exception e){ 
            e.printStackTrace(); 
            return 0;
        }   
    }
}
