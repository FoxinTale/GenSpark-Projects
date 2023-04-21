package org.clientproject.ServiceInterfaces;

import org.clientproject.Entity.ClientEntity;

import java.util.List;

public interface ClientServiceInterface {
    List<ClientEntity> getAllClients();

    ClientEntity getClientByID(int clientID);

    ClientEntity addClient(ClientEntity client);

    ClientEntity updateClient(ClientEntity client);

    String deleteClientByID(int clientID);

}
