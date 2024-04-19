package Tuan08.Test;

import javax.swing.*;
import java.awt.*;

public class Bai1 extends JFrame {
    public Bai1() {
        JFrame frame = new JFrame();
        frame.setTitle("Bai1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);

        JPanel pnMain = new JPanel();
        pnMain.setLayout(new BorderLayout(5,5));
        pnMain.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        JPanel pnTop = new JPanel();
        

        frame.setVisible(true);

    }
}
