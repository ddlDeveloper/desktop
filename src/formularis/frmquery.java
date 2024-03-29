package formularis;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.logClient;
import logica.logReservation;
import logica.logRooms;
import logica.logUser;

/**
 *
 * @author Lluís Barbó
 */
public class frmquery extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmquery
     */
    static DataInputStream in;
    static DataOutputStream out;
    int rol;

    DefaultTableModel model = new DefaultTableModel();

    public frmquery(DataInputStream in, DataOutputStream out, int rol) {
        initComponents();
        this.in = in;
        this.out = out;
        this.rol = rol;

        switch (rol) {
            case 1:
                //Administrator
                JOptionPane.showMessageDialog(this, "You are logged in with the Administrator role");
                btnClient.setVisible(true);
                btnReserve.setVisible(true);
                btnRoom.setVisible(true);
                btnUser.setVisible(true);
                break;
            case 2:
                //Reception
                JOptionPane.showMessageDialog(this, "You are logged in with the Reception role");
                btnClient.setVisible(true);
                btnReserve.setVisible(true);
                btnRoom.setVisible(true);
                btnUser.setVisible(false);
                break;
            default:
                break;

        }

    }

    void ocultar_columnas() {
        tablelist.getColumnModel().getColumn(0).setMaxWidth(0);
        tablelist.getColumnModel().getColumn(0).setMinWidth(0);
        tablelist.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

    void mostrarClient() {
        try {

            logClient func = new logClient(in, out);
            model = func.mostrar();

            tablelist.setModel(model);
            //ocultar_columnas();
            lbltotalregistros.setText("Total Registres " + Integer.toString(func.totalregistres));

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }

    void mostrarReserve() {
        try {

            logReservation func = new logReservation(in, out);
            model = func.mostrar();

            tablelist.setModel(model);
            //ocultar_columnas();
            lbltotalregistros.setText("Total Registres " + Integer.toString(func.totalregistres));

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }

    void mostrarRooms() {
        try {

            logRooms func = new logRooms(in, out);
            model = func.mostrar();

            tablelist.setModel(model);
            //ocultar_columnas();
            lbltotalregistros.setText("Total Registres " + Integer.toString(func.totalregistres));

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }

    void mostrarUsers() {
        try {

            logUser func = new logUser(in, out);
            model = func.mostrar();

            tablelist.setModel(model);
            //ocultar_columnas();
            lbltotalregistros.setText("Total Registres " + Integer.toString(func.totalregistres));

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
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

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablelist = new javax.swing.JTable();
        btnReserve = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        lbltotalregistros = new javax.swing.JLabel();
        btnRoom = new javax.swing.JButton();
        btnUser = new javax.swing.JButton();
        btnClient = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setResizable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Query");

        jPanel2.setBackground(new java.awt.Color(144, 164, 174));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Inquiries"));

        tablelist.setModel(new javax.swing.table.DefaultTableModel(
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
        tablelist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablelistMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablelist);

        btnReserve.setBackground(new java.awt.Color(51, 51, 51));
        btnReserve.setForeground(new java.awt.Color(255, 255, 255));
        btnReserve.setText("Reserve");
        btnReserve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReserveActionPerformed(evt);
            }
        });

        btnsalir.setBackground(new java.awt.Color(51, 51, 51));
        btnsalir.setForeground(new java.awt.Color(255, 255, 255));
        btnsalir.setText("Exit");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        lbltotalregistros.setText("Records");

        btnRoom.setBackground(new java.awt.Color(51, 51, 51));
        btnRoom.setForeground(new java.awt.Color(255, 255, 255));
        btnRoom.setText("Room");
        btnRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRoomActionPerformed(evt);
            }
        });

        btnUser.setBackground(new java.awt.Color(51, 51, 51));
        btnUser.setForeground(new java.awt.Color(255, 255, 255));
        btnUser.setText("User");
        btnUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserActionPerformed(evt);
            }
        });

        btnClient.setBackground(new java.awt.Color(51, 51, 51));
        btnClient.setForeground(new java.awt.Color(255, 255, 255));
        btnClient.setText("Client");
        btnClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnClient, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnReserve, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnUser, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 521, Short.MAX_VALUE)
                .addComponent(btnsalir)
                .addGap(28, 28, 28))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane3)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReserve)
                    .addComponent(btnsalir)
                    .addComponent(btnRoom)
                    .addComponent(btnUser)
                    .addComponent(btnClient))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbltotalregistros))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void tablelistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablelistMouseClicked
        // TODO add your handling code here:
        int fila = tablelist.rowAtPoint(evt.getPoint());

        /*
        txtidroom.setText(tablelist.getValueAt(fila, 0).toString());
        txtname.setText(tablelist.getValueAt(fila, 1).toString());
        txtnumber.setText(tablelist.getValueAt(fila, 2).toString());
        jComboBoxState.setSelectedItem(tablelist.getValueAt(fila, 3).toString());
        jCheckBoxWifi.setText(tablelist.getValueAt(fila, 4).toString());
        jCheckBoxAir.setText(tablelist.getValueAt(fila, 5).toString());
        jCheckBoxJacuzzi.setText(tablelist.getValueAt(fila, 6).toString());
        txtdayprice.setText(tablelist.getValueAt(fila, 7).toString());  */

    }//GEN-LAST:event_tablelistMouseClicked

    private void btnReserveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReserveActionPerformed
        // TODO add your handling code here:
        mostrarReserve();
    }//GEN-LAST:event_btnReserveActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void btnRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRoomActionPerformed
        // TODO add your handling code here:
        mostrarRooms();
    }//GEN-LAST:event_btnRoomActionPerformed

    private void btnUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserActionPerformed
        // TODO add your handling code here:
        mostrarUsers();
    }//GEN-LAST:event_btnUserActionPerformed

    private void btnClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientActionPerformed
        // TODO add your handling code here:
        mostrarClient();
    }//GEN-LAST:event_btnClientActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClient;
    private javax.swing.JButton btnReserve;
    private javax.swing.JButton btnRoom;
    private javax.swing.JButton btnUser;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbltotalregistros;
    private javax.swing.JTable tablelist;
    // End of variables declaration//GEN-END:variables
}
