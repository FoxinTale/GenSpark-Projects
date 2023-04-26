package org.clientproject.Services;

import org.clientproject.DAO.ClientDAO;
import org.clientproject.Entity.ClientEntity;
import org.clientproject.ServiceInterfaces.ClientServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements ClientServiceInterface {
    private ClientDAO clientDAO;
    private ClientEntity clientEntity;

    @Override
    public List<ClientEntity> getAllClients() {
        return this.clientDAO.findAll();
    }

    @Override
    public ClientEntity getClientByID(int clientID) {
        Optional<ClientEntity> clientList = this.clientDAO.findById(clientID);

        ClientEntity clientEntity = null;

        if(clientList.isPresent()){
            clientEntity = clientList.get();
        } else {
            throw new RuntimeException("There is no Client found for id: " + clientID);
        }

        return clientEntity;
    }

    @Override
    public ClientEntity addClient(ClientEntity client) {
        return this.clientDAO.save(client);
    }

    @Override
    public ClientEntity updateClient(ClientEntity client) {
        return this.clientDAO.save(client);
    }

    @Override
    public String deleteClientByID(int clientID) {
        this.clientDAO.deleteById(clientID);
        return "Client has been deleted";
    }
}
