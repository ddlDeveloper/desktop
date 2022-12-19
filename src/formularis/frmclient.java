/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package formularis;

//import Datos.vcliente;
//import Logica.fcliente;
//import Logica.fproducto;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lluís Barbó
 */
public class frmclient extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmcliente
     */
    public frmclient() {
        initComponents();
        mostrar("");
        inhabilitar();
    }
       private String accio = "save";

    void ocultar_columnas() {
        tablalistado.getColumnModel().getColumn(0).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(0).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

    void inhabilitar() {
        txtidpersona.setVisible(false);
        
        txtname.setEnabled(false);
        txtmunicipality.setEnabled(false);
        txtlastname.setEnabled(false);
        cbotype_document.setEnabled(false);
        txtnum_document.setEnabled(false);
        txtaddress.setEnabled(false);
        txtNacionality.setEnabled(false);
        txtemail.setEnabled(false);
        txtprovince.setEnabled(false);
        txtpostalcode.setEnabled(false);
        txtphone.setEnabled(false);
        txtiban.setEnabled(false);

        btnguardar.setEnabled(false);
        btncancelar.setEnabled(false);
        btneliminar.setEnabled(false);
        txtidpersona.setText("");
        txtname.setText("");
        txtmunicipality.setText("");
        txtlastname.setText("");
        txtnum_document.setText("");
        txtaddress.setText("");
        txtNacionality.setText("");
        txtemail.setText("");
        txtprovince.setText("");
    }

    void habilitar() {
        txtidpersona.setVisible(false);
        
        txtname.setEnabled(true);
        txtmunicipality.setEnabled(true);
        txtlastname.setEnabled(true);
        cbotype_document.setEnabled(true);
        txtnum_document.setEnabled(true);
        txtaddress.setEnabled(true);
        txtNacionality.setEnabled(true);
        txtemail.setEnabled(true);
        txtprovince.setEnabled(true);
        txtpostalcode.setEnabled(true);
        txtphone.setEnabled(true);
        txtiban.setEnabled(true);

        btnguardar.setEnabled(true);
        btncancelar.setEnabled(true);
        btneliminar.setEnabled(true);
        txtidpersona.setText("");
        txtname.setText("");
        txtmunicipality.setText("");
        txtlastname.setText("");
        txtnum_document.setText("");
        txtaddress.setText("");
        txtNacionality.setText("");
        txtemail.setText("");
        txtprovince.setText("");
        

    }

    void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            /*
            fcliente func = new fcliente();
            modelo = func.mostrar(buscar);

            tablalistado.setModel(modelo);
            ocultar_columnas();
            lbltotalregistros.setText("Total Registros " + Integer.toString(func.totalregistros));
            */

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

        jPanel1 = new javax.swing.JPanel();
        txtidpersona = new javax.swing.JTextField();
        jLabelName = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jLabelDocument = new javax.swing.JLabel();
        txtnum_document = new javax.swing.JTextField();
        jLabelDocType = new javax.swing.JLabel();
        cbotype_document = new javax.swing.JComboBox();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        jLabelLastName = new javax.swing.JLabel();
        txtmunicipality = new javax.swing.JTextField();
        txtlastname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabelAddress = new javax.swing.JLabel();
        txtaddress = new javax.swing.JTextField();
        jLabelNacionality = new javax.swing.JLabel();
        txtNacionality = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        jLabelMunicipality = new javax.swing.JLabel();
        txtprovince = new javax.swing.JTextField();
        jLabelProvince = new javax.swing.JLabel();
        jLabelPostalCode = new javax.swing.JLabel();
        txtpostalcode = new javax.swing.JTextField();
        jLabelPhone = new javax.swing.JLabel();
        txtphone = new javax.swing.JTextField();
        jLabelIBAN = new javax.swing.JLabel();
        txtiban = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablalistado = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        lbltotalregistros = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);

        jPanel1.setBackground(new java.awt.Color(144, 164, 174));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Client registration"));

        jLabelName.setText("Name:");

        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });

        jLabelDocument.setText("DNI:");

        txtnum_document.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnum_documentActionPerformed(evt);
            }
        });

        jLabelDocType.setText("Doc Tipe:");

        cbotype_document.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DNI", "NIE", "Passport", "Others" }));
        cbotype_document.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbotype_documentActionPerformed(evt);
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

        txtmunicipality.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmunicipalityActionPerformed(evt);
            }
        });

        txtlastname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtlastnameActionPerformed(evt);
            }
        });

        jLabel4.setText("EMAIL:");

        jLabelAddress.setText("Address:");

        txtaddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtaddressActionPerformed(evt);
            }
        });

        jLabelNacionality.setText("Nacionality:");

        txtNacionality.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNacionalityActionPerformed(evt);
            }
        });

        txtemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtemailActionPerformed(evt);
            }
        });

        jLabelMunicipality.setText("Municipality:");

        txtprovince.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprovinceActionPerformed(evt);
            }
        });

        jLabelProvince.setText("Province:");

        jLabelPostalCode.setText("Postal code:");

        txtpostalcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpostalcodeActionPerformed(evt);
            }
        });

        jLabelPhone.setText("Phone:");

        txtphone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtphoneActionPerformed(evt);
            }
        });

        jLabelIBAN.setText("IBAN:");

        txtiban.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtibanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtidpersona, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelPhone)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelAddress)
                            .addComponent(jLabelProvince)
                            .addComponent(jLabelLastName)
                            .addComponent(jLabel4)
                            .addComponent(jLabelDocType)
                            .addComponent(jLabelDocument)
                            .addComponent(jLabelName)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelMunicipality, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabelNacionality))
                            .addComponent(jLabelIBAN))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtname)
                                .addContainerGap())
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtmunicipality, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabelPostalCode))
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(txtlastname, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtemail, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtnum_document, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtNacionality, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtprovince, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                                .addComponent(txtphone, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(cbotype_document, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtaddress, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtiban, javax.swing.GroupLayout.Alignment.LEADING)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtpostalcode, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnnuevo)
                                        .addGap(32, 32, 32)
                                        .addComponent(btnguardar)
                                        .addGap(30, 30, 30)
                                        .addComponent(btncancelar)))
                                .addGap(0, 13, Short.MAX_VALUE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(txtidpersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtlastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelLastName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDocType)
                    .addComponent(cbotype_document, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnum_document, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDocument))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAddress)
                    .addComponent(txtaddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabelPostalCode))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtpostalcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtmunicipality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelMunicipality)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelProvince)
                    .addComponent(txtprovince, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNacionality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNacionality))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPhone)
                    .addComponent(txtphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtiban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelIBAN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnnuevo)
                    .addComponent(btnguardar)
                    .addComponent(btncancelar))
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Clients");

        jPanel2.setBackground(new java.awt.Color(144, 164, 174));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Client list"));

        tablalistado.setModel(new javax.swing.table.DefaultTableModel(
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
        tablalistado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablalistadoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablalistado);

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
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
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
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(54, Short.MAX_VALUE))
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

    private void cbotype_documentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbotype_documentActionPerformed
        // TODO add your handling code here:
        cbotype_document.transferFocus();
    }//GEN-LAST:event_cbotype_documentActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:
        habilitar();
        btnguardar.setText("Save");
        accio = "save";
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        if (txtname.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "You must enter a Name for the client");
            txtname.requestFocus();
            return;
        }
        if (txtmunicipality.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "You must enter a municipality for the customer");
            txtmunicipality.requestFocus();
            return;
        }
        
        if (txtlastname.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "You must enter a last name for the customer");
            txtlastname.requestFocus();
            return;
        }
        

        if (txtnum_document.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "You must enter a Doc Number for the client");
            txtnum_document.requestFocus();
            return;
        }
        
        if (txtprovince.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "You must enter a province for the client");
            txtprovince.requestFocus();
            return;
        }
