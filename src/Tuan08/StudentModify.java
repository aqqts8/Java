package Tuan08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class StudentModify {
    static final String HOST = "jdbc:mysql://localhost/db_qlsv";
    static final String USERNAME = "root";
    static final String PASSWORD = "";

    public static List<Student> getStudentList(String s) {
        List<Student> dataList = new ArrayList<>();

        Connection con = null;
        try {

            con = DriverManager.getConnection(HOST, USERNAME, PASSWORD);

            String sql = "select * from students";

            if(s != null && !s.isEmpty()) {
                sql += " where fullname like '"+s+"'";
            }
            PreparedStatement statement = con.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                Student std = new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("fullname"),
                        resultSet.getString("gender"),
                        resultSet.getString("email"),
                        resultSet.getString("phone"),
                        resultSet.getInt("age"));
                dataList.add(std);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi"+ ex.getMessage());
        } finally {
            //B3. Dong ket noi toi database
            if(con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    System.out.println("Lỗi"+ ex.getMessage());
                }
            }
        }

        return dataList;
    }
    public static void update(Student std) {
        Connection con = null;
        try {
            con = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
            String sql = "update students set fullname = ?, email = ?,gender = ?, age = ?, phone = ? where id = ?";
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, std.getFullname());
            statement.setString(2, std.getEmail());
            statement.setString(3, std.getGender());
            statement.setInt(4, std.getAge());
            statement.setString(5, std.getPhone());
            statement.setInt(6, std.getId());

            statement.execute();
        } catch (SQLException ex) {
            System.out.println("Lỗi "+ ex.getMessage());
        } finally {
            //B3. Dong ket noi toi database
            if(con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    System.out.println("Lỗi "+ ex.getMessage());
                }
            }
        }

    }
    public static void delete(int id) {
        Connection con = null;
        try {

            con = DriverManager.getConnection(HOST, USERNAME, PASSWORD);

            String sql = "delete from students where id = ?";
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setInt(1, id);

            statement.execute();
        } catch (SQLException ex) {
            System.out.println("Lỗi "+ ex.getMessage());
        } finally {
            if(con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    System.out.println("Lỗi "+ ex.getMessage());
                }
            }
        }
    }
    public static void insert(Student std) {
        Connection con = null;
        try {
            con = DriverManager.getConnection(HOST, USERNAME, PASSWORD);

            String sql = "insert into students (fullname, email, gender, age, phone) values (?, ?, ?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, std.getFullname());
            statement.setString(2, std.getEmail());
            statement.setString(3, std.getGender());
            statement.setInt(4, std.getAge());
            statement.setString(5, std.getPhone());

            statement.execute();
        } catch (SQLException ex) {
            System.out.println("lỗi "+ ex.getMessage());
        } finally {
            if(con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    System.out.println("Lỗi "+ ex.getMessage());
                }
            }
        }
    }
}

