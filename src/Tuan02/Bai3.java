package Tuan02;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Bai3 extends JFrame {
    public Bai3() {
        JFrame frm = new JFrame();
        frm.setSize(500,300);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setLocationRelativeTo(null);

        JPanel pnMain = new JPanel();
        frm.getContentPane().add(pnMain, BorderLayout.CENTER);
        pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
        frm.add(pnMain);

        JPanel pnTop = new JPanel();
        JLabel lblTieuDe = new JLabel("GIẢI PHƯƠNG TRÌNH BẬC 1");
        lblTieuDe.setForeground(Color.BLUE);
        pnTop.add(lblTieuDe);
        pnMain.add(pnTop);

        JPanel pnSoA = new JPanel();
        pnSoA.setLayout(new FlowLayout());
        JLabel lblSoa = new JLabel("Hệ Số a:");
        JTextField txtSoa = new JTextField(20);
        pnSoA.add(lblSoa);
        pnSoA.add(txtSoa);
        pnMain.add(pnSoA);
        JPanel pnSoB = new JPanel();
        pnSoB.setLayout(new FlowLayout());
        JLabel lblSob = new JLabel("Hệ Số b:");
        JTextField txtSob = new JTextField(20);
        pnSoB.add(lblSob);
        pnSoB.add(txtSob);
        pnMain.add(pnSoB);

        JPanel pnButton = new JPanel();
        JButton btnGiai = new JButton("Giải");
        JButton btnMoi = new JButton("Mới");
        JButton btnThoat = new JButton("Thoát");
        pnButton.add(btnGiai);
        pnButton.add(btnThoat);
        pnButton.add(btnMoi);
        pnMain.add(pnButton);

        JPanel pnBottom = new JPanel();
        pnBottom.setLayout(new FlowLayout());
        JLabel lblKetQua = new JLabel("Kết Quả");
        JTextField txtKetQua = new JTextField(20);
        txtKetQua.setEditable(false);
        txtKetQua.setBackground(Color.YELLOW);
        pnBottom.add(lblKetQua);
        pnBottom.add(txtKetQua);
        pnMain.add(pnBottom);

        frm.setVisible(true);
    }

    public static void main(String[] args) {
        new Bai3();
    }
}

