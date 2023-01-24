package dades;

import java.util.Date;

/**
 *
 * @author Lluís Barbó
 */
public class reservation {
    
    private int idReserve;
    private int idRoom;
    private int idClient;
    private int idEmployed;
    private String typeReserve;
    private Date dateReservation;
    private Date dateAdmission;
    private Date dateDeparture;
    private Double pryce;
    private String state;
    
    public reservation() {
        
    }
    
    public reservation(int idReserve, int idRoom, int idClient, int idEmployed, String typeRerve, Date dateReservation, Date dateAdmission, Date dateDaparture, Double pryce, String state) {
        this.idReserve = idReserve;
        this.idRoom = idRoom;
        this.idClient = idClient;
        this.idEmployed = idEmployed;
        this.typeReserve = typeRerve;
        this.dateReservation = dateReservation;
        this.dateAdmission = dateAdmission;
        this.dateDeparture = dateDaparture;
        this.pryce = pryce;
        this.state = state;
    }

    public int getIdReserve() {
        return idReserve;
    }

    public void setIdReserve(int idReserve) {
        this.idReserve = idReserve;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdEmployed() {
        return idEmployed;
    }

    public void setIdEmployed(int idEmployed) {
        this.idEmployed = idEmployed;
    }

    public String getTypeReserve() {
        return typeReserve;
    }

    public void setTypeReserve(String typeReserve) {
        this.typeReserve = typeReserve;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    public Date getDateAdmission() {
        return dateAdmission;
    }

    public void setDateAdmission(Date dateAdmission) {
        this.dateAdmission = dateAdmission;
    }

    public Date getDateDeparture() {
        return dateDeparture;
    }

    public void setDateDeparture(Date dateDeparture) {
        this.dateDeparture = dateDeparture;
    }

    public Double getPryce() {
        return pryce;
    }

    public void setPryce(Double pryce) {
        this.pryce = pryce;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

        
    
}
