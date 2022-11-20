package config.servingwebcontent.domain;

import org.springframework.data.annotation.Id;

public class Customer {

    @Id
    private Integer ID;
    private String document;
    private String name;
    private String lastName;
    private String adrress;

    public Customer(Integer ID, String document, String name, String lastName, String adrress) {
        this.ID = ID;
        this.document = document;
        this.name = name;
        this.lastName = lastName;
        this.adrress = adrress;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
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

    public String getAdrress() {
        return adrress;
    }

    public void setAdrress(String adrress) {
        this.adrress = adrress;
    }
}
