/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raven.form;

import com.componentfolder.Service.HopDongService;
import com.componentfolder.Service.Impl.HopDongServiceImpl;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import com.componentfolder.Model.HopDongModel;
import com.componentfolder.Model.KhachHangModel;
import com.componentfolder.Model.NhanVienModel;
import com.componentfolder.Service.HopDongService;
import com.componentfolder.Service.Impl.HopDongServiceImpl;
import com.componentfolder.View.InHopDong;
import com.componentfolder.ViewModel.HopDongViewModel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author RAVEN
 */
public class Form_hopdong1 extends javax.swing.JPanel {
HopDongService hopDongService = new HopDongServiceImpl();
        private DefaultComboBoxModel defaultComboBoxModel;
        private DefaultTableModel defaultTableModel;
        String sourceAnh = null;
    /**
     * Creates new form Form_1
     */
    public Form_hopdong1() {
        initComponents();
        loadHd(hopDongService.getList());
        lbl_find.setVisible(true);
        txt_findtenkhach.setVisible(true);
        addGr();
    }
    ButtonGroup buttonGroup = new ButtonGroup();
    public void addGr(){
        buttonGroup.add(rdo_chuaky);
        buttonGroup.add(rdo_daky);
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_hopdong = new javax.swing.JTable();
        Panel_print = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        rdo_chuaky = new javax.swing.JRadioButton();
        rdo_daky = new javax.swing.JRadioButton();
        txt_tenkhachhang = new javax.swing.JTextField();
        lbl_find = new javax.swing.JLabel();
        txt_findtenkhach = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txt_tennv = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txt_mahd = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txt_thongtinthem = new javax.swing.JLabel();
        txt_ngaytao = new javax.swing.JTextField();
        txt_ngayhethan = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btn_add = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();

        setBackground(new java.awt.Color(242, 242, 242));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/componentfolder/Image/Clien list.png"))); // NOI18N
        jLabel2.setText("THÔNG TIN HỢP ĐỒNG THUÊ XE");

        jTabbedPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTabbedPane2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        tbl_hopdong.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tbl_hopdong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã hợp đồng", "Tên nhân viên", "Tên khách hàng", "Ngày tạo", "Ngày hết hạn", "Tình trạng", "Thông tin thêm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_hopdong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_hopdongMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_hopdong);

        jTabbedPane2.addTab("Thông tin hợp đồng", jScrollPane1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(313, 313, 313)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Panel_print.setBackground(new java.awt.Color(47, 158, 193));
        Panel_print.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Tên Khách Hàng");

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Ngày Tạo");

        jLabel18.setBackground(new java.awt.Color(51, 51, 51));
        jLabel18.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Ngày Hết Hạn");

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Tình Trạng");

        rdo_chuaky.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        rdo_chuaky.setSelected(true);
        rdo_chuaky.setText("chưa ký");

        rdo_daky.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        rdo_daky.setText("đã ký");

        lbl_find.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbl_find.setForeground(new java.awt.Color(255, 255, 255));
        lbl_find.setText("Tìm kiếm");

        txt_findtenkhach.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_findtenkhachKeyPressed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Tên Nhân Viên");

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Mã hợp đồng");

        jLabel22.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Thông tin thêm");

        txt_thongtinthem.setText("jLabel1");
        txt_thongtinthem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_thongtinthemMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout Panel_printLayout = new javax.swing.GroupLayout(Panel_print);
        Panel_print.setLayout(Panel_printLayout);
        Panel_printLayout.setHorizontalGroup(
            Panel_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_printLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addGroup(Panel_printLayout.createSequentialGroup()
                        .addGroup(Panel_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jLabel21))
                            .addComponent(lbl_find))
                        .addGap(18, 18, 18)
                        .addGroup(Panel_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_tenkhachhang, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                            .addComponent(txt_tennv)
                            .addComponent(txt_mahd)
                            .addComponent(txt_findtenkhach)
                            .addGroup(Panel_printLayout.createSequentialGroup()
                                .addComponent(rdo_chuaky)
                                .addGap(18, 18, 18)
                                .addComponent(rdo_daky)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jLabel16)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Panel_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_thongtinthem, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Panel_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txt_ngayhethan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                        .addComponent(txt_ngaytao, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(72, 72, 72))
        );
        Panel_printLayout.setVerticalGroup(
            Panel_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_printLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(Panel_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(txt_tenkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ngaytao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Panel_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17)
                    .addGroup(Panel_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_tennv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18)
                        .addComponent(txt_ngayhethan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(Panel_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_printLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(Panel_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(txt_mahd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(Panel_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel19)
                            .addGroup(Panel_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rdo_chuaky)
                                .addComponent(rdo_daky)))
                        .addGap(23, 23, 23)
                        .addGroup(Panel_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_find)
                            .addComponent(txt_findtenkhach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_printLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_thongtinthem, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        jPanel2.setBackground(new java.awt.Color(47, 157, 191));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setForeground(new java.awt.Color(204, 204, 204));
        jPanel2.setMaximumSize(new java.awt.Dimension(300, 300));
        jPanel2.setPreferredSize(new java.awt.Dimension(181, 300));

        btn_add.setBackground(new java.awt.Color(204, 204, 204));
        btn_add.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btn_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/componentfolder/Image/Add.png"))); // NOI18N
        btn_add.setText("Tạo Hợp Đồng");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/componentfolder/Image/Print preview.png"))); // NOI18N
        jButton2.setText("In hợp đồng");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(204, 204, 204));
        jButton4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/componentfolder/Image/Gear.png"))); // NOI18N
        jButton4.setText("Update trạng thái");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btn_clear.setBackground(new java.awt.Color(204, 204, 204));
        btn_clear.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btn_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/componentfolder/Image/Left.png"))); // NOI18N
        btn_clear.setText("Clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_add, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(Panel_print, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 212, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Panel_print, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_hopdongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_hopdongMouseClicked
        // TODO add your handling code here:

        int row = tbl_hopdong.getSelectedRow();
        txt_mahd.setText(tbl_hopdong.getValueAt(row, 0).toString());
        txt_tennv.setText(tbl_hopdong.getValueAt(row, 1).toString());

        txt_tenkhachhang.setText(tbl_hopdong.getValueAt(row, 2).toString());
        txt_ngaytao.setText(tbl_hopdong.getValueAt(row, 3).toString());
        txt_ngayhethan.setText(tbl_hopdong.getValueAt(row, 4).toString());

        if(tbl_hopdong.getValueAt(row, 5).toString().equalsIgnoreCase("chưa ký")){
            rdo_chuaky.setSelected(true);
        }else
        rdo_daky.setSelected(true);
        txt_thongtinthem.setText("");
        sourceAnh = (String) defaultTableModel.getValueAt(row, 6);
        ImageIcon imgIcon = new ImageIcon(getClass().getResource("/Anh/" +  sourceAnh));
        Image img = imgIcon.getImage();
        img.getScaledInstance(txt_thongtinthem.getWidth(), txt_thongtinthem.getY(), 0);
        txt_thongtinthem.setIcon(imgIcon);

    }//GEN-LAST:event_tbl_hopdongMouseClicked

    private void txt_findtenkhachKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_findtenkhachKeyPressed
        // TODO add your handling code here:
        defaultTableModel = (DefaultTableModel) tbl_hopdong.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(defaultTableModel);
        tbl_hopdong.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(txt_findtenkhach.getText().trim()));
    }//GEN-LAST:event_txt_findtenkhachKeyPressed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // TODO add your handling code here:

        String p_hoten = "[a-zA-Z ]+";
        String p_mahd = "[A-Za-z0-9]+";
        if(txt_tenkhachhang.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "chưa điền tên khách hàng");
            txt_tenkhachhang.requestFocus();
            txt_tenkhachhang.setBackground(Color.red);
            txt_tenkhachhang.setText("");
            return;
        }
        if(txt_tennv.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "chưa điền tên nhân viên");
            txt_tennv.requestFocus();
            txt_tennv.setBackground(Color.red);
            txt_tennv.setText("");
            return;
        }
        if(txt_mahd.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "chưa điền mã hợp đồng");
            txt_mahd.requestFocus();
            txt_mahd.setBackground(Color.red);
            txt_mahd.setText("");
            return;
        }

