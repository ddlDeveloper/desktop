/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import dades.reserva;
import formularis.frmreservation;
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
public class logReserve {

    public Integer totalregistres;
    DataOutputStream out;
    DataInputStream in;

    public logReserve(DataInputStream in, DataOutputStream out) {
        this.in = in;
        this.out = out;
    }

    public DefaultTableModel mostrar() throws IOException {
        DefaultTableModel model = new DefaultTableModel();

        totalregistres = 0;

        try {
            out.writeInt(3);
            out.writeInt(4);
            out.writeInt(1);
            int comprovacio = in.readInt();

            if (comprovacio == 1) {
                out.writeBoolean(true);
                boolean senyal = in.readBoolean();
                if (senyal == true) {
                    int registres_trobats = Integer.parseInt(in.readUTF());
                    String[] nameColumns = {"ID", "Name", "LastName", "DocType", "NumDoc", "Address", "Phone", "Email", "Rol", "User", "Password", "Sex"};
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

    public boolean insertar(reserva res) {
        boolean verificar = false;

        try {

            out.writeInt(3);
            out.writeInt(1);
            out.writeInt(1);
            int comprovacio = in.readInt();
            if (comprovacio == 1) {
                out.writeBoolean(true);
                boolean senyal = in.readBoolean();

                if (senyal == true) {
                    out.writeUTF(res.getName());
                    out.writeUTF(res.getLastname());
                    out.writeUTF(res.getDoctype());
                    out.writeUTF(res.getNumdoc());
                    out.writeUTF(res.getAddress());

                    out.writeUTF(res.getPhone());
                    out.writeUTF(res.getEmail());
                    out.writeInt(res.getRol());
                    out.writeUTF(res.getUser());
                    out.writeUTF(SystemUtils.convertirSHA256(res.getPassword()));    
                    out.writeUTF(String.valueOf(res.getSex()));

                    String correcte = in.readUTF();
                    System.out.println(correcte);

                    verificar = true;
                }
            }

        } catch (IOException ex) {

            Logger.getLogger(frmreservation.class.getName()).log(Level.SEVERE, null, ex);

        }

        return verificar;
    }

    public boolean editar(reserva res) {
        boolean verificar = false;

        try {

            out.writeInt(3);
            out.writeInt(3);
            out.writeInt(1);
            int comprovacio = in.readInt();
            if (comprovacio == 1) {
                out.writeBoolean(true);
                boolean senyal = in.readBoolean();

                if (senyal == true) {

                    out.writeUTF(res.getName());
                    out.writeUTF(res.getLastname());
                    out.writeUTF(res.getDoctype());
                    out.writeUTF(res.getNumdoc());
                    out.writeUTF(res.getAddress());

                    out.writeUTF(res.getPhone());
                    out.writeUTF(res.getEmail());
                    out.writeInt(res.getRol());
                    out.writeUTF(res.getUser());
                    out.writeUTF(SystemUtils.convertirSHA256(res.getPassword()));
                    out.writeUTF(res.getSex());
                    out.writeInt(res.getIdreserva());

                    String correcte = in.readUTF();
                    System.out.println(correcte);

                    verificar = true;
                }
            }

        } catch (IOException ex) {

            Logger.getLogger(frmreservation.class.getName()).log(Level.SEVERE, null, ex);

        }

        return verificar;
    }

    public boolean eliminar(reserva res) {
        boolean verificar = false;

        try {
            out.writeInt(3);
            out.writeInt(2);
            out.writeInt(1);

            int comprovacio = in.readInt();

            if (comprovacio == 1) {
                out.writeBoolean(true);
                boolean senyal = in.readBoolean();
                if (senyal == true) {

                    out.writeInt(res.getIdreserva());
                    System.out.println("Enviem al servidor id reserve: " + res.getIdreserva());

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