/*
        vcliente dts = new vcliente();
        fcliente func = new fcliente();

        dts.setNombre(txtnombre.getText());

        dts.setApaterno(txtapaterno.getText());
        dts.setAmaterno(txtamaterno.getText());
        
        int seleccionado = cbotipo_documento.getSelectedIndex();
        dts.setTipo_documento((String) cbotipo_documento.getItemAt(seleccionado));
        dts.setNum_documento(txtnum_documento.getText());
        dts.setDireccion(txtdireccion.getText());
        dts.setTelefono(txttelefono.getText());
        dts.setEmail(txtemail.getText());
        dts.setCodigo_cliente(txtcodigo_cliente.getText());
        
        if (accio.equals("guardar")) {
            if (func.insertar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "el cliente fue registrado satisfactoriamente");
                mostrar("");
                inhabilitar();

            }

        }
        else if (accio.equals("editar")){
            dts.setIdpersona(Integer.parseInt(txtidpersona.getText()));

            if (func.editar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "El Cliente fue Editado satisfactoriamente");
                mostrar("");
                inhabilitar();
            }
        } */
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void tablalistadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoMouseClicked
        // TODO add your handling code here:
        btnguardar.setText("Edit");
        habilitar();
        btneliminar.setEnabled(true);
        accio="edit";

        int fila = tablalistado.rowAtPoint(evt.getPoint());

        txtidpersona.setText(tablalistado.getValueAt(fila, 0).toString());
        txtname.setText(tablalistado.getValueAt(fila, 1).toString());

        txtmunicipality.setText(tablalistado.getValueAt(fila, 2).toString());
        txtlastname.setText(tablalistado.getValueAt(fila, 3).toString());
        cbotype_document.setSelectedItem(tablalistado.getValueAt(fila, 4).toString());
        txtnum_document.setText(tablalistado.getValueAt(fila, 5).toString());
        txtaddress.setText(tablalistado.getValueAt(fila, 6).toString());
        txtNacionality.setText(tablalistado.getValueAt(fila, 7).toString());
        txtemail.setText(tablalistado.getValueAt(fila, 8).toString());
        txtprovince.setText(tablalistado.getValueAt(fila, 9).toString());

    }//GEN-LAST:event_tablalistadoMouseClicked

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // TODO add your handling code here:
        mostrar(txtbuscar.getText());
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        // TODO add your handling code here:
        if (!txtidpersona.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Are you sure to Delete the Client? ","Confirm",2);

            if (confirmacion==0) { /*
                fcliente func = new fcliente();
                vcliente dts= new vcliente();

                dts.setIdpersona(Integer.parseInt(txtidpersona.getText()));
                func.eliminar(dts);
                mostrar("");
                inhabilitar();
*/
            }

        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void txtmunicipalityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmunicipalityActionPerformed
        // TODO add your handling code here:
        txtmunicipality.transferFocus();
    }//GEN-LAST:event_txtmunicipalityActionPerformed

    private void txtlastnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtlastnameActionPerformed
        // TODO add your handling code here:
        txtlastname.transferFocus();
    }//GEN-LAST:event_txtlastnameActionPerformed

    private void txtaddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtaddressActionPerformed
        // TODO add your handling code here:
        txtaddress.transferFocus();
    }//GEN-LAST:event_txtaddressActionPerformed

    private void txtNacionalityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNacionalityActionPerformed
        // TODO add your handling code here:
        txtNacionality.transferFocus();
    }//GEN-LAST:event_txtNacionalityActionPerformed

    private void txtemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtemailActionPerformed
        // TODO add your handling code here:
        txtemail.transferFocus();
    }//GEN-LAST:event_txtemailActionPerformed

    private void txtprovinceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprovinceActionPerformed
        // TODO add your handling code here:
        txtprovince.transferFocus();
    }//GEN-LAST:event_txtprovinceActionPerformed

    private void txtpostalcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpostalcodeActionPerformed
        // TODO add your handling code here:
        txtpostalcode.transferFocus();
    }//GEN-LAST:event_txtpostalcodeActionPerformed

    private void txtphoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtphoneActionPerformed
        // TODO add your handling code here:
        txtphone.transferFocus();
    }//GEN-LAST:event_txtphoneActionPerformed

    private void txtibanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtibanActionPerformed
        // TODO add your handling code here:
        txtiban.transferFocus();
    }//GEN-LAST:event_txtibanActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox cbotype_document;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAddress;
    private javax.swing.JLabel jLabelDocType;
    private javax.swing.JLabel jLabelDocument;
    private javax.swing.JLabel jLabelIBAN;
    private javax.swing.JLabel jLabelLastName;
    private javax.swing.JLabel jLabelMunicipality;
    private javax.swing.JLabel jLabelNacionality;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelPhone;
    private javax.swing.JLabel jLabelPostalCode;
    private javax.swing.JLabel jLabelProvince;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbltotalregistros;
    private javax.swing.JTable tablalistado;
    private javax.swing.JTextField txtNacionality;
    private javax.swing.JTextField txtaddress;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtiban;
    private javax.swing.JTextField txtidpersona;
    private javax.swing.JTextField txtlastname;
    private javax.swing.JTextField txtmunicipality;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtnum_document;
    private javax.swing.JTextField txtphone;
    private javax.swing.JTextField txtpostalcode;
    private javax.swing.JTextField txtprovince;
    // End of variables declaration//GEN-END:variables
}
