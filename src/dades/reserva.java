/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dades;

/**
 *
 * @author Lluís Barbó
 */
public class reserva {
    private int idreserva;
    private String name;
    private String lastname;
    private String doctype;
    private String numdoc;
    private String address;
    private String phone;
    private String email;
    private int rol;
    private String user;
    private String password;
    private String sex;
    
    public reserva() {
        
    }
    
    public reserva (int idreserva, String name, String lastname, String doctype, String numdoc, String address, String phone, String email, int rol, String user, String password, String sex){
        this.idreserva = idreserva;
        this.name = name;
        this.lastname = lastname;
        this.doctype = doctype;
        this.numdoc = numdoc;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.rol = rol;
        this.user = user;
        this.password = password;
        this.sex = sex;
        
    }

    public int getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDoctype() {
        return doctype;
    }

    public void setDoctype(String doctype) {
        this.doctype = doctype;
    }

    public String getNumdoc() {
        return numdoc;
    }

    public void setNumdoc(String numdoc) {
        this.numdoc = numdoc;
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

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
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
    
    
    
}
