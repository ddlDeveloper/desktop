/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connexions;

import formularis.LoginForm;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Dapau69
 */
public class ConnexioSQL {

    //Login init = new Login();
    public static Connection conectar = null;

    public static String url = "jdbc:postgresql://192.168.1.134/javadb";
    public static String user = "admin";
    public static String passwd = "password";
    public static String clase = "org.postgresql.Driver";

    public static Connection establirConexio() {
        try {
            Class.forName(clase);
            conectar = DriverManager.getConnection(url, user, passwd);
            System.out.println("Connexió establerta a la base de dades");
            //JOptionPane.showMessageDialog(null, "Connexió establerta a la base de dades");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar amb la base de dades " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }

        return conectar;
    }

}
