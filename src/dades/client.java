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
public class client {
    private int idclient;
    private String name;
    private String lastname;
    private String email;
    private String doctype;
    private String numdoc;
    private String address;
    private String municipality;
    private String province;
    private String nacionality;
    private String phone;
    private String iban;
    private int postalcode;
    
    public client() {
        
    }
    
    public client(int idclient, String name, String lastname, String email, String doctype, String numdocument, String address, String municipality, String province, String nacionality, String phone, String iban, int postalcode){
        this.idclient = idclient;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.doctype = doctype;
        this.numdoc = numdocument;
        this.address = address;
        this.municipality = municipality;
        this.province = province;
        this.nacionality = nacionality;
        this.phone = phone;
        this.iban = iban;
        this.postalcode = postalcode;
    }

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getNacionality() {
        return nacionality;
    }

    public void setNacionality(String nacionality) {
        this.nacionality = nacionality;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public int getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(int postalcode) {
        this.postalcode = postalcode;
    }
    
    
    
}
