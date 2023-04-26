package org.clientproject.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "clients")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int clientID;
    private String clientName;
    private String clientOrg;

    public ClientEntity(int clientID, String clientName, String clientOrg) {
        this.clientID = clientID;
        this.clientName = clientName;
        this.clientOrg = clientOrg;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientOrg() {
        return clientOrg;
    }

    public void setClientOrg(String clientOrg) {
        this.clientOrg = clientOrg;
    }
}
