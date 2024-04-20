package Tuan09;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Bai2 extends JFrame {
    public Bai2() {
        JFrame frame = new JFrame();
        frame.setSize(400, 250);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pnMain = new JPanel();
        pnMain.setLayout(new BorderLayout());
        pnMain.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.add(pnMain, BorderLayout.CENTER);

        JPanel pnTop = new JPanel();
        TitledBorder titledBorderFilter = new TitledBorder(new LineBorder(new Color(0, 0, 0)),"Filter");
        pnTop.setBorder(titledBorderFilter);
        pnTop.setLayout(new FlowLayout());
        JLabel lblId = new JLabel("ID");
        JComboBox<String> cbId = new JComboBox<>();

        pnTop.add(lblId);
        pnTop.add(cbId);
        pnMain.add(pnTop, BorderLayout.NORTH);

        JPanel pnMid = new JPanel();
        TitledBorder titledBorderUpdate = new TitledBorder(new LineBorder(new Color(0, 0, 0)),"Update");
        pnMid.setBorder(titledBorderUpdate);
        pnMid.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);


        JLabel lblTitle = new JLabel("Title");
        JTextField txtTitle = new JTextField(15);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 0.5;
        pnMid.add(lblTitle, gbc);
        gbc.gridx = 1;
        gbc.weightx = 0.5;
        pnMid.add(txtTitle, gbc);

        JLabel lblPrice = new JLabel("Price");
        JTextField txtPrice = new JTextField(5);
        gbc.gridx = 0;
        gbc.gridy = 1;
        pnMid.add(lblPrice, gbc);
        gbc.gridx = 1;
        pnMid.add(txtPrice, gbc);

        pnMain.add(pnMid, BorderLayout.CENTER);

        JPanel pnBottom = new JPanel();
        pnBottom.setLayout(new FlowLayout());
        JTextField txtKetqua = new JTextField(15);
        txtKetqua.setEditable(false);
        JButton btnSave = new JButton("Save");
        JButton btnExit = new JButton("Exit");

        pnBottom.add(txtKetqua);
        pnBottom.add(btnSave);
        pnBottom.add(btnExit);
        pnMain.add(pnBottom, BorderLayout.SOUTH);


        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Bai2();
    }
}
