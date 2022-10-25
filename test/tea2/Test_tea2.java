/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tea2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.Socket;

/**
 *
 * @author Lluís Barbó
 */
public class Test_tea2 {

    private static int resposta_server_id;

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Test TEA2 - ACCESOS al servidor: \n");

        // Test login usuari administrador
        loginAdministrador("lluis", "daniel");
        logout("lluis", "daniel", String.valueOf(resposta_server_id));

        System.out.println("");

        System.out.println("Test TEA2 - ACCESOS al servidor: \n");

        // Test login usuari erroni
        loginErroni("userErroni", "passErroni");

        System.out.println("");

    }

    /**
     * Fem el Login amb l'usuari administrador passant per paràmetre les dades
     * necessaries
     *
     * @param user
     * @param password
     * @throws InterruptedException
     */
    public static void loginAdministrador(String user, String password) throws InterruptedException {

        Socket cli;

        try {

            cli = new Socket("127.0.0.1", 8000);
            DataInputStream in = new DataInputStream(cli.getInputStream());
            DataOutputStream out = new DataOutputStream(cli.getOutputStream());

            // Llegir la resposta del servidor en establir la connexió
            String resposta_server = in.readUTF();

            // Enviem resposta al servidor amb l'usuari i contrasenya
            out.writeUTF(user);
            out.writeUTF(password);
            out.writeBoolean(true);
            System.out.println("LOGIN: " + user + ", " + password);

            int resposta_server_id = in.readInt();
            System.out.println("Resposta servidor: " + resposta_server);

            if (resposta_server_id != 0) {

                System.out.println("Benvingut " + user);
                System.out.println("Obrim client d'administrador");
                System.out.println("Test Administrador --> CORRECTE");

            }

        } catch (Exception ex) {

            System.out.println("No és pot establir connexió amb el servidor");

        }
    }

    /**
     * Fem el Login amb usuari erroni passant per paràmetre les dades
     *
     * @param user
     * @param password
     * @throws InterruptedException
     */
    public static void loginErroni(String user, String password) throws InterruptedException {

        Socket cli;

        try {

            cli = new Socket("127.0.0.1", 8000);
            DataInputStream in = new DataInputStream(cli.getInputStream());
            DataOutputStream out = new DataOutputStream(cli.getOutputStream());

            // Llegir la resposta del servidor en establir la connexió
            String resposta_server = in.readUTF();

            // Enviem resposta al servidor amb l'usuari i contrasenya
            out.writeUTF(user);
            out.writeUTF(password);
            out.writeBoolean(true);
            System.out.println("LOGIN: " + user + ", " + password);

            int resposta_server_id = in.readInt();

            System.out.println("Resposta servidor: " + resposta_server);

            if (resposta_server_id == 0) {

                System.out.println("Error d'usuari o contrasenya");

            }

        } catch (Exception ex) {

            System.out.println("No és pot establir connexió amb el servidor");

        }
    }

    /**
     * Realitzem el logout d'un user pasat per paràmetre
     *
     * @param user
     * @param password
     * @param id
     */
    public static void logout(String user, String password, String id) {

        Socket cli;
        System.out.println("Logout usuari: " + user);

        try {

            cli = new Socket("127.0.0.1", 8000);
            DataInputStream in = new DataInputStream(cli.getInputStream());
            DataOutputStream out = new DataOutputStream(cli.getOutputStream());

            // Llegir la resposta del servidor en establir connexió
            String resposta_svr = in.readUTF();

            // Enviem resposta al servidor amb l'usuari i contrasenya
            out.writeUTF("LOGIN," + user + "," + password + "," + id);

            //Executo la consulta de la crida per sortir
            out.writeUTF("USER_EXIT");
            System.out.println("Logout CORRECTE");

        } catch (IOException ex) {
            Logger.getLogger(Test_tea2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
