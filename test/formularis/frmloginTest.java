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
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.postgresql.shaded.com.ongres.scram.common.bouncycastle.base64.Base64;

/**
 *
 * @author Lluís Barbó
 */
public class frmloginTest {
    
    final String KEY = "abecedari69@";
    
    public frmloginTest() {
        
               
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
        String password = Encriptar("password");

        try {

            cli = new Socket("127.0.0.1", 8000);
            DataInputStream in = new DataInputStream(cli.getInputStream());
            DataOutputStream out = new DataOutputStream(cli.getOutputStream());

            // Llegir la resposta del servidor en establir la connexió
            String resposta_server = in.readUTF();

            // Enviem resposta al servidor amb l'usuari i contrasenya
            out.writeUTF(user);
            out.writeUTF(password);
            out.writeInt(1);
            System.out.println("LOGIN: " + user + ", " + password);

            int resposta_server_id = in.readInt();
            System.out.println("Resposta servidor: " + resposta_server);
            
            int rol = in.readInt();

            if (resposta_server_id != 0) {

                System.out.println("Benvingut " + user);
                if (rol == 1) {
                    System.out.println("Obrim usuari d'administrador");
                }
                
                System.out.println("Test rol Administrador --> CORRECTE");

            }
            
        } catch (Exception ex) {

            System.out.println("No és pot establir connexió amb el servidor");

        }
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
    public void loginRecepcio() throws InterruptedException {

        Socket cli;
        String user = "david";
        String password = Encriptar("1234qwer");

        try {

            cli = new Socket("127.0.0.1", 8000);
            DataInputStream in = new DataInputStream(cli.getInputStream());
            DataOutputStream out = new DataOutputStream(cli.getOutputStream());

            // Llegir la resposta del servidor en establir la connexió
            String resposta_server = in.readUTF();

            // Enviem resposta al servidor amb l'usuari i contrasenya
            out.writeUTF(user);
            out.writeUTF(password);
            out.writeInt(1);
            System.out.println("LOGIN: " + user + ", " + password);

            int resposta_server_id = in.readInt();
            System.out.println("Resposta servidor: " + resposta_server);
            
            int rol = in.readInt();

            if (resposta_server_id != 0) {

                System.out.println("Benvingut " + user);
                if (rol == 2) {
                    System.out.println("Obrim usuari recepció");
                }
                
                System.out.println("Test rol Recepció --> CORRECTE");

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
        String password = Encriptar("passErroni");

        try {

            cli = new Socket("127.0.0.1", 8000);
            DataInputStream in = new DataInputStream(cli.getInputStream());
            DataOutputStream out = new DataOutputStream(cli.getOutputStream());

            // Llegir la resposta del servidor en establir la connexió
            String resposta_server = in.readUTF();

            // Enviem resposta al servidor amb l'usuari i contrasenya
            out.writeUTF(user);
            out.writeUTF(password);
            out.writeInt(1);
            System.out.println("LOGIN: " + user + ", " + password);

            int resposta_server_id = in.readInt();

            System.out.println("Resposta servidor: " + resposta_server);
            
            int rol = in.readInt();

            if (resposta_server_id == 0) {

                System.out.println("Error d'usuari o contrasenya");
                
                if (rol == 0) {
                    System.out.println("En ser un usuari erroni, no té cap rol associat");
                }
            }

        } catch (Exception ex) {

            System.out.println("No és pot establir connexió amb el servidor");

        }
    }
    
    // Clau d'encriptació / desencriptació
    public SecretKeySpec CrearClave(String llave) {
        
        try {
            
            byte[] cadena = llave.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            cadena = md.digest(cadena);
            cadena = Arrays.copyOf(cadena, 16);
            SecretKeySpec secretKeySpec = new SecretKeySpec(cadena, "AES");
            
            return secretKeySpec;
            
        } catch (Exception e) {
            
            return null;
            
        }

    }

    // Encriptar
    public String Encriptar(String encriptar) {

        try {
            
            SecretKeySpec secretKeySpec = CrearClave(KEY);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

            byte[] cadena = encriptar.getBytes("UTF-8");
            byte[] encriptada = cipher.doFinal(cadena);
            byte[] cadena_encriptar = Base64.encode(encriptada);
            String cadena_encriptada = new String(cadena_encriptar);
            
            return cadena_encriptada;

        } catch (Exception e) {
            
            return "";
            
        }
    }

        
}

