package DeThiMau.Dang1;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.X_AXIS));
        pnMain.add(pnCenter, BorderLayout.CENTER);

        JPanel pnCenterLeft = new JPanel();
        TitledBorder border = new TitledBorder(new LineBorder(Color.BLUE, 3, true), "Thong Tin");
        border.setTitleJustification(TitledBorder.CENTER);
        border.setTitleColor(Color.RED);
        pnCenterLeft.setBorder(border);
        pnCenterLeft.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);

        JLabel lblGioBatDau = new JLabel("Gio Bat Dau");
        JTextField txtGioBatDau = new JTextField(15);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 0.5;
        pnCenterLeft.add(lblGioBatDau, gbc);
        gbc.gridx = 1;
        gbc.weightx = 0.5;
        pnCenterLeft.add(txtGioBatDau, gbc);

        JLabel lblGioKetThuc = new JLabel("Gio Ket Thuc");
        JTextField txtGioKetThuc = new JTextField(15);
        gbc.gridx = 0;
        gbc.gridy = 1;
        pnCenterLeft.add(lblGioKetThuc, gbc);
        gbc.gridx = 1;
        pnCenterLeft.add(txtGioKetThuc, gbc);

        JLabel lblTienThanhToan = new JLabel("Tien Thanh Toan");
        JTextField txtTienThanhToan = new JTextField(15);
        txtTienThanhToan.setBackground(Color.CYAN);
        txtTienThanhToan.setEditable(false);
        gbc.gridx = 0;
        gbc.gridy = 2;
        pnCenterLeft.add(lblTienThanhToan, gbc);
        gbc.gridx = 1;
        pnCenterLeft.add(txtTienThanhToan, gbc);

        pnCenter.add(pnCenterLeft);

        JPanel pnCenterRight = new JPanel();
        pnCenterRight.setLayout(new GridBagLayout());
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx = 0;
        gbc1.gridy = GridBagConstraints.RELATIVE;
        gbc1.fill = GridBagConstraints.HORIZONTAL;
        gbc1.insets = new Insets(5, 5, 5, 5);

        JButton btnThanhToan = new JButton("Thanh Toan");
        JButton btnLamMoi = new JButton("Lam Moi");
        JButton btnDong = new JButton("Dong");

        pnCenterRight.add(btnThanhToan, gbc1);
        pnCenterRight.add(btnLamMoi, gbc1);
        pnCenterRight.add(btnDong, gbc1);

        btnThanhToan.setPreferredSize(new Dimension(150, 40));
        btnLamMoi.setPreferredSize(new Dimension(150, 40));
        btnDong.setPreferredSize(new Dimension(150, 40));

        pnCenter.add(pnCenterRight);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Cau2();
    }
}
