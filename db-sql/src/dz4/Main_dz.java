package dz4;

import Base.DB;

import java.sql.SQLException;

public class Main_dz {
    public static void main(String[] args) {
        DB_dz4 db = new DB_dz4();
        try {
            db.setOrders("orders");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}