        HopDongModel hopDongModel = new HopDongModel();
        hopDongModel.setMahd(txt_mahd.getText().toString());
        NhanVienModel nhanVienModel = new NhanVienModel();
        KhachHangModel khachHangModel = new KhachHangModel();
        
        hopDongModel.setMahd(txt_mahd.getText().toString());
        nhanVienModel.setId(hopDongService.idnhanvien(txt_tennv.getText().toString()));
        hopDongModel.setIdnv(nhanVienModel);
        khachHangModel.setMakh(hopDongService.idkhachhang(txt_tenkhachhang.getText().toString()));
        hopDongModel.setIdkh(khachHangModel);

       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    try {
        hopDongModel.setNgayTao(sdf.parse(txt_ngaytao.getText()));
        hopDongModel.setNgayHetHan(sdf.parse(txt_ngayhethan.getText()));
    } catch (ParseException ex) {
        java.util.logging.Logger.getLogger(Form_hopdong1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
       

        hopDongModel.setSourceAnh(sourceAnh);
        int tinhTrang = 0;
        if(rdo_daky.isSelected()){
            tinhTrang = 1;
        }
        hopDongModel.setTinhTrang(tinhTrang);
        if(hopDongService.add(hopDongModel)){
            JOptionPane.showMessageDialog(this, "thành công");
            loadHd(hopDongService.getList());
        }else
        JOptionPane.showMessageDialog(this, "thất bại");

    }//GEN-LAST:event_btn_addActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new InHopDong().setVisible(true);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int row = tbl_hopdong.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(this, "hãy chọn một dòng rồi ấn nút update");

        }else{
            HopDongModel hopDongModel = new HopDongModel();
            String id = txt_mahd.getText().toString();
            int tinhTrang = 0;
            if(rdo_daky.isSelected()){
                tinhTrang = 1;
            }
            hopDongModel.setTinhTrang(tinhTrang);
            if(hopDongService.update(hopDongModel, id)){
                JOptionPane.showMessageDialog(this, "update trạng thái thành công");
                loadHd(hopDongService.getList());
            }else
            JOptionPane.showMessageDialog(this, "thất bại");
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        // TODO add your handling code here:

        txt_tenkhachhang.setText("");
        txt_tennv.setText("");
        txt_mahd.setText("");
        txt_thongtinthem.setText("");

    }//GEN-LAST:event_btn_clearActionPerformed

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

        }
    }//GEN-LAST:event_txt_thongtinthemMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_print;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel lbl_find;
    private javax.swing.JRadioButton rdo_chuaky;
    private javax.swing.JRadioButton rdo_daky;
    private javax.swing.JTable tbl_hopdong;
    private javax.swing.JTextField txt_findtenkhach;
    private javax.swing.JTextField txt_mahd;
    private javax.swing.JTextField txt_ngayhethan;
    private javax.swing.JTextField txt_ngaytao;
    private javax.swing.JTextField txt_tenkhachhang;
    private javax.swing.JTextField txt_tennv;
    private javax.swing.JLabel txt_thongtinthem;
    // End of variables declaration//GEN-END:variables
}
