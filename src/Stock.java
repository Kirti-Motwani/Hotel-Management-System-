import java.sql.Connection;
import java.awt.Color;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import net.proteanit.sql.DbUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.general.Dataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;



public class Stock extends javax.swing.JFrame {
/********************************************************************************************************************************
    creates a new form stock
 **********************************************************************************************************************************/
    public Stock() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        conn = DBConnection.connectDB();
        
        refreshAddCategory();
        drawBarChart();
        
        
        sql = "SELECT product_id, product_name, quantity FROM product";
        updateTableData(sql);
    
 
    }
/********************************************************************************************************************************
     closes the window of application.
 **********************************************************************************************************************************/
    private void close(){
        WindowEvent we = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(we);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        sepQuantity = new javax.swing.JSeparator();
        lblProductName = new javax.swing.JLabel();
        lblCategoryName = new javax.swing.JLabel();
        jcbCategory = new javax.swing.JComboBox<>();
        sepProductName = new javax.swing.JSeparator();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbStocks = new javax.swing.JTable();
        txtProductName = new javax.swing.JTextField();
        btnAddCategory = new javax.swing.JButton();
        txtQuantity = new javax.swing.JTextField();
        btnClear = new javax.swing.JButton();
        lblQuantity = new javax.swing.JLabel();
        pnlChart = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(36, 59, 85));
        jPanel1.setPreferredSize(new java.awt.Dimension(1820, 1000));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(29, 35, 59));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/left-arrow.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(1322, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1401, -1));

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAdd.setBackground(new java.awt.Color(255, 255, 255));
        btnAdd.setFont(new java.awt.Font("Averia Serif Libre", 0, 20)); // NOI18N
        btnAdd.setText(" Add");
        btnAdd.setBorder(null);
        btnAdd.setNextFocusableComponent(btnUpdate);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel3.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 241, 90, 40));

        sepQuantity.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.add(sepQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 207, 320, 28));

        lblProductName.setFont(new java.awt.Font("Averia Serif Libre", 0, 18)); // NOI18N
        lblProductName.setForeground(new java.awt.Color(255, 255, 255));
        lblProductName.setText("Product Name");
        jPanel3.add(lblProductName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 81, 140, 50));

        lblCategoryName.setFont(new java.awt.Font("Averia Serif Libre", 0, 18)); // NOI18N
        lblCategoryName.setForeground(new java.awt.Color(255, 255, 255));
        lblCategoryName.setText("Category Name");
        jPanel3.add(lblCategoryName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 140, 50));

        jcbCategory.setFont(new java.awt.Font("Share Tech Mono", 0, 24)); // NOI18N
        jcbCategory.setToolTipText("");
        jcbCategory.setBorder(null);
        jcbCategory.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jcbCategory.setNextFocusableComponent(txtProductName);
        jPanel3.add(jcbCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 16, 320, 35));

        sepProductName.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.add(sepProductName, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 124, 320, 20));

        btnUpdate.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdate.setFont(new java.awt.Font("Averia Serif Libre", 0, 20)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setBorder(null);
        btnUpdate.setNextFocusableComponent(btnDelete);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel3.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 90, 40));

        btnDelete.setBackground(new java.awt.Color(255, 255, 255));
        btnDelete.setFont(new java.awt.Font("Averia Serif Libre", 0, 20)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setBorder(null);
        btnDelete.setNextFocusableComponent(btnClear);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel3.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, 89, 40));

        jtbStocks.setAutoCreateRowSorter(true);
        jtbStocks.setBackground(new java.awt.Color(36, 59, 85));
        jtbStocks.setFont(new java.awt.Font("Share Tech Mono", 0, 24)); // NOI18N
        jtbStocks.setForeground(new java.awt.Color(255, 255, 255));
        jtbStocks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtbStocks.setGridColor(new java.awt.Color(204, 204, 204));
        jtbStocks.setRowHeight(30);
        jtbStocks.setRowMargin(2);
        jtbStocks.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jtbStocks.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jtbStocks.setSurrendersFocusOnKeystroke(true);
        jtbStocks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbStocksMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbStocks);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 333, 522, 151));

        txtProductName.setBackground(new java.awt.Color(29, 35, 59));
        txtProductName.setFont(new java.awt.Font("Averia Serif Libre", 0, 18)); // NOI18N
        txtProductName.setForeground(new java.awt.Color(255, 255, 255));
        txtProductName.setBorder(null);
        txtProductName.setCaretColor(new java.awt.Color(255, 255, 255));
        txtProductName.setDragEnabled(true);
        txtProductName.setOpaque(false);
        txtProductName.setSelectionColor(new java.awt.Color(255, 255, 255));
        txtProductName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtProductNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtProductNameFocusLost(evt);
            }
        });
        txtProductName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductNameActionPerformed(evt);
            }
        });
        jPanel3.add(txtProductName, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 91, 320, 30));

        btnAddCategory.setBackground(new java.awt.Color(255, 255, 255));
        btnAddCategory.setFont(new java.awt.Font("Averia Serif Libre", 0, 20)); // NOI18N
        btnAddCategory.setText("Add Category");
        btnAddCategory.setBorder(null);
        btnAddCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCategoryActionPerformed(evt);
            }
        });
        jPanel3.add(btnAddCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 130, 28));

        txtQuantity.setFont(new java.awt.Font("Averia Serif Libre", 0, 14)); // NOI18N
        txtQuantity.setForeground(new java.awt.Color(255, 255, 255));
        txtQuantity.setBorder(null);
        txtQuantity.setOpaque(false);
        txtQuantity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtQuantityFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtQuantityFocusLost(evt);
            }
        });
        jPanel3.add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 167, 320, 30));

        btnClear.setBackground(new java.awt.Color(255, 255, 255));
        btnClear.setFont(new java.awt.Font("Averia Serif Libre", 0, 20)); // NOI18N
        btnClear.setText("Clear");
        btnClear.setBorder(null);
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel3.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 240, 90, 40));

        lblQuantity.setFont(new java.awt.Font("Averia Serif Libre", 0, 18)); // NOI18N
        lblQuantity.setForeground(new java.awt.Color(255, 255, 255));
        lblQuantity.setText("Quantity");
        jPanel3.add(lblQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 161, 130, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 146, 650, 583));
        jPanel1.add(pnlChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 169, 654, 400));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1401, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtProductNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProductNameFocusGained
         if(evt.getSource() == txtProductName){
           sepProductName.setForeground(Color.WHITE);
        }
    }//GEN-LAST:event_txtProductNameFocusGained

    private void txtProductNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProductNameFocusLost
         if(evt.getSource() == txtProductName){
           sepProductName.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txtProductNameFocusLost

    private void txtProductNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductNameActionPerformed
        
    }//GEN-LAST:event_txtProductNameActionPerformed

    private void jtbStocksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbStocksMouseClicked
        selectedRow = jtbStocks.getSelectedRow();
        selectedProductId = jtbStocks.getModel().getValueAt(selectedRow, 0).toString();
        try { 
            sql = "SELECT * FROM product WHERE product_id = " + selectedProductId;
            preparedStatement = conn.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            if(rs.next()){

                txtProductName.setText(rs.getString("product_name"));
                txtQuantity.setText(rs.getString("quantity"));
                catID = rs.getInt(3);
            }
            
            sql = "SELECT category_name FROM category WHERE category_id = '" + catID + "'";
            statement = conn.createStatement();
            rs = statement.executeQuery(sql);

           while(rs.next()){
                jcbCategory.setSelectedItem(rs.getString("category_name"));
            }

        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Some Error : " + e);
        }
    }//GEN-LAST:event_jtbStocksMouseClicked
 private void updateTableData(String sql){
        try {
            
            preparedStatement = conn.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            jtbStocks.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " ISSUE : " + e);
        }finally{
            try {
                rs.close();
                preparedStatement.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Problem in closing rs or preparedStatement:");
            }
        }
        
    
    }
 /********************************************************************************************************************************
     this method is used to clear all fields.
 **********************************************************************************************************************************/
   
    private void clearFields(){
        jcbCategory.setSelectedIndex(-1);
        txtProductName.setText("");
        txtQuantity.setText("");

    }
