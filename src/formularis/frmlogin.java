/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularis;

import java.awt.Color;
import java.awt.Image;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Lluís Barbó
 */
public class frmlogin extends javax.swing.JFrame {

    /**
     * Creates new form frmlogin
     */
    int xMouse,
            /**
             * Creates new form LoginForm
             */
            /**
             * Creates new form frmlogin
             */
            yMouse;

    public frmlogin() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("../images/logo.png")).getImage());
        setLocationRelativeTo(this);

        //rescalelabel.RSScaleLabel.setScaleLabel(ddlbg, "src/images/images_1_.png");
        SetImageLabel(ddlbg, "src/images/images_1_.png");
        //SetImageLabel(bg, "src/image/gris_1.png");
    }

    private void SetImageLabel(JLabel labelName, String root) {
        ImageIcon image = new ImageIcon(root);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
        labelName.setIcon(icon);
        this.repaint();

    }

    // Comprovació GIT
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        ddlbg = new javax.swing.JLabel();
        capçaleraPanel = new javax.swing.JPanel();
        inici_sessio = new javax.swing.JLabel();
        usuariLabel = new javax.swing.JLabel();
        usuariTextField = new javax.swing.JTextField();
        nomSeparator = new javax.swing.JSeparator();
        passSeparator = new javax.swing.JSeparator();
        passLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        entrarPanel = new javax.swing.JPanel();
        entrarLabel = new javax.swing.JLabel();
        registrarPanel = new javax.swing.JPanel();
        registrarLabel = new javax.swing.JLabel();
        tancarPanel = new javax.swing.JPanel();
        tancarLabel = new javax.swing.JLabel();
        olvidarLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        bg.setBackground(new java.awt.Color(144, 164, 174));
        bg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N
        bg.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, 300, -1));

        ddlbg.setBackground(new java.awt.Color(250, 250, 250));
        ddlbg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ddlbg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images_1_.png"))); // NOI18N
        bg.add(ddlbg, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 300, 500));

        capçaleraPanel.setBackground(new java.awt.Color(144, 164, 174));
        capçaleraPanel.setForeground(new java.awt.Color(255, 255, 255));
        capçaleraPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                capçaleraPanelMouseDragged(evt);
            }
        });
        capçaleraPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                capçaleraPanelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout capçaleraPanelLayout = new javax.swing.GroupLayout(capçaleraPanel);
        capçaleraPanel.setLayout(capçaleraPanelLayout);
        capçaleraPanelLayout.setHorizontalGroup(
            capçaleraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        capçaleraPanelLayout.setVerticalGroup(
            capçaleraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        bg.add(capçaleraPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 800, 40));

        inici_sessio.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        inici_sessio.setText("LOGIN");
        bg.add(inici_sessio, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        usuariLabel.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        usuariLabel.setText("USER");
        bg.add(usuariLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        usuariTextField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        usuariTextField.setForeground(new java.awt.Color(204, 204, 204));
        usuariTextField.setText("Enter your user");
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
        bg.add(usuariTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 340, 30));
        bg.add(nomSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 340, -1));
        bg.add(passSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 340, -1));

        passLabel.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        passLabel.setText("PASSWORD");
        bg.add(passLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, -1, -1));

        passwordField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        passwordField.setForeground(new java.awt.Color(204, 204, 204));
        passwordField.setText("********");
        passwordField.setBorder(null);
        passwordField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                passwordFieldMousePressed(evt);
            }
        });
        bg.add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 340, 30));

        entrarPanel.setBackground(new java.awt.Color(0, 134, 190));
        entrarPanel.setFont(new java.awt.Font("Rockwell Condensed", 0, 14)); // NOI18N
        entrarPanel.setName(""); // NOI18N

        entrarLabel.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        entrarLabel.setForeground(new java.awt.Color(255, 255, 255));
        entrarLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        entrarLabel.setText("LOG IN");
        entrarLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                entrarLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                entrarLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                entrarLabelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout entrarPanelLayout = new javax.swing.GroupLayout(entrarPanel);
        entrarPanel.setLayout(entrarPanelLayout);
        entrarPanelLayout.setHorizontalGroup(
            entrarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, entrarPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(entrarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116))
        );
        entrarPanelLayout.setVerticalGroup(
            entrarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, entrarPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(entrarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        bg.add(entrarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 110, 40));

        registrarPanel.setBackground(new java.awt.Color(0, 134, 190));
        registrarPanel.setFont(new java.awt.Font("Rockwell Condensed", 0, 14)); // NOI18N
        registrarPanel.setName(""); // NOI18N

        registrarLabel.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        registrarLabel.setForeground(new java.awt.Color(255, 255, 255));
        registrarLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registrarLabel.setText("REGISTER");
        registrarLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registrarLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registrarLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                registrarLabelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout registrarPanelLayout = new javax.swing.GroupLayout(registrarPanel);
        registrarPanel.setLayout(registrarPanelLayout);
        registrarPanelLayout.setHorizontalGroup(
            registrarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(registrarLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );
        registrarPanelLayout.setVerticalGroup(
            registrarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registrarPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(registrarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        bg.add(registrarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 390, 110, 40));

        tancarPanel.setBackground(new java.awt.Color(144, 164, 174));
        tancarPanel.setForeground(new java.awt.Color(255, 255, 255));
        tancarPanel.setPreferredSize(new java.awt.Dimension(40, 40));

        tancarLabel.setBackground(new java.awt.Color(144, 164, 174));
        tancarLabel.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        tancarLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tancarLabel.setText("X");
        tancarLabel.setPreferredSize(new java.awt.Dimension(40, 40));
        tancarLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tancarLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tancarLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tancarLabelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout tancarPanelLayout = new javax.swing.GroupLayout(tancarPanel);
        tancarPanel.setLayout(tancarPanelLayout);
        tancarPanelLayout.setHorizontalGroup(
            tancarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tancarPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(tancarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        tancarPanelLayout.setVerticalGroup(
            tancarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tancarPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(tancarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        bg.add(tancarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        olvidarLabel.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        olvidarLabel.setText("Have you forgotten your password?");
        bg.add(olvidarLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 450, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void capçaleraPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_capçaleraPanelMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_capçaleraPanelMousePressed

    private void capçaleraPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_capçaleraPanelMouseDragged
        //Al passar el ratolí la finestra es desplaça
        //Llavors creem les variables x i y, per saber on es el cursor a la pantalla
        //Per finalitzar restem les variables amb la ubicació x - xMouse i y - yMouse
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_capçaleraPanelMouseDragged

    private void tancarLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tancarLabelMouseClicked
        System.exit(0);
    }//GEN-LAST:event_tancarLabelMouseClicked

    private void tancarLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tancarLabelMouseEntered
        tancarPanel.setBackground(new Color(144, 164, 174));
        tancarLabel.setForeground(Color.red);
    }//GEN-LAST:event_tancarLabelMouseEntered

    private void tancarLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tancarLabelMouseExited
        //tancarPanel.setBackground(Color.white);
        tancarPanel.setBackground(new Color(144, 164, 174));
        tancarLabel.setForeground(Color.black);
    }//GEN-LAST:event_tancarLabelMouseExited

    private void entrarLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_entrarLabelMouseEntered
        entrarPanel.setBackground(new Color(0, 156, 223));
    }//GEN-LAST:event_entrarLabelMouseEntered

    private void entrarLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_entrarLabelMouseExited
        entrarPanel.setBackground(new Color(0, 134, 190));
    }//GEN-LAST:event_entrarLabelMouseExited

    private void passwordFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordFieldMousePressed
        if (String.valueOf(passwordField.getPassword()).equals("********")) {
            passwordField.setText("");
            passwordField.setForeground(Color.black);
        }
        if (usuariTextField.getText().isEmpty()) {
            usuariTextField.setText("Enter your user");
            usuariTextField.setForeground(Color.gray);
        }

    }//GEN-LAST:event_passwordFieldMousePressed

    private void entrarLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_entrarLabelMouseClicked
        // Ho deixem comentat per comprovacions
        /*javax.swing.JOptionPane.showMessageDialog(this, "Intent d'accés amb les dades:\nUsuari: " 
        + usuariTextField.getText() + "\nContrasenya: " + String.valueOf(passwordField.getPassword()), 
        "LOGIN", javax.swing.JOptionPane.INFORMATION_MESSAGE);*/

        Socket cli;

        try {
            cli = new Socket("127.0.0.1", 8000);
            DataInputStream in = new DataInputStream(cli.getInputStream());
            DataOutputStream out = new DataOutputStream(cli.getOutputStream());

            String resposta_server = in.readUTF();
            String pass = passwordField.getText();
            String encryptedPass;
            
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(pass.getBytes());
            byte[] bytes = m.digest();
            
            StringBuilder stringBuilder = new StringBuilder();
            
            for (int i = 0; i < bytes.length; i++) {
                
                    stringBuilder.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
                    
                }

            encryptedPass = stringBuilder.toString();

            // send response to server with user and password
            out.writeUTF(usuariTextField.getText());
            out.writeUTF(encryptedPass);
            //out.writeUTF(passwordField.getText());
            out.writeInt(1);
            int resposta_server_id = in.readInt();
            System.out.println("Resposta servidor:  " + resposta_server);
            int rol = in.readInt(); //Recollim el valor numeric del rol, per enviar al formulari frmInici i fer un switch

            if (resposta_server_id > 0) {
                JOptionPane.showMessageDialog(this, "Welcome user " + usuariTextField.getText().toString());
                                
                frmInici formInici = new frmInici(in, out, rol);

                formInici.setId(resposta_server_id);
                formInici.setUsuari(usuariTextField.getText().toString());
                formInici.setPass(passwordField.getText().toString());
                formInici.setRol(rol);
                formInici.setVisible(true);
                this.dispose();

            } else {
                JOptionPane.showMessageDialog(this, "Incorrect username or password");

            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Unable to connect to server");
            Logger.getLogger(frmlogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(frmlogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_entrarLabelMouseClicked

    private void registrarLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrarLabelMouseClicked
        // TODO add your handling code here:

        Socket cli;

        try {
            cli = new Socket("127.0.0.1", 8000);
            DataInputStream in = new DataInputStream(cli.getInputStream());
            DataOutputStream out = new DataOutputStream(cli.getOutputStream());

            String resposta_server = in.readUTF();

            // send response to server with user and password
            out.writeUTF(usuariTextField.getText());
            out.writeUTF(passwordField.getText());
            out.writeInt(0);
            
            int resposta_server_id = in.readInt();
            
            if (resposta_server_id == 0) {
                
                this.setVisible(false);
                RegistreForm r1 = new RegistreForm(cli, in, out);
                r1.setVisible(true);

            } 
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "No es pot establir connexió amb el servidor");
            Logger.getLogger(frmlogin.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_registrarLabelMouseClicked

    private void registrarLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrarLabelMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_registrarLabelMouseEntered

    private void registrarLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrarLabelMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_registrarLabelMouseExited

    private void usuariTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuariTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuariTextFieldActionPerformed

    private void usuariTextFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usuariTextFieldMousePressed
        if (usuariTextField.getText().equals("Enter your user")) {
            usuariTextField.setText("");
            usuariTextField.setForeground(Color.black);
        }
        if (String.valueOf(passwordField.getPassword()).isEmpty()) {
            passwordField.setText("********");
            passwordField.setForeground(Color.gray);
        }

    }//GEN-LAST:event_usuariTextFieldMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JPanel capçaleraPanel;
    private javax.swing.JLabel ddlbg;
    private javax.swing.JLabel entrarLabel;
    private javax.swing.JPanel entrarPanel;
    private javax.swing.JLabel inici_sessio;
    private javax.swing.JLabel logo;
    private javax.swing.JSeparator nomSeparator;
    private javax.swing.JLabel olvidarLabel;
    private javax.swing.JLabel passLabel;
    private javax.swing.JSeparator passSeparator;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel registrarLabel;
    private javax.swing.JPanel registrarPanel;
    private javax.swing.JLabel tancarLabel;
    private javax.swing.JPanel tancarPanel;
    private javax.swing.JLabel usuariLabel;
    private javax.swing.JTextField usuariTextField;
    // End of variables declaration//GEN-END:variables

}
