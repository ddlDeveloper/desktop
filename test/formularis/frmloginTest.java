/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularis;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author Lluís Barbó
 */
public class frmloginTest {
    
    public frmloginTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSomeMethod() throws InterruptedException {
        // TODO review the generated test code and remove the default call to fail.
                
    }
    
    /**
     * Fem el Login amb l'usuari administrador passant per paràmetre les dades
     * necessaries
     *
     * @param user
     * @param password
     * @throws InterruptedException
     */
    @Test
    public void loginAdministrador() throws InterruptedException {

        Socket cli;
        String user = "lluis";
        String password = "password";

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
    
    //Preparat per comprovar que no ha de donar accés amb usari o passsword erroni
    
    /**
     * Fem el Login amb usuari erroni passant per paràmetre les dades
     *
     * @param user
     * @param password
     * @throws InterruptedException
     */
    
    
    @Test
    public void loginErroni() throws InterruptedException {

        Socket cli;
        String user = "userErroni";
        String password = "passErroni";

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

        
}
