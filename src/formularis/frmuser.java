/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularis;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.Socket;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import utils.ManagedUsers;

/**
 *
 * @author Lluís Barbó
 */
public class frmuser extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmcliente
     */
    DataInputStream in;
    DataOutputStream out;
    Socket cli;
    int rol;
    int access = 0;

    frmuser(DataInputStream in, DataOutputStream out, int rol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getAccess() {
        return access;
    }

    public void setAccess(int access) {
        this.access = access;
    }

    public frmuser(DataInputStream in, DataOutputStream out) {
        initComponents();
        this.in = in;
        this.out = out;
        //mostrar("");
        inhabilitar();
    }
    private String accio = "save";

    void ocultar_columnas() {
        tablelist.getColumnModel().getColumn(0).setMaxWidth(0);
        tablelist.getColumnModel().getColumn(0).setMinWidth(0);
        tablelist.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

    void inhabilitar() {
        txtiduser.setVisible(false);

        txtname.setEnabled(false);
        txtlastname.setEnabled(false);
        cbotipo_document.setEnabled(false);
        txtnum_document.setEnabled(false);
        txtaddress.setEnabled(false);
        txtphone.setEnabled(false);
        txtemail.setEnabled(false);
        cboaccess.setEnabled(false);
        txtlogin.setEnabled(false);
        txtpassword.setEnabled(false);
        cbosex.setEnabled(false);

        btnguardar.setEnabled(false);
        btncancelar.setEnabled(false);
        btneliminar.setEnabled(false);
        txtiduser.setText("");
        txtname.setText("");
        txtlastname.setText("");
        txtnum_document.setText("");
        txtaddress.setText("");
        txtphone.setText("");
        txtemail.setText("");
        txtlogin.setText("");
        txtpassword.setText("");
    }

    void habilitar() {
        txtiduser.setVisible(true);

        txtname.setEnabled(true);
        txtlastname.setEnabled(true);
        cbotipo_document.setEnabled(true);
        txtnum_document.setEnabled(true);
        txtaddress.setEnabled(true);
        txtphone.setEnabled(true);
        txtemail.setEnabled(true);
        cboaccess.setEnabled(true);
        txtlogin.setEnabled(true);
        txtpassword.setEnabled(true);
        cbosex.setEnabled(true);

        btnguardar.setEnabled(true);
        btncancelar.setEnabled(true);
        btneliminar.setEnabled(true);
        txtiduser.setText("");
        txtname.setText("");
        txtlastname.setText("");
        txtnum_document.setText("");
        txtaddress.setText("");
        txtphone.setText("");
        txtemail.setText("");
        txtlogin.setText("");
        txtpassword.setText("");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtiduser = new javax.swing.JTextField();
        jLabelName = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jLabelNumDoc = new javax.swing.JLabel();
        txtnum_document = new javax.swing.JTextField();
        jLabelDocType = new javax.swing.JLabel();
        cbotipo_document = new javax.swing.JComboBox();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        jLabelLastName = new javax.swing.JLabel();
        txtlastname = new javax.swing.JTextField();
        jLabelAddress = new javax.swing.JLabel();
        txtaddress = new javax.swing.JTextField();
        jLabelPhone = new javax.swing.JLabel();
        txtphone = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        jLabelEmail = new javax.swing.JLabel();
        cboaccess = new javax.swing.JComboBox();
        jLabelAccess = new javax.swing.JLabel();
        jLabelLogin = new javax.swing.JLabel();
        txtlogin = new javax.swing.JTextField();
        txtpassword = new javax.swing.JTextField();
        jLabelPassword = new javax.swing.JLabel();
        cbosex = new javax.swing.JComboBox();
        jLabelSex = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablelist = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        lbltotalregistros = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(144, 164, 174));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("User registration"));

        txtiduser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtiduserActionPerformed(evt);
            }
        });

        jLabelName.setText("Name:");

        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });

        jLabelNumDoc.setText("Num doc:");

        txtnum_document.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnum_documentActionPerformed(evt);
            }
        });

        jLabelDocType.setText("Doc Type:");

        cbotipo_document.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DNI", "NIE", "Passport", "Others" }));
        cbotipo_document.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbotipo_documentActionPerformed(evt);
            }
        });

        btnnuevo.setBackground(new java.awt.Color(51, 51, 51));
        btnnuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnnuevo.setText("New");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btnguardar.setBackground(new java.awt.Color(51, 51, 51));
        btnguardar.setForeground(new java.awt.Color(255, 255, 255));
        btnguardar.setText("Save");
        btnguardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnguardarMouseClicked(evt);
            }
        });
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btncancelar.setBackground(new java.awt.Color(51, 51, 51));
        btncancelar.setForeground(new java.awt.Color(255, 255, 255));
        btncancelar.setText("Cancel");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        jLabelLastName.setText("Last Name:");

        txtlastname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtlastnameActionPerformed(evt);
            }
        });

        jLabelAddress.setText("Address:");

        txtaddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtaddressActionPerformed(evt);
            }
        });

        jLabelPhone.setText("Phone:");

        txtphone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtphoneActionPerformed(evt);
            }
        });

        txtemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtemailActionPerformed(evt);
            }
        });

        jLabelEmail.setText("EMAIL:");

        cboaccess.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrator", "Reception" }));
        cboaccess.setToolTipText("");

        jLabelAccess.setText("Access:");

        jLabelLogin.setText("Login:");
        jLabelLogin.setToolTipText("");

        txtlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtloginActionPerformed(evt);
            }
        });

        jLabelPassword.setText("Password:");

        cbosex.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MALE", "FEMALE" }));

        jLabelSex.setText("Sex:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtiduser, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnnuevo)
                                .addGap(42, 42, 42)
                                .addComponent(btnguardar)
                                .addGap(38, 38, 38)
                                .addComponent(btncancelar)
                                .addGap(37, 37, 37))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabelLastName)
                                                        .addComponent(jLabelAddress)
                                                        .addComponent(jLabelPhone)
                                                        .addComponent(jLabelEmail))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabelNumDoc)
                                                        .addGap(13, 13, 13)))
                                                .addComponent(jLabelName))
                                            .addGap(55, 55, 55))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabelLogin)
                                                .addComponent(jLabelAccess))
                                            .addGap(75, 75, 75)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelSex)
                                            .addComponent(jLabelDocType)
                                            .addComponent(jLabelPassword))
                                        .addGap(60, 60, 60)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtname)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbosex, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cboaccess, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtphone, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtaddress, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtnum_document, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbotipo_document, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtlastname, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addGap(45, 45, 45))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(txtiduser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelName)
                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtlastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelLastName))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDocType)
                    .addComponent(cbotipo_document, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNumDoc)
                    .addComponent(txtnum_document, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtaddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAddress))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPhone)
                    .addComponent(txtphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEmail))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboaccess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAccess))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelLogin)
                    .addComponent(txtlogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPassword))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelSex)
                    .addComponent(cbosex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnnuevo)
                    .addComponent(btnguardar)
                    .addComponent(btncancelar))
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("User");

        jPanel2.setBackground(new java.awt.Color(144, 164, 174));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("User list"));

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

        jLabel9.setText("Search");

        btnbuscar.setBackground(new java.awt.Color(51, 51, 51));
        btnbuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnbuscar.setText("Search");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        btneliminar.setBackground(new java.awt.Color(51, 51, 51));
        btneliminar.setForeground(new java.awt.Color(255, 255, 255));
        btneliminar.setText("Remove");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbltotalregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btneliminar)
                                .addGap(18, 18, 18)
                                .addComponent(btnsalir)))
                        .addGap(0, 161, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscar)
                    .addComponent(btneliminar)
                    .addComponent(btnsalir))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                .addGap(9, 9, 9)
                .addComponent(lbltotalregistros))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
        txtname.transferFocus();
    }//GEN-LAST:event_txtnameActionPerformed

    private void txtnum_documentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnum_documentActionPerformed
        // TODO add your handling code here:
        txtnum_document.transferFocus();
    }//GEN-LAST:event_txtnum_documentActionPerformed

    private void cbotipo_documentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbotipo_documentActionPerformed
        // TODO add your handling code here:
        cbotipo_document.transferFocus();
    }//GEN-LAST:event_cbotipo_documentActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:
        habilitar();
        btnguardar.setText("Save");
        accio = "save";
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        if (txtname.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "You must enter a Name for the User");
            txtname.requestFocus();
            return;
        }
        if (txtlastname.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "You must enter a last name for the User");
            txtlastname.requestFocus();
            return;
        }

        if (txtnum_document.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "You must enter a Doc Number for the User");
            txtnum_document.requestFocus();
            return;
        }

        if (txtlogin.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "You must enter a login for the User");
            txtlogin.requestFocus();
            return;
        }
        if (txtpassword.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "You must enter a password for the User");
            txtpassword.requestFocus();
            return;
        }

        // Creem les variables on desem les dades de l'usuari
        String name = txtname.getText().toString();
        String lastName = txtlastname.getText().toString();
        String docType = cbotipo_document.getSelectedItem().toString();
        String numDoc = txtnum_document.getText().toString();
        String address = txtaddress.getText().toString();
        String phone = txtphone.getText().toString();
        String email = txtemail.getText().toString();
        String acces = cboaccess.getSelectedItem().toString();
        String user = txtlogin.getText().toString();
        String password = txtpassword.getText().toString();
        String sex = cbosex.getSelectedItem().toString();
        JOptionPane.showMessageDialog(this, acces);

        if (cboaccess.equals("Administration")) {
            acces = "1";
        } else {
            acces = "2";
        }

        try {
            out.writeInt(2);
            out.writeInt(1);
            //out.writeInt(1);
            int comprovacio = in.readInt();
            if (comprovacio == 1) {
                out.writeBoolean(true);
                boolean senyal = in.readBoolean();
                if (senyal == true) {
                    out.writeUTF(user);
                    out.writeUTF(password);
                    out.writeUTF(name);
                    out.writeUTF(lastName);
                    out.writeUTF(email);
                    out.writeUTF(numDoc);
                    out.writeUTF(address);
                    out.writeUTF(phone);
                    out.writeUTF(acces);
                    out.writeUTF(sex);
                    String correcte = in.readUTF();
                    System.out.println(correcte);
                    JOptionPane.showMessageDialog(this, "The user has been entered");
                    inhabilitar();

                }
            }

        } catch (IOException ex) {
            //Logger.getLogger(frmuser.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(frmuser.class.getName()).log(Level.SEVERE, null, ex);

        }


    }//GEN-LAST:event_btnguardarActionPerformed

    public void llistar(String buscar) {

        Socket sc;

        try {

            sc = new Socket("127.0.0.1", 8000);
            DataInputStream in = new DataInputStream(sc.getInputStream());
            DataOutputStream out = new DataOutputStream(sc.getOutputStream());

            out.writeBoolean(true);

            // Realitzem la crida per llegir l'usuari
            out.writeUTF(",USER_QUERY,");

            int response_query = in.readInt();

            String[] nameColumns = {"ID", "Name", "LastName", "TypeDoc", "NumDoc", "Address", "Phone", "Email", "Acces", "User", "Password", "Sex"};
            String[] fields;
            Object[][] recordGrid = new Object[response_query][12];

            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(nameColumns);

            for (int i = 0; i < response_query; i++) {
                String record = in.readUTF();
                fields = record.split(",");

                for (int j = 0; j < 0; j++) {
                    recordGrid[i][j] = fields[j];
                }

                model.addRow(fields);

            }

            tablelist.setModel(model);

        } catch (Exception e) {

        }
    }

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void tablelistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablelistMouseClicked
        // TODO add your handling code here:
        btnguardar.setText("Edit");
        habilitar();
        btneliminar.setEnabled(true);
        accio = "edit";

        int fila = tablelist.rowAtPoint(evt.getPoint());

        txtiduser.setText(tablelist.getValueAt(fila, 0).toString());
        txtname.setText(tablelist.getValueAt(fila, 1).toString());
        txtlastname.setText(tablelist.getValueAt(fila, 2).toString());
        cbotipo_document.setSelectedItem(tablelist.getValueAt(fila, 3).toString());
        txtnum_document.setText(tablelist.getValueAt(fila, 4).toString());
        txtaddress.setText(tablelist.getValueAt(fila, 5).toString());
        txtphone.setText(tablelist.getValueAt(fila, 6).toString());
        txtemail.setText(tablelist.getValueAt(fila, 7).toString());
        cboaccess.setSelectedItem(tablelist.getValueAt(fila, 8).toString());
        txtlogin.setText(tablelist.getValueAt(fila, 9).toString());
        txtpassword.setText(tablelist.getValueAt(fila, 10).toString());
        cbosex.setSelectedItem(tablelist.getValueAt(fila, 11).toString());
    }//GEN-LAST:event_tablelistMouseClicked

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // TODO add your handling code here:
        llistar(txtbuscar.getText());
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        // TODO add your handling code here:
        if (!txtiduser.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Are you sure to delete the user?", "Confirm", 2);

            if (confirmacion == 0) {/*
                ftrabajador func = new ftrabajador();
                vtrabajador dts= new vtrabajador();

                dts.setIdpersona(Integer.parseInt(txtidpersona.getText()));
                func.eliminar(dts);
                mostrar("");
                inhabilitar();*/

            }

        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void txtlastnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtlastnameActionPerformed
        // TODO add your handling code here:
        txtlastname.transferFocus();
    }//GEN-LAST:event_txtlastnameActionPerformed

    private void txtaddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtaddressActionPerformed
        // TODO add your handling code here:
        txtaddress.transferFocus();
    }//GEN-LAST:event_txtaddressActionPerformed

    private void txtphoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtphoneActionPerformed
        // TODO add your handling code here:
        txtphone.transferFocus();
    }//GEN-LAST:event_txtphoneActionPerformed

    private void txtemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtemailActionPerformed
        // TODO add your handling code here:
        txtemail.transferFocus();
    }//GEN-LAST:event_txtemailActionPerformed

    private void txtloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtloginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtloginActionPerformed

    private void txtiduserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtiduserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtiduserActionPerformed

    private void btnguardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnguardarMouseClicked


    }//GEN-LAST:event_btnguardarMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox cboaccess;
    private javax.swing.JComboBox cbosex;
    private javax.swing.JComboBox cbotipo_document;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAccess;
    private javax.swing.JLabel jLabelAddress;
    private javax.swing.JLabel jLabelDocType;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelLastName;
    private javax.swing.JLabel jLabelLogin;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelNumDoc;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelPhone;
    private javax.swing.JLabel jLabelSex;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbltotalregistros;
    private javax.swing.JTable tablelist;
    private javax.swing.JTextField txtaddress;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtiduser;
    private javax.swing.JTextField txtlastname;
    private javax.swing.JTextField txtlogin;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtnum_document;
    private javax.swing.JTextField txtpassword;
    private javax.swing.JTextField txtphone;
    // End of variables declaration//GEN-END:variables
}
