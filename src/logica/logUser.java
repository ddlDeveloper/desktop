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
            out.writeInt(4);
            out.writeInt(4);
            out.writeInt(1);
            int comprovacio = in.readInt();

            if (comprovacio == 1) {
                out.writeBoolean(true);
                boolean senyal = in.readBoolean();
                if (senyal == true) {
                    int registres_trobats = Integer.parseInt(in.readUTF());
                    String[] nameColumns = {"ID", "User", "Password", "Name", "LastName", "Email", "TypeDoc", "NumDoc", "Address", "Phone", "Sex", "Rol"};
                    String[] fields;

                    Object[][] registre = new Object[registres_trobats][12];

                    model.setColumnIdentifiers(nameColumns);

                    for (int i = 0; i < registres_trobats; i++) {

                        String record = in.readUTF();
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

            out.writeInt(4);
            out.writeInt(1);
            out.writeInt(1);
            int comprovacio = in.readInt();
            if (comprovacio == 1) {
                out.writeBoolean(true);
                boolean senyal = in.readBoolean();

                if (senyal == true) {
                    out.writeUTF(user.getUser());
                    out.writeUTF(SystemUtils.convertirSHA256(user.getPassword()));
                    out.writeUTF(user.getName());
                    out.writeUTF(user.getLastname());
                    out.writeUTF(user.getEmail());

                    out.writeUTF(user.getDoctype());
                    out.writeUTF(user.getNumdoc());
                    out.writeUTF(user.getAddress());
                    out.writeUTF(user.getPhone());
                    out.writeUTF(user.getSex());
                    out.writeUTF(String.valueOf(user.getRol()));

                    String correcte = in.readUTF();
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

            out.writeInt(4);
            out.writeInt(3);
            out.writeInt(1);
            int comprovacio = in.readInt();
            if (comprovacio == 1) {
                out.writeBoolean(true);
                boolean senyal = in.readBoolean();

                if (senyal == true) {

                    out.writeUTF(user.getUser());
                    out.writeUTF(SystemUtils.convertirSHA256(user.getPassword()));
                    out.writeUTF(user.getName());
                    out.writeUTF(user.getLastname());
                    out.writeUTF(user.getEmail());

                    out.writeUTF(user.getDoctype());
                    out.writeUTF(user.getNumdoc());
                    out.writeUTF(user.getAddress());
                    out.writeUTF(user.getPhone());
                    out.writeUTF(user.getSex());
                    out.writeInt(user.getRol());
                    out.writeInt(user.getIduser());

                    String correcte = in.readUTF();
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
            out.writeInt(4);
            out.writeInt(2);
            out.writeInt(1);

            int comprovacio = in.readInt();

            if (comprovacio == 1) {
                out.writeBoolean(true);
                boolean senyal = in.readBoolean();
                if (senyal == true) {

                    out.writeInt(user.getIduser());
                    System.out.println("Enviem al servidor id user: " + user.getIduser());

                    String correcte = in.readUTF();
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
