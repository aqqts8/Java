package Tuan02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bai1 extends JFrame {
    public Bai1() {
        JFrame frm = new JFrame();
        frm.setSize(500,300);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setLocationRelativeTo(null);

        JPanel pnMain = new JPanel();
        pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
        frm.add(pnMain);

        JPanel pnTop = new JPanel();
        JLabel lblTieuDe = new JLabel("CHƯƠNG TRÌNH HIỆN THÔNG BÁO");
        lblTieuDe.setForeground(Color.BLUE);
        pnTop.add(lblTieuDe);
        pnMain.add(pnTop);

        JPanel pnBottom = new JPanel();
        pnBottom.setLayout(new FlowLayout());
        JButton btnHienThi = new JButton("Hiển Thị");
        btnHienThi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Java Swing kính chào các bạn");
            }
        });

        JButton btnDong = new JButton("Đóng Cửa Sổ");
        btnDong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        pnBottom.add(btnHienThi);
        pnBottom.add(btnDong);
        pnMain.add(pnBottom);


        frm.setVisible(true);
    }
    public static void main(String[] args) {
        new Bai1();
    }
}
