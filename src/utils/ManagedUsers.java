/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import formularis.frmuser;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.plaf.RootPaneUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lluís Barbó
 */
public class ManagedUsers {
    
    Socket sc;
    DataInputStream in;
    DataOutputStream out;

    private String id;
    private String name;
    private String lastName;
    private String docType;
    private String numDoc;
    private String address;
    private String phone;
    private String email;
    private String acces;
    private String user;
    private String password;
    private String sex;
    private int access;

    public int getAccess() {
        return access;
    }

    public void setAccess(int access) {
        this.access = access;
    }

    ArrayList<String> usersArray = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAcces() {
        return acces;
    }

    public void setAcces(String acces) {
        this.acces = acces;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public ArrayList<String> getUsersArray() {
        return usersArray;
    }

    public void setUsersArray(ArrayList<String> usersArray) {
        this.usersArray = usersArray;
    }

    // Mètode afegir usuaris
    public boolean addUser() {
          boolean result = false;
          Socket sc;
          

        try {

            sc = new Socket("127.0.0.1", 8000);
            DataInputStream in = new DataInputStream(sc.getInputStream());
            DataOutputStream out = new DataOutputStream(sc.getOutputStream());

            out.writeBoolean(true);

            // Realitzem la crida per afegir l'usuari
            out.writeUTF(id + ",USER_ADD," + name + "," + lastName + "," + docType + "," + numDoc + "," + address + "," + phone + "," + email + "," + access + "," + user + "," + password + "," + sex);

            int response_add = in.readInt();

            if (response_add == 1) {

                result = true;
            }

        } catch (Exception e) {
        }

        return result;

    }
/*
    public void setAcces(int access) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

}