/********************************************************************************************************************************
     this method is used to refresh the category added.
 **********************************************************************************************************************************/
    private void refreshAddCategory(){
        try {
            jcbCategory.removeAllItems();
            String sql = "SELECT category_name from category";
            statement = conn.createStatement();
            rs = statement.executeQuery(sql);
            
            while (rs.next()) {
                jcbCategory.addItem(rs.getString(1));
            }
            jcbCategory.setSelectedIndex(-1);
        } catch (Exception e) {
        }finally{
            try {
                rs.close();
                statement.close();
            } catch (Exception e) {
            }
        }
    }
    private void btnAddCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCategoryActionPerformed
        inputCategory = JOptionPane.showInputDialog(this, "Enter a category");
        if (inputCategory.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter a category!");
        } else {
            
            sql = "INSERT INTO category (category_name) VALUES (?)";
            try {
                preparedStatement = conn.prepareStatement(sql);
                
                preparedStatement.setString(1, inputCategory);
                boolean stmt = preparedStatement.execute();
                System.out.println("Test");


                JOptionPane.showMessageDialog(null, "Record Saved Successfully");


                refreshAddCategory();

            } catch(NullPointerException e){} 
            
            catch (Exception e) {
                
                JOptionPane.showMessageDialog(null, "Some Error 1 : " + e);
            }
           
            finally{
                try {
                    preparedStatement.close();
                } catch (Exception e) {
                }
            }
        }
    }//GEN-LAST:event_btnAddCategoryActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {

            sql = "SELECT category_id FROM category WHERE category_name = '" +jcbCategory.getSelectedItem().toString() + "'";
            statement = conn.createStatement();
            rs = statement.executeQuery(sql);

            while(rs.next()){
                catID = rs.getInt(1);
            }

            sql = "UPDATE product SET product_name = ? , category_id = ?, quantity = ? WHERE product_id = ?";

            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, txtProductName.getText());
            preparedStatement.setString(3, txtQuantity.getText());
            preparedStatement.setInt(2, catID);
            preparedStatement.setInt(4, Integer.parseInt(selectedProductId));
            //txtQuantity.setText(rs.getString("quantity"));

            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "Record Updated Successfully");

            sql ="SELECT product_id, product_name, quantity FROM product";
            updateTableData(sql);
            refreshGraph();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Issue : " + e);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if(selectedProductId.equals("")){
            JOptionPane.showMessageDialog(null, "Please select some Recocord to delete!");
        }else{
            int btn = JOptionPane.showConfirmDialog(null, "Do you wanna realluy delete record?", "Delete", JOptionPane.YES_NO_OPTION);
            if(btn == JOptionPane.YES_OPTION){
                try {
                    String sql = "DELETE FROM product WHERE product_id = ?";
                    preparedStatement = conn.prepareStatement(sql);
                    preparedStatement.setString(1, selectedProductId);
                    preparedStatement.execute();
                    JOptionPane.showMessageDialog(null, "Record Deleted Successfully!");
                    clearFields();
                    sql = "SELECT * FROM product";
                    updateTableData(sql);
                    refreshGraph();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Delete Issue : " + e);
                }finally{
                    try {
                        preparedStatement.close();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Eroor while closing the statement : " + e);
                    }
                }
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearFields();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        try {
            String sql = "SELECT category_id FROM category WHERE category_name = '" + jcbCategory.getSelectedItem().toString() + "'";
            statement = conn.createStatement();
            rs = statement.executeQuery(sql);

            while(rs.next()){
                catID = rs.getInt(1);
                System.out.println(catID);
            }

            if(txtProductName.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Some Fields are missing");
            }
            else{

                sql = "INSERT INTO product( product_name, quantity, category_id) VALUES (?,?,?)";
                preparedStatement = conn.prepareStatement(sql);

                preparedStatement.setString(1, txtProductName.getText());
                preparedStatement.setString(2, txtQuantity.getText());
                preparedStatement.setInt(3, catID);
                

                boolean stmt = preparedStatement.execute();
                refreshGraph();
                JOptionPane.showMessageDialog(null, "Sucessfully inserted!!");
            }
            clearFields();

            sql = "SELECT product_id, product_name, quantity FROM product";
            updateTableData(sql);
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Some Error : " + e);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
            mouseX = evt.getX();
            mouseY = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
            int x = evt.getXOnScreen();
            int y = evt.getYOnScreen();
            this.setLocation(x-mouseX,y-mouseY);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void txtQuantityFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQuantityFocusGained
        if(evt.getSource() == txtQuantity){
            sepQuantity.setForeground(Color.WHITE);
         }
    }//GEN-LAST:event_txtQuantityFocusGained

    private void txtQuantityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQuantityFocusLost
         if(evt.getSource() == txtQuantity){
           sepQuantity.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txtQuantityFocusLost

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        
        this.dispose();
        try {
            new Dashboard().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel1MousePressed
   
 /********************************************************************************************************************************
     this method is used to create bar chart
 **********************************************************************************************************************************/  
    private void drawBarChart(){
        refreshGraph();
   }
 /********************************************************************************************************************************
     this method is used to refresh the entries made to the category
 **********************************************************************************************************************************/
   private void refreshGraph(){
       try {
           pnlChart.removeAll();
            sql = "SELECT product_name,quantity from product";
            preparedStatement  = conn.prepareStatement(sql);
            rs = preparedStatement.executeQuery(sql);

            JDBCCategoryDataset dataset = new JDBCCategoryDataset(DBConnection.connectDB(), sql);
            JFreeChart chart = ChartFactory.createBarChart("","productname","quantity", dataset,PlotOrientation.VERTICAL, false, true, false);
            ChartPanel cp = new ChartPanel(chart);

            chart.setBackgroundPaint(new Color(43,87,151));
            cp.setBounds(0, 0, 660 , 400);
            cp.setBorder(null);

            pnlChart.add(cp);

            CategoryPlot p = (CategoryPlot) chart.getPlot();
            BarRenderer renderer = (BarRenderer) p.getRenderer();
            renderer.setBarPainter(new StandardBarPainter());
            renderer.setSeriesPaint(1, new Color(12, 206, 107));
            renderer.setSeriesPaint(2, new Color(239, 45, 86));

            p.setRangeGridlinePaint(new Color(0, 246, 237));
            p.setBackgroundPaint(new Color(29, 35, 59));
            chart.setBackgroundPaint(new Color(29, 35, 59));
            p.setOutlinePaint(new Color(29, 35, 59));
            chart.removeLegend();
                
       } catch (Exception e) { }  
   }
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
                if ("Window".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Stock().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddCategory;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbCategory;
    private javax.swing.JTable jtbStocks;
    private javax.swing.JLabel lblCategoryName;
    private javax.swing.JLabel lblProductName;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JPanel pnlChart;
    private javax.swing.JSeparator sepProductName;
    private javax.swing.JSeparator sepQuantity;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
   private Connection conn = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;
    private Statement statement;
    private String inputCategory = null;
    private int catID ;
    private String sql = null;
    private int selectedRow;
    private String selectedProductId;
    private int mouseX,mouseY;
    
}