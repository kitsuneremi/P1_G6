package com.raven.main;

import com.componentfolder.Service.DangNhapService;
import com.componentfolder.Service.Impl.DangNhapImpl;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public class Start extends javax.swing.JFrame {

    DangNhapService dns = new DangNhapImpl();

    public Start() {
        initComponents();
        txtmk.setText("12345678");
        txttaikhoan.setText("nguyenngocminh123");
    }

    public Start(String taikhoan) {
        initComponents();
        txtmk.setText("12345678");
        txttaikhoan.setText("nguyenngocminh123");
    }

    void signin() {
        String taikhoan = txttaikhoan.getText();
        String Mk = txtmk.getText();
        try {
            switch (dns.get(taikhoan, Mk)) {
                case "Quản Lý": {
                    JOptionPane.showMessageDialog(this, "Đăng nhập tài Khoản Quản Lý thành công!!");
                    Main m = new Main(dns.get(taikhoan, Mk));
                    m.setSize(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width, GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height);
                    m.setLocationRelativeTo(null);
                    m.setVisible(true);
                    this.dispose();
                    break;
                }
                case "Nhân Viên": {
                    JOptionPane.showMessageDialog(this, "Đăng nhập tài Khoản Nhân Viên thành công!!");
                    Main m = new Main(dns.get(taikhoan, Mk));
                    m.setSize(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width, GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height);
                    m.setLocationRelativeTo(null);
                    m.setVisible(true);
                    this.dispose();
                    break;
                }
                default:
                    JOptionPane.showMessageDialog(this, "Sai Tài Khoản Hoặc Mật Khẩu! Vui Lòng Nhập Lại!");
                    break;
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, "Sai Tài Khoản Hoặc Mật Khẩu! Vui Lòng Nhập Lại!");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txttaikhoan = new javax.swing.JTextField();
        txtmk = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txttaikhoan.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        txttaikhoan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txttaikhoanKeyPressed(evt);
            }
        });

        txtmk.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        txtmk.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtmkKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel1.setText("tài khoản");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel2.setText("mật khẩu");

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton1.setText("đăng nhập");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButton2.setText("thoát");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txttaikhoan, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                    .addComponent(txtmk))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txttaikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtmk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        signin();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtmkKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmkKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            signin();
        }

    }//GEN-LAST:event_txtmkKeyPressed

    private void txttaikhoanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttaikhoanKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            signin();
        }
    }//GEN-LAST:event_txttaikhoanKeyPressed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            Start hi = new Start();
            hi.setLocationRelativeTo(null);
            hi.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField txtmk;
    private javax.swing.JTextField txttaikhoan;
    // End of variables declaration//GEN-END:variables
}
