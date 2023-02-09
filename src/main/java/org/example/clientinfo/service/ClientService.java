package org.example.clientinfo.service;

import org.example.clientinfo.entity.Client;

import java.util.List;

public interface ClientService {
    Client saveClient(Client client);

    List<Client> getAll();

    List<Client> getClientByRequestParam(String requestParam);
}
