package Tuan01;

import javax.swing.*;
import java.awt.*;

public class Bai3 {
    public static void main(String args[]) {

        JFrame frm = new JFrame("Tính Tổng, Tích, Hiệu");
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setSize(300,200);
        frm.setLocationRelativeTo(null);

        frm.setLayout(new BoxLayout(frm.getContentPane(), BoxLayout.Y_AXIS));

        JPanel pnTieuDe = new JPanel();
        pnTieuDe.setLayout(new FlowLayout());

        JLabel lblTieuDe = new JLabel("Tính Lương Nhân Viên");
        pnTieuDe.add(lblTieuDe);

        JPanel pnDuLieu = new JPanel();
        pnDuLieu.setLayout(new GridLayout(3,2));

        JLabel lblLuong1Ngay = new JLabel("Lương một ngày:");
        JTextField txtLuong1Ngay = new JTextField(15);
        pnDuLieu.add(lblLuong1Ngay); pnDuLieu.add(txtLuong1Ngay);

        JLabel lblNgayCong = new JLabel("Ngày công:");
        JTextField txtNgayCong = new JTextField(15);
        pnDuLieu.add(lblNgayCong); pnDuLieu.add(txtNgayCong);

        JLabel lblLuongThang = new JLabel("Lương tháng:");
        JTextField txtLuongThang = new JTextField(15);
        pnDuLieu.add(lblLuongThang); pnDuLieu.add(txtLuongThang);

        JPanel pnNut = new JPanel();
        pnNut.setLayout(new FlowLayout());

        JButton btnTinh = new JButton("Tính");
        //btnTinh.setIcon(new ImageIcon("Hinh/TinhIcon.png"));
        pnNut.add(btnTinh);

        JButton btnXoa = new JButton("Xóa");
        //btnXoa.setIcon(new ImageIcon("Hinh/XoaIcon.png"));
        pnNut.add(btnXoa);

        JButton btnThoat = new JButton("Thoát");
        //btnThoat.setIcon(new ImageIcon("../Hinh/ThoatIcon.png"));
        pnNut.add(btnThoat);

        frm.add(pnTieuDe);
        frm.add(pnDuLieu);
        frm.add(pnNut);
        frm.setVisible(true);
    }
}

