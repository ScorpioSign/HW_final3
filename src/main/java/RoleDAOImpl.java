import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class RoleDAOImpl implements RoleDAO {
    @Override
    public Role getRoleById(int id) {
        EntityManager entityManager = EntityUtil.create();
        entityManager.getTransaction().begin();
        Role role = entityManager.find(Role.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return role;
    }

    @Override
    public List<Role> getAllRoles() {
        EntityManager entityManager = EntityUtil.create();
        entityManager.getTransaction().begin();
        String jpqlQuery = "SELECT s FROM Role s";
        TypedQuery<Role> query = entityManager.createQuery(jpqlQuery, Role.class);
        List<Role> roleList = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return roleList;
    }


    @Override
    public void updateRole(Role role, Role role1) {
        EntityManager entityManager = EntityUtil.create();
        entityManager.getTransaction().begin();
        entityManager.merge(role1);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("роль №" + role.getRoleId() + " изменена");
    }

    @Override
    public void deleteRole(Role role) {
        EntityManager entityManager = EntityUtil.create();
        entityManager.getTransaction().begin();
        Role role1 = entityManager.find(Role.class, role.getRoleId());
        entityManager.remove(role1);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("роль №" + role.getRoleId() + " удалена");
    }

    @Override
    public void addRole(Role role) {
        EntityManager entityManager = EntityUtil.create();
        entityManager.getTransaction().begin();
        entityManager.persist(role);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("Роль " + role.getRoleName() + " добавлена");

    }
}


