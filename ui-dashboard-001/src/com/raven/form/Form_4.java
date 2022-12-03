/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form;

import java.io.FileOutputStream;
import javax.swing.JOptionPane;
import com.componentfolder.Repository.HoaDonTraXeRepo;
import ViewModel.HoaDonTraXeViewModel;
import com.componentfolder.Model.HoaDonTraXeModel;
import com.componentfolder.Model.HopDongModel;
import com.componentfolder.Model.KhachHangModel;
import com.componentfolder.Model.ViPhamModel;
import com.componentfolder.ViewModel.HopDongViewModel;
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.UUID;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

/**
 *
 * @author DELL
 */
public class Form_4 extends javax.swing.JPanel {

    private final HoaDonTraXeRepo traxerepo = new HoaDonTraXeRepo();
    private ArrayList<HoaDonTraXeViewModel> listx = traxerepo.getlistdata();

    /**
     * Creates new form Form_4
     */
    public Form_4() {
        initComponents();
        firstLoad();
    }

    void firstLoad() {
        loadcbb();
        loadtablehoadon();
        loadtablehopdong12();
        removeColumn();
    }

    void removeColumn() {
        tblhoadon.removeColumn(tblhoadon.getColumnModel().getColumn(5));
        tblhoadon.removeColumn(tblhoadon.getColumnModel().getColumn(5));
        tblhoadon.removeColumn(tblhoadon.getColumnModel().getColumn(5));
        tblhopdong12.removeColumn(tblhopdong12.getColumnModel().getColumn(6));
        tblhopdong12.removeColumn(tblhopdong12.getColumnModel().getColumn(6));
    }

    void loadcbb() {
        ArrayList<String> list = new ArrayList<>();
        list.add("không");
        list.add("quá hạn hợp đồng");
        list.add("chưa đến hạn hợp đồng");
        list.add("hư hỏng xe");
        DefaultComboBoxModel dcm = (DefaultComboBoxModel) cbbvipham.getModel();
        dcm.removeAllElements();
        for (String string : list) {
            dcm.addElement(string);
        }
    }

    String convertdate(java.util.Date date) {
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(utilDate);
    }

    void loadtablehoadon() {
        ArrayList<HoaDonTraXeViewModel> list = traxerepo.getlistdata();
        DefaultTableModel dtm = (DefaultTableModel) tblhoadon.getModel();
        dtm.setRowCount(0);
        for (HoaDonTraXeViewModel h : list) {
            Object[] rowData = {
                traxerepo.getkh(h.getIdhd()).getTen(),
                convertdate(h.getNgaytra()),
                intvipham(h.getVipham()),
                h.getPhiphatsinh(),
                h.getTongtien(),
                h.getId(),
                h.getIdhd(),
                h.getIdkh(),};
            dtm.addRow(rowData);
        }
    }

    void loadtablehopdong12() {
        ArrayList<HopDongViewModel> list = traxerepo.getlisthd();
        DefaultTableModel dtm = (DefaultTableModel) tblhopdong12.getModel();
        dtm.setRowCount(0);
        for (HopDongViewModel h : list) {
            Object[] rowData = {
                h.getMahd(),
                traxerepo.getkh(h.getMahd()).getTen(),
                traxerepo.getnv(h.getIdnv()),
                h.getTinhTrangXe() == 0 ? "0" : "1",
                convertdate(h.getNgayTao()),
                convertdate(h.getNgayHetHan()),
                h.getIdkh(),
                h.getIdnv()
            };
            dtm.addRow(rowData);
        }
    }

    HoaDonTraXeModel gethoadonformdata() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        HoaDonTraXeModel hdtxm = new HoaDonTraXeModel();

