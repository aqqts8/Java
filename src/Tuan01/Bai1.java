package Tuan01;

import javax.swing.*;

public class Bai1 {

    public Bai1() {
        JFrame frm = new JFrame("Hello World");
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setSize(250,200);
        frm.setLocation(300,200);
        frm.setVisible(true);
    }

    public static void main(String[] args) {
        new Bai1();
    }
}
