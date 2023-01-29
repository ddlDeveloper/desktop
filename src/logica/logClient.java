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
            //Cálcul clau pública client
            String[] claus_ps = SystemUtils.clauPublicaClient().split(",");
            //Enviem la clau pública del client al servidor
            out.writeUTF(String.valueOf(claus_ps[0]));
            //llegim la clau pública del servidor
            BigInteger shared_secret = SystemUtils.calculClauCompartida(in.readUTF(), claus_ps[1]);
            //Executo la consulta de la crida per sortir
            out.writeUTF(SystemUtils.encryptedText(String.valueOf(2), shared_secret.toByteArray()));
            out.writeUTF(SystemUtils.encryptedText(String.valueOf(4), shared_secret.toByteArray()));
            
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
                    String[] nameColumns = {"ID", "Name", "LastName", "Email", "TypeDoc", "NumDoc", "Address", "Municipality", "Province", "Nacionality", "Phone", "Iban", "Postalcode"};
                    String[] fields;

                    Object[][] registre = new Object[registres_trobats][13];

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

    public boolean insertar(client cli) {
        boolean verificar = false;

        try {
            //Cálcul clau pública client
            String[] claus_ps = SystemUtils.clauPublicaClient().split(",");
            //Enviem la clau pública del client al servidor
            out.writeUTF(String.valueOf(claus_ps[0]));
            //llegim la clau pública del servidor
            BigInteger shared_secret = SystemUtils.calculClauCompartida(in.readUTF(), claus_ps[1]);
            //Executo la consulta de la crida per sortir
            out.writeUTF(SystemUtils.encryptedText(String.valueOf(2), shared_secret.toByteArray()));
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
                    out.writeUTF(SystemUtils.encryptedText(cli.getName(), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(cli.getLastname(), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(cli.getEmail(), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(cli.getDoctype(), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(cli.getNumdoc(), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(cli.getAddress(), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(cli.getMunicipality(), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(cli.getProvince(), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(cli.getNacionality(), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(cli.getPhone(), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(cli.getIban(), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(String.valueOf(cli.getPostalcode()), shared_secret.toByteArray()));
                    
                    String correcte = SystemUtils.decryptedText(in.readUTF(), shared_secret.toByteArray());
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
            //Cálcul clau pública client
            String[] claus_ps = SystemUtils.clauPublicaClient().split(",");
            //Enviem la clau pública del client al servidor
            out.writeUTF(String.valueOf(claus_ps[0]));
            //llegim la clau pública del servidor
            BigInteger shared_secret = SystemUtils.calculClauCompartida(in.readUTF(), claus_ps[1]);
            //Executo la consulta de la crida per sortir
            out.writeUTF(SystemUtils.encryptedText(String.valueOf(2), shared_secret.toByteArray()));
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

                    out.writeUTF(SystemUtils.encryptedText(cli.getName(), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(cli.getLastname(), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(cli.getEmail(), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(cli.getDoctype(), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(cli.getNumdoc(), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(cli.getAddress(), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(cli.getMunicipality(), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(cli.getProvince(), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(cli.getNacionality(), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(cli.getPhone(), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(cli.getIban(), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(String.valueOf(cli.getPostalcode()), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(String.valueOf(cli.getIdclient()), shared_secret.toByteArray()));
                    
                    String correcte = SystemUtils.decryptedText(in.readUTF(), shared_secret.toByteArray());
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
            //Cálcul clau pública client
            String[] claus_ps = SystemUtils.clauPublicaClient().split(",");
            //Enviem la clau pública del client al servidor
            out.writeUTF(String.valueOf(claus_ps[0]));
            //llegim la clau pública del servidor
            BigInteger shared_secret = SystemUtils.calculClauCompartida(in.readUTF(), claus_ps[1]);
            //Executo la consulta de la crida per sortir
            out.writeUTF(SystemUtils.encryptedText(String.valueOf(2), shared_secret.toByteArray()));
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

                    out.writeUTF(SystemUtils.encryptedText(String.valueOf(cli.getIdclient()), shared_secret.toByteArray()));
                    System.out.println("Enviem al servidor id room: " + cli.getIdclient());

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

