import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class ClientDAOImpl implements ClientDAO {
    @Override
    public List<Client> getAllClients() {
        EntityManager entityManager = EntityUtil.create();
        entityManager.getTransaction().begin();
        String jpqlQuery = "SELECT s FROM Client s";
        TypedQuery<Client> query = entityManager.createQuery(jpqlQuery, Client.class);
        List<Client> clients = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return clients;
    }

    @Override
    public Client getClientById(int id) {
        EntityManager entityManager = EntityUtil.create();
        entityManager.getTransaction().begin();
        Client client = entityManager.find(Client.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return client;
    }

    @Override
    public Set<Client> getClientsByRole(Role role) {

        return role.getClients();
    }

    @Override
    public void addClient(Client client) {
        EntityManager entityManager = EntityUtil.create();
        entityManager.getTransaction().begin();
        entityManager.persist(client);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("Сотрудник добавлен");

    }

    @Override
    public void updateClient(int id, Client clientNew) {
        EntityManager entityManager = EntityUtil.create();
        entityManager.getTransaction().begin();
        Client clientUpd = entityManager.find(Client.class, id);
        clientUpd.setName(clientNew.getName());
        clientUpd.setLogin(clientNew.getLogin());
        clientUpd.setPassword(clientNew.getPassword());
        clientUpd.setModificationDateTime(LocalDateTime.now());

        entityManager.merge(clientUpd);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("Данные сотрудника ID " + clientUpd.getId() + " обновлены");

    }

    @Override
    public void deleteClient(Client client) {
        EntityManager entityManager = EntityUtil.create();
        entityManager.getTransaction().begin();
        Client client1 = entityManager.find(Client.class, client.getId());
        entityManager.remove(client1);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("пользователь №" + client.getId() + " удален");
    }







    }


