package com.raven.form;

import com.componentfolder.Model.ChiTietHopDongModel;
import com.componentfolder.Repository.HoaDonTraXeRepo;
import com.componentfolder.Model.HoaDonTraXeModel;
import com.componentfolder.Model.HopDongModel;
import com.componentfolder.Model.ViPhamModel;
import com.componentfolder.ViewModel.HoaDonTraXeViewModel;
import com.componentfolder.ViewModel.HopDongViewModel;
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.Icon;

public final class Form_hoadon extends javax.swing.JPanel {

    private final HoaDonTraXeRepo traxerepo = new HoaDonTraXeRepo();
    private final ArrayList<HoaDonTraXeViewModel> listx = traxerepo.getlistdata();

    /**
     * Creates new form Form_4
     */
    public Form_hoadon() {
        initComponents();
        firstLoad();
    }

    void firstLoad() {
        loadcbb();
        loadtablehoadon();
        loadtablehopdong();
        removeColumn();
        rdochuaky.setEnabled(false);
        rdodaky.setEnabled(false);
        loademptytable();
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
                h.getIdkh()
            };
            dtm.addRow(rowData);
        }
    }

    void loademptytable() {
        ArrayList<HoaDonTraXeViewModel> list = traxerepo.getemptylist();
        DefaultTableModel dtm = (DefaultTableModel) tblhoadon.getModel();
        dtm.setRowCount(0);
        for (HoaDonTraXeViewModel h : list) {
            Object[] rowData = {
                "",
                "--/--/----",
                "không",
                h.getPhiphatsinh(),
                h.getTongtien(),
                h.getId(),
                "",
                ""
            };
            dtm.addRow(rowData);
        }
    }

    void loadtablehopdong() {
        ArrayList<HopDongViewModel> list = traxerepo.getlisthd();
        DefaultTableModel dtm = (DefaultTableModel) tblhopdong12.getModel();
        dtm.setRowCount(0);
        for (HopDongViewModel h : list) {
            Object[] rowData = {
                h.getMahd(),
                traxerepo.getkh(h.getMahd()).getTen(),
                traxerepo.getnv(h.getIdnv()),
                h.getTinhTrang() == 0 ? "chưa ký" : "đã ký",
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
        hdm.setMahd(txtmahopdong1.getText());
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
            hdtxm.setTongtien(Double.parseDouble(txttongtien1.getText()));
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
            case 0:{
                return "không";
            }
            case 1: {
                return "quá hạn hợp đồng";
            }
            case 2: {
                return "chưa đến hạn hợp đồng";
            }
            case 3: {
                return "hư hỏng xe";
            }
            default: {
                return "không";
            }
        }
    }

    void openFileExplorer(String filepath) {
        try {
            File file = new File(filepath);
            Desktop desktop = Desktop.getDesktop();
            desktop.open(file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    boolean sendemail() {
        String to = traxerepo.getemail(txtidkhachhang1.getText());
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
                String password = "vjslxvolwqpnjaub";
                return new PasswordAuthentication(email, password);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("payment successfully!");
            message.setText("Thank you for belive our service~");
            Transport.send(message, "lilypeachew@gmail.com", "vjslxvolwqpnjaub");
            JOptionPane.showMessageDialog(this, "Done!, email have been sent to the customer");
            return true;
        } catch (MessagingException mex) {
            mex.printStackTrace();
            return false;
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
        lblidhopdong1 = new javax.swing.JLabel();
        lbltenkhachhang1 = new javax.swing.JLabel();
        lblvipham = new javax.swing.JLabel();
        lblphuphi = new javax.swing.JLabel();
        lbltongtien = new javax.swing.JLabel();
        txtmahopdong1 = new javax.swing.JTextField();
        txttenkhachhang1 = new javax.swing.JTextField();
        cbbvipham = new javax.swing.JComboBox<>();
        txtphuphi = new javax.swing.JTextField();
        txttongtien1 = new javax.swing.JTextField();
        txtngaytra = new javax.swing.JTextField();
        lblngaytra = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnthemhoadon = new javax.swing.JButton();
        btnpayment = new javax.swing.JButton();
        btnQR = new javax.swing.JButton();
        txtsearchvaluehoadon = new javax.swing.JTextField();
        lblsearchcounthoadon = new javax.swing.JLabel();
        btnreload = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblhoadon = new javax.swing.JTable();
        txtidkhachhang1 = new javax.swing.JTextField();
        lblmota = new javax.swing.JLabel();
        txtmota = new javax.swing.JTextField();
        txtmahoadon1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtidhopdong2 = new javax.swing.JTextField();
        txttenkhachhang2 = new javax.swing.JTextField();
        txttennhanvien2 = new javax.swing.JTextField();
        rdochuaky = new javax.swing.JRadioButton();
        rdodaky = new javax.swing.JRadioButton();
        txtngaytao12 = new javax.swing.JTextField();
        txtngayhethan12 = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        txtsearchvaluehopdong = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        btnselecthopdong = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblhopdong12 = new javax.swing.JTable();
        txtmakhachhang2 = new javax.swing.JTextField();
        txtidnhanvien2 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        lblidhopdong1.setText("mã hợp đồng");

        lbltenkhachhang1.setText("tên khách hàng");

        lblvipham.setText("vi phạm");

        lblphuphi.setText("phụ phí");

        lbltongtien.setText("tổng tiền");

        txtmahopdong1.setEditable(false);

        txttenkhachhang1.setEditable(false);

        cbbvipham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbvipham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbviphamActionPerformed(evt);
            }
        });

        txtphuphi.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtphuphiCaretUpdate(evt);
            }
        });

        txttongtien1.setEditable(false);

        lblngaytra.setText("ngày trả");

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 51, 255), null));

        btnthemhoadon.setText("tạo mới");
        btnthemhoadon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemhoadonActionPerformed(evt);
            }
        });

        btnpayment.setText("thanh toán");
        btnpayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpaymentActionPerformed(evt);
            }
        });

        btnQR.setText("tạo mã QR");
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
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(lblsearchcounthoadon)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnreload))
                            .addComponent(txtsearchvaluehoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(21, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnthemhoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnpayment)
                        .addGap(30, 30, 30))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(btnQR, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnthemhoadon)
                    .addComponent(btnpayment))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(btnQR)
                .addGap(18, 18, 18)
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
                "tên khách hàng", "ngày trả", "vi phạm", "phụ phí", "tổng tiền", "mã hóa đơn", "mã hợp đồng", "mã khách hàng"
            }
        ));
        tblhoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblhoadonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblhoadon);

        txtidkhachhang1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidkhachhang1ActionPerformed(evt);
            }
        });

        lblmota.setText("mo ta");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbltenkhachhang1)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblphuphi)
                                        .addComponent(lblvipham))
                                    .addComponent(lblidhopdong1))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbbvipham, 0, 168, Short.MAX_VALUE)
                                    .addComponent(txttenkhachhang1, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                    .addComponent(txtphuphi, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                    .addComponent(txttongtien1, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                    .addComponent(txtngaytra, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                    .addComponent(txtmahopdong1)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbltongtien)
                                    .addComponent(lblngaytra)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtidkhachhang1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(txtmahoadon1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblmota)
                                .addGap(18, 18, 18)
                                .addComponent(txtmota))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(22, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(lblidhopdong1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtmahopdong1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblmota)
                                .addComponent(txtmota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(lbltenkhachhang1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txttenkhachhang1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblvipham)
                            .addComponent(cbbvipham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblphuphi)
                            .addComponent(txtphuphi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbltongtien)
                            .addComponent(txttongtien1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblngaytra)
                            .addComponent(txtngaytra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtidkhachhang1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmahoadon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("hóa đơn", jPanel1);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jLabel10.setText("id hợp đồng");

        jLabel11.setText("tên khách hàng");

        jLabel12.setText("tên nhân viên");

        jLabel15.setText("tinh trang");

        jLabel13.setText("ngày tạo");

        jLabel14.setText("ngày hết");

        hopdonggroup.add(rdochuaky);
        rdochuaky.setSelected(true);
        rdochuaky.setText("chưa ký");

        hopdonggroup.add(rdodaky);
        rdodaky.setText("đã ký");

        jPanel15.setBackground(new java.awt.Color(204, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(204, 204, 255)));

        txtsearchvaluehopdong.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtsearchvaluehopdongCaretUpdate(evt);
            }
        });
        txtsearchvaluehopdong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsearchvaluehopdongActionPerformed(evt);
            }
        });

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
                        .addComponent(txtsearchvaluehopdong, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnselecthopdong)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jLabel16)
                .addGap(5, 5, 5)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsearchvaluehopdong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txttenkhachhang2)
                                    .addComponent(txtidhopdong2)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel15))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(rdochuaky)
                                        .addGap(31, 31, 31)
                                        .addComponent(rdodaky)
                                        .addGap(0, 83, Short.MAX_VALUE))
                                    .addComponent(txttennhanvien2))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(txtngaytao12, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(18, 18, 18)
                                .addComponent(txtngayhethan12, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(txtmakhachhang2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126)
                .addComponent(txtidnhanvien2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel13)
                    .addComponent(txtidhopdong2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtngaytao12))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel14)
                    .addComponent(txttenkhachhang2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtngayhethan12))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txttennhanvien2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(rdochuaky)
                            .addComponent(rdodaky)))
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(190, 190, 190)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmakhachhang2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidnhanvien2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        jTabbedPane1.addTab("hop dong", jPanel2);

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
            double tienthuexe = traxerepo.tienthuexe(txtmahopdong1.getText().trim());
            if (txtmahopdong1.getText().equalsIgnoreCase("")) {
                txttongtien1.setText(String.valueOf(tienthuexe));
                return;
            }
            double phiphatsinh = Double.parseDouble(txtphuphi.getText());
            if (phiphatsinh == 0) {
                txttongtien1.setText(String.valueOf(tienthuexe));
            }
            txttongtien1.setText(String.valueOf(tienthuexe + phiphatsinh));
        } catch (NumberFormatException ex) {
            return;
        }
    }//GEN-LAST:event_txtphuphiCaretUpdate

    private void btnthemhoadonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemhoadonActionPerformed
        HoaDonTraXeModel hdtxm = new HoaDonTraXeModel();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        hdtxm.setId("HoaDon" + traxerepo.getlistdata().size());
        try {
            hdtxm.setNgaytra(sdf.parse("30/12/2099"));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        hdtxm.setPhiphatsinh(0);
        hdtxm.setTongtien(0);
        hdtxm.setVipham(new ViPhamModel(0, "không"));
        hdtxm.setMota("");
        boolean insert = traxerepo.insert(hdtxm);
        if (insert) {
            JOptionPane.showMessageDialog(this, "tạo trắng thành công");
        } else {
            JOptionPane.showMessageDialog(this, "tạo trắng thất bại");
        }
        loadtablehoadon();
    }//GEN-LAST:event_btnthemhoadonActionPerformed

    private void btnpaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpaymentActionPerformed
        HoaDonTraXeModel hdtxm = gethoadonformdata();
        if (traxerepo.update(hdtxm) && sendemail()) {
            JOptionPane.showMessageDialog(this, "thành công, đã gửi email đến khách hàng");
        } else {
            JOptionPane.showMessageDialog(this, "thất bại");
        }
        ArrayList<ChiTietHopDongModel> cthdm = traxerepo.getdsbienso(hdtxm.getHdm().getMahd());
        for (ChiTietHopDongModel chiTietHopDongModel : cthdm) {
            traxerepo.updatexe(chiTietHopDongModel.getMahd().getMahd());
        }
    }//GEN-LAST:event_btnpaymentActionPerformed

    private void btnQRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQRActionPerformed
        FileOutputStream fos = null;
        try {
            int row = tblhoadon.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "chưa có hàng nào được lựa chọn");
                return;
            }
            DefaultTableModel dtm = (DefaultTableModel) tblhoadon.getModel();
            String f_name = "ma hoa don: " + dtm.getValueAt(row, 5) + "\nten khach hang: " + dtm.getValueAt(row, 0) + "\nma hop dong"
                    + dtm.getValueAt(row, 6) + "\nngay tra: " + dtm.getValueAt(row, 1)
                    + "\nphu phi: " + tblhoadon.getValueAt(row, 3) + "\ntong tien: " + tblhoadon.getValueAt(row, 4);
            ByteArrayOutputStream out = QRCode.from(f_name).to(ImageType.PNG).stream();
            String path = "D:\\fpt\\QRCode\\" + dtm.getValueAt(row, 5) + ".PNG";
            File fx = new File(dtm.getValueAt(row, 5) + ".PNG");
            fx.delete();
            fos = new FileOutputStream(new File(path));
            fos.write(out.toByteArray());
            fos.flush();
            openFileExplorer(path);
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
        txtidhopdong2.setText(dtm.getValueAt(row, 0).toString());
        txttenkhachhang2.setText(dtm.getValueAt(row, 1).toString());
        txttennhanvien2.setText(dtm.getValueAt(row, 2).toString());
        if (dtm.getValueAt(row, 3).toString().equalsIgnoreCase("chưa ký")) {
            rdochuaky.setSelected(true);
        } else {
            rdodaky.setSelected(true);
        }
        txtngaytao12.setText(dtm.getValueAt(row, 4).toString());
        txtngayhethan12.setText(dtm.getValueAt(row, 5).toString());
        txtmakhachhang2.setText(dtm.getValueAt(row, 6).toString());
        txtidnhanvien2.setText(dtm.getValueAt(row, 7).toString());
    }//GEN-LAST:event_tblhopdong12MouseClicked

    private void btnselecthopdongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnselecthopdongActionPerformed
        if (rdochuaky.isSelected()) {
            JOptionPane.showMessageDialog(this, "bạn không thể chọn 1 hợp đồng chưa được ký");
            return;
        }
        jTabbedPane1.setSelectedIndex(0);
        txtmahopdong1.setText(txtidhopdong2.getText());
        txttenkhachhang1.setText(txttenkhachhang2.getText());
        txtidkhachhang1.setText(txtmakhachhang2.getText());
    }//GEN-LAST:event_btnselecthopdongActionPerformed

    private void txtidkhachhang1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidkhachhang1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidkhachhang1ActionPerformed

    private void txtsearchvaluehopdongCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtsearchvaluehopdongCaretUpdate
