package logica;

import dades.reservation;
import formularis.frmreserva;
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
            //Cálcul clau pública client
            String[] claus_ps = SystemUtils.clauPublicaClient().split(",");
            //Enviem la clau pública del client al servidor
            out.writeUTF(String.valueOf(claus_ps[0]));
            //llegim la clau pública del servidor
            BigInteger shared_secret = SystemUtils.calculClauCompartida(in.readUTF(), claus_ps[1]);
            //Executo la consulta de la crida per sortir
            out.writeUTF(SystemUtils.encryptedText(String.valueOf(7), shared_secret.toByteArray()));
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
                    String[] nameColumns = {"ID", "IDRoom", "NumberRoom", "IDClient", "Client", "IDEmployed", "Employed", "TypeReserve", "DateReservation", "DateAdmission", "DateDeparture", "Pryce", "Estate"};
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

    public boolean insertar(reservation res) {
        boolean verificar = false;

        try {
            //Cálcul clau pública client
            String[] claus_ps = SystemUtils.clauPublicaClient().split(",");
            //Enviem la clau pública del client al servidor
            out.writeUTF(String.valueOf(claus_ps[0]));
            //llegim la clau pública del servidor
            BigInteger shared_secret = SystemUtils.calculClauCompartida(in.readUTF(), claus_ps[1]);
            //Executo la consulta de la crida per sortir
            out.writeUTF(SystemUtils.encryptedText(String.valueOf(7), shared_secret.toByteArray()));
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
                                        
                    out.writeUTF(SystemUtils.encryptedText(String.valueOf(res.getIdRoom()), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(String.valueOf(res.getIdClient()), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(String.valueOf(res.getIdEmployed()), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(res.getTypeReserve(), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(String.valueOf(res.getDateReservation()), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(String.valueOf(res.getDateAdmission()), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(String.valueOf(res.getDateDeparture()), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(String.valueOf(res.getPryce()), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(res.getState(), shared_secret.toByteArray()));
                    
                    String correcte = SystemUtils.decryptedText(in.readUTF(), shared_secret.toByteArray());
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
            //Cálcul clau pública client
            String[] claus_ps = SystemUtils.clauPublicaClient().split(",");
            //Enviem la clau pública del client al servidor
            out.writeUTF(String.valueOf(claus_ps[0]));
            //llegim la clau pública del servidor
            BigInteger shared_secret = SystemUtils.calculClauCompartida(in.readUTF(), claus_ps[1]);
            //Executo la consulta de la crida per sortir
            out.writeUTF(SystemUtils.encryptedText(String.valueOf(7), shared_secret.toByteArray()));
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

                    out.writeUTF(SystemUtils.encryptedText(String.valueOf(res.getIdRoom()), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(String.valueOf(res.getIdClient()), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(String.valueOf(res.getIdEmployed()), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(res.getTypeReserve(), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(String.valueOf(res.getDateReservation()), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(String.valueOf(res.getDateAdmission()), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(String.valueOf(res.getDateDeparture()), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(String.valueOf(res.getPryce()), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(res.getState(), shared_secret.toByteArray()));
                    out.writeUTF(SystemUtils.encryptedText(String.valueOf(res.getIdReserve()), shared_secret.toByteArray()));
                    
                    String correcte = SystemUtils.decryptedText(in.readUTF(), shared_secret.toByteArray());
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
            //Cálcul clau pública client
            String[] claus_ps = SystemUtils.clauPublicaClient().split(",");
            //Enviem la clau pública del client al servidor
            out.writeUTF(String.valueOf(claus_ps[0]));
            //llegim la clau pública del servidor
            BigInteger shared_secret = SystemUtils.calculClauCompartida(in.readUTF(), claus_ps[1]);
            //Executo la consulta de la crida per sortir
            out.writeUTF(SystemUtils.encryptedText(String.valueOf(7), shared_secret.toByteArray()));
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

                    out.writeUTF(SystemUtils.encryptedText(String.valueOf(res.getIdReserve()), shared_secret.toByteArray()));
                    System.out.println("Enviem al servidor id reserve: " + res.getIdReserve());

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

    public boolean pagar(reservation res) {
        boolean verificar = false;

        try {
            //Cálcul clau pública client
            String[] claus_ps = SystemUtils.clauPublicaClient().split(",");
            //Enviem la clau pública del client al servidor
            out.writeUTF(String.valueOf(claus_ps[0]));
            //llegim la clau pública del servidor
            BigInteger shared_secret = SystemUtils.calculClauCompartida(in.readUTF(), claus_ps[1]);
            //Executo la consulta de la crida per sortir
            out.writeUTF(SystemUtils.encryptedText(String.valueOf(7), shared_secret.toByteArray()));
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

                    out.writeUTF(SystemUtils.encryptedText(String.valueOf(res.getIdReserve()), shared_secret.toByteArray()));
                    System.out.println("Enviem al servidor id reserve: " + res.getIdReserve());

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
