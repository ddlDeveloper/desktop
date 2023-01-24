package logica;

import dades.reservation;
import formularis.frmreserva;
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
public class logReservation {

    public Integer totalregistres;
    DataOutputStream out;
    DataInputStream in;

    public logReservation(DataInputStream in, DataOutputStream out) {
        this.in = in;
        this.out = out;
    }

    public DefaultTableModel mostrar() throws IOException {
        DefaultTableModel model = new DefaultTableModel();

        totalregistres = 0;

        try {
            out.writeInt(7);
            out.writeInt(4);
            out.writeInt(1);
            int comprovacio = in.readInt();

            if (comprovacio == 1) {
                out.writeBoolean(true);
                boolean senyal = in.readBoolean();
                if (senyal == true) {
                    int registres_trobats = Integer.parseInt(in.readUTF());
                    String[] nameColumns = {"ID", "IDRoom", "NumberRoom", "IDClient", "Client", "IDEmployed", "Employed", "TypeReserve", "DateReservation", "DateAdmission", "DateDeparture", "Pryce", "Estate"};
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

    public boolean insertar(reservation res) {
        boolean verificar = false;

        try {

            out.writeInt(7);
            out.writeInt(1);
            out.writeInt(1);
            int comprovacio = in.readInt();
            if (comprovacio == 1) {
                out.writeBoolean(true);
                boolean senyal = in.readBoolean();

                if (senyal == true) {
                    out.writeInt(res.getIdRoom());
                    out.writeInt(res.getIdClient());
                    out.writeInt(res.getIdEmployed());
                    out.writeUTF(res.getTypeReserve());
                    out.writeUTF(String.valueOf(res.getDateReservation()));
                    out.writeUTF(String.valueOf(res.getDateAdmission()));
                    out.writeUTF(String.valueOf(res.getDateDeparture()));
                    out.writeDouble(res.getPryce());
                    out.writeUTF(res.getState());

                    String correcte = in.readUTF();
                    System.out.println(correcte);

                    verificar = true;
                }
            }

        } catch (IOException ex) {

            Logger.getLogger(frmreserva.class.getName()).log(Level.SEVERE, null, ex);

        }

        return verificar;
    }

    public boolean editar(reservation res) {
        boolean verificar = false;

        try {

            out.writeInt(7);
            out.writeInt(3);
            out.writeInt(1);
            int comprovacio = in.readInt();
            if (comprovacio == 1) {
                out.writeBoolean(true);
                boolean senyal = in.readBoolean();

                if (senyal == true) {

                    out.writeInt(res.getIdRoom());
                    out.writeInt(res.getIdClient());
                    out.writeInt(res.getIdEmployed());
                    out.writeUTF(res.getTypeReserve());
                    out.writeUTF(String.valueOf(res.getDateReservation()));
                    out.writeUTF(String.valueOf(res.getDateAdmission()));
                    out.writeUTF(String.valueOf(res.getDateDeparture()));
                    out.writeDouble(res.getPryce());
                    out.writeUTF(res.getState());
                    out.writeInt(res.getIdReserve());

                    String correcte = in.readUTF();
                    System.out.println(correcte);

                    verificar = true;
                }
            }

        } catch (IOException ex) {

            Logger.getLogger(frmreserva.class.getName()).log(Level.SEVERE, null, ex);

        }

        return verificar;
    }

    public boolean eliminar(reservation res) {
        boolean verificar = false;

        try {
            out.writeInt(7);
            out.writeInt(2);
            out.writeInt(1);

            int comprovacio = in.readInt();

            if (comprovacio == 1) {
                out.writeBoolean(true);
                boolean senyal = in.readBoolean();
                if (senyal == true) {

                    out.writeInt(res.getIdReserve());
                    System.out.println("Enviem al servidor id reserve: " + res.getIdReserve());

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

    public boolean pagar(reservation res) {
        boolean verificar = false;

        try {
            out.writeInt(7);
            out.writeInt(2);
            out.writeInt(1);

            int comprovacio = in.readInt();

            if (comprovacio == 1) {
                out.writeBoolean(true);
                boolean senyal = in.readBoolean();
                if (senyal == true) {

                    out.writeInt(res.getIdReserve());
                    System.out.println("Enviem al servidor id reserve: " + res.getIdReserve());

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
