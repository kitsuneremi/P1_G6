package com.componentfolder.View;

import com.componentfolder.Model.KhachHangModel;
import com.componentfolder.Service.Impl.KhachHangServiceImpl;
import com.componentfolder.Service.KhachHangService;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.raven.main.Main;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import javax.swing.JOptionPane;

public class KhachHangRetail extends javax.swing.JFrame implements Runnable, ThreadFactory {
    private KhachHangService khachHangService = new KhachHangServiceImpl();
    int makh = khachHangService.getcountDB();
    private WebcamPanel panel = null;
    private Webcam webcam = null;
    String mane;

    private static final long serialVersionUID = 6441489157408381878L;
    private Executor executor = Executors.newSingleThreadExecutor(this);

    public KhachHangRetail() {
        initComponents();
        initWebcam();
        rdoNam.setSelected(true);
        btnSua.setVisible(false);
        
    }
    public KhachHangRetail(String ma, String ten,String sdt,String cccd,String email, String sex) {
        initComponents();
        mane = sex;
        txtMaKh.setText(ma); 
        txtCCCD.setText(cccd);
        txtSdt.setText(sdt);
        txtEmail.setText(email);
        txtHoTen.setText(ten);
        if(sex.equals("Nam")){
        rdoNam.setSelected(true);
        }else{rdoNu.setSelected(true);}
        btnThem.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        result_field = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMaKh = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSdt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCCCD = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnDong = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        result_field.setBorder(null);
        jPanel1.add(result_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 470, 20));

        jSeparator1.setForeground(new java.awt.Color(126, 167, 206));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 470, 10));

        jLabel1.setForeground(new java.awt.Color(105, 105, 105));
        jLabel1.setText("Resultado");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        jPanel2.setBackground(new java.awt.Color(250, 250, 250));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 300, 180));

        jLabel2.setText("Họ Tên:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));
        jPanel1.add(txtHoTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 230, -1));

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel3.setText("Khách Hàng Retail");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 190, 30));

        jLabel4.setText("Mã KH:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        txtMaKh.setEditable(false);
        jPanel1.add(txtMaKh, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 230, -1));

        jLabel5.setText("SĐT:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));
        jPanel1.add(txtSdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 230, -1));

        jLabel6.setText("CCCD:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));
        jPanel1.add(txtCCCD, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 230, -1));

        jLabel7.setText("Giới Tính:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 230, -1, -1));

        buttonGroup1.add(rdoNam);
        rdoNam.setText("Nam");
        jPanel1.add(rdoNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 230, -1, -1));

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");
        jPanel1.add(rdoNu, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 230, -1, -1));

        jLabel8.setText("Email:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 230, -1));

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel1.add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 410, -1, -1));

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        jPanel1.add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 410, -1, -1));

        btnDong.setText("Đóng");
        btnDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongActionPerformed(evt);
            }
        });
        jPanel1.add(btnDong, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 410, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongActionPerformed
        // TODO add your handling code here:
        this.dispose();
        
        
    }//GEN-LAST:event_btnDongActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        KhachHangModel khh = new KhachHangModel();        
        khh.setMakh(txtMaKh.getText());
        khh.setTen(txtHoTen.getText());
        khh.setSdt(txtSdt.getText());
        khh.setCccd(txtCCCD.getText());
        khh.setEmail(txtEmail.getText());
        System.out.println(txtSdt.getText());
        if (rdoNam.isSelected()) {
            khh.setGioitinh(0);
        }else{ khh.setGioitinh(1);}
        
        if(khachHangService.updateKH(khh)){
        JOptionPane.showMessageDialog(null, "Sửa Thông Tin Khách Hàng thành công");
        }else{
        JOptionPane.showMessageDialog(null, "Sửa Thông Tin Khách Hàng không thành công");}
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        KhachHangModel kh = new KhachHangModel();        
        for (int i = 0; i <= makh; i++) {
            kh.setMakh("KH" + (i + 1));
        }
        makh++;
        kh.setEmail(txtEmail.getText());
        kh.setTen(txtHoTen.getText());
        kh.setSdt(txtSdt.getText());
        kh.setCccd(txtCCCD.getText());
        if (rdoNam.isSelected()) {
            kh.setGioitinh(0);
        }else{ kh.setGioitinh(1);}
        
        if(khachHangService.addKH(kh)){
        JOptionPane.showMessageDialog(null, "Thêm mới Khách Hàng thành công");
        }else{
        JOptionPane.showMessageDialog(null, "Thêm mới Khách Hàng không thành công");}
    
    }//GEN-LAST:event_btnThemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KhachHangRetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new KhachHangRetail().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDong;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTextField result_field;
    private javax.swing.JTextField txtCCCD;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaKh;
    private javax.swing.JTextField txtSdt;
    // End of variables declaration//GEN-END:variables

    private void initWebcam() {
        Dimension size = WebcamResolution.QVGA.getSize();
        webcam = Webcam.getWebcams().get(1); //0 is default webcam
        webcam.setViewSize(size);

        panel = new WebcamPanel(webcam);
        panel.setPreferredSize(size);
        panel.setFPSDisplayed(true);

        jPanel2.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 300));

        executor.execute(this);
        
    }

    @Override
    public void run() {
        do {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Result result = null;
            BufferedImage image = null;
            try {
               if (webcam.isOpen()) {
                if ((image = webcam.getImage()) == null) {
                    continue;
                }
            } 
            } catch (Exception e) {
                webcam.close();
            }
            

            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            try {
                result = new MultiFormatReader().decode(bitmap);
            } catch (NotFoundException e) {
                //No result...
            }

            if (result != null) {
                result_field.setText(result.getText());
                String[] parts = result_field.getText().split("\\|");
                txtCCCD.setText(parts[0]);
                txtHoTen.setText(parts[2]);
                if(parts[4].equals("Nam")){
                    rdoNam.setSelected(true);
                }else{
                    rdoNu.setSelected(true);
                }
            }
        } while (true);
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "My Thread");
        t.setDaemon(true);
        return t;
    }
}
