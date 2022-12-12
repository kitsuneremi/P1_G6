/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.componentfolder.Repository;

import Utilities.DBConnections;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class AnalystRepo {
    private DBConnections connection;
    // Quý 4
    public int HopDongThang10(){
        int he = 0;
        String sql = "Select count(*) From HopDong where month(ngaytao) = 10";
        try(Connection conn = connection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                he = rs.getInt(1);
            }
            return he;
            
        }catch(Exception e){ 
            e.printStackTrace(); 
            return 0;
        }   
    }
    public int HoaDonThang10(){
        int he = 0;
        String sql = "Select SUM(Thanhtien) From HoaDonTraXe where month(ngaytra) = 10";
        try(Connection conn = connection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                he = rs.getInt(1);
            }
            return he/1000000;
            
        }catch(Exception e){ 
            e.printStackTrace(); 
            return 0;
        }   
    }
    public int HopDongThang11(){
        int he = 0;
        String sql = "Select count(*) From HopDong where month(ngaytao) = 11";
        try(Connection conn = connection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                he = rs.getInt(1);
            }
            return he;
            
        }catch(Exception e){ 
            e.printStackTrace(); 
            return 0;
        }   
    }
    public int HoaDonThang11(){
        int he = 0;
        String sql = "Select SUM(Thanhtien) From HoaDonTraXe where month(ngaytra) = 11";
        try(Connection conn = connection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                he = rs.getInt(1);
            }
            return he/1000000;
            
        }catch(Exception e){ 
            e.printStackTrace(); 
            return 0;
        }   
    }
    public int HopDongThang12(){
        int he = 0;
        String sql = "Select count(*) From HopDong where month(ngaytao) = 12";
        try(Connection conn = connection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                he = rs.getInt(1);
            }
            return he;
            
        }catch(Exception e){ 
            e.printStackTrace(); 
            return 0;
        }   
    }
    public int HoaDonThang12(){
        int he = 0;
        String sql = "Select SUM(Thanhtien) From HoaDonTraXe where month(ngaytra) = 12";
        try(Connection conn = connection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                he = rs.getInt(1);
            }
            return he/1000000;
            
        }catch(Exception e){ 
            e.printStackTrace(); 
            return 0;
        }   
    }
 // Quý 1
    public int HopDongThang1(){
        int he = 0;
        String sql = "Select count(*) From HopDong where month(ngaytao) = 1";
        try(Connection conn = connection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                he = rs.getInt(1);
            }
            return he;
            
        }catch(Exception e){ 
            e.printStackTrace(); 
            return 0;
        }   
    }
    public int HoaDonThang1(){
        int he = 0;
        String sql = "Select SUM(Thanhtien) From HoaDonTraXe where month(ngaytra) = 1";
        try(Connection conn = connection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                he = rs.getInt(1);
            }
            return he/1000000;
            
        }catch(Exception e){ 
            e.printStackTrace(); 
            return 0;
        }   
    }
    public int HopDongThang2(){
        int he = 0;
        String sql = "Select count(*) From HopDong where month(ngaytao) = 2";
        try(Connection conn = connection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                he = rs.getInt(1);
            }
            return he;
            
        }catch(Exception e){ 
            e.printStackTrace(); 
            return 0;
        }   
    }
    public int HoaDonThang2(){
        int he = 0;
        String sql = "Select SUM(Thanhtien) From HoaDonTraXe where month(ngaytra) = 2";
        try(Connection conn = connection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                he = rs.getInt(1);
            }
            return he/1000000;
            
        }catch(Exception e){ 
            e.printStackTrace(); 
            return 0;
        }   
    }
    public int HopDongThang3(){
        int he = 0;
        String sql = "Select count(*) From HopDong where month(ngaytao) = 3";
        try(Connection conn = connection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                he = rs.getInt(1);
            }
            return he;
            
        }catch(Exception e){ 
            e.printStackTrace(); 
            return 0;
        }   
    }
    public int HoaDonThang3(){
        int he = 0;
        String sql = "Select SUM(Thanhtien) From HoaDonTraXe where month(ngaytra) = 3";
        try(Connection conn = connection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                he = rs.getInt(1);
            }
            return he/1000000;
            
        }catch(Exception e){ 
            e.printStackTrace(); 
            return 0;
        }   
    }
    // Quý 2
    public int HopDongThang4(){
        int he = 0;
        String sql = "Select count(*) From HopDong where month(ngaytao) = 4";
        try(Connection conn = connection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                he = rs.getInt(1);
            }
            return he;
            
        }catch(Exception e){ 
            e.printStackTrace(); 
            return 0;
        }   
    }
    public int HoaDonThang4(){
        int he = 0;
        String sql = "Select SUM(Thanhtien) From HoaDonTraXe where month(ngaytra) = 4";
        try(Connection conn = connection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                he = rs.getInt(1);
            }
            return he/1000000;
        }catch(Exception e){ 
            e.printStackTrace(); 
            return 0;
        }   
    }
    public int HopDongThang5(){
        int he = 0;
        String sql = "Select count(*) From HopDong where month(ngaytao) = 5";
        try(Connection conn = connection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                he = rs.getInt(1);
            }
            return he;
            
        }catch(Exception e){ 
            e.printStackTrace(); 
            return 0;
        }   
    }
    public int HoaDonThang5(){
        int he = 0;
        String sql = "Select SUM(Thanhtien) From HoaDonTraXe where month(ngaytra) =5";
        try(Connection conn = connection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                he = rs.getInt(1);
            }
            return he/1000000;
            
        }catch(Exception e){ 
            e.printStackTrace(); 
            return 0;
        }   
    }
    public int HopDongThang6(){
        int he = 0;
        String sql = "Select count(*) From HopDong where month(ngaytao) = 6";
        try(Connection conn = connection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                he = rs.getInt(1);
            }
            return he;
            
        }catch(Exception e){ 
            e.printStackTrace(); 
            return 0;
        }   
    }
    public int HoaDonThang6(){
        int he = 0;
        String sql = "Select SUM(Thanhtien) From HoaDonTraXe where month(ngaytra) = 6";
        try(Connection conn = connection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                he = rs.getInt(1);
            }
            return he/1000000;
            
        }catch(Exception e){ 
            e.printStackTrace(); 
            return 0;
        }   
    }
 // Quý 3
    public int HopDongThang7(){
        int he = 0;
        String sql = "Select count(*) From HopDong where month(ngaytao) = 7";
        try(Connection conn = connection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                he = rs.getInt(1);
            }
            return he;
            
        }catch(Exception e){ 
            e.printStackTrace(); 
            return 0;
        }   
    }
    public int HoaDonThang7(){
        int he = 0;
        String sql = "Select SUM(Thanhtien) From HoaDonTraXe where month(ngaytra) = 7";
        try(Connection conn = connection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                he = rs.getInt(1);
            }
            return he/1000000;
            
        }catch(Exception e){ 
            e.printStackTrace(); 
            return 0;
        }   
    }
    public int HopDongThang8(){
        int he = 0;
        String sql = "Select count(*) From HopDong where month(ngaytao) = 8";
        try(Connection conn = connection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                he = rs.getInt(1);
            }
            return he;
            
        }catch(Exception e){ 
            e.printStackTrace(); 
            return 0;
        }   
    }
    public int HoaDonThang8(){
        int he = 0;
        String sql = "Select SUM(Thanhtien) From HoaDonTraXe where month(ngaytra) = 8";
        try(Connection conn = connection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                he = rs.getInt(1);
            }
            return he/1000000;
            
        }catch(Exception e){ 
            e.printStackTrace(); 
            return 0;
        }   
    }
    public int HopDongThang9(){
        int he = 0;
        String sql = "Select count(*) From HopDong where month(ngaytao) = 9";
        try(Connection conn = connection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                he = rs.getInt(1);
            }
            return he = 0;
             
        }catch(Exception e){ 
            e.printStackTrace(); 
            return 0;
        }   
    }
    public int HoaDonThang9(){
        int he = 0;
        String sql = "Select SUM(Thanhtien) From HoaDonTraXe where month(ngaytra) = 9";
        try(Connection conn = connection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                he = rs.getInt(1);
            }
            return he/1000000;
            
        }catch(Exception e){ 
            e.printStackTrace(); 
            return 0;
        }   
    }
    public int TongHopDong(){
        int he = 0;
        String sql = "Select Count(*) From HopDong";
        try(Connection conn = connection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                he = rs.getInt(1);
            }
            return he;
            
        }catch(Exception e){ 
            e.printStackTrace(); 
            return 0;
        }   
    }
    public int HoaDonTong(){
        int he = 0;
        String sql = "Select SUM(Thanhtien) From HoaDonTraXe";
        try(Connection conn = connection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                he = rs.getInt(1);
            }
            return he/1000000;
            
        }catch(Exception e){ 
            e.printStackTrace(); 
            return 0;
        }   
    }
    public int TongXe(){
        int he = 0;
        String sql = "Select Count(*) From chitietXe";
        try(Connection conn = connection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                he = rs.getInt(1);
            }
            return he;
            
        }catch(Exception e){ 
            e.printStackTrace(); 
            return 0;
        }   
    }
    public String XeTop1(){
        String he = "";
        String sql = "select top 1 loaixe.ten, COUNT(chiTietHopDong.bienSo) ten from loaiXe join chiTietXe on loaiXe.maLx = chiTietXe.maLx\n" +
"						join chiTietHopDong on chiTietXe.bienSo = chiTietHopDong.bienSo\n" +
"						Group by loaixe.ten\n" +
"						order by COUNT(chiTietHopDong.bienSo) desc";
        try(Connection conn = connection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                he = rs.getString(1);
            }
            return he;
            
        }catch(Exception e){ 
            e.printStackTrace(); 
            return null;
        }   
    }
    public String XeTop2(){
        String he = "";
        String sql = "select top 2 loaixe.ten, COUNT(chiTietHopDong.bienSo) ten from loaiXe join chiTietXe on loaiXe.maLx = chiTietXe.maLx\n" +
"						join chiTietHopDong on chiTietXe.bienSo = chiTietHopDong.bienSo\n" +
"						Group by loaixe.ten\n" +
"						order by COUNT(chiTietHopDong.bienSo) desc";
        try(Connection conn = connection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                he = rs.getString(1);
            }
            return he;
            
        }catch(Exception e){ 
            e.printStackTrace(); 
            return null;
        }   
    }
    public String XeTop3(){
        String he = "";
        String sql = "select top 3 loaixe.ten, COUNT(chiTietHopDong.bienSo) ten from loaiXe join chiTietXe on loaiXe.maLx = chiTietXe.maLx\n" +
"						join chiTietHopDong on chiTietXe.bienSo = chiTietHopDong.bienSo\n" +
"						Group by loaixe.ten\n" +
"						order by COUNT(chiTietHopDong.bienSo) desc";
        try(Connection conn = connection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                he = rs.getString(1);
            }
            return he;
            
        }catch(Exception e){ 
            e.printStackTrace(); 
            return null;
        }   
    }
    public String XeTop4(){
        String he = "";
        String sql = "select top 4 loaixe.ten, COUNT(chiTietHopDong.bienSo) ten from loaiXe join chiTietXe on loaiXe.maLx = chiTietXe.maLx\n" +
"						join chiTietHopDong on chiTietXe.bienSo = chiTietHopDong.bienSo\n" +
"						Group by loaixe.ten\n" +
"						order by COUNT(chiTietHopDong.bienSo) desc";
        try(Connection conn = connection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                he = rs.getString(1);
            }
            return he;
            
        }catch(Exception e){ 
            e.printStackTrace(); 
            return null;
        }   
    }
    public String XeTop5(){
        String he = "";
        String sql = "select top 5 loaixe.ten, COUNT(chiTietHopDong.bienSo) ten from loaiXe join chiTietXe on loaiXe.maLx = chiTietXe.maLx\n" +
"						join chiTietHopDong on chiTietXe.bienSo = chiTietHopDong.bienSo\n" +
"						Group by loaixe.ten\n" +
"						order by COUNT(chiTietHopDong.bienSo) desc";
        try(Connection conn = connection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                he = rs.getString(1);
            }
            return he;
            
        }catch(Exception e){ 
            e.printStackTrace(); 
            return null;
        }   
    }
    public int LanthueXeTop1(){
        int he = 0;
        String sql = "select top 1 loaixe.ten, COUNT(chiTietHopDong.bienSo) ten from loaiXe join chiTietXe on loaiXe.maLx = chiTietXe.maLx\n" +
"						join chiTietHopDong on chiTietXe.bienSo = chiTietHopDong.bienSo\n" +
"						Group by loaixe.ten\n" +
"						order by COUNT(chiTietHopDong.bienSo) desc";
        try(Connection conn = connection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                he = rs.getInt(2);
            }
            return he;
            
        }catch(Exception e){ 
            e.printStackTrace(); 
            return 0;
        }   
    }
    public int LanthueXeTop2(){
        int he = 0;
        String sql = "select top 2 loaixe.ten, COUNT(chiTietHopDong.bienSo) ten from loaiXe join chiTietXe on loaiXe.maLx = chiTietXe.maLx\n" +
"						join chiTietHopDong on chiTietXe.bienSo = chiTietHopDong.bienSo\n" +
"						Group by loaixe.ten\n" +
"						order by COUNT(chiTietHopDong.bienSo) desc";
        try(Connection conn = connection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                he = rs.getInt(2);
            }
            return he;
            
        }catch(Exception e){ 
            e.printStackTrace(); 
            return 0;
        }   
    }
    public int LanthueXeTop3(){
        int he = 0;
        String sql = "select top 3 loaixe.ten, COUNT(chiTietHopDong.bienSo) ten from loaiXe join chiTietXe on loaiXe.maLx = chiTietXe.maLx\n" +
"						join chiTietHopDong on chiTietXe.bienSo = chiTietHopDong.bienSo\n" +
"						Group by loaixe.ten\n" +
"						order by COUNT(chiTietHopDong.bienSo) desc";
        try(Connection conn = connection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                he = rs.getInt(2);
            }
            return he;
            
        }catch(Exception e){ 
            e.printStackTrace(); 
            return 0;
        }   
    }
    public int LanthueXeTop4(){
        int he = 0;
        String sql = "select top 4 loaixe.ten, COUNT(chiTietHopDong.bienSo) ten from loaiXe join chiTietXe on loaiXe.maLx = chiTietXe.maLx\n" +
"						join chiTietHopDong on chiTietXe.bienSo = chiTietHopDong.bienSo\n" +
"						Group by loaixe.ten\n" +
"						order by COUNT(chiTietHopDong.bienSo) desc";
        try(Connection conn = connection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                he = rs.getInt(2);
            }
            return he;
            
        }catch(Exception e){ 
            e.printStackTrace(); 
            return 0;
        }   
    }
    public int LanthueXeTop5(){
        int he = 0;
        String sql = "select top 5 loaixe.ten, COUNT(chiTietHopDong.bienSo) ten from loaiXe join chiTietXe on loaiXe.maLx = chiTietXe.maLx\n" +
"						join chiTietHopDong on chiTietXe.bienSo = chiTietHopDong.bienSo\n" +
"						Group by loaixe.ten\n" +
"						order by COUNT(chiTietHopDong.bienSo) desc";
        try(Connection conn = connection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                he = rs.getInt(2);
            }
            return he;
            
        }catch(Exception e){ 
            e.printStackTrace(); 
            return 0;
        }   
    }
    
}
