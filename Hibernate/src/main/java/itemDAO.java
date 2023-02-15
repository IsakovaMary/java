import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class itemDAO {
    private static final EntityManagerFactory MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");

    @PersistenceContext
    private EntityManager entityManager;

    public int add(item item){
        entityManager = MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(item);
        entityTransaction.commit();

        return item.getId();
    }

    public void edit(int id, item item){
        entityManager = MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        item newItem = entityManager.find(item.class, id);
        newItem.setPrice(item.getPrice());
        newItem.setInfo(item.getInfo());
        newItem.setName(item.getName());

        entityManager.persist(newItem);
        entityTransaction.commit();
    }

    public void delete(int id){
        entityManager = MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        item item = entityManager.find(item.class, id);

        entityManager.remove(item);
        entityTransaction.commit();
    }

    public List<item> getAll(){
        EntityManager entityManager = MANAGER_FACTORY.createEntityManager();
        String query = "SELECT i FROM item i";

        TypedQuery<item> typedQuery = entityManager.createQuery(query, item.class);
        List<item> items = typedQuery.getResultList();

        return items;
    }

    public item getField(int id){
        EntityManager entityManager = MANAGER_FACTORY.createEntityManager();
        String query = "SELECT i FROM item i WHERE i.id = :id1";

        TypedQuery<item> typedQuery = entityManager.createQuery(query, item.class);
        typedQuery.setParameter("id1", id);
        item item = typedQuery.getSingleResult();

        return item;
    }

}
