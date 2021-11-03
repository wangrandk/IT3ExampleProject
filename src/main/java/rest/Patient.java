package rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Patient {
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
