package rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Patient {
    public String name;
    public String Cpr;
    public String password;

    public String getName() {
        return name;
    }
    public String getCpr() {
        return Cpr;
    }
    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setCpr(String Cpr) {
        this.Cpr = Cpr;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
