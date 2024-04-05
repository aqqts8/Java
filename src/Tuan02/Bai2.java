package Tuan02;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Bai2 extends JFrame {
    public Bai2() {
        JFrame frm = new JFrame();
        frm.setSize(500,300);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setLocationRelativeTo(null);

        JPanel pnMain = new JPanel();
        pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
        frm.add(pnMain);

        JPanel pnTop = new JPanel();
        JLabel lblTieuDe = new JLabel("TÌM SỐ LỚN NHẤT TRONG BA SỐ", JLabel.CENTER);
        pnTop.add(lblTieuDe);
        pnMain.add(pnTop);

        JPanel pnMid = new JPanel();
        pnMid.setBorder(new LineBorder(Color.BLACK, 2));

        pnMain.add(pnMid);

        frm.setVisible(true);
    }

    public static void main(String[] args) {
        new Bai2();
    }
}