        HopDongModel hdm = new HopDongModel();
        hdm.setMahd(txtidhopdong11.getText());
        hdm.setIdkh(txtidkhachhang12.getText());
        try {
            hdm.setNgayHetHan(sdf.parse(txtngayhethan12.getText()));
            hdm.setNgayTao(sdf.parse(txtngaytao12.getText()));
            hdtxm.setNgaytra(sdf.parse(txtngaytra.getText()));
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }
        try {
            hdtxm.setPhiphatsinh(Double.parseDouble(txtphuphi.getText()));
            hdtxm.setTongtien(Double.parseDouble(txttongtien11.getText()));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "sai dinh dang phu phi");
            return null;
        }
        hdtxm.setVipham(new ViPhamModel(cbbvipham.getSelectedIndex(), ""));
        hdtxm.setHdm(hdm);
        return hdtxm;
    }

    String intvipham(int vipham) {
        switch (vipham) {
            case 0: {
                return "quá hạn hợp đồng";
            }
            case 1: {
                return "chưa đến hạn hợp đồng";
            }
            case 2: {
                return "hư hỏng xe";
            }
        }
        return "";
    }

    void openFileExplorer(String filename) {
        try {
            String pathname = "D:\\fpt\\QRCode\\" + filename;
            File file = new File(pathname);
            Desktop desktop = Desktop.getDesktop();
            desktop.open(file);
        } catch (IOException ex) {
            ex.printStackTrace();
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

        hopdonggroup = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtidhopdong11 = new javax.swing.JTextField();
        txttenkhachhang11 = new javax.swing.JTextField();
        cbbvipham = new javax.swing.JComboBox<>();
        txtphuphi = new javax.swing.JTextField();
        txttongtien11 = new javax.swing.JTextField();
        txtngaytra = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnthemhoadon = new javax.swing.JButton();
        btnsuahoadon = new javax.swing.JButton();
        btnQR = new javax.swing.JButton();
        txtsearchvaluehoadon = new javax.swing.JTextField();
        lblsearchcounthoadon = new javax.swing.JLabel();
        btnreload = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblhoadon = new javax.swing.JTable();
        txtidkhachhang11 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtidhopdong12 = new javax.swing.JTextField();
        txttenkhachhang12 = new javax.swing.JTextField();
        txttennhanvien12 = new javax.swing.JTextField();
        rdo0 = new javax.swing.JRadioButton();
        rdo1 = new javax.swing.JRadioButton();
        txtngaytao12 = new javax.swing.JTextField();
        txtngayhethan12 = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        btnselecthopdong = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblhopdong12 = new javax.swing.JTable();
        txtidkhachhang12 = new javax.swing.JTextField();
        txtidnhanvien12 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("id hợp đồng");

        jLabel2.setText("tên khách hàng");

        jLabel4.setText("vi phạm");

        jLabel5.setText("phụ phí");

        jLabel6.setText("tổng tiền");

        txtidhopdong11.setEditable(false);

        txttenkhachhang11.setEditable(false);

        cbbvipham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtphuphi.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtphuphiCaretUpdate(evt);
            }
        });

        txttongtien11.setEditable(false);

        jLabel3.setText("ngày trả");

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 51, 255), null));

        btnthemhoadon.setText("thêm");
        btnthemhoadon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemhoadonActionPerformed(evt);
            }
        });

        btnsuahoadon.setText("sửa");
        btnsuahoadon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuahoadonActionPerformed(evt);
            }
        });

        btnQR.setText("QR");
        btnQR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQRActionPerformed(evt);
            }
        });

        txtsearchvaluehoadon.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtsearchvaluehoadonCaretUpdate(evt);
            }
        });

        lblsearchcounthoadon.setText("tìm thấy x");

        btnreload.setText("reload");
        btnreload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreloadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnthemhoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnsuahoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnQR, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(lblsearchcounthoadon)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnreload))
                        .addComponent(txtsearchvaluehoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnthemhoadon)
                    .addComponent(btnsuahoadon)
                    .addComponent(btnQR))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(txtsearchvaluehoadon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblsearchcounthoadon, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnreload, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        tblhoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "tên khách hàng", "ngày trả", "vi phạm", "phụ phí", "tổng tiền", "mahoadon", "mahd", "makh"
            }
        ));
        jScrollPane2.setViewportView(tblhoadon);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel3))
                                .addGap(247, 247, 247)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4))
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtidhopdong11, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtidkhachhang11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbbvipham, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttenkhachhang11, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtphuphi, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttongtien11, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtngaytra, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtidhopdong11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtidkhachhang11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txttenkhachhang11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbbvipham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtphuphi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txttongtien11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtngaytra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab1", jPanel1);

        jLabel10.setText("id hợp đồng");

        jLabel11.setText("tên khách hàng");

        jLabel12.setText("tên nhân viên");

        jLabel15.setText("tinh trang");

        jLabel13.setText("ngày tạo");

        jLabel14.setText("ngày hết");

        hopdonggroup.add(rdo0);
        rdo0.setSelected(true);
        rdo0.setText("0");

        hopdonggroup.add(rdo1);
        rdo1.setText("1");

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(204, 204, 255)));

        jLabel16.setText("tìm kiếm");

        btnselecthopdong.setText("select");
        btnselecthopdong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnselecthopdongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnselecthopdong)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jLabel16)
                .addGap(5, 5, 5)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnselecthopdong))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblhopdong12.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "mã hợp đồng", "tên khách hàng", "tên nhân viên", "tình trạng", "ngày tạo", "ngày hết hạn", "makh", "idnv"
            }
        ));
        tblhopdong12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblhopdong12MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblhopdong12);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))
                                .addGap(9, 9, 9)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtidhopdong12, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                                    .addComponent(txttenkhachhang12)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel15))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(rdo0)
                                        .addGap(31, 31, 31)
                                        .addComponent(rdo1)
                                        .addGap(0, 83, Short.MAX_VALUE))
                                    .addComponent(txttennhanvien12))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(18, 18, 18)
                                .addComponent(txtngayhethan12))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(txtngaytao12))
                            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtidkhachhang12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtidnhanvien12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 6, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel13)
                    .addComponent(txtidhopdong12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtngaytao12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidkhachhang12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel14)
                    .addComponent(txttenkhachhang12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtngayhethan12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidnhanvien12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txttennhanvien12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(rdo0)
                            .addComponent(rdo1)))
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(226, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab2", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtphuphiCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtphuphiCaretUpdate
        try {
            double tienthuexe = traxerepo.tienthuexe(txtidhopdong11.getText().trim());
            if (txtidhopdong11.getText().equalsIgnoreCase("")) {
                txttongtien11.setText(String.valueOf(tienthuexe));
                return;
            }
            double phiphatsinh = Double.parseDouble(txtphuphi.getText());
            if (phiphatsinh == 0) {
                txttongtien11.setText(String.valueOf(tienthuexe));
            }
            txttongtien11.setText(String.valueOf(tienthuexe + phiphatsinh));
        } catch (NumberFormatException ex) {
            return;
        }
    }//GEN-LAST:event_txtphuphiCaretUpdate

    private void btnthemhoadonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemhoadonActionPerformed
        HoaDonTraXeModel hdtxm = gethoadonformdata();
        if (hdtxm == null) {
            return;
        }
        hdtxm.setId(UUID.randomUUID().toString());
        boolean insert = traxerepo.insert(hdtxm);
        if (insert) {
            JOptionPane.showMessageDialog(this, "insert thành cmn công");
        } else {
            JOptionPane.showMessageDialog(this, "insert thất cmn bại");
        }
        loadtablehoadon();
    }//GEN-LAST:event_btnthemhoadonActionPerformed

    private void btnsuahoadonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuahoadonActionPerformed
        HoaDonTraXeModel hdtxm = gethoadonformdata();
        if (hdtxm == null) {
            return;
        }
        boolean update = traxerepo.update(hdtxm);
        if (update) {
            JOptionPane.showMessageDialog(this, "update thành cmn công");
        } else {
            JOptionPane.showMessageDialog(this, "update thất cmn bại");
        }
        loadtablehoadon();
    }//GEN-LAST:event_btnsuahoadonActionPerformed

    private void btnQRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQRActionPerformed
        FileOutputStream fos = null;
        try {
            int row = tblhoadon.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "chưa có hàng nào được lựa chọn");
                return;
            }
            String f_name = "id hoa don: " + tblhoadon.getValueAt(row, 0) + "\nten khach hang: " + tblhoadon.getValueAt(row, 2) + "\nid hop dong"
                    + tblhoadon.getValueAt(row, 1) + "\nngay tra: " + tblhoadon.getValueAt(row, 3)
                    + "\ntinh trang: " + tblhoadon.getValueAt(row, 4) + "\nphi phat sinh: " + (tblhoadon.getValueAt(row, 5).equals("chưa trả") ? 0 : 1) + "\ntong tien: " + tblhoadon.getValueAt(row, 6);
            ByteArrayOutputStream out = QRCode.from(f_name).to(ImageType.PNG).stream();
            String path = "D:\\fpt\\QRCode\\";
            String filename = UUID.randomUUID().toString() + ".PNG";
            fos = new FileOutputStream(new File(path + filename));
            fos.write(out.toByteArray());
            fos.flush();
            openFileExplorer(filename);
        } catch (HeadlessException | IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnQRActionPerformed

    private void txtsearchvaluehoadonCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtsearchvaluehoadonCaretUpdate
        ArrayList<HoaDonTraXeViewModel> flist = new ArrayList<>();
        DefaultTableModel dtm = (DefaultTableModel) tblhoadon.getModel();
        for (HoaDonTraXeViewModel h : listx) {
            for (int i = 0; i < 4; i++) {
                if (traxerepo.getkh(h.getIdhd()).getTen().contains(txtsearchvaluehoadon.getText())) {
                    listx.add(h);
                }
            }
        }
        for (HoaDonTraXeViewModel h : flist) {
            Object[] rowData = {
                traxerepo.getkh(h.getIdhd()),
                h.getNgaytra(),
                intvipham(h.getVipham()),
                h.getTongtien(),
                h.getId(),
                h.getIdhd(),
                h.getIdkh()
            };
            dtm.addRow(rowData);
        }
    }//GEN-LAST:event_txtsearchvaluehoadonCaretUpdate

    private void btnreloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreloadActionPerformed
        loadtablehoadon();
    }//GEN-LAST:event_btnreloadActionPerformed

    private void tblhopdong12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblhopdong12MouseClicked
        int row = tblhopdong12.getSelectedRow();
        DefaultTableModel dtm = (DefaultTableModel) tblhopdong12.getModel();
        txtidhopdong12.setText(dtm.getValueAt(row, 0).toString());
        txttenkhachhang12.setText(dtm.getValueAt(row, 1).toString());
        txttennhanvien12.setText(dtm.getValueAt(row, 2).toString());
        if (dtm.getValueAt(row, 3).toString().equalsIgnoreCase("đã ký")) {
            rdo0.setSelected(true);
        } else {
            rdo1.setSelected(true);
        }
        txtngaytao12.setText(dtm.getValueAt(row, 4).toString());
        txtngayhethan12.setText(dtm.getValueAt(row, 5).toString());
        txtidkhachhang12.setText(dtm.getValueAt(row, 6).toString());
        txtidnhanvien12.setText(dtm.getValueAt(row, 7).toString());
    }//GEN-LAST:event_tblhopdong12MouseClicked

    private void btnselecthopdongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnselecthopdongActionPerformed
        txtidhopdong11.setText(txtidhopdong12.getText());
        txttenkhachhang11.setText(txttenkhachhang12.getText());
        txtidkhachhang11.setText(txtidkhachhang12.getText());
    }//GEN-LAST:event_btnselecthopdongActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnQR;
    private javax.swing.JButton btnreload;
    private javax.swing.JButton btnselecthopdong;
    private javax.swing.JButton btnsuahoadon;
    private javax.swing.JButton btnthemhoadon;
    private javax.swing.JComboBox<String> cbbvipham;
    private javax.swing.ButtonGroup hopdonggroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblsearchcounthoadon;
    private javax.swing.JRadioButton rdo0;
    private javax.swing.JRadioButton rdo1;
    private javax.swing.JTable tblhoadon;
    private javax.swing.JTable tblhopdong12;
    private javax.swing.JTextField txtidhopdong11;
    private javax.swing.JTextField txtidhopdong12;
    private javax.swing.JTextField txtidkhachhang11;
    private javax.swing.JTextField txtidkhachhang12;
    private javax.swing.JTextField txtidnhanvien12;
    private javax.swing.JTextField txtngayhethan12;
    private javax.swing.JTextField txtngaytao12;
    private javax.swing.JTextField txtngaytra;
    private javax.swing.JTextField txtphuphi;
    private javax.swing.JTextField txtsearchvaluehoadon;
    private javax.swing.JTextField txttenkhachhang11;
    private javax.swing.JTextField txttenkhachhang12;
    private javax.swing.JTextField txttennhanvien12;
    private javax.swing.JTextField txttongtien11;
    // End of variables declaration//GEN-END:variables
}
