/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import dades.client;
import formularis.frmclient;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lluís Barbó
 */
public class logClient {

    public Integer totalregistres;
    DataOutputStream out;
    DataInputStream in;

    public logClient(DataInputStream in, DataOutputStream out) {
        this.in = in;
        this.out = out;
    }

    public DefaultTableModel mostrar() throws IOException {
        DefaultTableModel model = new DefaultTableModel();

        totalregistres = 0;

        try {
            out.writeInt(2);
            out.writeInt(4);
            out.writeInt(1);
            int comprovacio = in.readInt();

            if (comprovacio == 1) {
                out.writeBoolean(true);
                boolean senyal = in.readBoolean();
                if (senyal == true) {
                    int registres_trobats = Integer.parseInt(in.readUTF());
                    String[] nameColumns = {"ID", "Name", "LastName", "Email", "TypeDoc", "NumDoc", "Address", "Municipality", "Province", "Nacionality", "Phone", "Iban", "Postalcode"};
                    String[] fields;

                    Object[][] registre = new Object[registres_trobats][13];

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

    public boolean insertar(client cli) {
        boolean verificar = false;

        try {

            out.writeInt(2);
            out.writeInt(1);
            out.writeInt(1);
            int comprovacio = in.readInt();
            if (comprovacio == 1) {
                out.writeBoolean(true);
                boolean senyal = in.readBoolean();

                if (senyal == true) {
                    out.writeUTF(cli.getName());
                    out.writeUTF(cli.getLastname());
                    out.writeUTF(cli.getEmail());

                    out.writeUTF(cli.getDoctype());
                    out.writeUTF(cli.getNumdoc());
                    out.writeUTF(cli.getAddress());
                    out.writeUTF(cli.getMunicipality());
                    out.writeUTF(cli.getProvince());
                    out.writeUTF(cli.getNacionality());
                    out.writeUTF(cli.getPhone());
                    out.writeUTF(cli.getIban());
                    out.writeInt(cli.getPostalcode());

                    String correcte = in.readUTF();
                    System.out.println(correcte);

                    verificar = true;
                }
            }

        } catch (IOException ex) {

            Logger.getLogger(frmclient.class.getName()).log(Level.SEVERE, null, ex);

        }

        return verificar;
    }

    public boolean editar(client cli) {
        boolean verificar = false;

        try {

            out.writeInt(2);
            out.writeInt(3);
            out.writeInt(1);
            int comprovacio = in.readInt();
            if (comprovacio == 1) {
                out.writeBoolean(true);
                boolean senyal = in.readBoolean();

                if (senyal == true) {

                    out.writeUTF(cli.getName());
                    out.writeUTF(cli.getLastname());
                    out.writeUTF(cli.getEmail());
                    out.writeUTF(cli.getDoctype());
                    out.writeUTF(cli.getNumdoc());

                    out.writeUTF(cli.getAddress());
                    out.writeUTF(cli.getMunicipality());
                    out.writeUTF(cli.getProvince());
                    out.writeUTF(cli.getNacionality());
                    out.writeUTF(cli.getPhone());
                    out.writeUTF(cli.getIban());
                    out.writeInt(cli.getPostalcode());
                    out.writeInt(cli.getIdclient());

                    String correcte = in.readUTF();
                    System.out.println(correcte);

                    verificar = true;
                }
            }

        } catch (IOException ex) {

            Logger.getLogger(frmclient.class.getName()).log(Level.SEVERE, null, ex);

        }

        return verificar;
    }

    public boolean eliminar(client cli) {
        boolean verificar = false;

        try {
            out.writeInt(2);
            out.writeInt(2);
            out.writeInt(1);

            int comprovacio = in.readInt();

            if (comprovacio == 1) {
                out.writeBoolean(true);
                boolean senyal = in.readBoolean();
                if (senyal == true) {

                    out.writeInt(cli.getIdclient());
                    System.out.println("Enviem al servidor id client: " + cli.getIdclient());

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

