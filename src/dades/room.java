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
public class room {
    private int idroom;
    private String name;
    private int marriedbed;
    private int bed;
    private String ratecode;
    private boolean wifi;
    private boolean air;
    private boolean jacuzzi;
    
    
    public room() {
        
    }
    
    public room(int idroom, String name, int marriedbed, int bed, String ratecode, boolean wifi, boolean air, boolean jacuzzi){
        this.idroom = idroom;
        this.name = name;
        this.marriedbed = marriedbed;
        this.bed = bed;
        this.ratecode = ratecode;
        this.wifi = wifi;
        this.air = air;
        this.jacuzzi = jacuzzi;
        
    }

    public int getIdroom() {
        return idroom;
    }

    public void setIdroom(int idroom) {
        this.idroom = idroom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarriedbed() {
        return marriedbed;
    }

    public void setMarriedbed(int marriedbed) {
        this.marriedbed = marriedbed;
    }

    public int getBed() {
        return bed;
    }

    public void setBed(int bed) {
        this.bed = bed;
    }

    public String getRatecode() {
        return ratecode;
    }

    public void setRatecode(String ratecode) {
        this.ratecode = ratecode;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public boolean isAir() {
        return air;
    }

    public void setAir(boolean air) {
        this.air = air;
    }

    public boolean isJacuzzi() {
        return jacuzzi;
    }

    public void setJacuzzi(boolean jacuzzi) {
        this.jacuzzi = jacuzzi;
    }

    
    
}
