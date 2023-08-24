package tn.esprit.services;

import java.util.List;

import tn.esprit.entities.Client;

public interface ClientService {

	List<Client> retrieveAllClients();

	Client addClient (Client a);

	void deleteClient (Long id);

	Client updateClient (Client a);

	Client retrieveClient (Long id);
	
	Client retrieveConnectedClient();

}
