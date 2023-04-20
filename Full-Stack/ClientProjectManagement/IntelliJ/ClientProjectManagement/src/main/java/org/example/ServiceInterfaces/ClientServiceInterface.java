package org.example.ServiceInterfaces;

import org.example.Entity.ClientEntity;

import java.util.List;

public interface ClientServiceInterface {
    List<ClientEntity> getAllClients();

    ClientEntity getClientByID(int clientID);

    ClientEntity addClient(ClientEntity client);

    ClientEntity updateClient(ClientEntity client);

    ClientEntity deleteClientByID(int clientID);

}
