package com.raven.form;

//import com.raven.model.Model_Card;
import com.componentfolder.Service.CTXeSevices;
import com.componentfolder.Service.Impl.CTXeServiceImpl;
import com.componentfolder.ViewModel.Top10ViewModel;
import com.raven.model.ModelCard;
import com.raven.chart.ModelChart;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class Form_Home extends javax.swing.JPanel {
    private DefaultTableModel dtm = new DefaultTableModel();
    private List<Top10ViewModel> listTop10 = new ArrayList<>();
    private CTXeSevices cTXeSevices = new CTXeServiceImpl();

    public Form_Home() {
        initComponents();
        setOpaque(false);
        initCardData();
        init();
        listTop10 = cTXeSevices.getTop10ThueXe();
        showDataTop10(listTop10);

    }
    private void showDataTop10(List<Top10ViewModel> list){
        dtm = (DefaultTableModel) tblTop10.getModel();
        dtm.setRowCount(0);
        for(Top10ViewModel top : list){
            dtm.addRow(top.toRowDataTop10());
        }
    }

    private void initCardData() {
        ModelCard c1 = new ModelCard();
        c1.setTitle("Hợp đồng");
        c1.setValues(100);
        card1.setData(c1);
        
        ModelCard c2 = new ModelCard();
        c2.setTitle("Khách hàng");
        c2.setValues(110);
        card2.setData(c2);
        
        ModelCard c3 = new ModelCard();
        c3.setTitle("Xe");
        c3.setValues(100);
        card3.setData(c3);
        
        ModelCard c4 = new ModelCard();
        c4.setTitle("Xe đã thuê");
        c4.setValues(100);
        card4.setData(c4);
        
        ModelCard c5 = new ModelCard();
        c5.setTitle("Doanh thu");
        c5.setValues(100);
        card5.setData(c5);

    }

    private void init() {
        chart.addLegend("Số Lượng Hợp Đồng", new Color(12, 84, 175), new Color(0, 108, 247));
        chart.addLegend("Số Lượng Xe Thuê", new Color(54, 4, 143), new Color(104, 49, 200));
        chart.addLegend("Số Lượng Khách Hàng", new Color(5, 125, 0), new Color(95, 209, 69));
        chart.addLegend("Số Tiền", new Color(186, 37, 37), new Color(241, 100, 120));
        chart.addData(new ModelChart("January", new double[]{500, 200, 80, 89}));
        chart.addData(new ModelChart("February", new double[]{1000, 750, 90, 150}));
        chart.addData(new ModelChart("March", new double[]{200, 350, 460, 900}));
        chart.addData(new ModelChart("April", new double[]{480, 150, 750, 700}));
        chart.addData(new ModelChart("May", new double[]{350, 540, 300, 150}));
        chart.addData(new ModelChart("June", new double[]{190, 280, 81, 200}));
        chart.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JLayeredPane();
        card1 = new com.ViewGiaoDienChinh.component.Card();
        card2 = new com.ViewGiaoDienChinh.component.Card();
        card3 = new com.ViewGiaoDienChinh.component.Card();
        card4 = new com.ViewGiaoDienChinh.component.Card();
        card5 = new com.ViewGiaoDienChinh.component.Card();
        panelBorder1 = new com.ViewGiaoDienChinh.swing.PanelBorder();
        chart = new com.raven.chart.CurveChart();
        panelBorder2 = new com.ViewGiaoDienChinh.swing.PanelBorder();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTop10 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        panel.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        card1.setBackground(new java.awt.Color(117, 29, 169));
        panel.add(card1);

        card2.setBackground(new java.awt.Color(11, 40, 114));
        panel.add(card2);

        card3.setBackground(new java.awt.Color(51, 87, 123));
        panel.add(card3);

        card4.setBackground(new java.awt.Color(121, 12, 12));
        panel.add(card4);

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

        panelBorder2.setBackground(new java.awt.Color(23, 21, 21));
        panelBorder2.setForeground(new java.awt.Color(51, 51, 51));

        tblTop10.setAutoCreateRowSorter(true);
        tblTop10.setBackground(new java.awt.Color(51, 51, 51));
        tblTop10.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        tblTop10.setForeground(new java.awt.Color(204, 204, 204));
        tblTop10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Xe", "Tên Xe", "Số Lượt Thuê", "Mô Tả"
            }
        ));
        tblTop10.setSelectionForeground(new java.awt.Color(102, 102, 102));
        jScrollPane1.setViewportView(tblTop10);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Top 10 Xe Thuê Nhiều Nhất");

        javax.swing.GroupLayout panelBorder2Layout = new javax.swing.GroupLayout(panelBorder2);
        panelBorder2.setLayout(panelBorder2Layout);
        panelBorder2Layout.setHorizontalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addGap(316, 316, 316)
                .addComponent(jLabel1)
                .addContainerGap(341, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        panelBorder2Layout.setVerticalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.ViewGiaoDienChinh.component.Card card1;
    private com.ViewGiaoDienChinh.component.Card card2;
    private com.ViewGiaoDienChinh.component.Card card3;
    private com.ViewGiaoDienChinh.component.Card card4;
    private com.ViewGiaoDienChinh.component.Card card5;
    private com.raven.chart.CurveChart chart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLayeredPane panel;
    private com.ViewGiaoDienChinh.swing.PanelBorder panelBorder1;
    private com.ViewGiaoDienChinh.swing.PanelBorder panelBorder2;
    private javax.swing.JTable tblTop10;
    // End of variables declaration//GEN-END:variables
}
