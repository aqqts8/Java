package Tuan09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KetNoiCSDL {
    private static final String URL = "jdbc:mysql://localhost/db_libary";
    private static final String USER = "root";
    private static final String PASS = "";
    public KetNoiCSDL() throws ClassNotFoundException {
    }
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
