/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularis;

import formularis.frmInici;
import java.awt.Color;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Lluís Barbó
 */
public class RegistreForm extends javax.swing.JFrame {

    /**
     * Creates new form RegistreForm
     */
    DataInputStream in;
    DataOutputStream out;
    Socket s;
    int rol;

    public RegistreForm(Socket s, DataInputStream in, DataOutputStream out) {
        initComponents();
        this.in = in;
        this.out = out;
        this.s = s;
        setIconImage(new ImageIcon(getClass().getResource("../images/logo.png")).getImage());
        this.setLocationRelativeTo(this);
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
        registreForm = new javax.swing.JLabel();
        tornarPanel = new javax.swing.JPanel();
        tornarLabel = new javax.swing.JLabel();
        desarPanel = new javax.swing.JPanel();
        desarLabel = new javax.swing.JLabel();
        usuariLabel = new javax.swing.JLabel();
        usuariTextField = new javax.swing.JTextField();
        passLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        usuariLabel8 = new javax.swing.JLabel();
        jComboBoxRol = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(144, 164, 174));

        registreForm.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        registreForm.setText("REGISTER");

        tornarPanel.setBackground(new java.awt.Color(0, 134, 190));
        tornarPanel.setFont(new java.awt.Font("Rockwell Condensed", 0, 14)); // NOI18N
        tornarPanel.setName(""); // NOI18N

