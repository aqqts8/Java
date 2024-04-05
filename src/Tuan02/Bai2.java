package Tuan02;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bai2 extends JFrame {
    public Bai2() {
        JFrame frm = new JFrame();
        frm.setSize(500,300);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setLocationRelativeTo(null);

        JPanel pnMain = new JPanel();
        pnMain.setBorder(new EmptyBorder(10,5,5,5));
        frm.getContentPane().add(pnMain, BorderLayout.CENTER);
        pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
        frm.add(pnMain);

        JPanel pnTop = new JPanel();
        JLabel lblTieuDe = new JLabel("TÌM SỐ LỚN NHẤT TRONG BA SỐ");
        pnTop.add(lblTieuDe);
        pnMain.add(pnTop);

        JPanel pnMid = new JPanel();
        pnMid.setBorder(new LineBorder(Color.BLACK, 2));
        pnMid.setLayout(new GridLayout(0,2));
        JLabel lblSo1 = new JLabel("Số Thứ 01:");
        JTextField txtSo1 = new JTextField(10);
        JLabel lblSo2 = new JLabel("Số Thứ 02:");
        JTextField txtSo2 = new JTextField(10);
        JLabel lblSo3 = new JLabel("Số Thứ 03:");
        JTextField txtSo3 = new JTextField(10);
        pnMid.add(lblSo1);
        pnMid.add(txtSo1);
        pnMid.add(lblSo2);
        pnMid.add(txtSo2);
        pnMid.add(lblSo3);
        pnMid.add(txtSo3);
        pnMain.add(pnMid);

        JPanel pnButton = new JPanel();
        JButton btnThucHien = new JButton("Thực Hiện");
        JButton btnMoi = new JButton("Mới");
        JButton btnDongCuaSo = new JButton("Đóng Cửa Sổ");
        pnButton.add(btnThucHien);
        pnButton.add(btnMoi);
        pnButton.add(btnDongCuaSo);
        pnMain.add(pnButton);

        JPanel pnBottom = new JPanel();
        pnBottom.setLayout(new GridLayout(0,2));
        JLabel lblSoLonNhat = new JLabel("Số Lớn Nhất Là:");
        JTextField txtSoLonNhat = new JTextField(15);
        txtSoLonNhat.setEditable(false);
        txtSoLonNhat.setBackground(Color.YELLOW);
        pnBottom.add(lblSoLonNhat);
        pnBottom.add(txtSoLonNhat);
        pnMain.add(pnBottom);

        btnThucHien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double so1 = Double.parseDouble(txtSo1.getText());
                double so2 = Double.parseDouble(txtSo2.getText());
                double so3 = Double.parseDouble(txtSo3.getText());

                double solonnhat = so1;
                if (solonnhat < so2 ) solonnhat = so2;
                if (solonnhat < so3 ) solonnhat = so3;

                txtSoLonNhat.setText(String.valueOf(solonnhat));

            }
        });

        btnMoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtSo1.setText(null);
                txtSo2.setText(null);
                txtSo3.setText(null);
                txtSo1.requestFocus();
            }
        });

        btnDongCuaSo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frm.setVisible(true);
    }

    public static void main(String[] args) {
        new Bai2();
    }
}
