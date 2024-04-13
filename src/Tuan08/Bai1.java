package Tuan08;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Bai1 extends JFrame {

    private JTable table;
    private DefaultTableModel model;

    public Bai1() {
        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pnMain = new JPanel();
        pnMain.setLayout(new BorderLayout(10,10));
        pnMain.setBorder(new EmptyBorder(5,5,5,5));
        frame.add(pnMain, BorderLayout.CENTER);

        JPanel pnTop = new JPanel();
        TitledBorder TitledBorder1 = new TitledBorder(new LineBorder(new Color(0, 0, 0), 3, true), "Nhap Thong Tin Sinh Vien");
        TitledBorder1.setTitlePosition(TitledBorder.ABOVE_TOP);
        pnTop.setLayout(new BoxLayout(pnTop, BoxLayout.Y_AXIS));
        pnTop.setBorder(TitledBorder1);
        pnMain.add(pnTop, BorderLayout.NORTH);

        JPanel pnTopLabel = new JPanel();
        pnTopLabel.setBorder(new EmptyBorder(5,5,5,5));
        pnTopLabel.setLayout(new GridLayout(0,2));
        JLabel lblHoTen = new JLabel("Ho Ten:");
        JTextField txtHoTen = new JTextField(10);
        JLabel lblGioiTinh = new JLabel("Gioi Tinh:");
        JComboBox<String> cbGioiTinh = new JComboBox<>();
        JLabel lblTuoi = new JLabel("Tuoi:");
        JTextField txtTuoi = new JTextField(10);
        JLabel lblEmail = new JLabel("Email:");
        JTextField txtEmail = new JTextField(10);
        JLabel lblSoDT  = new JLabel("So DT:");
        JTextField txtSoDT = new JTextField(10);

        pnTopLabel.add(lblHoTen);
        pnTopLabel.add(txtHoTen);
        pnTopLabel.add(lblGioiTinh);
        pnTopLabel.add(cbGioiTinh);
        pnTopLabel.add(lblTuoi);
        pnTopLabel.add(txtTuoi);
        pnTopLabel.add(lblEmail);
        pnTopLabel.add(txtEmail);
        pnTopLabel.add(lblSoDT);
        pnTopLabel.add(txtSoDT);
        pnTop.add(pnTopLabel);

        JPanel pnTopButton = new JPanel();
        pnTopButton.setLayout(new FlowLayout());
        JButton btnLuuTru = new JButton("Luu Tru");
        JButton btnLamMoi = new JButton("Lam Moi");
        JButton btnXoa = new JButton("Xoa");
        JButton btnTimKiem = new JButton("Tim Kiem");
        pnTopButton.add(btnLuuTru);
        pnTopButton.add(btnLamMoi);
        pnTopButton.add(btnXoa);
        pnTopButton.add(btnTimKiem);
        pnTop.add(pnTopButton);

        JPanel pnBottom = new JPanel();
        pnBottom.setLayout(new BorderLayout());
        model = new DefaultTableModel();
        table = new JTable(model);

        model.addColumn("STT");
        model.addColumn("Ho & Ten");
        model.addColumn("Gioi Tinh");
        model.addColumn("Tuoi");
        model.addColumn("Dia Chi");
        model.addColumn("Dien Thoai");

        JScrollPane scrollPane = new JScrollPane(table);

        pnBottom.add(scrollPane, BorderLayout.CENTER);
        pnMain.add(pnBottom, BorderLayout.CENTER);

        frame.setVisible(true);

    }

    public class Student {
        int id;
        String fullname, gender, email, phone;
        int age;
        public Student(int id, String fullname, String gender, String email, String
                phone, int age) {
            this.id = id;
            this.fullname = fullname;
            this.gender = gender;
            this.email = email;
            this.phone = phone;
            this.age = age;
        }
        public Student() { }
        public Student(String fullname, String gender, String email, String phone, int
                age) {
            this.fullname = fullname;
            this.gender = gender;
            this.email = email;
            this.phone = phone;
            this.age = age;
        }

        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getFullname() {
            return fullname;
        }
        public void setFullname(String fullname) {
            this.fullname = fullname;
        }
        public String getGender() {
            return gender;
        }
        public void setGender(String gender) {
            this.gender = gender;
        }
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public String getPhone() {
            return phone;
        }
        public void setPhone(String phone) {
            this.phone = phone;
        }
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }
    }

    public class StudentModify {
        static final String HOST = "jdbc:mysql://localhost/db_qlsv";
        static final String USER = "root";
        static final String PASS = "";

        public static List<Student> getStudentList (String s) {
            List<Student> dataList = new ArrayList<>();

            Connection con = null;
            try {
                con = DriverManager.getConnection(HOST, USER, PASS);
                String sql = "select * from students";

                if (s != null && !s.isEmpty()) {
                    sql += "where fullname like '"+s+"'";
                }
                PreparedStatement statement = con.prepareStatement(sql);

                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    Student std = new Student(
                            resultSet.getInt("id"),
                            resultSet.getString("fullname"),
                            resultSet.getString("gender"),
                            resultSet.getString("email"),
                            resultSet.getString("phone"),
                            resultSet.getInt("age")
                );
                    dataList.add(std);
                }
            } catch (SQLException ex) {
                System.out.println("Loi");
            } finally {
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException ex) {
                        System.out.println("Loi");
                    }
                }
            }
            return dataList;
        }

        public static void update (Student std) {
            Connection con = null;
            try {
                con = DriverManager.getConnection(HOST,USER, PASS);

                String sql = "update students set fullname = ?, email = ?, gender = ?, age = ?, phone = ? where id = ?";
                PreparedStatement statement = con.prepareStatement(sql);

                statement.setString(1, std.getFullname());
                statement.setString(2, std.getEmail());
                statement.setString(3, std.getGender());
                statement.setInt(4, std.getAge());
                statement.setString(5, std.getPhone());
                statement.setInt(6, std.getId());

                statement.execute();
            } catch (SQLException ex) {
                System.out.println("Loi");
            } finally {
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException ex) {
                        System.out.println("Loi");
                    }
                }
            }
        }

        public static void insert (Student std) {
            Connection con = null;
            try {
                con = DriverManager.getConnection(HOST,USER, PASS);
                String sql = "insert into students (fullname, email, gender, age, phone) values (?, ?, ?, ?, ?)";
                PreparedStatement statement = con.prepareStatement(sql);

                statement.setString(1, std.getFullname());
                statement.setString(2, std.getEmail());
                statement.setString(3, std.getGender());
                statement.setInt(4, std.getAge());
                statement.setString(5, std.getPhone());

                statement.execute();
            } catch (SQLException ex) {
                System.out.println("Loi");
            } finally {
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException ex) {
                        System.out.println("Loi");
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new Bai1();
    }
}
