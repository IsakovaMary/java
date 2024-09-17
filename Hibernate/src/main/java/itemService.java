import java.util.List;

public class itemService {

    private static final itemDAO _itemDAO = new itemDAO();

    public static int add(item item) {
        return _itemDAO.add(item);
    }

    public static void edit(int id, item item) {
        _itemDAO.edit(id, item);
    }

    public static void delete(int id) {
        _itemDAO.delete(id);
    }

    public static List<item> getAll() {
        return _itemDAO.getAll();
    }

    public static item getField(int id) {
        return _itemDAO.getField(id);
    }
}
