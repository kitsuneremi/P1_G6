/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raven.form;
import com.componentfolder.Model.ChiTietHopDongModel;
import com.componentfolder.Model.ChiTietXe;
import com.componentfolder.Model.ChiTietXeModel;
import com.componentfolder.Model.HopDongModel;
import com.componentfolder.Model.KhachHangModel;
import com.componentfolder.Model.LoaiXe;
import com.componentfolder.Model.NhanVienModel;
import com.componentfolder.Repository.HoaDonTraXeRepo;
import com.componentfolder.Service.CTXeSevices;

import com.componentfolder.Service.HopDongService;
import com.componentfolder.Service.Impl.CTXeServiceImpl;
import com.componentfolder.Service.Impl.HopDongServiceImpl;
import com.componentfolder.Service.Impl.LoaiXeServiceImpl;
import com.componentfolder.Service.LoaiXeServices;
import com.componentfolder.View.InHopDong;
import com.componentfolder.ViewModel.ChiTietHopDongViewModel;
import com.componentfolder.ViewModel.ChiTietXeViewModel;
import com.componentfolder.ViewModel.HoaDonTraXeViewModel;
import com.componentfolder.ViewModel.HopDongViewModel;
import com.componentfolder.ViewModel.Top10ViewModel;
import java.awt.Color;
import java.awt.Image;
import java.beans.Customizer;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import jdk.internal.org.jline.utils.Display;
/**
 *
 * @author RAVEN
 */
public class Form_hopdong extends javax.swing.JPanel{
       private DefaultTableModel defaultTableModel;
    private HopDongService hopDongService = new HopDongServiceImpl();
    private CTXeSevices cTXeSevices = new CTXeServiceImpl();
    private DefaultListModel defaultListModel;
     private final HoaDonTraXeRepo traxerepo = new HoaDonTraXeRepo();
    private final ArrayList<HoaDonTraXeViewModel> listx = traxerepo.getlistdata();
    private DefaultComboBoxModel defaultComboBoxModel;
     private List<LoaiXe> listLoaiXe = new ArrayList<>();
    private List<ChiTietXe> listChiTietXe = new ArrayList<>();
    private LoaiXeServices loaiXeServices = new LoaiXeServiceImpl();
   
    private Form_3 form_3 = new Form_3();
    String sourceAnh = null;
    /**
     * Creates new form Form_1
     */
    public Form_hopdong() {
        initComponents();
     
    loadHd(hopDongService.getList());
        loadDataChiTiet(hopDongService.getListChiTiet());
        loadHd(hopDongService.getList());
       
        Panel_chitiet.setVisible(false);
        txt_searchchitiet.setVisible(false);
        LBL_THUE.setVisible(false);
       addCbid(hopDongService.getCbid());
        addCbNV(hopDongService.getCbNhanVien());
        txt_email.setVisible(false);
        lbl_email.setVisible(false);
        
    }
    
    
     void addCbid(ArrayList<String> list){
        defaultComboBoxModel = (DefaultComboBoxModel) cbo_bienso.getModel();
        for(String chiTietXeModel:list){
            defaultComboBoxModel.addElement(chiTietXeModel);
        }
    }
     void addCbNV(ArrayList<String> list){
        defaultComboBoxModel = (DefaultComboBoxModel) cbo_nhanvien.getModel();
        for(String chiTietXeModel:list){
            defaultComboBoxModel.addElement(chiTietXeModel);
        }
    }
    void loadHd(ArrayList<HopDongViewModel> list){
       defaultTableModel = (DefaultTableModel) tbl_hopdong.getModel();
       defaultTableModel.setRowCount(0);
       for(HopDongViewModel x:list){
           defaultTableModel.addRow(new Object[]{
               x.getMahd(),hopDongService.tenNhanVien(x.getIdnv()),hopDongService.tenKhachHang(x.getIdkh()),x.getNgayTao(),
               x.getNgayHetHan(),x.hienThiTinhTrang(),x.getSourceAnh(),
           });
           
           
       }
       
   }
 
