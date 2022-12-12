package com.raven.form;

//import com.raven.model.Model_Card;
import com.componentfolder.Repository.AnalystRepo;
import com.componentfolder.Service.CTXeSevices;
import com.componentfolder.Service.Impl.CTXeServiceImpl;
import com.componentfolder.ViewModel.Top10ViewModel;
import com.raven.model.ModelCard;
import com.raven.chart.ModelChart;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import com.raven.javaswingdev.chart.ModelPieChart;
import com.raven.javaswingdev.chart.PieChart;
import com.raven.javaswingdev.chart.PieChartRepo;
import com.raven.bar.ModelBarChart;

public class Form_Home extends javax.swing.JPanel {
    private DefaultTableModel dtm = new DefaultTableModel();
    private List<Top10ViewModel> listTop10 = new ArrayList<>();
    private CTXeSevices cTXeSevices = new CTXeServiceImpl();
    private AnalystRepo alr = new AnalystRepo();
    private PieChartRepo repo = new PieChartRepo();
    private ModelPieChart md = new ModelPieChart();
    int aa = 10;

    public Form_Home() {
        initComponents();
        setOpaque(false);
        initCardData();
        init();
        listTop10 = cTXeSevices.getTop10ThueXe();
        showDataTop10(listTop10);
        loadChart();
        loadBar();

    }
    public void loadBar(){
        barChart1.addLegend("Top 5 Xe được thuê nhiều nhất", new Color(245, 189, 135));
        barChart1.addData(new ModelBarChart(alr.XeTop1(), new double[]{alr.LanthueXeTop1()}));
        barChart1.addData(new ModelBarChart(alr.XeTop2(), new double[]{alr.LanthueXeTop2()}));
        barChart1.addData(new ModelBarChart(alr.XeTop3(), new double[]{alr.LanthueXeTop3()}));
        barChart1.addData(new ModelBarChart(alr.XeTop4(), new double[]{alr.LanthueXeTop4()}));
        barChart1.addData(new ModelBarChart(alr.XeTop5(), new double[]{alr.LanthueXeTop5()}));
        barChart1.start();
    }
    public void loadChart(){
        pieChart1.setBackground(Color.white);
        pieChart1.setChartType(PieChart.PeiChartType.DONUT_CHART);
        pieChart1.addData(new ModelPieChart("Xe có thể cho thuê", repo.XenTrong(), new Color(23, 126, 238)));
        pieChart1.addData(new ModelPieChart("Xe đang cho thuê", repo.XeDangChoThue(), new Color(221, 65, 65)));
        pieChart1.addData(new ModelPieChart("Xe đang hỏng hóc", repo.XeDangSua(), new Color(47, 157, 64)));
        
    }
    private void showDataTop10(List<Top10ViewModel> list){
//        dtm = (DefaultTableModel) tblTop10.getModel();
//        dtm.setRowCount(0);
//        for(Top10ViewModel top : list){
//            dtm.addRow(top.toRowDataTop10());
//        }
    }

    private void initCardData() {
        ModelCard c1 = new ModelCard();
        c1.setTitle("Hợp Đồng Đã Ký");
        c1.setValues(alr.TongHopDong());
        card1.setData(c1);
        ModelCard c2 = new ModelCard();
        c2.setTitle("Doanh Thu(Triệu VNĐ)");
        c2.setValues(alr.HoaDonTong());
        card3.setData(c2);
        ModelCard c3 = new ModelCard();
        c3.setTitle("Xe");
        c3.setValues(alr.TongXe());
        card5.setData(c3);

    }

