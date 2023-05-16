
import java.util.List;
import java.util.Set;

public class Application {

    public static void main(String[] args) {
        ClientDAO clientDAO = new ClientDAOImpl();
        RoleDAO roleDAO = new RoleDAOImpl();

        Client client = new Client("Ivan", "Ivan1", "123");
        Client client1 = new Client("Max", "Max1", "234");
        Client client2 = new Client("Alex", "Alex1", "345");
        Client client3 = new Client("John", "John1", "456");
        Client client4 = new Client("Ann", "Ann1", "567");
        Client client5 = new Client("Nataly", "Nataly1", "678");
        Client client6 = new Client("Jane", "Jane1", "789");
        Client client7 = new Client("Emily", "Emily1", "891");

        roleDAO.addRole(new Role("developer"));
        roleDAO.addRole(new Role("analyst"));
        roleDAO.addRole(new Role("tester"));
        roleDAO.addRole(new Role("manager"));
        roleDAO.addRole(new Role("designer"));
        roleDAO.addRole(new Role("default"));


        client.setRoles(Set.of(roleDAO.getRoleById(1)));
        client1.setRoles(Set.of(roleDAO.getRoleById(22), roleDAO.getRoleById(2)));
        client2.setRoles(Set.of(roleDAO.getRoleById(1), roleDAO.getRoleById(3)));
        client3.setRoles(Set.of(roleDAO.getRoleById(3), roleDAO.getRoleById(4)));
        client4.setRoles(Set.of(roleDAO.getRoleById(5), roleDAO.getRoleById(6)));
        client5.setRoles(Set.of(roleDAO.getRoleById(7)));
        client6.setRoles(Set.of(roleDAO.getRoleById(6), roleDAO.getRoleById(3)));
        client7.setRoles(Set.of(roleDAO.getRoleById(5), roleDAO.getRoleById(2)));


        //Добавлять нового пользователя с ролями в БД;
        clientDAO.addClient(client);
        clientDAO.addClient(client1);
        clientDAO.addClient(client2);
        clientDAO.addClient(client3);
        clientDAO.addClient(client4);
        clientDAO.addClient(client5);
        clientDAO.addClient(client6);
        clientDAO.addClient(client7);


        System.out.println(roleDAO.getAllRoles());


        // Получать список пользователей из БД (без ролей);
        printClients(clientDAO.getAllClients());


        //Получать конкретного пользователя (с его ролями) из БД;
        System.out.println(clientDAO.getClientById(19));

        //Получать список пользователей по конкретной роли;
        System.out.println((clientDAO.getClientsByRole(roleDAO.getRoleById(3))));


        //Удалять пользователя в БД;
        clientDAO.deleteClient(clientDAO.getClientById(11));

        //Редактировать существующего пользователя в БД.
        clientDAO.updateClient(23, new Client("Nick", "Nick1", "552"));


        EntityUtil.closeEntityManagerFactory();

    }

    public static void printClients(List<Client> clients) {
        for (Client client : clients) {
            System.out.println("Пользователь ID " + client.getId() + " " + client.getName() + ", логин: " + client.getLogin() + ", пароль: " + client.getPassword());
        }
    }

}