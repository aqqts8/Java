package Tuan01;

import javax.swing.*;
import java.awt.*;

public class Bai4 {
    public static void main(String args[]) {

        JFrame frm = new JFrame("Giải Phương Trình");
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setSize(400,300);
        frm.setLocationRelativeTo(null);

        frm.setLayout(new BoxLayout(frm.getContentPane(), BoxLayout.Y_AXIS));

        JPanel pnTieuDe = new JPanel();
        pnTieuDe.setLayout(new FlowLayout());

        JLabel lblTieuDe = new JLabel("Giải Phương Trình Bậc 1");
        pnTieuDe.add(lblTieuDe);

        JPanel pnHeSoA = new JPanel();
        pnHeSoA.setLayout(new FlowLayout());

        JLabel lblHeSoA = new JLabel("Hệ số a:");
        JTextField txtHeSoA = new JTextField(15);
        pnHeSoA.add(lblHeSoA); pnHeSoA.add(txtHeSoA);

        JPanel pnHeSoB = new JPanel();
        pnHeSoA.setLayout(new FlowLayout());

        JLabel lblHeSoB = new JLabel("Hệ số b:");
        JTextField txtHeSoB = new JTextField(15);
        pnHeSoB.add(lblHeSoB); pnHeSoB.add(txtHeSoB);

        JPanel pnNut = new JPanel();
        pnNut.setLayout(new FlowLayout());

        JButton btnTinh = new JButton("Giải");
        pnNut.add(btnTinh);

        JButton btnThoat = new JButton("Thoát");
        pnNut.add(btnThoat);

        JButton btnMoi = new JButton("Mới");
        pnNut.add(btnMoi);

        JPanel pnKetQua = new JPanel();

        JLabel lblKetQua = new JLabel("Kết quả:");
        JTextField txtKetQua = new JTextField(15);
        pnKetQua.add(lblKetQua); pnKetQua.add(txtKetQua);

        frm.add(pnTieuDe);
        frm.add(pnHeSoA);
        frm.add(pnHeSoB);
        frm.add(pnNut);
        frm.add(pnKetQua);
        frm.setVisible(true);
    }
}