    private void init() {
        chart.addLegend("Số Lượng Hợp Đồng", new Color(12, 84, 175), new Color(0, 108, 247));
        chart.addLegend("Số Tiền(Triệu VNĐ)", new Color(186, 37, 37), new Color(241, 100, 120));
        chart.addData(new ModelChart("Tháng 10", new double[]{alr.HopDongThang10(), alr.HoaDonThang10()})); 
        chart.addData(new ModelChart("Tháng 11", new double[]{alr.HopDongThang11(), alr.HoaDonThang11()}));
        chart.addData(new ModelChart("Tháng 12", new double[]{alr.HopDongThang12(), alr.HoaDonThang12()}));
        chart.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JLayeredPane();
        card1 = new com.ViewGiaoDienChinh.component.Card();
        card3 = new com.ViewGiaoDienChinh.component.Card();
        card5 = new com.ViewGiaoDienChinh.component.Card();
        panelBorder1 = new com.ViewGiaoDienChinh.swing.PanelBorder();
        chart = new com.raven.chart.CurveChart();
        btnCaNam = new javax.swing.JButton();
        cbbQuy = new javax.swing.JComboBox<>();
        pieChart1 = new com.raven.javaswingdev.chart.PieChart();
        barChart1 = new com.raven.bar.BarChart();

        panel.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        card1.setBackground(new java.awt.Color(117, 29, 169));
        panel.add(card1);

        card3.setBackground(new java.awt.Color(51, 87, 123));
        panel.add(card3);

        card5.setBackground(new java.awt.Color(16, 93, 31));
        panel.add(card5);

        panelBorder1.setBackground(new java.awt.Color(32, 27, 27));

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCaNam.setText("Cả Năm");
        btnCaNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaNamActionPerformed(evt);
            }
        });

        cbbQuy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quý 1", "Quý 2", "Quý 3", "Quý 4" }));
        cbbQuy.setSelectedIndex(3);
        cbbQuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbQuyActionPerformed(evt);
            }
        });

        pieChart1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pieChart1MouseClicked(evt);
            }
        });

        barChart1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barChart1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(132, 132, 132)
                                .addComponent(btnCaNam)
                                .addGap(75, 75, 75)
                                .addComponent(cbbQuy, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(barChart1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addComponent(pieChart1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(barChart1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(pieChart1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCaNam)
                    .addComponent(cbbQuy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbbQuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbQuyActionPerformed
        // TODO add your handling code here:
        chart.clear();
        if(cbbQuy.getSelectedIndex()== 0){
        chart.addData(new ModelChart("Tháng 1", new double[]{alr.HopDongThang1(), alr.HoaDonThang1()})); 
        chart.addData(new ModelChart("Tháng 2", new double[]{alr.HopDongThang2(), alr.HoaDonThang2()}));
        chart.addData(new ModelChart("Tháng 3", new double[]{alr.HopDongThang3(), alr.HoaDonThang3()}));
        chart.start();
        }if(cbbQuy.getSelectedIndex()== 1){
        chart.addData(new ModelChart("Tháng 4", new double[]{alr.HopDongThang4(), alr.HoaDonThang4()})); 
        chart.addData(new ModelChart("Tháng 5", new double[]{alr.HopDongThang5(), alr.HoaDonThang5()}));
        chart.addData(new ModelChart("Tháng 6", new double[]{alr.HopDongThang6(), alr.HoaDonThang6()}));
        chart.start();
        }if(cbbQuy.getSelectedIndex()== 2){
        chart.addData(new ModelChart("Tháng 7", new double[]{alr.HopDongThang7(), alr.HoaDonThang7()})); 
        chart.addData(new ModelChart("Tháng 8", new double[]{alr.HopDongThang8(), alr.HoaDonThang8()}));
        chart.addData(new ModelChart("Tháng 9", new double[]{alr.HopDongThang9(), alr.HoaDonThang9()}));
        chart.start();
        }if(cbbQuy.getSelectedIndex()== 3){
        chart.addData(new ModelChart("Tháng 10", new double[]{alr.HopDongThang10(), alr.HoaDonThang10()})); 
        chart.addData(new ModelChart("Tháng 11", new double[]{alr.HopDongThang11(), alr.HoaDonThang11()}));
        chart.addData(new ModelChart("Tháng 12", new double[]{alr.HopDongThang12(), alr.HoaDonThang12()}));
        chart.start();
        }
    }//GEN-LAST:event_cbbQuyActionPerformed

    private void btnCaNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaNamActionPerformed
        // TODO add your handling code here:
        chart.clear();
        chart.addData(new ModelChart("Tháng 1", new double[]{alr.HopDongThang1(), alr.HoaDonThang1()})); 
        chart.addData(new ModelChart("Tháng 2", new double[]{alr.HopDongThang2(), alr.HoaDonThang2()}));
        chart.addData(new ModelChart("Tháng 3", new double[]{alr.HopDongThang3(), alr.HoaDonThang3()}));
        chart.addData(new ModelChart("Tháng 4", new double[]{alr.HopDongThang4(), alr.HoaDonThang4()})); 
        chart.addData(new ModelChart("Tháng 5", new double[]{alr.HopDongThang5(), alr.HoaDonThang5()}));
        chart.addData(new ModelChart("Tháng 6", new double[]{alr.HopDongThang6(), alr.HoaDonThang6()}));
        chart.addData(new ModelChart("Tháng 7", new double[]{alr.HopDongThang7(), alr.HoaDonThang7()})); 
        chart.addData(new ModelChart("Tháng 8", new double[]{alr.HopDongThang8(), alr.HoaDonThang8()}));
        chart.addData(new ModelChart("Tháng 9", new double[]{alr.HopDongThang9(), alr.HoaDonThang9()}));
        chart.addData(new ModelChart("Tháng 10", new double[]{alr.HopDongThang10(), alr.HoaDonThang10()})); 
        chart.addData(new ModelChart("Tháng 11", new double[]{alr.HopDongThang11(), alr.HoaDonThang11()}));
        chart.addData(new ModelChart("Tháng 12", new double[]{alr.HopDongThang12(), alr.HoaDonThang12()}));
        chart.start();
    }//GEN-LAST:event_btnCaNamActionPerformed

    private void barChart1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barChart1MouseClicked
        // TODO add your handling code here:
        barChart1.clear();
        barChart1.addData(new ModelBarChart(alr.XeTop1(), new double[]{alr.LanthueXeTop1()}));
        barChart1.addData(new ModelBarChart(alr.XeTop2(), new double[]{alr.LanthueXeTop2()}));
        barChart1.addData(new ModelBarChart(alr.XeTop3(), new double[]{alr.LanthueXeTop3()}));
        barChart1.addData(new ModelBarChart(alr.XeTop4(), new double[]{alr.LanthueXeTop4()}));
        barChart1.addData(new ModelBarChart(alr.XeTop5(), new double[]{alr.LanthueXeTop5()}));
        barChart1.start();
    }//GEN-LAST:event_barChart1MouseClicked

    private void pieChart1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pieChart1MouseClicked
        // TODO add your handling code here:
        pieChart1.clearData();
        loadChart();
    }//GEN-LAST:event_pieChart1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.bar.BarChart barChart1;
    private javax.swing.JButton btnCaNam;
    private com.ViewGiaoDienChinh.component.Card card1;
    private com.ViewGiaoDienChinh.component.Card card3;
    private com.ViewGiaoDienChinh.component.Card card5;
    private javax.swing.JComboBox<String> cbbQuy;
    private com.raven.chart.CurveChart chart;
    private javax.swing.JLayeredPane panel;
    private com.ViewGiaoDienChinh.swing.PanelBorder panelBorder1;
    private com.raven.javaswingdev.chart.PieChart pieChart1;
    // End of variables declaration//GEN-END:variables
}
