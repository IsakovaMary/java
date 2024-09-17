package dz4;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DB_dz4 {
    private final String HOST = "localhost";
    private final String PORT = "3306";
    private final String DB_NAME = "dz_4";
    private final String LOGIN = "root";
    private final String PASS = "root";

    private Connection dbConn = null;

    private Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connStr = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME ;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConn = DriverManager.getConnection(connStr, LOGIN, PASS);
        return dbConn;
    }

    public void isConnected() throws SQLException, ClassNotFoundException {
        dbConn = getDbConnection();
        System.out.println(dbConn.isValid(1000));
    }

    public void setOrders(String orders) throws SQLException, ClassNotFoundException {
        String sql = " SELECT `id` FROM `users` WHERE `login` = ? LIMIT 1";
        PreparedStatement prUsers = getDbConnection().prepareStatement(sql);
        prUsers.setString(1, "john");
        ResultSet resUsers = prUsers.executeQuery();

        int user_id = 0;
        while (resUsers.next())
            user_id = resUsers.getInt("id");

        sql = "SELECT `id` FROM `items` WHERE `category` = ?";
        PreparedStatement prTovar = getDbConnection().prepareStatement(sql);
        prTovar.setString(1, "hats");
        ResultSet resTovar = prTovar.executeQuery();

//        List<Integer> arr_items_id = new ArrayList<>();
//
//        while (resTovar.next())
//            arr_items_id.add(resTovar.getInt("id"));
//        for(int item_id: arr_items_id){
//            sql = "INSERT INTO `orders` (user_id, item_id) VALUES (?,?)";
//            PreparedStatement prOrders = getDbConnection().prepareStatement(sql);
//            prOrders.setInt(1,user_id);
//            prOrders.setInt(2, item_id);
//            prOrders.executeUpdate();
//        }

        sql = "SELECT * FROM `orders`";
        Statement statement = getDbConnection().createStatement();
        ResultSet result = statement.executeQuery(sql);

        System.out.println("Все заказы\n");

        // Далее выводим их, плюс получаем соответствующие записи из других таблиц
        String user_id2 = null;
        String item_id2 = null;
        String item_id3 = null;
        while (result.next()) {
            // Получаем имя пользователя
            sql = "SELECT `login` FROM `users` WHERE `id` = '1' LIMIT 1";
            PreparedStatement prUsers1 = getDbConnection().prepareStatement(sql);
            ResultSet resUsers1 = prUsers1.executeQuery();

            while (resUsers1.next()) {
                user_id2 = resUsers1.getString("login");
            }

            sql = "SELECT * FROM `orders` WHERE user_id = 1";
            PreparedStatement prTovar1 = getDbConnection().prepareStatement(sql);
            ResultSet resTovar1 = prTovar1.executeQuery();

            while (resTovar1.next()) {
                sql = "SELECT `title` FROM `items` WHERE `id` = 3  ";
                PreparedStatement prTovar2 = getDbConnection().prepareStatement(sql);
                ResultSet resTovar2 = prTovar2.executeQuery();
                while (resTovar2.next()) {
                    item_id2 = resTovar2.getString("title");
                }
                sql = "SELECT `title` FROM `items` WHERE `id` = 2  ";
                PreparedStatement prTovar3 = getDbConnection().prepareStatement(sql);
                ResultSet resTovar3 = prTovar3.executeQuery();
                while (resTovar3.next()) {
                    item_id3 = resTovar3.getString("title");
                }
            }
        }
        System.out.println(user_id2 + " - " + item_id2);
        System.out.println(user_id2 + " - " + item_id3);
    }

    }

