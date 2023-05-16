import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class EntityUtil {
    public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
    public static EntityManager create(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager;
    }
    public static void closeEntityManagerFactory(){
        entityManagerFactory.close();
    }
}