    void loadDataChiTiet(ArrayList<ChiTietHopDongViewModel> list){
        defaultTableModel = (DefaultTableModel) tbl_chitiet.getModel();
        defaultTableModel.setRowCount(0);
        for(ChiTietHopDongViewModel x:list){
            defaultTableModel.addRow(new Object[]{
                x.getMahd(),x.getBienso(),x.getTiencoc()
            });
        }
    }    
   
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btn_xoahopdong = new javax.swing.JButton();
        txt_tenkhachhang = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        rdo_chuaky = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        btn_addhopdong = new javax.swing.JButton();
        btn_updatehd = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txt_mahd = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txt_thongtinthem = new javax.swing.JLabel();
        txt_search1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_ngaytao = new javax.swing.JTextField();
        txt_ngayhethan = new javax.swing.JTextField();
        txt_searchchitiet = new javax.swing.JTextField();
        LBL_THUE = new javax.swing.JLabel();
        Panel_chitiet = new javax.swing.JPanel();
        btn_add = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_clearchitiet = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txt_tiencoc = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btn_in = new javax.swing.JButton();
        txt_idchitiet = new javax.swing.JTextField();
        cbo_bienso = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbo_nhanvien = new javax.swing.JComboBox<>();
        txt_email = new javax.swing.JTextField();
        lbl_email = new javax.swing.JLabel();
        JtablePanel = new javax.swing.JTabbedPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_hopdong = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_chitiet = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Qu???n L?? H???p ?????ng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 14), new java.awt.Color(255, 0, 51))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setText("Ng??y h???t h???n");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel11.setText("T??n Kh??ch H??ng");

        btn_xoahopdong.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btn_xoahopdong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/componentfolder/Image/Delete.png"))); // NOI18N
        btn_xoahopdong.setText("X??a");
        btn_xoahopdong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoahopdongActionPerformed(evt);
            }
        });

        txt_tenkhachhang.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel12.setText("T??nh Tr???ng");

        rdo_chuaky.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        rdo_chuaky.setText("ch??a k??");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel14.setText("Ng??y T???o");

        btn_addhopdong.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btn_addhopdong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/componentfolder/Image/Add.png"))); // NOI18N
        btn_addhopdong.setText("Th??m");
        btn_addhopdong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addhopdongActionPerformed(evt);
            }
        });

        btn_updatehd.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btn_updatehd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/componentfolder/Image/Gear.png"))); // NOI18N
        btn_updatehd.setText("S???a");
        btn_updatehd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updatehdActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel15.setText("M?? H???p ?????ng");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel16.setText("T??n Nh??n Vi??n");

        txt_mahd.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_mahd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_mahdActionPerformed(evt);
            }
        });

        jLabel17.setBackground(new java.awt.Color(187, 187, 187));
        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel17.setText("Th??ng Tin Th??m");

        txt_thongtinthem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_thongtinthemMouseClicked(evt);
            }
        });

        txt_search1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_search1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_search1KeyPressed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/componentfolder/Image/Search.png"))); // NOI18N
        jLabel13.setText("T??m Ki???m Th??ng Tin H???p ?????ng Treo");

        txt_ngaytao.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        txt_ngayhethan.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        txt_searchchitiet.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_searchchitiet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_searchchitietKeyPressed(evt);
            }
        });

        LBL_THUE.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        LBL_THUE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/componentfolder/Image/Search.png"))); // NOI18N
        LBL_THUE.setText("T??m Ki???m Th??ng Tin H???p ?????ng Thu??");

        Panel_chitiet.setBackground(new java.awt.Color(255, 255, 153));
        Panel_chitiet.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "H???p ?????ng Thu?? Xe", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 14), new java.awt.Color(255, 0, 51))); // NOI18N
        Panel_chitiet.setForeground(new java.awt.Color(255, 255, 255));

        btn_add.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btn_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/componentfolder/Image/Add.png"))); // NOI18N
        btn_add.setText("Th??m");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_update.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btn_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/componentfolder/Image/Gear.png"))); // NOI18N
        btn_update.setText("S???a");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_delete.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/componentfolder/Image/Delete.png"))); // NOI18N
        btn_delete.setText("X??a");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_clearchitiet.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btn_clearchitiet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/componentfolder/Image/Left.png"))); // NOI18N
        btn_clearchitiet.setText("Clear");
        btn_clearchitiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearchitietActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("Ti???n c???c");

        txt_tiencoc.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setText("Bi???n s???");

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel19.setText("ID H???p ?????ng");

        btn_in.setBackground(new java.awt.Color(204, 204, 204));
        btn_in.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btn_in.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/componentfolder/Image/Print.png"))); // NOI18N
        btn_in.setText("In h???p ?????ng");
        btn_in.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inActionPerformed(evt);
            }
        });

        txt_idchitiet.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        cbo_bienso.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        javax.swing.GroupLayout Panel_chitietLayout = new javax.swing.GroupLayout(Panel_chitiet);
        Panel_chitiet.setLayout(Panel_chitietLayout);
        Panel_chitietLayout.setHorizontalGroup(
            Panel_chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_chitietLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_chitietLayout.createSequentialGroup()
                        .addGroup(Panel_chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel_chitietLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbo_bienso, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Panel_chitietLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_tiencoc, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(Panel_chitietLayout.createSequentialGroup()
                        .addGroup(Panel_chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel_chitietLayout.createSequentialGroup()
                                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_in))
                            .addGroup(Panel_chitietLayout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_idchitiet, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Panel_chitietLayout.createSequentialGroup()
                                .addComponent(btn_clearchitiet, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 9, Short.MAX_VALUE))))
        );
        Panel_chitietLayout.setVerticalGroup(
            Panel_chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_chitietLayout.createSequentialGroup()
                .addGroup(Panel_chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txt_idchitiet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cbo_bienso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_tiencoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_add)
                    .addComponent(btn_update)
                    .addComponent(btn_in))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_chitietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_clearchitiet)
                    .addComponent(btn_delete)))
        );

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/componentfolder/Image/Left.png"))); // NOI18N
        jButton1.setText("Clear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("(yyyy-MM-dd)");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("(yyyy-MM-dd)");

        cbo_nhanvien.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        txt_email.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        lbl_email.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_email.setText("Email kh??ch h??ng :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel16)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cbo_nhanvien, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel12))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(rdo_chuaky)
                                        .addComponent(txt_tenkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel13))
                        .addGap(70, 70, 70)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel15)
                                .addComponent(jLabel14)
                                .addComponent(jLabel10))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(5, 5, 5))))
                    .addComponent(txt_search1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_updatehd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_xoahopdong, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_addhopdong, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_mahd, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_ngaytao, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_ngayhethan, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)))
                    .addComponent(txt_thongtinthem, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(166, 166, 166)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_searchchitiet, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LBL_THUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_email)))
                    .addComponent(Panel_chitiet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(cbo_nhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txt_mahd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LBL_THUE)))
                    .addComponent(lbl_email, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_tenkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_ngaytao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rdo_chuaky)
                                    .addComponent(jLabel2)
                                    .addComponent(txt_ngayhethan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel17))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_search1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton1)
                                    .addComponent(btn_updatehd)
                                    .addComponent(btn_xoahopdong)
                                    .addComponent(btn_addhopdong)))
                            .addComponent(txt_thongtinthem, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_searchchitiet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(Panel_chitiet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        JtablePanel.setBackground(new java.awt.Color(255, 255, 255));
        JtablePanel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        JtablePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JtablePanelMouseClicked(evt);
            }
        });

        tbl_hopdong.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tbl_hopdong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "M?? h???p ?????ng", "T??n nh??n vi??n", "T??n kh??ch h??ng", "ng??y t???o", "ng??y h???t h???n", "T??nh tr???ng", "Th??ng tin th??m"
            }
        ));
        tbl_hopdong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_hopdongMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_hopdong);

        JtablePanel.addTab("H???p ?????ng treo", jScrollPane4);

        tbl_chitiet.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        tbl_chitiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID H???p ?????ng", "Bi???n s???", "Ti???n c???c"
            }
        ));
        tbl_chitiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_chitietMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_chitiet);

        JtablePanel.addTab("H???p ?????ng thu?? xe", jScrollPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JtablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1499, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JtablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_xoahopdongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoahopdongActionPerformed
        // TODO add your handling code here:
        ArrayList<HopDongModel> list = new ArrayList<>();
        int row = tbl_hopdong.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(this, "h??y ch???n m???t d??ng r???i ???n n??t x??a");

        }else{
            int luachon= JOptionPane.showConfirmDialog(this, "b???n ch???c mu???n x??a ch??? ?","X??a",JOptionPane.YES_NO_OPTION);
            if(luachon ==0){
                  boolean checkMaExist = true;
        ArrayList<HopDongViewModel> lst = hopDongService.getList();
        for (HopDongViewModel hopDongViewModel : lst) {
            if (txt_mahd.getText().equalsIgnoreCase(tbl_hopdong.getValueAt(row, 0).toString())== false) {
               txt_mahd.setText("m?? b???n x??a kh??ng t???n t???i");
                txt_mahd.setForeground(Color.red);
                checkMaExist = false;
            }
        }
        if (checkMaExist == false) {
            return;
        }
          
                String id = txt_mahd.getText().toString();
                if(hopDongService.delete(id)){
                    JOptionPane.showMessageDialog(this, "th??nh c??ng");
                    txt_mahd.setForeground(Color.BLACK);
                    loadHd(hopDongService.getList());
                }else
                JOptionPane.showMessageDialog(this, "th???t b???i");
            }
        }
    }//GEN-LAST:event_btn_xoahopdongActionPerformed

    private void tbl_hopdongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_hopdongMouseClicked
        DefaultTableModel dtm = new DefaultTableModel();
        int row = tbl_hopdong.getSelectedRow();
        txt_mahd.setText(tbl_hopdong.getValueAt(row, 0).toString());
        cbo_nhanvien.setSelectedItem(tbl_hopdong.getValueAt(row, 1).toString());
        txt_tenkhachhang.setText(tbl_hopdong.getValueAt(row, 2).toString());
        txt_ngaytao.setText(tbl_hopdong.getValueAt(row, 3).toString());
        txt_ngayhethan.setText(tbl_hopdong.getValueAt(row, 4).toString());

        if(tbl_hopdong.getValueAt(row, 5).toString().equalsIgnoreCase("ch??a k??")){
            rdo_chuaky.setSelected(true);
        }if(tbl_hopdong.getValueAt(row, 5).toString().equalsIgnoreCase("???? k??")){
            rdo_chuaky.setSelected(false);
        }
            
        

         txt_thongtinthem.setText("");
        sourceAnh = (String) tbl_hopdong.getValueAt(row, 6);
        ImageIcon imgIcon = new ImageIcon(getClass().getResource("/com/raven/Anh/" +  sourceAnh));
        Image img = imgIcon.getImage();
        img.getScaledInstance(txt_thongtinthem.getWidth(), txt_thongtinthem.getY(), 0);
        txt_thongtinthem.setIcon(imgIcon);

    }//GEN-LAST:event_tbl_hopdongMouseClicked

    private void btn_addhopdongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addhopdongActionPerformed
        // TODO add your handling code here:
        String p_ngay ="([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))";
        String p_hoten = "[a-zA-Z ]+";
         String p_scmt = "[0-9]{1,12}";
        String p_mahd = "[A-Za-z0-9]+";
        if(txt_tenkhachhang.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "ch??a ??i???n t??n kh??ch h??ng");
            txt_tenkhachhang.requestFocus();
            txt_tenkhachhang.setBackground(Color.red);
            txt_tenkhachhang.setText("");
            return;
        }
        if(txt_tenkhachhang.getText().matches(p_scmt)==true){
            JOptionPane.showMessageDialog(this, "t??n kh??ch h??ng sai");
            txt_tenkhachhang.requestFocus();
            txt_tenkhachhang.setBackground(Color.red);
            txt_tenkhachhang.setText("");
            return;
        }
      
        if(txt_mahd.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "ch??a ??i???n m?? h???p ?????ng");
            txt_mahd.requestFocus();
            txt_mahd.setBackground(Color.red);
            txt_mahd.setText("");
            return;
        }
        if(txt_ngaytao.getText().matches(p_ngay)==false){
            JOptionPane.showMessageDialog(this, "ng??y t???o sai ?????nh d???ng");
            txt_ngaytao.requestFocus();
            txt_ngaytao.setBackground(Color.red);
            txt_ngaytao.setText("");
            return;
        }
        if(txt_ngaytao.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "ch??a ??i???n ng??y t???o");
            txt_ngaytao.requestFocus();
            txt_ngaytao.setBackground(Color.red);
            txt_ngaytao.setText("");
            return;
        }
            if(txt_ngayhethan.getText().matches(p_ngay)==false){
            JOptionPane.showMessageDialog(this, "ng??y h???t h???n sai ?????nh d???ng");
            txt_ngayhethan.requestFocus();
            txt_ngayhethan.setBackground(Color.red);
            txt_ngayhethan.setText("");
            return;
        }
        if(txt_ngayhethan.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "ch??a ??i???n ng??y h???t h???n");
            txt_ngayhethan.requestFocus();
            txt_ngayhethan.setBackground(Color.red);
            txt_ngayhethan.setText("");
            return;
        }
        
        if(rdo_chuaky.isSelected()==false){
            JOptionPane.showMessageDialog(this, "ch??a ch???n t??nh tr???ng");
            return;
        }
         boolean checkMaTrung = true;
        ArrayList<HopDongViewModel> lst = hopDongService.getList();
        for (HopDongViewModel hopDongViewModel : lst) {
            if (hopDongViewModel.getMahd().equalsIgnoreCase(txt_mahd.getText())) {
                txt_mahd.setText("M?? tr??ng");
                txt_mahd.setForeground(Color.red);
                checkMaTrung = false;
            }
        }
        if (checkMaTrung == false) {
            return;
        }
        
        
        NhanVienModel nhanVienModel = new NhanVienModel();
        KhachHangModel khachHangModel = new KhachHangModel();
        HopDongModel hopDongModel = new HopDongModel();
        hopDongModel.setMahd(txt_mahd.getText().toString());
        nhanVienModel.setId(hopDongService.idnhanvien(cbo_nhanvien.getSelectedItem().toString()));
        hopDongModel.setIdnv(nhanVienModel);
        khachHangModel.setMakh(hopDongService.idkhachhang(txt_tenkhachhang.getText().toString()));
        hopDongModel.setIdkh(khachHangModel);

          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    try {
        
        hopDongModel.setNgayTao(sdf.parse(txt_ngaytao.getText()));
        hopDongModel.setNgayHetHan(sdf.parse(txt_ngayhethan.getText()));
    } catch (ParseException ex) {
        java.util.logging.Logger.getLogger(Form_hopdong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }

        hopDongModel.setSourceAnh(sourceAnh);

        int tinhTrang = 0;
       
        hopDongModel.setTinhTrang(tinhTrang);
        if(hopDongService.add(hopDongModel)){
            JOptionPane.showMessageDialog(this, "th??m th??nh c??ng");
            txt_ngaytao.setBackground(Color.WHITE);
            txt_ngayhethan.setBackground(Color.WHITE);
            cbo_nhanvien.setBackground(Color.WHITE);
            txt_tenkhachhang.setBackground(Color.WHITE);
            txt_mahd.setForeground(Color.BLACK);
            txt_mahd.setBackground(Color.WHITE);
            
            loadHd(hopDongService.getList());
            
        }else
        JOptionPane.showMessageDialog(this, " th??m th???t b???i");
    }//GEN-LAST:event_btn_addhopdongActionPerformed

    private void btn_updatehdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updatehdActionPerformed
        // TODO add your handling code here:
        int row = tbl_hopdong.getSelectedRow();
        
        if(row == -1){
            JOptionPane.showMessageDialog(this, "h??y ch???n m???t d??ng r???i ???n n??t update");

        }else{
        String p_ngay ="([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))";
        String p_hoten = "[a-zA-Z ]+";
        String p_mahd = "[A-Za-z0-9]+";
        String p_scmt = "[0-9]{1,12}";
        if(txt_tenkhachhang.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "ch??a ??i???n t??n kh??ch h??ng");
            txt_tenkhachhang.requestFocus();
            txt_tenkhachhang.setBackground(Color.red);
            txt_tenkhachhang.setText("");
            return;
        }
        if(txt_tenkhachhang.getText().matches(p_scmt)==true){
            JOptionPane.showMessageDialog(this, "t??n kh??ch h??ng sai");
            txt_tenkhachhang.requestFocus();
            txt_tenkhachhang.setBackground(Color.red);
            txt_tenkhachhang.setText("");
            return;
        }
       
        if(txt_mahd.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "ch??a ??i???n m?? h???p ?????ng");
            txt_mahd.requestFocus();
            txt_mahd.setBackground(Color.red);
            txt_mahd.setText("");
            return;
        }
        if(txt_ngaytao.getText().matches(p_ngay)==false){
            JOptionPane.showMessageDialog(this, "ng??y t???o sai ?????nh d???ng");
            txt_ngaytao.requestFocus();
            txt_ngaytao.setBackground(Color.red);
            txt_ngaytao.setText("");
            return;
        }
        if(txt_ngaytao.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "ch??a ??i???n ng??y t???o");
            txt_ngaytao.requestFocus();
            txt_ngaytao.setBackground(Color.red);
            txt_ngaytao.setText("");
            return;
        }
            if(txt_ngayhethan.getText().matches(p_ngay)==false){
            JOptionPane.showMessageDialog(this, "ng??y h???t h???n sai ?????nh d???ng");
            txt_ngayhethan.requestFocus();
            txt_ngayhethan.setBackground(Color.red);
            txt_ngayhethan.setText("");
            return;
        }
        if(txt_ngayhethan.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "ch??a ??i???n ng??y h???t h???n");
            txt_ngayhethan.requestFocus();
            txt_ngayhethan.setBackground(Color.red);
            txt_ngayhethan.setText("");
            return;
        }
          boolean checkMaExist = true;
        ArrayList<HopDongViewModel> lst = hopDongService.getList();
        for (HopDongViewModel hopDongViewModel : lst) {
            if (txt_mahd.getText().equalsIgnoreCase(tbl_hopdong.getValueAt(row, 0).toString())== false) {
                txt_mahd.setText("m?? b???n update kh??ng t???n t???i");
                txt_mahd.setForeground(Color.red);
                checkMaExist = false;
            }
        }
        if (checkMaExist == false) {
            return;
        }
             
            HopDongModel hopDongModel = new HopDongModel();
            NhanVienModel nhanVienModel = new NhanVienModel();
            KhachHangModel khachHangModel = new KhachHangModel();
            String id = txt_mahd.getText().toString();
            hopDongModel.setMahd(txt_mahd.getText().toString());
        nhanVienModel.setId(hopDongService.idnhanvien(cbo_nhanvien.getSelectedItem().toString()));
        hopDongModel.setIdnv(nhanVienModel);
        khachHangModel.setMakh(hopDongService.idkhachhang(txt_tenkhachhang.getText().toString()));
        hopDongModel.setIdkh(khachHangModel);
               SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    try {
        hopDongModel.setNgayTao(sdf.parse(txt_ngaytao.getText()));
        hopDongModel.setNgayHetHan(sdf.parse(txt_ngayhethan.getText()));
    } catch (ParseException ex) {
        java.util.logging.Logger.getLogger(Form_hopdong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
            int tinhTrang = 0;
            
            hopDongModel.setMahd(txt_mahd.getText().toString());
            hopDongModel.setSourceAnh(sourceAnh);
            hopDongModel.setTinhTrang(tinhTrang);
            if(hopDongService.update2(hopDongModel, id)){
                JOptionPane.showMessageDialog(this, "update th??nh c??ng");
                txt_ngaytao.setBackground(Color.WHITE);
            txt_ngayhethan.setBackground(Color.WHITE);
            cbo_nhanvien.setBackground(Color.WHITE);
            txt_tenkhachhang.setBackground(Color.WHITE);
            txt_mahd.setBackground(Color.WHITE);
            txt_mahd.setForeground(Color.BLACK);
                loadHd(hopDongService.getList());
            }else
            JOptionPane.showMessageDialog(this, "update th???t b???i");
    }//GEN-LAST:event_btn_updatehdActionPerformed
    }
    private void txt_searchchitietKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchchitietKeyPressed
        // TODO add your handling code here:
         defaultTableModel = (DefaultTableModel) tbl_chitiet.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(defaultTableModel);
        tbl_chitiet.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(txt_searchchitiet.getText().trim()));
    }//GEN-LAST:event_txt_searchchitietKeyPressed

    private void tbl_chitietMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_chitietMouseClicked
        // TODO add your handling code here:
        
         int row = tbl_chitiet.getSelectedRow();
        txt_idchitiet.setText(tbl_chitiet.getValueAt(row, 0).toString());
        cbo_bienso.setSelectedItem(tbl_chitiet.getValueAt(row, 1).toString());
        txt_tiencoc.setText(tbl_chitiet.getValueAt(row, 2).toString());
    }//GEN-LAST:event_tbl_chitietMouseClicked

    private void txt_search1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_search1KeyPressed
        // TODO add your handling code here:
        defaultTableModel = (DefaultTableModel) tbl_hopdong.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(defaultTableModel);
        tbl_hopdong.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(txt_search1.getText().trim()));
    }//GEN-LAST:event_txt_search1KeyPressed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // TODO add your handling code here:
        String p_scmt = "[+-]?([0-9]*[.])?[0-9]+";

        if (txt_tiencoc.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "ch??a ??i???n ti???n c???c");
            txt_tiencoc.requestFocus();
            txt_tiencoc.setBackground(Color.red);
            txt_tiencoc.setText("");
            return;
        } else if (txt_tiencoc.getText().matches(p_scmt) == false) {
            JOptionPane.showMessageDialog(this, "ti???n c???c sai ?????nh d???ng");
            txt_tiencoc.requestFocus();
            txt_tiencoc.setBackground(Color.red);
            txt_tiencoc.setText("");
            return;
        }

       // boolean checkMaTrung = true;
      //  ArrayList<ChiTietHopDongViewModel> lst = hopDongService.getListChiTiet();
        //for (ChiTietHopDongViewModel hopDongViewModel : lst) {
           // if (hopDongViewModel.getMahd().equalsIgnoreCase(txt_idchitiet.getText())) {
           //     txt_idchitiet.setText("M?? tr??ng");
                //txt_idchitiet.setForeground(Color.red);
                //checkMaTrung = false;
            //}
       // }
       /// if (checkMaTrung == false) {
           // return;
       // }
        boolean checkMaTrung2 = true;
        ArrayList<ChiTietHopDongViewModel> list = hopDongService.getListChiTiet();
        for (ChiTietHopDongViewModel hopDongViewModel : list) {
            if (hopDongViewModel.getBienso().equals(cbo_bienso.getSelectedItem())) {
                JOptionPane.showMessageDialog(this, "xe ??ang ???????c thu??");
                cbo_bienso.setForeground(Color.red);
                checkMaTrung2 = false;
            }
        }
        if (checkMaTrung2 == false) {
            return;
        }

        HopDongModel hopDongModel = new HopDongModel();
        String id = txt_idchitiet.getText().toString();
        int tinhTrang = 1;
        String bienso = cbo_bienso.getSelectedItem().toString();
        int tinhTrangXe = 1;

        ChiTietXeModel chiTietXeModel = new ChiTietXeModel();
        chiTietXeModel.setTinhTrangXe(tinhTrangXe);

        hopDongModel.setTinhTrang(tinhTrang);
        

        ChiTietHopDongModel chiTietHopDongModel = new ChiTietHopDongModel();

        hopDongModel.setMahd(txt_idchitiet.getText().toString());
        chiTietHopDongModel.setMahd(hopDongModel);
        chiTietHopDongModel.setBienso(cbo_bienso.getSelectedItem().toString());
        chiTietHopDongModel.setTienCoc(Float.parseFloat(txt_tiencoc.getText()));

        if (hopDongService.addChiTiet(chiTietHopDongModel)) {
            JOptionPane.showMessageDialog(this, "th??nh c??ng");
            txt_tiencoc.setBackground(Color.WHITE);
            txt_idchitiet.setForeground(Color.BLACK);
            cbo_bienso.setForeground(Color.BLACK);
            loadDataChiTiet(hopDongService.getListChiTiet());
            if (hopDongService.update(hopDongModel, id)) {
                sendemail();
                loadHd(hopDongService.getList());

            }
            if (hopDongService.update3(chiTietXeModel, bienso)) {
                loadHd(hopDongService.getList());
            }
        } else
            JOptionPane.showMessageDialog(this, "th??m th???t b???i kh??ng t???n m?? HD treo");
        
        
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
        int row = tbl_chitiet.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(this, "h??y ch???n m???t d??ng r???i ???n n??t update");

        }else{
             String p_scmt = "[+-]?([0-9]*[.])?[0-9]+";

        if(txt_tiencoc.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "ch??a ??i???n ti???n c???c");
            txt_tiencoc.requestFocus();
            txt_tiencoc.setBackground(Color.red);
            txt_tiencoc.setText("");
            return;
        }else
        if(txt_tiencoc.getText().matches(p_scmt)==false){
            JOptionPane.showMessageDialog(this, "ti???n c???c sai ?????nh d???ng");
            txt_tiencoc.requestFocus();
            txt_tiencoc.setBackground(Color.red);
            txt_tiencoc.setText("");
            return;
        }
            boolean checkMaExist = true;
        ArrayList<ChiTietHopDongViewModel> check = hopDongService.getListChiTiet();
        for (ChiTietHopDongViewModel hopDongViewModel : check) {
            if (txt_idchitiet.getText().equalsIgnoreCase(tbl_chitiet.getValueAt(row, 0).toString())==false) {
               txt_idchitiet.setText("m?? b???n update kh??ng t???n t???i");
                txt_idchitiet.setForeground(Color.red);
                checkMaExist = false;
            }
        }
        if (checkMaExist == false) {
            return;
        }
        boolean checkMaTrung2 = true;
        ArrayList<ChiTietHopDongViewModel> list = hopDongService.getListChiTiet();
        for (ChiTietHopDongViewModel hopDongViewModel : list) {
            if (cbo_bienso.getSelectedItem().equals(tbl_chitiet.getValueAt(row, 1).toString())==false) {                             
                checkMaTrung2 = false;
            }
        }
        if (checkMaTrung2 == false) {
            JOptionPane.showMessageDialog(this, "H???p ?????ng n??y ???? thu?? ???????c xe");
            return;
        }
        
       
            ChiTietHopDongModel chiTietHopDongModel = new ChiTietHopDongModel();
             HopDongModel hopDongModel = new HopDongModel();
       hopDongModel.setMahd(txt_idchitiet.getText().toString());
       chiTietHopDongModel.setMahd(hopDongModel);
            chiTietHopDongModel.setBienso(cbo_bienso.getSelectedItem().toString());

            chiTietHopDongModel.setTienCoc(Float.parseFloat(txt_tiencoc.getText()));
            String idhd = txt_idchitiet.getText().toString();
            if(hopDongService.updateChiTiet(chiTietHopDongModel, idhd)){
                JOptionPane.showMessageDialog(this, "th??nh c??ng");
                 txt_tiencoc.setBackground(Color.WHITE);
            
            txt_idchitiet.setForeground(Color.BLACK);
                loadDataChiTiet(hopDongService.getListChiTiet());
            }else
            JOptionPane.showMessageDialog(this, "update th???t b???i");
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        ArrayList<ChiTietHopDongModel> list = new ArrayList<>();
        int row = tbl_chitiet.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(this, "h??y ch???n m???t d??ng r???i ???n n??t x??a");

        }else{
            int luachon= JOptionPane.showConfirmDialog(null, "b???n ch???c mu???n x??a ch??? ?","X??a",JOptionPane.YES_NO_OPTION);
            if(luachon ==0){
                   boolean checkMaExist = true;
        ArrayList<ChiTietHopDongViewModel> check = hopDongService.getListChiTiet();
        for (ChiTietHopDongViewModel hopDongViewModel : check) {
            if (txt_idchitiet.getText().equalsIgnoreCase(tbl_chitiet.getValueAt(row, 0).toString())==false) {
               txt_idchitiet.setText("m?? b???n x??a kh??ng t???n t???i");
                txt_idchitiet.setForeground(Color.red);
                checkMaExist = false;
            }
        }
        if (checkMaExist == false) {
            return;
        }
          String bienso = cbo_bienso.getSelectedItem().toString();
        int tinhTrangXe = 0;
        
        ChiTietXeModel chiTietXeModel = new ChiTietXeModel();
        chiTietXeModel.setTinhTrangXe(tinhTrangXe);
        if(hopDongService.update3(chiTietXeModel, bienso)){
            loadHd(hopDongService.getList());
        }
                String idhd = txt_idchitiet.getText().toString();
            if(hopDongService.DeleteChiTiet(idhd)){
                JOptionPane.showMessageDialog(this, "th??nh c??ng");
                loadDataChiTiet(hopDongService.getListChiTiet());
               
            }else
            JOptionPane.showMessageDialog(this, "th???t b???i");
        } 
            }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_clearchitietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearchitietActionPerformed
        // TODO add your handling code here:
        txt_tiencoc.setText("");
        
        txt_idchitiet.setText("");
         txt_tiencoc.setBackground(Color.WHITE);
          
            txt_idchitiet.setForeground(Color.BLACK);
    }//GEN-LAST:event_btn_clearchitietActionPerformed

    private void JtablePanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtablePanelMouseClicked
        // TODO add your handling code here:
        int row = JtablePanel.getSelectedIndex();
        if(row == 1){
            Panel_chitiet.setVisible(true);
            txt_searchchitiet.setVisible(true);
            LBL_THUE.setVisible(true);
            lbl_email.setVisible(true);
            txt_email.setVisible(true);
            loadDataChiTiet(hopDongService.getListChiTiet());
        }if(row==0){
            Panel_chitiet.setVisible(false);
            txt_searchchitiet.setVisible(false);
            LBL_THUE.setVisible(false);
            loadHd(hopDongService.getList());
        }
    }//GEN-LAST:event_JtablePanelMouseClicked

    private void btn_inActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inActionPerformed
        // TODO add your handling code here:
        new InHopDong().setVisible(true);
    }//GEN-LAST:event_btn_inActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        txt_mahd.setText("");
        txt_ngayhethan.setText("");
        txt_tenkhachhang.setText("");
        txt_ngaytao.setText("");
        txt_tenkhachhang.setText("");
        
        txt_ngaytao.setBackground(Color.WHITE);
            txt_ngayhethan.setBackground(Color.WHITE);
            cbo_nhanvien.setBackground(Color.WHITE);
            txt_tenkhachhang.setBackground(Color.WHITE);
            txt_mahd.setBackground(Color.white);
            txt_mahd.setForeground(Color.BLACK);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_thongtinthemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_thongtinthemMouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            JFileChooser jfc = new JFileChooser("C:\\Users\\Admin\\Downloads\\DuAn1\\src\\icon");
            jfc.showOpenDialog(null);
            File file = jfc.getSelectedFile();
            Image img = ImageIO.read(file);
            sourceAnh = file.getName();
            txt_thongtinthem.setText("");
            int width = txt_thongtinthem.getWidth();
            int height = txt_thongtinthem.getHeight();
            txt_thongtinthem.setIcon(new ImageIcon(img.getScaledInstance(width, height, 0)));
        } catch (IOException ex) {
            Logger.getLogger(Form_hopdong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txt_thongtinthemMouseClicked

    private void txt_mahdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_mahdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_mahdActionPerformed
boolean sendemail() {
//        String to = service.getemail(txtidkhachhang1.getText());
        String to = txt_email.getText();
        String from = "lilypeachew@gmail.com";

        Properties properties = new Properties();
        properties.setProperty("mail.smtp.host", "smtp.gmail.com");
        properties.setProperty("mail.smtp.port", "465");
        properties.setProperty("mail.smtp.startls.enable", "true");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.smtp.socketFactory.fallback", "false");

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthenication() {
                String email = "lilypeachew@gmail.com";
                String password = "qgvvffdbtvsfpsav";
                return new PasswordAuthentication(email, password);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Qu?? kh??ch ???? t???o h???p ?????ng th??nh c??ng");
            message.setText("Thank you for belive our service~ H???p ?????ng c???a qu?? kh??ch s??? h???t h???n v??o ng??y: " + txt_ngayhethan.getText());
            Transport.send(message, "lilypeachew@gmail.com", "qgvvffdbtvsfpsav");
            return true;
        } catch (MessagingException mex) {
            mex.printStackTrace();
            return false;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane JtablePanel;
    private javax.swing.JLabel LBL_THUE;
    private javax.swing.JPanel Panel_chitiet;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_addhopdong;
    private javax.swing.JButton btn_clearchitiet;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_in;
    private javax.swing.JButton btn_update;
    private javax.swing.JButton btn_updatehd;
    private javax.swing.JButton btn_xoahopdong;
    private javax.swing.JComboBox<String> cbo_bienso;
    private javax.swing.JComboBox<String> cbo_nhanvien;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbl_email;
    private javax.swing.JRadioButton rdo_chuaky;
    private javax.swing.JTable tbl_chitiet;
    private javax.swing.JTable tbl_hopdong;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_idchitiet;
    private javax.swing.JTextField txt_mahd;
    private javax.swing.JTextField txt_ngayhethan;
    private javax.swing.JTextField txt_ngaytao;
    private javax.swing.JTextField txt_search1;
    private javax.swing.JTextField txt_searchchitiet;
    private javax.swing.JTextField txt_tenkhachhang;
    private javax.swing.JLabel txt_thongtinthem;
    private javax.swing.JTextField txt_tiencoc;
    // End of variables declaration//GEN-END:variables

    
}
