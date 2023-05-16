import java.util.List;
import java.util.Set;

public interface RoleDAO {
    void addRole (Role role);
    Role getRoleById(int id);
    List<Role> getAllRoles();
    void updateRole(Role role, Role role1);
    void deleteRole(Role role);

}