//        if(txtsearchvaluehopdong.getText().equalsIgnoreCase("")){
//            loadtablehopdong();
//            return ;
//        }
//        ArrayList<HopDongViewModel> initList = traxerepo.getlisthd();
//        ArrayList<HopDongViewModel> finalList = new ArrayList<>();
//        for (HopDongViewModel h : initList) {
//            for (int i = 0; i < 5; i++) {
//                if (traxerepo.getkh(h.getMahd()).getTen().contains(txtsearchvaluehoadon.getText())) {
//                    for (HopDongViewModel hx : finalList) {
//                        if (hx.getMahd().equals(h.getMahd())) {
//                            System.out.println(hx.getMahd() + " " +h.getMahd());
//                        } else {
//                            finalList.add(h);
//                        }
//                    }
//                }
//                else if (traxerepo.getnv(h.getIdnv()).contains(txtsearchvaluehoadon.getText())) {
//                    finalList.add(h);
//                } else if (h.getMahd().contains(txtsearchvaluehoadon.getText())) {
//                    finalList.add(h);
//                }
//            }
//        }
//        DefaultTableModel dtm = (DefaultTableModel) tblhopdong12.getModel();
//        dtm.setRowCount(0);
//        for (HopDongViewModel h : finalList) {
//            Object[] rowData = {
//                h.getMahd(),
//                traxerepo.getkh(h.getMahd()).getTen(),
//                traxerepo.getnv(h.getIdnv()),
//                h.getTinhTrang() == 0 ? "chưa ký" : "đã ký",
//                convertdate(h.getNgayTao()),
//                convertdate(h.getNgayHetHan()),
//                h.getIdkh(),
//                h.getIdnv()
//            };
//            dtm.addRow(rowData);
//        }
    }//GEN-LAST:event_txtsearchvaluehopdongCaretUpdate

    private void txtsearchvaluehopdongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsearchvaluehopdongActionPerformed

    }//GEN-LAST:event_txtsearchvaluehopdongActionPerformed

    private void tblhoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblhoadonMouseClicked
        DefaultTableModel dtm = (DefaultTableModel) tblhoadon.getModel();
        int row = tblhoadon.getSelectedRow();
        if (dtm.getValueAt(row, 1).equals("--/--/----")) {
            cbbvipham.setSelectedIndex(0);
            txttongtien1.setText(String.valueOf(0));
            txtphuphi.setText(String.valueOf(0));
        } else {
            txtmahoadon1.setText(dtm.getValueAt(row, 5).toString());
            if (dtm.getValueAt(row, 2).equals("không")) {
                cbbvipham.setSelectedIndex(0);
            } else if (dtm.getValueAt(row, 2).equals("quá hạn hợp đồng")) {
                cbbvipham.setSelectedIndex(1);
            } else if (dtm.getValueAt(row, 2).equals("chưa đến hạn hợp đồng")) {
                cbbvipham.setSelectedIndex(2);
            } else if (dtm.getValueAt(row, 2).equals("hư hỏng xe")) {
                cbbvipham.setSelectedIndex(3);
            }
            txtphuphi.setText(dtm.getValueAt(row, 3).toString());
            txttongtien1.setText(dtm.getValueAt(row, 4).toString());
        }

    }//GEN-LAST:event_tblhoadonMouseClicked

    private void cbbviphamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbviphamActionPerformed
        if (cbbvipham.getSelectedIndex() == 0) {
            txtmota.setVisible(false);
            lblmota.setVisible(false);
        } else {
            txtmota.setVisible(true);
            lblmota.setVisible(true);
        }
    }//GEN-LAST:event_cbbviphamActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnQR;
    private javax.swing.JButton btnpayment;
    private javax.swing.JButton btnreload;
    private javax.swing.JButton btnselecthopdong;
    private javax.swing.JButton btnthemhoadon;
    private javax.swing.JComboBox<String> cbbvipham;
    private javax.swing.ButtonGroup hopdonggroup;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblidhopdong1;
    private javax.swing.JLabel lblmota;
    private javax.swing.JLabel lblngaytra;
    private javax.swing.JLabel lblphuphi;
    private javax.swing.JLabel lblsearchcounthoadon;
    private javax.swing.JLabel lbltenkhachhang1;
    private javax.swing.JLabel lbltongtien;
    private javax.swing.JLabel lblvipham;
    private javax.swing.JRadioButton rdochuaky;
    private javax.swing.JRadioButton rdodaky;
    private javax.swing.JTable tblhoadon;
    private javax.swing.JTable tblhopdong12;
    private javax.swing.JTextField txtidhopdong2;
    private javax.swing.JTextField txtidkhachhang1;
    private javax.swing.JTextField txtidnhanvien2;
    private javax.swing.JTextField txtmahoadon1;
    private javax.swing.JTextField txtmahopdong1;
    private javax.swing.JTextField txtmakhachhang2;
    private javax.swing.JTextField txtmota;
    private javax.swing.JTextField txtngayhethan12;
    private javax.swing.JTextField txtngaytao12;
    private javax.swing.JTextField txtngaytra;
    private javax.swing.JTextField txtphuphi;
    private javax.swing.JTextField txtsearchvaluehoadon;
    private javax.swing.JTextField txtsearchvaluehopdong;
    private javax.swing.JTextField txttenkhachhang1;
    private javax.swing.JTextField txttenkhachhang2;
    private javax.swing.JTextField txttennhanvien2;
    private javax.swing.JTextField txttongtien1;
    // End of variables declaration//GEN-END:variables
}
