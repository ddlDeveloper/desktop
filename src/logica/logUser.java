/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import dades.usuari;
import formularis.frmuser;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utils.SystemUtils;

/**
 *
 * @author Lluís Barbó
 */
public class logUser {

    public Integer totalregistres;
    DataOutputStream out;
    DataInputStream in;

    public logUser(DataInputStream in, DataOutputStream out) {
        this.in = in;
        this.out = out;
    }

    public DefaultTableModel mostrar() throws IOException {
        DefaultTableModel model = new DefaultTableModel();

        totalregistres = 0;

        try {
            //Cálcul clau pública client
            String[] claus_ps = SystemUtils.clauPublicaClient().split(",");
            //Enviem la clau pública del client al servidor
            out.writeUTF(String.valueOf(claus_ps[0]));
            //llegim la clau pública del servidor
            BigInteger shared_secret = SystemUtils.calculClauCompartida(in.readUTF(), claus_ps[1]);
            //Executo la consulta de la crida per sortir
            out.writeUTF(SystemUtils.encryptedText(String.valueOf(4), shared_secret.toByteArray()));
            out.writeUTF(SystemUtils.encryptedText(String.valueOf(4), shared_secret.toByteArray()));
            
            //Enviem la clau pública del client al servidor
            out.writeUTF(String.valueOf(claus_ps[0]));
            //llegim la clau pública del servidor
            shared_secret = SystemUtils.calculClauCompartida(in.readUTF(), claus_ps[1]);
            out.writeUTF(SystemUtils.encryptedText(String.valueOf(1), shared_secret.toByteArray()));
            int comprovacio = Integer.parseInt(SystemUtils.decryptedText(in.readUTF(), shared_secret.toByteArray()));

            if (comprovacio == 1) {
                out.writeUTF(SystemUtils.encryptedText(String.valueOf("true"), shared_secret.toByteArray()));
                boolean senyal = Boolean.parseBoolean(SystemUtils.decryptedText(in.readUTF(), shared_secret.toByteArray()));
                if (senyal == true) {
                    int registres_trobats = Integer.parseInt(SystemUtils.decryptedText(in.readUTF(), shared_secret.toByteArray()));
                    String[] nameColumns = {"ID", "User", "Password", "Name", "LastName", "Email", "TypeDoc", "NumDoc", "Address", "Phone", "Sex", "Rol"};
                    String[] fields;

                    Object[][] registre = new Object[registres_trobats][12];

                    model.setColumnIdentifiers(nameColumns);

                    for (int i = 0; i < registres_trobats; i++) {

                        String record = SystemUtils.decryptedText(in.readUTF(), shared_secret.toByteArray());
                        fields = record.split(",");

                        for (int j = 0; j < 0; j++) {

                            registre[i][j] = fields[j];

                        }

                        model.addRow(fields);
                        totalregistres = totalregistres + 1;

                    }

                }
            }
            return model;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public boolean insertar(usuari user) {
        boolean verificar = false;

        try {
            //Cálcul clau pública client
            String[] claus_ps = SystemUtils.clauPublicaClient().split(",");
            //Enviem la clau pública del client al servidor
            out.writeUTF(String.valueOf(claus_ps[0]));
            //llegim la clau pública del servidor
            BigInteger shared_secret = SystemUtils.calculClauCompartida(in.readUTF(), claus_ps[1]);
            //Executo la consulta de la crida per sortir
            out.writeUTF(SystemUtils.encryptedText(String.valueOf(4), shared_secret.toByteArray()));
            out.writeUTF(SystemUtils.encryptedText(String.valueOf(1), shared_secret.toByteArray()));
            
            //Enviem la clau pública del client al servidor
            out.writeUTF(String.valueOf(claus_ps[0]));
            //llegim la clau pública del servidor
            shared_secret = SystemUtils.calculClauCompartida(in.readUTF(), claus_ps[1]);
            out.writeUTF(SystemUtils.encryptedText(String.valueOf(1), shared_secret.toByteArray()));
            int comprovacio = Integer.parseInt(SystemUtils.decryptedText(in.readUTF(), shared_secret.toByteArray()));

            if (comprovacio == 1) {
                out.writeUTF(SystemUtils.encryptedText(String.valueOf("true"), shared_secret.toByteArray()));
                boolean senyal = Boolean.parseBoolean(SystemUtils.decryptedText(in.readUTF(), shared_secret.toByteArray()));
                if (senyal == true) {
                    
                    out.writeUTF(SystemUtils.encryptedText(user.getUser(), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(SystemUtils.convertirSHA256(user.getPassword()), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(user.getName(), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(user.getLastname(), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(user.getEmail(), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(user.getDoctype(), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(user.getNumdoc(), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(user.getAddress(), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(user.getPhone(), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(user.getSex(), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(String.valueOf(user.getRol()), shared_secret.toByteArray()));
                    
                    String correcte = SystemUtils.decryptedText(in.readUTF(), shared_secret.toByteArray());
                    System.out.println(correcte);

                    verificar = true;
                }
            }

        } catch (IOException ex) {

            Logger.getLogger(frmuser.class.getName()).log(Level.SEVERE, null, ex);

        }

        return verificar;
    }

    public boolean editar(usuari user) {
        boolean verificar = false;

        try {
            //Cálcul clau pública client
            String[] claus_ps = SystemUtils.clauPublicaClient().split(",");
            //Enviem la clau pública del client al servidor
            out.writeUTF(String.valueOf(claus_ps[0]));
            //llegim la clau pública del servidor
            BigInteger shared_secret = SystemUtils.calculClauCompartida(in.readUTF(), claus_ps[1]);
            //Executo la consulta de la crida per sortir
            out.writeUTF(SystemUtils.encryptedText(String.valueOf(4), shared_secret.toByteArray()));
            out.writeUTF(SystemUtils.encryptedText(String.valueOf(3), shared_secret.toByteArray()));
            
            //Enviem la clau pública del client al servidor
            out.writeUTF(String.valueOf(claus_ps[0]));
            //llegim la clau pública del servidor
            shared_secret = SystemUtils.calculClauCompartida(in.readUTF(), claus_ps[1]);
            out.writeUTF(SystemUtils.encryptedText(String.valueOf(1), shared_secret.toByteArray()));
            int comprovacio = Integer.parseInt(SystemUtils.decryptedText(in.readUTF(), shared_secret.toByteArray()));

            if (comprovacio == 1) {
                out.writeUTF(SystemUtils.encryptedText(String.valueOf("true"), shared_secret.toByteArray()));
                boolean senyal = Boolean.parseBoolean(SystemUtils.decryptedText(in.readUTF(), shared_secret.toByteArray()));
                if (senyal == true) {

                    out.writeUTF(SystemUtils.encryptedText(user.getUser(), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(SystemUtils.convertirSHA256(user.getPassword()), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(user.getName(), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(user.getLastname(), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(user.getEmail(), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(user.getDoctype(), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(user.getNumdoc(), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(user.getAddress(), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(user.getPhone(), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(user.getSex(), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(String.valueOf(user.getRol()), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(String.valueOf(user.getIduser()), shared_secret.toByteArray()));
                    
                    String correcte = SystemUtils.decryptedText(in.readUTF(), shared_secret.toByteArray());
                    System.out.println(correcte);

                    verificar = true;
                }
            }

        } catch (IOException ex) {

            Logger.getLogger(frmuser.class.getName()).log(Level.SEVERE, null, ex);

        }

        return verificar;
    }

    public boolean eliminar(usuari user) {
        boolean verificar = false;

        try {
            //Cálcul clau pública client
            String[] claus_ps = SystemUtils.clauPublicaClient().split(",");
            //Enviem la clau pública del client al servidor
            out.writeUTF(String.valueOf(claus_ps[0]));
            //llegim la clau pública del servidor
            BigInteger shared_secret = SystemUtils.calculClauCompartida(in.readUTF(), claus_ps[1]);
            //Executo la consulta de la crida per sortir
            out.writeUTF(SystemUtils.encryptedText(String.valueOf(4), shared_secret.toByteArray()));
            out.writeUTF(SystemUtils.encryptedText(String.valueOf(2), shared_secret.toByteArray()));
            
            //Enviem la clau pública del client al servidor
            out.writeUTF(String.valueOf(claus_ps[0]));
            //llegim la clau pública del servidor
            shared_secret = SystemUtils.calculClauCompartida(in.readUTF(), claus_ps[1]);
            out.writeUTF(SystemUtils.encryptedText(String.valueOf(1), shared_secret.toByteArray()));
            int comprovacio = Integer.parseInt(SystemUtils.decryptedText(in.readUTF(), shared_secret.toByteArray()));

            if (comprovacio == 1) {
                out.writeUTF(SystemUtils.encryptedText(String.valueOf("true"), shared_secret.toByteArray()));
                boolean senyal = Boolean.parseBoolean(SystemUtils.decryptedText(in.readUTF(), shared_secret.toByteArray()));
                if (senyal == true) {

                    out.writeUTF(SystemUtils.encryptedText(String.valueOf(user.getIduser()), shared_secret.toByteArray()));
                    System.out.println("Enviem al servidor id user: " + user.getIduser());

                    String correcte = SystemUtils.decryptedText(in.readUTF(), shared_secret.toByteArray());
                    System.out.println(correcte);

                    verificar = true;
                }
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }

        return verificar;
    }
}
