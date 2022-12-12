package com.raven.form;

import com.componentfolder.Model.ChiTietHopDongModel;
import com.componentfolder.Model.ChiTietViPhamModel;
import com.componentfolder.Model.HoaDonTraXeModel;
import com.componentfolder.Model.HopDongModel;
import com.componentfolder.Model.ViPhamModel;
import com.componentfolder.Service.HoaDonTraXeService;
import com.componentfolder.Service.Impl.HoaDonTraXeServiceImpl;
import com.componentfolder.ViewModel.HoaDonTraXeViewModel;
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
import java.util.HashSet;
import java.util.Properties;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
import javax.mail.*;
import javax.mail.internet.*;

public final class Form_hoadon extends javax.swing.JPanel {

    private final HoaDonTraXeService service = new HoaDonTraXeServiceImpl();
    HashSet<HopDongViewModel> finalList = new HashSet<>();

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
    }

    void removeColumn() {
        tblhoadon.removeColumn(tblhoadon.getColumnModel().getColumn(7));
        tblhoadon.removeColumn(tblhoadon.getColumnModel().getColumn(5));
        tblhopdong12.removeColumn(tblhopdong12.getColumnModel().getColumn(6));
        tblhopdong12.removeColumn(tblhopdong12.getColumnModel().getColumn(6));
    }

    void loadcbb() {
        ArrayList<ViPhamModel> list = service.vipham();
        DefaultComboBoxModel dcm = (DefaultComboBoxModel) cbbvipham.getModel();
        dcm.removeAllElements();
        for (ViPhamModel viPhamModel : list) {
            dcm.addElement(viPhamModel.getTen());
        }
        cbbvipham.setSelectedIndex(0);
    }

    String convertdate(java.util.Date date) {
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(utilDate);
    }

    void loadtablehoadon() {
        ArrayList<HoaDonTraXeViewModel> list = service.getlistdata();
        ArrayList<HoaDonTraXeViewModel> list1 = service.getemptylist();
        DefaultTableModel dtm = (DefaultTableModel) tblhoadon.getModel();
        dtm.setRowCount(0);
        for (HoaDonTraXeViewModel h : list) {
            Object[] rowData = {
                service.getkh(h.getIdhd()).getTen(),
                convertdate(h.getNgaytra()),
                service.getsovipham(h.getId()),
                h.getPhiphatsinh(),
                h.getTongtien(),
                h.getId(),
                h.getIdhd(),
                h.getIdkh()
            };
            dtm.addRow(rowData);
        }
        for (HoaDonTraXeViewModel h : list1) {
            Object[] rowData = {
                "",
                "--/--/----",
                "Không Vi Phạm",
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
        ArrayList<HopDongViewModel> list = service.getlisthd();
        DefaultTableModel dtm = (DefaultTableModel) tblhopdong12.getModel();
        dtm.setRowCount(0);
        for (HopDongViewModel h : list) {
            Object[] rowData = {
                h.getMahd(),
                service.getkh(h.getMahd()).getTen(),
                service.getnv(h.getIdnv()),
                h.getTinhTrangXe() == 0 ? "chưa ký" : "đã ký",
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
        hdtxm.setId(txtidhoadon1.getText());
        try {
            hdm.setNgayHetHan(sdf.parse(txtngayhethan12.getText()));
            hdm.setNgayTao(sdf.parse(txtngaytao12.getText()));
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
        if (txtmota.getText().equalsIgnoreCase("")) {
            hdtxm.setMota("không có");
        } else {
            hdtxm.setMota(txtmota.getText());
        }

        hdtxm.setHdm(hdm);
        return hdtxm;
    }
    int strvipham(String vipham) {
        switch (vipham) {
            case "Không Vi Phạm":
                return 0;
            case "Trả Xe Trước Hạn":
                return 1;
            case "Trả Xe Quá Hạn":
                return 2;
            case "Xe Hỏng":
                return 3;
            case "Xe Thiếu Phụ Kiện":
                return 4;
            case "Mất Xe":
                return 5;
            case "Khác":
                return 6;
            default:
                return 0;
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
    boolean tracuu(String init, String value) {
        boolean x = false;
        for (int i = 0; i < init.length() - value.length() + 1; i++) {
            if (init.substring(i, i + value.length()).toLowerCase().equals(value.toLowerCase())) {
                x = true;
                break;
            } else {
                x = false;
            }
        }
        return x;
    }
    HashSet<HopDongViewModel> hx(HashSet<String> list) {
        HashSet<HopDongViewModel> set = new HashSet<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        loadtablehopdong();
        DefaultTableModel dtm = (DefaultTableModel) tblhopdong12.getModel();
        for (String s : list) {
            HopDongViewModel hdvm = new HopDongViewModel();
            hdvm.setIdkh(dtm.getValueAt(Integer.parseInt(s), 6).toString());
            hdvm.setIdnv(dtm.getValueAt(Integer.parseInt(s), 7).toString());
            hdvm.setMahd(dtm.getValueAt(Integer.parseInt(s), 0).toString());
            try {
                hdvm.setNgayHetHan(sdf.parse(dtm.getValueAt(Integer.parseInt(s), 5).toString()));
                hdvm.setNgayTao(sdf.parse(dtm.getValueAt(Integer.parseInt(s), 4).toString()));
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            if (dtm.getValueAt(Integer.parseInt(s), 4).equals("đã ký")) {
                hdvm.setTinhTrangXe(1);
            } else {
                hdvm.setTinhTrangXe(0);
            }
            set.add(hdvm);
        }
        return set;
    }
    HashSet<HoaDonTraXeViewModel> hy(HashSet<String> list) {
        HashSet<HoaDonTraXeViewModel> set = new HashSet<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        loadtablehopdong();
        DefaultTableModel dtm = (DefaultTableModel) tblhoadon.getModel();
        for (String s : list) {
            HoaDonTraXeViewModel hdtxvm = new HoaDonTraXeViewModel();
            hdtxvm.setIdkh(dtm.getValueAt(Integer.parseInt(s), 7).toString());
            hdtxvm.setId(dtm.getValueAt(Integer.parseInt(s), 5).toString());
            hdtxvm.setIdhd(dtm.getValueAt(Integer.parseInt(s), 6).toString());
            try {
                hdtxvm.setNgaytra(sdf.parse(dtm.getValueAt(Integer.parseInt(s), 1).toString()));
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            hdtxvm.setPhiphatsinh(Double.parseDouble(dtm.getValueAt(Integer.parseInt(s), 3).toString()));
            hdtxvm.setTongtien(Double.parseDouble(dtm.getValueAt(Integer.parseInt(s), 4).toString()));
            set.add(hdtxvm);
        }
        return set;
    }
    HashSet<ChiTietViPhamModel> getlistvp(String mahd) {
        HashSet<ChiTietViPhamModel> list = new HashSet<>();
        for (int i = 0; i < txtvipham1.getText().length(); i++) {
            ChiTietViPhamModel ctvpm = new ChiTietViPhamModel();
            ctvpm.setMahoadon(mahd);
            ctvpm.setVpm(new ViPhamModel(Integer.parseInt(txtvipham1.getText().substring(i, i + 1)), ""));
            list.add(ctvpm);
        }
        return list;
    }
    
    boolean sendemail(String mahd, double tongtien) {
        String to = "erinasaiyukii@gmail.com";
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
            message.setText("bạn đã thanh tóa hóa đơn: " + mahd + "\ntổng tiền: " + tongtien + "\nThank you for belive our service~");
            Transport.send(message, "lilypeachew@gmail.com", "vjslxvolwqpnjaub");
            return true;
        } catch (MessagingException mex) {
            mex.printStackTrace();
            return false;
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hopdonggroup = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lblidhopdong1 = new javax.swing.JLabel();
        lbltenkhachhang1 = new javax.swing.JLabel();
        lblphuphi = new javax.swing.JLabel();
        lbltongtien = new javax.swing.JLabel();
        txtmahopdong1 = new javax.swing.JTextField();
        txttenkhachhang1 = new javax.swing.JTextField();
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
        txtidhoadon1 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        cbbvipham = new javax.swing.JComboBox<>();
        txtvipham = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtvipham1 = new javax.swing.JTextField();
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

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        lblidhopdong1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblidhopdong1.setText("mã hợp đồng");

        lbltenkhachhang1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lbltenkhachhang1.setText("tên khách hàng");

        lblphuphi.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblphuphi.setText("phụ phí");

        lbltongtien.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lbltongtien.setText("tổng tiền");

        txtmahopdong1.setEditable(false);
        txtmahopdong1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        txttenkhachhang1.setEditable(false);
        txttenkhachhang1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        txtphuphi.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtphuphi.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtphuphiCaretUpdate(evt);
            }
        });

        txttongtien1.setEditable(false);
        txttongtien1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        txtngaytra.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        lblngaytra.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
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

        lblsearchcounthoadon.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblsearchcounthoadon.setText("tìm thấy ");

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
                        .addComponent(btnthemhoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnpayment)
                        .addGap(30, 30, 30))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(lblsearchcounthoadon)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnreload))
                                .addComponent(txtsearchvaluehoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(btnQR, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(21, Short.MAX_VALUE))))
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

        tblhoadon.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        tblhoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "tên khách hàng", "ngày trả", "số vi phạm", "phụ phí", "tổng tiền", "mã hóa đơn", "mã hợp đồng", "mã khách hàng"
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

        lblmota.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblmota.setText("mô tả");

        txtmota.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cbbvipham.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        cbbvipham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbvipham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbviphamActionPerformed(evt);
            }
        });

        txtvipham.setEditable(false);
        txtvipham.setBackground(new java.awt.Color(255, 255, 255));
        txtvipham.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtvipham.setText("Không Vi Phạm");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(cbbvipham, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 67, Short.MAX_VALUE))
                    .addComponent(txtvipham))
                .addGap(13, 13, 13))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(cbbvipham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtvipham, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel1.setText("vi phạm");

        txtvipham1.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblphuphi)
                            .addComponent(lbltongtien)
                            .addComponent(lblngaytra)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbltenkhachhang1)
                                    .addComponent(lblidhopdong1))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txttenkhachhang1, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                    .addComponent(txtphuphi, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                    .addComponent(txttongtien1, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                    .addComponent(txtngaytra, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                    .addComponent(txtmahopdong1)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(txtidkhachhang1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(txtmahoadon1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtidhoadon1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(191, 191, 191)
                        .addComponent(txtvipham1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(400, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(lblmota)
                            .addGap(18, 18, 18)
                            .addComponent(txtmota, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(lblidhopdong1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(34, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtmahopdong1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblmota))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttenkhachhang1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbltenkhachhang1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(txtmota, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblphuphi)
                            .addComponent(txtphuphi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbltongtien)
                            .addComponent(txttongtien1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblngaytra)
                            .addComponent(txtngaytra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtidkhachhang1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmahoadon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidhoadon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtvipham1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            double tienthuexe = service.tienthuexe(txtmahopdong1.getText().trim());
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
        hdtxm.setId("HoaDon" + service.getlistdata().size());
        try {
            hdtxm.setNgaytra(sdf.parse("30/12/2099"));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        hdtxm.setPhiphatsinh(0);
        hdtxm.setTongtien(0);
        hdtxm.setMota("");
        boolean insert = service.insert(hdtxm);
        if (insert) {
            JOptionPane.showMessageDialog(this, "tạo trắng thành công");
        } else {
            JOptionPane.showMessageDialog(this, "tạo trắng thất bại");
        }
        loadtablehoadon();
    }//GEN-LAST:event_btnthemhoadonActionPerformed

    private void btnpaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpaymentActionPerformed
        Calendar cld = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        txtngaytra.setText(sdf.format(cld.getTime()));
        HoaDonTraXeModel hdtxm = gethoadonformdata();
        ArrayList<HoaDonTraXeViewModel> list = service.getlistdata();
        for (HoaDonTraXeViewModel hoaDonTraXeViewModel : list) {
            if (hdtxm.getId().equals(hoaDonTraXeViewModel.getId())) {
                JOptionPane.showMessageDialog(this, "hợp đồng này đã được thanh toán");
                return;
            }
        }
        try {
            hdtxm.setNgaytra(sdf.parse(txtngaytra.getText()));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        boolean b = true;
        HashSet<ChiTietViPhamModel> set = getlistvp(hdtxm.getId());
        for (ChiTietViPhamModel chiTietViPhamModel : set) {
            if (!service.updatevipham(chiTietViPhamModel)) {
                b = false;
            }
        }
        if (service.update(hdtxm) && b && sendemail(hdtxm.getId(), hdtxm.getTongtien())) {
            JOptionPane.showMessageDialog(this, "thành công, đã gửi email đến khách hàng");
        } else {
            JOptionPane.showMessageDialog(this, "thất bại");
        }
        ArrayList<ChiTietHopDongModel> cthdm = service.getdsbienso(hdtxm.getHdm().getMahd());
        for (ChiTietHopDongModel chiTietHopDongModel : cthdm) {
            service.updatexe(chiTietHopDongModel.getMahd().getMahd());
        }
        loadtablehoadon();
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
        if (txtsearchvaluehoadon.getText().equalsIgnoreCase("")) {
            loadtablehoadon();
            return;
        }
        HashSet<HoaDonTraXeViewModel> fList = new HashSet<>();
        HashSet<String> newset = new HashSet<>();
        loadtablehoadon();
        DefaultTableModel dtm = (DefaultTableModel) tblhoadon.getModel();
        int rowcount = dtm.getRowCount();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (int j = 0; j < rowcount; j++) {
            for (int i = 0; i < 5; i++) {
                if (i == 2) {
                    break;
                }
                if (tracuu(dtm.getValueAt(j, i).toString(), txtsearchvaluehoadon.getText())) {
                    if (fList.isEmpty()) {
                        HoaDonTraXeViewModel hdtxvm = new HoaDonTraXeViewModel();
                        hdtxvm.setIdkh(dtm.getValueAt(j, 7).toString());
                        hdtxvm.setId(dtm.getValueAt(j, 5).toString());
                        hdtxvm.setIdhd(dtm.getValueAt(j, 6).toString());
                        try {
                            hdtxvm.setNgaytra(sdf.parse(dtm.getValueAt(j, 1).toString()));
                        } catch (ParseException ex) {
                            ex.printStackTrace();
                        }
                        hdtxvm.setPhiphatsinh(Double.parseDouble(dtm.getValueAt(j, 3).toString()));
                        hdtxvm.setTongtien(Double.parseDouble(dtm.getValueAt(j, 4).toString()));
                        hdtxvm.setVpm(new ViPhamModel(0, "Không Vi Phạm"));

                        fList.add(hdtxvm);
                    }
                    for (HoaDonTraXeViewModel hy : fList) {
                        if (!hy.getId().equals(dtm.getValueAt(j, 5))) {
                            newset.add(String.valueOf(j));
                        }
                    }
                }
            }
        }
        HashSet<HoaDonTraXeViewModel> settronang = hy(newset);
        for (HoaDonTraXeViewModel h : settronang) {
            fList.add(h);
        }
        dtm.setRowCount(0);
        for (HoaDonTraXeViewModel h : fList) {
            Object[] rowData = {
                service.getkh(h.getIdhd()).getTen(),
                convertdate(h.getNgaytra()),
                service.getsovipham(h.getId()),
                h.getPhiphatsinh(),
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
        int row=tblhopdong12.getSelectedRow();DefaultTableModel dtm=(DefaultTableModel)tblhopdong12.getModel();txtidhopdong2.setText(dtm.getValueAt(row,0).toString());txttenkhachhang2.setText(dtm.getValueAt(row,1).toString());txttennhanvien2.setText(dtm.getValueAt(row,2).toString());if(dtm.getValueAt(row,3).toString().equalsIgnoreCase("chưa ký")){rdochuaky.setSelected(true);}else{rdodaky.setSelected(true);}txtngaytao12.setText(dtm.getValueAt(row,4).toString());txtngayhethan12.setText(dtm.getValueAt(row,5).toString());txtmakhachhang2.setText(dtm.getValueAt(row,6).toString());txtidnhanvien2.setText(dtm.getValueAt(row,7).toString());
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
        txttongtien1.setText("0");
    }//GEN-LAST:event_btnselecthopdongActionPerformed

    private void txtidkhachhang1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidkhachhang1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidkhachhang1ActionPerformed

    private void txtsearchvaluehopdongCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtsearchvaluehopdongCaretUpdate
        if (txtsearchvaluehopdong.getText().equalsIgnoreCase("")) {
            loadtablehopdong();
            return;
        }
        HashSet<String> newset = new HashSet<>();
        loadtablehopdong();
        DefaultTableModel dtm = (DefaultTableModel) tblhopdong12.getModel();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (int j = 0; j < dtm.getRowCount() - 1; j++) {
            for (int i = 0; i < 5; i++) {
                if (tracuu(dtm.getValueAt(j, i).toString(), txtsearchvaluehopdong.getText())) {
                    if (finalList.isEmpty()) {
                        HopDongViewModel hdvm = new HopDongViewModel();
                        hdvm.setIdkh(dtm.getValueAt(j, 6).toString());
                        hdvm.setIdnv(dtm.getValueAt(j, 7).toString());
                        hdvm.setMahd(dtm.getValueAt(j, 0).toString());
                        try {
                            hdvm.setNgayHetHan(sdf.parse(dtm.getValueAt(j, 5).toString()));
                            hdvm.setNgayTao(sdf.parse(dtm.getValueAt(j, 4).toString()));
                        } catch (ParseException ex) {
                            ex.printStackTrace();
                        }
                        if (dtm.getValueAt(j, 4).equals("đã ký")) {
                            hdvm.setTinhTrangXe(1);
                        } else {
                            hdvm.setTinhTrangXe(0);
                        }
                        finalList.add(hdvm);
                    }
                    for (HopDongViewModel hx : finalList) {
                        if (!hx.getMahd().equals(dtm.getValueAt(j, 0))) {
                            newset.add(String.valueOf(j));
                        }
                    }

                }
            }
        }
        HashSet<HopDongViewModel> settronang = hx(newset);
        for (HopDongViewModel hopDongViewModel : settronang) {
            finalList.add(hopDongViewModel);
        }
        dtm.setRowCount(0);
        for (HopDongViewModel h : finalList) {
            Object[] rowData = {
                h.getMahd(),
                service.getkh(h.getMahd()).getTen(),
                service.getnv(h.getIdnv()),
                h.getTinhTrangXe() == 0 ? "chưa ký" : "đã ký",
                convertdate(h.getNgayTao()),
                convertdate(h.getNgayHetHan()),
                h.getIdkh(),
                h.getIdnv()
            };

            dtm.addRow(rowData);
        }
        finalList = new HashSet<>();
    }//GEN-LAST:event_txtsearchvaluehopdongCaretUpdate

    private void txtsearchvaluehopdongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsearchvaluehopdongActionPerformed

    }//GEN-LAST:event_txtsearchvaluehopdongActionPerformed

    private void tblhoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblhoadonMouseClicked
        DefaultTableModel dtm = (DefaultTableModel) tblhoadon.getModel();
        int row = tblhoadon.getSelectedRow();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        if (dtm.getValueAt(row, 1).equals("--/--/----")) {
            cbbvipham.setSelectedIndex(0);
            txttongtien1.setText(String.valueOf(0));
            txtphuphi.setText(String.valueOf(0));
            txttenkhachhang1.setText("");
            txtmahopdong1.setText("");

        } else {
            txtmahoadon1.setText(dtm.getValueAt(row, 5).toString());
            cbbvipham.setSelectedIndex(strvipham(dtm.getValueAt(row, 2).toString()));
            txtphuphi.setText(dtm.getValueAt(row, 3).toString());
            txttongtien1.setText(dtm.getValueAt(row, 4).toString());
            txtngaytra.setText(dtm.getValueAt(row, 1).toString());
            txtmahopdong1.setText(dtm.getValueAt(row, 6).toString());
            txtmota.setText(service.mota(dtm.getValueAt(row, 5).toString()));
            txttenkhachhang1.setText(dtm.getValueAt(row, 0).toString());
            HopDongViewModel hdvm = service.gethdx(dtm.getValueAt(row, 6).toString());
            txtngayhethan12.setText(convertdate(hdvm.getNgayHetHan()));
            txtngaytao12.setText(convertdate(hdvm.getNgayTao()));
        }
        txtidhoadon1.setText(dtm.getValueAt(row, 5).toString());

    }//GEN-LAST:event_tblhoadonMouseClicked

    private void cbbviphamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbviphamActionPerformed
        if (cbbvipham.getSelectedIndex() == 0) {
            txtmota.setVisible(false);
            lblmota.setVisible(false);
            txtvipham.setText("Không Vi Phạm");
            txtvipham1.setText("0");
            if (txtvipham.getText().substring(0, 1).equals(",")) {
                txtvipham.setText(txtvipham.getText().substring(1, txtvipham.getText().length()));
            }
            System.out.println(txtvipham1.getText());
        } else {
            txtmota.setVisible(true);
            lblmota.setVisible(true);

            for (int i = 0; i < txtvipham1.getText().length(); i++) {
                if (cbbvipham.getSelectedIndex() == Integer.parseInt(txtvipham1.getText().substring(i, i + 1))) {
                    return;
                }
            }
            try {
                String text = txtvipham.getText();
                String text1 = txtvipham1.getText();
                if (tracuu(text, "Không Vi Phạm")) {
                    text = text.substring(13, text.length());
                }
                txtvipham.setText(text + "," + cbbvipham.getSelectedItem().toString());
                if (tracuu(text1, "0")) {
                    text1 = text1.substring(1, text1.length());
                }
                txtvipham1.setText(text1 + String.valueOf(cbbvipham.getSelectedIndex()));
            } catch (Exception ex) {

            }
            if (txtvipham.getText().substring(0, 1).equals(",")) {
                txtvipham.setText(txtvipham.getText().substring(1, txtvipham.getText().length()));
            }
            System.out.println(txtvipham1.getText());
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
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JPanel jPanel4;
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
    private javax.swing.JRadioButton rdochuaky;
    private javax.swing.JRadioButton rdodaky;
    private javax.swing.JTable tblhoadon;
    private javax.swing.JTable tblhopdong12;
    private javax.swing.JTextField txtidhoadon1;
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
    private javax.swing.JTextField txtvipham;
    private javax.swing.JTextField txtvipham1;
    // End of variables declaration//GEN-END:variables
}
