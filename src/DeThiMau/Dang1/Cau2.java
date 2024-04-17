package DeThiMau.Dang1;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Cau2 extends JFrame {
    public Cau2() {
        JFrame frame = new JFrame();
        frame.setSize(600, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pnMain = new JPanel();
        pnMain.setLayout(new BorderLayout(10,10));
        pnMain.setBorder(new EmptyBorder(10, 30, 10, 30));
        frame.add(pnMain, BorderLayout.CENTER);

        JPanel pnTieuDe = new JPanel();
        JLabel lblTieuDe = new JLabel("Tinh Tien Choi BIDA");
        lblTieuDe.setFont(new Font("Arial", Font.BOLD, 20));
        lblTieuDe.setForeground(Color.BLUE);
        pnTieuDe.add(lblTieuDe);
        pnMain.add(pnTieuDe, BorderLayout.NORTH);

        JPanel pnCenter = new JPanel();
        pnCenter.setLayout(new GridLayout(0,2));
        pnMain.add(pnCenter, BorderLayout.CENTER);

        JPanel pnCenterLeft = new JPanel();
        TitledBorder border = new TitledBorder(new LineBorder(Color.BLUE, 3, true), "Thong Tin");
        border.setTitleColor(Color.RED);
        pnCenterLeft.setBorder(border);
        pnCenterLeft.setLayout(new GridLayout(0,2));
        JLabel lblGioBatDau = new JLabel("Gio Bat Dau");
        JTextField txtGioBatDau = new JTextField(15);
        JLabel lblGioKetThuc = new JLabel("Gio Ket Thuc");
        JTextField txtGioKetThuc = new JTextField(15);
        JLabel lblTienThanhToan = new JLabel("Tien Thanh Toan");
        JTextField txtTienThanhToan = new JTextField(15);
        txtTienThanhToan.setBackground(Color.CYAN);
        txtTienThanhToan.setEditable(false);


        pnCenterLeft.add(lblGioBatDau);
        pnCenterLeft.add(txtGioBatDau);
        pnCenterLeft.add(lblGioKetThuc);
        pnCenterLeft.add(txtGioKetThuc);
        pnCenterLeft.add(lblTienThanhToan);
        pnCenterLeft.add(txtTienThanhToan);
        pnCenter.add(pnCenterLeft);

        JPanel pnCenterRight = new JPanel();
        pnCenterRight.setLayout(new GridLayout(0,1));
        JButton btnThanhToan = new JButton("Thanh Toan");
        JButton btnLamMoi = new JButton("Lam Moi");
        JButton btnDong = new JButton("Dong");

        pnCenterRight.add(btnThanhToan);
        pnCenterRight.add(btnLamMoi);
        pnCenterRight.add(btnDong);
        pnCenter.add(pnCenterRight);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Cau2();
    }
}
