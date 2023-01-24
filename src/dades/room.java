package dades;

/**
 *
 * @author Lluís Barbó
 */
public class room {
    private int idroom;
    private String name;
    private int number;
    private int marriedbed;
    private int bed;
    private String state;
    private boolean wifi;
    private boolean air;
    private boolean jacuzzi;
    private double dayprice;
    
    
    public room() {
        
    }
    
    public room(int idroom, String name, int number, int marriedbed, int bed, String state, boolean wifi, boolean air, boolean jacuzzi, double dayprice){
        this.idroom = idroom;
        this.name = name;
        this.number = number;
        this.marriedbed = marriedbed;
        this.bed = bed;
        this.state = state;
        this.wifi = wifi;
        this.air = air;
        this.jacuzzi = jacuzzi;
        this.dayprice = dayprice;
        
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public double getDayprice() {
        return dayprice;
    }

    public void setDayprice(double dayprice) {
        this.dayprice = dayprice;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    
    
}
