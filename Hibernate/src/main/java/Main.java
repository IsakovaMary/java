import javax.persistence.*;
import java.util.List;

public class Main {

    private static final EntityManagerFactory MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");

    public static void main(String[] args) {
//        item item = new item("Ce!", 25, "Hot");
//        itemService.add(item);
//        itemService.delete(6);
       item item = itemService.getField(3);
        System.out.println("Name: " + item.getName());
    }

//    private static void editItem(int id, int price, String info) {
//        EntityManager entityManager = MANAGER_FACTORY.createEntityManager();
//        EntityTransaction entityTransaction = null;
//
//        item item = null;
//
//        try{
//            entityTransaction = entityManager.getTransaction();
//            entityTransaction.begin();
//
//            item = entityManager.find(item.class, id);
//            item.setInfo(info);
//            item.setPrice(price);
//
//            entityManager.persist(item);
//            entityTransaction.commit();
//
//        }catch (Exception ex){
//            if(entityTransaction != null)
//                entityTransaction.rollback();
//
//            ex.printStackTrace();
//        }finally {
//            entityManager.close();
//        }
//    }
//
//    public static void deleteItem(int id){
//        EntityManager entityManager = MANAGER_FACTORY.createEntityManager();
//        EntityTransaction entityTransaction = null;
//
//        item item = null;
//        try{
//            entityTransaction = entityManager.getTransaction();
//            entityTransaction.begin();
//
//            item = entityManager.find(item.class, id);
//            entityManager.remove(item);
//            entityTransaction.commit();
//
//    }catch (Exception ex){
//        if(entityTransaction != null)
//            entityTransaction.rollback();
//
//            ex.printStackTrace();
//    }finally {
//        entityManager.close();
//    }
//    }
//
//    public static void getItems(){
//        EntityManager entityManager = MANAGER_FACTORY.createEntityManager();
//        String query = "SELECT i FROM item i WHERE i.id > :id1 AND i.id < :id2";
//
//        TypedQuery<item> typedQuery = entityManager.createQuery(query, item.class);
//        typedQuery.setParameter("id1", 1);
//        typedQuery.setParameter("id2", 4);
//
//        List<item> items;
//        try{
//            items = typedQuery.getResultList();
//             for(item item : items)
//                 System.out.println("Name: " + item.getName() + ", price: "
//                         + item.getPrice() + ", info: " + item.getInfo());
//        } catch (Exception ex){
//            ex.printStackTrace();
//
//        }  finally {entityManager.close();
//        }
//    }
//
//    public static void getItem(int id) {
//        EntityManager entityManager = MANAGER_FACTORY.createEntityManager();
//        String query = "SELECT i FROM item i WHERE i.id = :id1";
//
//        TypedQuery<item> typedQuery = entityManager.createQuery(query, item.class);
//        typedQuery.setParameter("id1", id);
//        item item = null;
//
//        try{
//            item = typedQuery.getSingleResult();
//                System.out.println("Name: " + item.getName() + ", price: "
//                        + item.getPrice() + ", info: " + item.getInfo());
//        } catch (Exception ex){
//            ex.printStackTrace();
//
//        }  finally {entityManager.close();
//        }
//    }
//
//    public static void addItems(String name, int price, String info){
//        EntityManager entityManager = MANAGER_FACTORY.createEntityManager();
//
//        EntityTransaction entityTransaction = null;
//
//        try {
//            entityTransaction = entityManager.getTransaction();
//            entityTransaction.begin();
//
//            item item = new item(name, price, info);
//            entityManager.persist(item);
//            entityTransaction.commit();
//        } catch (Exception e){
//            if(entityTransaction != null)
//                entityTransaction.rollback();
//            e.printStackTrace();
//        }finally {
//            entityManager.close();
//        }
//    }
}
