package dades;

/**
 *
 * @author Lluís Barbó
 */
public class usuari {
    private int iduser;
    private String user;
    private String password;
    private String name;
    private String lastname;
    private String email;
    private String doctype;
    private String numdoc;
    private String address;
    private String phone;
    private String sex;
    private int rol;
    
    public usuari() {
        
    }
    
    public usuari(int iduser, String user, String password, String name, String lastname, String email, String doctype, String numdoc, String address, String phone, String sex, int rol) {
        this.iduser = iduser;
        this.user = user;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.doctype = doctype;
        this.numdoc = numdoc;
        this.address = address;
        this.phone = phone;
        this.sex = sex;
        this.rol = rol;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }
    
    
    
}
