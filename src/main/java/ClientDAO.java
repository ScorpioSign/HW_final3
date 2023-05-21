import java.util.List;
import java.util.Set;

public interface ClientDAO {
    List<Client> getAllClients();

    Client getClientById(int id);

    Set<Client> getClientsByRole(Role role);

    void addClient(Client client);

    void updateClient(int id, Client client1);

    void deleteClient(Client client);


}
