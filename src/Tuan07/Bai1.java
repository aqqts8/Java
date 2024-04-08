package Tuan07;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Bai1 extends JFrame {

    private JTable table;
    private DefaultTableModel model;

    public Bai1() {
        JFrame frame = new JFrame();
        frame.setTitle("Quản Lý Nhân Viên");
        frame.setSize(700, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout(5,5));

        JPanel pnMain = new JPanel();
        pnMain.setLayout(new BorderLayout(5,5));
        pnMain.setBorder(new EmptyBorder(5, 20, 5, 20));
        frame.add(pnMain, BorderLayout.CENTER);

        JPanel pnTieuDe = new JPanel();
        JLabel lblTieuDe = new JLabel("Chọn Bằng Cấp");
        JComboBox cbbBangCap = new JComboBox();
        JButton btnTimKiem = new JButton("Tìm Kiếm");
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

        addRow("NV001", "Nguyễn Văn A", "01/01/1990", "Hà Nội", "0123456789");
        addRow("NV002", "Trần Thị B", "05/05/1995", "Hồ Chí Minh", "0987654321");

        JScrollPane scrollPane = new JScrollPane(table);

        pnBang.add(scrollPane, BorderLayout.CENTER);
        pnMain.add(pnBang, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private void addRow(String maNV, String hoTen, String ngaySinh, String diaChi, String dienThoai) {
        Object[] row = {maNV, hoTen, ngaySinh, diaChi, dienThoai};
        model.addRow(row);
    }

    public static void main(String[] args) {
        new Bai1();
    }
}
