/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import dades.room;
import dades.usuari;
import formularis.frmrooms;
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
public class logRooms {

    public Integer totalregistres;
    DataOutputStream out;
    DataInputStream in;

    public logRooms(DataInputStream in, DataOutputStream out) {
        this.in = in;
        this.out = out;
    }
    
    public DefaultTableModel mostrar() throws IOException {
        DefaultTableModel model = new DefaultTableModel();

        totalregistres = 0;

        try {
            out.writeInt(6);
            out.writeInt(4);
            out.writeInt(1);
            int comprovacio = in.readInt();

            if (comprovacio == 1) {
                out.writeBoolean(true);
                boolean senyal = in.readBoolean();
                if (senyal == true) {
                    int registres_trobats = Integer.parseInt(in.readUTF());
                    String[] nameColumns = {"ID", "Name", "Number", "MarriedBed", "Bed", "State", "Wifi", "Air", "Jacuzzi", "DayPrice"};
                    String[] fields;

                    Object[][] registre = new Object[registres_trobats][10];

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
    public DefaultTableModel mostrarvista() throws IOException {
        DefaultTableModel model = new DefaultTableModel();

        totalregistres = 0;

        try {
            out.writeInt(6);
            out.writeInt(4);
            out.writeInt(1);
            int comprovacio = in.readInt();

            if (comprovacio == 1) {
                out.writeBoolean(true);
                boolean senyal = in.readBoolean();
                if (senyal == true) {
                    int registres_trobats = Integer.parseInt(in.readUTF());
                    String[] nameColumns = {"ID", "Name", "Number", "MarriedBed", "Bed", "State", "Wifi", "Air", "Jacuzzi", "DayPrice"};
                    String[] fields;

                    Object[][] registre = new Object[registres_trobats][10];

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

    public boolean insertar(room room) {
        boolean verificar = false;

        try {

            out.writeInt(6);
            out.writeInt(1);
            out.writeInt(1);
            int comprovacio = in.readInt();
            if (comprovacio == 1) {
                out.writeBoolean(true);
                boolean senyal = in.readBoolean();

                if (senyal == true) {
                    out.writeUTF(room.getName());
                    out.writeInt(room.getNumber());
                    out.writeInt(room.getMarriedbed());
                    out.writeInt(room.getBed());
                    out.writeUTF(room.getState());
                    out.writeBoolean(room.isWifi());
                    out.writeBoolean(room.isAir());
                    out.writeBoolean(room.isJacuzzi());
                    out.writeDouble(room.getDayprice());

                    String correcte = in.readUTF();
                    System.out.println(correcte);

                    verificar = true;
                }
            }

        } catch (IOException ex) {

            Logger.getLogger(frmrooms.class.getName()).log(Level.SEVERE, null, ex);

        }

        return verificar;
    }

    public boolean editar(room room) {
        boolean verificar = false;

        try {

            out.writeInt(6);
            out.writeInt(3);
            out.writeInt(1);
            int comprovacio = in.readInt();
            if (comprovacio == 1) {
                out.writeBoolean(true);
                boolean senyal = in.readBoolean();

                if (senyal == true) {

                    out.writeUTF(room.getName());
                    out.writeInt(room.getNumber());
                    out.writeInt(room.getMarriedbed());
                    out.writeInt(room.getBed());
                    out.writeUTF(room.getState());
                    out.writeBoolean(room.isWifi());
                    out.writeBoolean(room.isAir());
                    out.writeBoolean(room.isJacuzzi());
                    out.writeDouble(room.getDayprice());
                    out.writeInt(room.getIdroom());
                    

                    String correcte = in.readUTF();
                    System.out.println(correcte);

                    verificar = true;
                }
            }

        } catch (IOException ex) {

            Logger.getLogger(frmrooms.class.getName()).log(Level.SEVERE, null, ex);

        }

        return verificar;
    }

    public boolean eliminar(room room) {
        boolean verificar = false;

        try {
            out.writeInt(6);
            out.writeInt(2);
            out.writeInt(1);

            int comprovacio = in.readInt();

            if (comprovacio == 1) {
                out.writeBoolean(true);
                boolean senyal = in.readBoolean();
                if (senyal == true) {

                    out.writeInt(room.getIdroom());
                    System.out.println("Enviem al servidor id room: " + room.getIdroom());

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
    
    public boolean notBusy (room room) {
        boolean verificar =  false;
        
        try {
            out.writeInt(6);
            out.writeInt(5);
            out.writeInt(1);
            
            int comprovacio = in.readInt();
            
            if (comprovacio == 1) {
                out.writeBoolean(true);
                boolean senyal = in.readBoolean();
                if (senyal == true) {

                    out.writeInt(room.getIdroom());
                    System.out.println("Enviem al servidor id room: " + room.getIdroom());

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
    
    public boolean occupied (room room) {
        boolean verificar =  false;
        
        try {
            out.writeInt(6);
            out.writeInt(6);
            out.writeInt(1);
            
            int comprovacio = in.readInt();
            
            if (comprovacio == 1) {
                out.writeBoolean(true);
                boolean senyal = in.readBoolean();
                if (senyal == true) {

                    out.writeInt(room.getIdroom());
                    System.out.println("Enviem al servidor id room: " + room.getIdroom());

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