        tornarLabel.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        tornarLabel.setForeground(new java.awt.Color(255, 255, 255));
        tornarLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tornarLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/previous.png"))); // NOI18N
        tornarLabel.setText("BACK");
        tornarLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tornarLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tornarLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tornarLabelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout tornarPanelLayout = new javax.swing.GroupLayout(tornarPanel);
        tornarPanel.setLayout(tornarPanelLayout);
        tornarPanelLayout.setHorizontalGroup(
            tornarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tornarPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(tornarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116))
        );
        tornarPanelLayout.setVerticalGroup(
            tornarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tornarPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(tornarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        desarPanel.setBackground(new java.awt.Color(0, 134, 190));
        desarPanel.setFont(new java.awt.Font("Rockwell Condensed", 0, 14)); // NOI18N
        desarPanel.setName(""); // NOI18N

        desarLabel.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        desarLabel.setForeground(new java.awt.Color(255, 255, 255));
        desarLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        desarLabel.setText("SAVE");
        desarLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                desarLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                desarLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                desarLabelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout desarPanelLayout = new javax.swing.GroupLayout(desarPanel);
        desarPanel.setLayout(desarPanelLayout);
        desarPanelLayout.setHorizontalGroup(
            desarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, desarPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(desarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116))
        );
        desarPanelLayout.setVerticalGroup(
            desarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, desarPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(desarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        usuariLabel.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        usuariLabel.setText("USER");

        usuariTextField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        usuariTextField.setForeground(new java.awt.Color(204, 204, 204));
        usuariTextField.setText("Enter new user");
        usuariTextField.setBorder(null);
        usuariTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                usuariTextFieldMousePressed(evt);
            }
        });
        usuariTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuariTextFieldActionPerformed(evt);
            }
        });

        passLabel.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        passLabel.setText("PASSWORD");

        passwordField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        passwordField.setForeground(new java.awt.Color(204, 204, 204));
        passwordField.setText("********");
        passwordField.setBorder(null);
        passwordField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                passwordFieldMousePressed(evt);
            }
        });

        usuariLabel8.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        usuariLabel8.setText("ROL");

        jComboBoxRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administration", "Reception" }));
        jComboBoxRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxRolActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(desarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 236, Short.MAX_VALUE)
                .addComponent(tornarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addComponent(registreForm))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passLabel)
                            .addComponent(usuariLabel8)
                            .addComponent(usuariLabel))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(usuariTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                            .addComponent(passwordField)
                            .addComponent(jComboBoxRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(registreForm)
                .addGap(83, 83, 83)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usuariTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuariLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passLabel))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usuariLabel8)
                    .addComponent(jComboBoxRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tornarPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(desarPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tornarLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tornarLabelMouseClicked

        frmlogin t1 = new frmlogin();
        logOut(in, out);

        try {
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(RegistreForm.class.getName()).log(Level.SEVERE, null, ex);
        }

        t1.setVisible(true);
        this.dispose();


    }//GEN-LAST:event_tornarLabelMouseClicked

    private void tornarLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tornarLabelMouseEntered
        tornarPanel.setBackground(new Color(0, 156, 223));
    }//GEN-LAST:event_tornarLabelMouseEntered

    private void tornarLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tornarLabelMouseExited
        tornarPanel.setBackground(new Color(0, 134, 190));
    }//GEN-LAST:event_tornarLabelMouseExited

    private void desarLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_desarLabelMouseClicked

        try {

            out.writeInt(1);
            int comprovacio = in.readInt();
            if (comprovacio == 1) {
                out.writeBoolean(true);
                boolean senyal = in.readBoolean();
                if (senyal == true) {
                    //out.writeUTF(idTextField.getText());
                    out.writeUTF(usuariTextField.getText());
                    out.writeUTF(passwordField.getText());
                    String comboRol = "";
                    if (jComboBoxRol.getSelectedItem().toString().equals("Administration")) {
                        comboRol = "1";
                    } else {
                        comboRol = "2";
                    }
                    out.writeUTF(comboRol);
                    String correcte = in.readUTF();
                    System.out.println(correcte);
                    int rol = in.readInt();
                    if (rol != 0) {
                        System.out.println("Ha accedit l'usuari " + usuariTextField.getText() + " amb el rol de " + jComboBoxRol.getSelectedItem().toString() + " numero " + rol + ".");
                    } else {
                        System.out.println("L'usuari " + usuariTextField.getText() + " no te rol correcte.");
                    }
                }
            }

            frmlogin form = new frmlogin();
            frmInici inici = new frmInici(in, out, rol);
            form.setVisible(true);
            inici.logOut(in, out);
            this.dispose();

        } catch (IOException ex) {
            Logger.getLogger(RegistreForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_desarLabelMouseClicked

    private void desarLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_desarLabelMouseEntered
        tornarPanel.setBackground(new Color(0, 156, 223));
    }//GEN-LAST:event_desarLabelMouseEntered

    private void desarLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_desarLabelMouseExited
        tornarPanel.setBackground(new Color(0, 134, 190));
    }//GEN-LAST:event_desarLabelMouseExited

    private void usuariTextFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usuariTextFieldMousePressed
        if (usuariTextField.getText().equals("Enter new user")) {
            usuariTextField.setText("");
            usuariTextField.setForeground(Color.black);
        }
        if (String.valueOf(passwordField.getPassword()).isEmpty()) {
            passwordField.setText("********");
            passwordField.setForeground(Color.gray);
        }

    }//GEN-LAST:event_usuariTextFieldMousePressed

    private void passwordFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordFieldMousePressed
        if (String.valueOf(passwordField.getPassword()).equals("********")) {
            passwordField.setText("");
            passwordField.setForeground(Color.black);
        }
        if (usuariTextField.getText().isEmpty()) {
            usuariTextField.setText("Enter new user");
            usuariTextField.setForeground(Color.gray);
        }

    }//GEN-LAST:event_passwordFieldMousePressed

    private void usuariTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuariTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuariTextFieldActionPerformed

    private void jComboBoxRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxRolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxRolActionPerformed

    void logOut(DataInputStream in, DataOutputStream out) {

        try {

            out.writeInt(0);

        } catch (IOException ex) {
            Logger.getLogger(frmInici.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel desarLabel;
    private javax.swing.JPanel desarPanel;
    private javax.swing.JComboBox<String> jComboBoxRol;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel passLabel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel registreForm;
    private javax.swing.JLabel tornarLabel;
    private javax.swing.JPanel tornarPanel;
    private javax.swing.JLabel usuariLabel;
    private javax.swing.JLabel usuariLabel8;
    private javax.swing.JTextField usuariTextField;
    // End of variables declaration//GEN-END:variables
}
