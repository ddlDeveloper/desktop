/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Lluís Barbó
 */
public class SystemUtils {
    public static final String AES = "AES/GCM/NoPadding";
    private static final int GCM_IV_LENGTH = 12;
    private static final int GCM_TAG_LENGTH = 16;
    private static final boolean ACTIVAR_ENCRIPTACIO = true;
    
    /**
     *
     * @param clientPublicKeyUTF
     * @return
     * @throws IOException
     */
    public static String clausServer(String clientPublicKeyUTF) throws IOException {

        BigInteger base = new BigInteger("2");
        BigInteger prime = new BigInteger("1468523489461321548621584916755822478963");
        BigInteger secret = new BigInteger(128, new Random());
        BigInteger public_key = base.modPow(secret, prime);
        BigInteger client_public_key = new BigInteger(clientPublicKeyUTF);
        BigInteger shared_secret = client_public_key.modPow(secret, prime);

        while (secret.toByteArray().length != 16
                || public_key.toByteArray().length != 16
                || shared_secret.toByteArray().length != 16) {

            secret = new BigInteger(128, new Random());
            public_key = base.modPow(secret, prime);
            shared_secret = client_public_key.modPow(secret, prime);
            System.out.println("Secret: " + secret.toByteArray().length);
            System.out.println("Public: " + public_key.toByteArray().length);
            System.out.println("Shared: " + shared_secret.toByteArray().length);

        }
        
        String claus_publica_share_server = String.valueOf(public_key) + "," + String.valueOf(shared_secret);
        
        return claus_publica_share_server;

    }

    public static String clauPublicaClient() throws IOException {

        //Enviaem la clau publica del client
        BigInteger base = new BigInteger("2");
        BigInteger prime = new BigInteger("1468523489461321548621584916755822478963");
        BigInteger secret = new BigInteger(128, new Random());
        BigInteger public_key = base.modPow(secret, prime);

        while (secret.toByteArray().length != 16 || public_key.toByteArray().length != 16) {

            secret = new BigInteger(128, new Random());
            public_key = base.modPow(secret, prime);
            System.out.println("Secret: " + secret.toByteArray().length);
            System.out.println("Public: " + public_key.toByteArray().length);

        }

        String clau_publica_client_secret = String.valueOf(public_key) + "," + String.valueOf(secret);

        return clau_publica_client_secret;
    }

    public static BigInteger calculClauCompartida(String publicKeyServer, String secretString) throws IOException {

        BigInteger prime = new BigInteger("1468523489461321548621584916755822478963");
        BigInteger secret = new BigInteger(secretString);

        BigInteger server_public_key = new BigInteger(publicKeyServer);
        System.out.println("Valor server_public_key part client rebuda del servidor: " + server_public_key);

        BigInteger shared_secret = server_public_key.modPow(secret, prime);

        System.out.println("Server public key : " + server_public_key);
        System.out.println("Shared secret     : " + shared_secret);

        return shared_secret;
    }
    
    /**
     * Aquest mètode l static que genera un número aleatori entre un interval
     * definit en els paràmetres d'entrada s'utilitza per genera el id_sessio al
     * fer el login
     *
     * @param minim enter positiu més petit que el parametre maxim.
     * @param maxim enter positiu més gran que el parametre minim.
     * @return un mumero enter aleatori que està entre el valor minim i el maxim
     */
    public static int generaNumAleatorio(int minim, int maxim) {
        int num = (int) Math.floor((Math.random() * (maxim - minim + 1) + (minim)));
        return num;
    }

    /**
     * Aquest mètode és l'encarregat d'encriptar la contrasenya aplicant SHA-256
     * de la contrasenya original i ser guardada en aquest format a la Bd's
     *
     * @param password la contrasenya en texta pla introduida a la hora de fer
     * l'alta d'un nou usuari
     * @return de la contrasenya del resultat de SHA-256
     */
    public static String convertirSHA256(String password) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }

        byte[] hash = md.digest(password.getBytes());
        StringBuffer sb = new StringBuffer();

        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }

        return sb.toString();
    }

    /**
     *
     * @param pText
     * @param key
     * @return
     */
    public static String encryptedText(String pText, byte[] key) {

        if (ACTIVAR_ENCRIPTACIO) {

            try {
                byte[] iv = new byte[GCM_IV_LENGTH];
                (new SecureRandom()).nextBytes(iv);

                Cipher cipher = Cipher.getInstance(AES);
                GCMParameterSpec ivSpec = new GCMParameterSpec(GCM_TAG_LENGTH * Byte.SIZE, iv);
                cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, "AES"), ivSpec);

                byte[] cipherText = cipher.doFinal(pText.getBytes(StandardCharsets.UTF_8));
                byte[] encrypted = new byte[iv.length + cipherText.length];
                System.arraycopy(iv, 0, encrypted, 0, iv.length);
                System.arraycopy(cipherText, 0, encrypted, iv.length, cipherText.length);

                return Base64.getEncoder().encodeToString(encrypted);
            } catch (InvalidAlgorithmParameterException | NoSuchPaddingException | IllegalBlockSizeException
                    | NoSuchAlgorithmException | BadPaddingException | InvalidKeyException e) {
                throw new RuntimeException(e);
            }
        } else {
            return pText;
        }
    }

    /**
     *
     * @param pTextEncrypted
     * @param key
     * @return
     */
    public static String decryptedText(String pTextEncrypted, byte[] key) {

        if (ACTIVAR_ENCRIPTACIO) {
            try {

                byte[] decoded = Base64.getDecoder().decode(pTextEncrypted);

                byte[] iv = Arrays.copyOfRange(decoded, 0, GCM_IV_LENGTH);

                Cipher cipher = Cipher.getInstance(AES);
                GCMParameterSpec ivSpec = new GCMParameterSpec(GCM_TAG_LENGTH * Byte.SIZE, iv);
                cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, "AES"), ivSpec);

                byte[] cipherText = cipher.doFinal(decoded, GCM_IV_LENGTH, decoded.length - GCM_IV_LENGTH);

                return new String(cipherText, StandardCharsets.UTF_8);
            } catch (InvalidAlgorithmParameterException | NoSuchPaddingException | IllegalBlockSizeException
                    | NoSuchAlgorithmException | BadPaddingException | InvalidKeyException e) {
                throw new RuntimeException(e);
            }
        } else {
            return pTextEncrypted;
        }
    }

        
}
