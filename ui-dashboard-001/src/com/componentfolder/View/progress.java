package com.componentfolder.View;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class progress extends javax.swing.JFrame implements Runnable {
    String mahd = "";
    double tongtien = 0;
    public progress() {
        initComponents();
        Thread t = new Thread(this);
        t.start();
        lbltext.setVisible(false);
        btnconfirm.setVisible(false);
    }

    public progress(String mahd,double tongtien) {
        initComponents();
        Thread t = new Thread(this);
        t.start();
        lbltext.setVisible(false);
        btnconfirm.setVisible(false);
        this.tongtien = tongtien;
        this.mahd = mahd;
    }

    boolean sendemail(String mahd, double tongtien) {
//        String to = service.getemail(txtidkhachhang1.getText());
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

        pro = new javax.swing.JProgressBar();
        btnconfirm = new javax.swing.JButton();
        lblpercent = new javax.swing.JLabel();
        lbltext = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(pro, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 16, 220, 20));

        btnconfirm.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btnconfirm.setText("xác nhận");
        btnconfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconfirmActionPerformed(evt);
            }
        });
        getContentPane().add(btnconfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));

        lblpercent.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        lblpercent.setText("0%");
        getContentPane().add(lblpercent, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, -1, -1));

        lbltext.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        lbltext.setText("đã gửi email đến khách hàng");
        getContentPane().add(lbltext, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnconfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconfirmActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnconfirmActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(progress.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(progress.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(progress.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(progress.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new progress().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnconfirm;
    private javax.swing.JLabel lblpercent;
    private javax.swing.JLabel lbltext;
    private javax.swing.JProgressBar pro;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        int i = pro.getValue();
//        sendemail(mahd, tongtien);
        while (true) {
            try {
                if (i == 100) {
                    lbltext.setVisible(true);
                    btnconfirm.setVisible(true);
                    lblpercent.setVisible(false);
                    break;
                }
                pro.setValue(i);
                i++;
                lblpercent.setText(i + "%");
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
