package Tuan01;


import javax.swing.*;

public class Bai2 extends JFrame {
    public Bai2() {
        setTitle("Chào Bạn");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel chao = new JLabel("Java Swing chào các bạn");
        setSize(300,100);
        setLocationRelativeTo(null);
        setVisible(true);
        add(chao);
    }

    public static void main(String args[]) {
        new Bai2();
    }
}
