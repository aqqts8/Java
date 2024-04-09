package Tuan07;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class Bai1 extends JFrame {

    private JTable table;
    private DefaultTableModel model;

    public Bai1() {
        JFrame frame = new JFrame();
        frame.setTitle("Quản Lý Nhân Viên");
        frame.setSize(800, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout(5,5));

        JPanel pnMain = new JPanel();
        pnMain.setLayout(new BorderLayout(5,5));
        pnMain.setBorder(new EmptyBorder(5, 20, 5, 20));
        frame.add(pnMain, BorderLayout.CENTER);

        JPanel pnTieuDe = new JPanel();
        JLabel lblTieuDe = new JLabel("Chọn Bằng Cấp");

            BangCapDAO bc = new BangCapDAO();
        List<BangCap> dsbc = null;
        try {
            dsbc = bc.layTatBangCap();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Vector<String> bangcap = new Vector<>();
            for (BangCap it : dsbc) {
                bangcap.add(it.getTenBangCap());
            }
            JComboBox<String> cbbBangCap = new JComboBox<>(bangcap);

        JButton btnTimKiem = new JButton("Tìm Kiếm");
        btnTimKiem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<NhanVien> dsnv = new ArrayList<>();
                int selectedIndex = cbbBangCap.getSelectedIndex();
                String sql = "SELECT * from nhanvien WHERE MaBangCap="+ selectedIndex;
                JOptionPane.showMessageDialog(null,sql);
                NhanVienDAO nvdao = new NhanVienDAO();
                try {
                    dsnv = nvdao.layTatCaNhanVien(sql);
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                String colTieuDe[] = {"Mã NV","Họ Tên","Ngày Sinh","Địa Chỉ","Điện Thoại"};
                DefaultTableModel model = new DefaultTableModel(colTieuDe,0);
                Object[] row;
                for (NhanVien nv : dsnv) {
                    row = new Object[5];
                    row[0] = nv.getId();
                    row[1] = nv.getHoTen();
                    row[2] = nv.getNgaySinh();
                    row[3] = nv.getDiaChi();
                    row[4] = nv.getDienThoai();

                    model.addRow(row);
                }
                table.setModel(model);
            }
        });

        pnTieuDe.setLayout(new FlowLayout());
        pnTieuDe.add(lblTieuDe);
        pnTieuDe.add(cbbBangCap);
        pnTieuDe.add(btnTimKiem);
        pnMain.add(pnTieuDe, BorderLayout.NORTH);

        JPanel pnBang = new JPanel();
        pnBang.setLayout(new BorderLayout());
        model = new DefaultTableModel();
        table = new JTable(model);

        model.addColumn("Mã NV");
        model.addColumn("Họ Tên");
        model.addColumn("Ngày Sinh");
        model.addColumn("Địa Chỉ");
        model.addColumn("Điện Thoại");

        JScrollPane scrollPane = new JScrollPane(table);

        pnBang.add(scrollPane, BorderLayout.CENTER);
        pnMain.add(pnBang, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public class KetNoiCSDL {
        private static final String URL = "jdbc:mysql://localhost:3306/db_qlnv";
        private static final String USER = "root";
        private static final String PASS = "";
        public KetNoiCSDL() throws ClassNotFoundException {

        }
        public static Connection getConnection() throws SQLException, ClassNotFoundException {
            return DriverManager.getConnection(URL, USER, PASS);
        }
    }

    public class BangCap {
        private int MaBangCap;
        private String TenBangCap;

        public BangCap(int maBangCap, String tenBangCap) {
            super();
            MaBangCap = maBangCap;
            TenBangCap = tenBangCap;
        }

        public int getMaBangCap() {
            return MaBangCap;
        }

        public void setMaBangCap(int maBangCap) {
            MaBangCap = maBangCap;
        }

        public String getTenBangCap() {
            return TenBangCap;
        }

        public void setTenBangCap(String tenBangCap) {
            TenBangCap = tenBangCap;
        }
    }

    public class BangCapDAO {
        public List<BangCap> layTatBangCap() throws SQLException, ClassNotFoundException {

            Connection connection = KetNoiCSDL.getConnection();
            String query = "SELECT * from bangcap";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            List<BangCap> dsbc = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("MaBangCap");
                String tenbangcap = resultSet.getString("TenBangCap");
                BangCap bc = new BangCap(id, tenbangcap);
                dsbc.add(bc);
            }

            resultSet.close();
            statement.close();
            connection.close();
            return dsbc;
        }
    }

    public class NhanVien {
        private int id;
        private String HoTen;
        private Date NgaySinh;
        private String DiaChi;
        private String DienThoai;
        private int MaBangCap;

        public NhanVien(int id, String hoTen, Date ngaySinh, String diaChi, String dienThoai, int maBangCap) {
            super();
            this.id = id;
            this.HoTen = hoTen;
            this.NgaySinh = ngaySinh;
            this.DiaChi = diaChi;
            this.DienThoai = dienThoai;
            this.MaBangCap = maBangCap;
        }
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getHoTen() {
            return HoTen;
        }
        public void setHoTen(String hoTen) {
            HoTen = hoTen;
        }
        public Date getNgaySinh() {
            return NgaySinh;
        }
        public void setNgaySinh(Date ngaySinh) {
            NgaySinh = ngaySinh;
        }
        public String getDiaChi() {
            return DiaChi;
        }
        public void setDiaChi(String diaChi) {
            DiaChi = diaChi;
        }
        public String getDienThoai() {
            return DienThoai;
        }
        public void setDienThoai(String dienThoai) {
            DienThoai = dienThoai;
        }
        public int getMaBangCap() {
            return MaBangCap;
        }
        public void setMaBangCap(int maBangCap) {
            MaBangCap = maBangCap;
        }
    }

    public class NhanVienDAO {
        public List<NhanVien> layTatCaNhanVien(String sql) throws SQLException, ClassNotFoundException {
            Connection connection = KetNoiCSDL.getConnection();
            String query = sql;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            List<NhanVien> dsnv = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("MaNhanVien");
                String hoTen = resultSet.getString("HoTenNhanVien");
                Date ngaySinh = resultSet.getDate("NgaySinh");
                String diaChi = resultSet.getString("DiaChi");
                String dienThoai = resultSet.getString("DienThoai");
                int MaBangCap = resultSet.getInt("MaBangCap");
                NhanVien nv = new NhanVien(id, hoTen, ngaySinh, diaChi, dienThoai, MaBangCap);
                dsnv.add(nv);
            }
            resultSet.close();
            statement.close();
            connection.close();
            return dsnv;
        }
        public NhanVien layTatCaNhanVien(int id) throws SQLException {
            return null;
        }
    }


    public static void main(String[] args) {
        new Bai1();
    }
}
