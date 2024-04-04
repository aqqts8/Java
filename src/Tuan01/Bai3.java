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

        // Vì ở package khác nên phải dẫn vào đường dẫn trực tiếp
        ImageIcon iconTinh = new ImageIcon(Bai3.class.getClassLoader().getResource("Hinh/TinhIcon.png"));
        JButton btnTinh = new JButton("Tính", iconTinh);
        pnNut.add(btnTinh);

        ImageIcon iconXoa = new ImageIcon(Bai3.class.getClassLoader().getResource("Hinh/XoaIcon.png"));
        JButton btnXoa = new JButton("Xóa", iconXoa);
        pnNut.add(btnXoa);

        ImageIcon iconThoat = new ImageIcon(Bai3.class.getClassLoader().getResource("Hinh/ThoatIcon.png"));
        JButton btnThoat = new JButton("Thoát", iconThoat);
        pnNut.add(btnThoat);

        frm.add(pnTieuDe);
        frm.add(pnDuLieu);
        frm.add(pnNut);
        frm.setVisible(true);
    }
}

