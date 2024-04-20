package Tuan09;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Bai1 extends JFrame {
    public Bai1() {
        JFrame frame = new JFrame();
        frame.setSize(300, 150);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pnMain = new JPanel();
        pnMain.setLayout(new BorderLayout(5,5));
        pnMain.setBorder(new EmptyBorder(5,5,5,5));
        frame.add(pnMain, BorderLayout.CENTER);

        JPanel pnTop = new JPanel();
        pnTop.setLayout(new FlowLayout());
        JLabel lblTitle = new JLabel("Title");
        JTextField txtTitle = new JTextField(15);
        pnTop.add(lblTitle);
        pnTop.add(txtTitle);
        pnMain.add(pnTop, BorderLayout.NORTH);

        JPanel pnMid = new JPanel();
        pnMid.setLayout(new FlowLayout());
        JLabel lblPrice = new JLabel("Price");
        JTextField txtPrice = new JTextField(5);
        JTextField txtKetqua = new JTextField(10);
        txtKetqua.setEditable(false);
        pnMid.add(lblPrice);
        pnMid.add(txtPrice);
        pnMid.add(txtKetqua);
        pnMain.add(pnMid, BorderLayout.CENTER);

        JPanel pnBottom = new JPanel();
        pnBottom.setLayout(new FlowLayout());
        JButton btnSave = new JButton("Save");
        JButton btnReset = new JButton("Reset");
        JButton btnExit = new JButton("Exit");

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = txtTitle.getText();
                if (title == null || title.trim().isEmpty()) {
                    txtKetqua.setText("Title không được để trống");
                    return;
                }

                String priceInput = txtPrice.getText();
                if (priceInput == null || priceInput.trim().isEmpty()) {
                    txtKetqua.setText("Price không được để trống");
                    return;
                }

                int price;
                try {
                    price = Integer.parseInt(priceInput.trim());
                } catch (NumberFormatException ex) {
                    txtKetqua.setText("Price phải là một số");
                    return;
                }

                try {
                    BookDAO bookDAO = new BookDAO();
                    int newBookId = bookDAO.addBook(title, price);
                    if (newBookId != -1) {
                        txtKetqua.setText("Sách đã được thêm với ID: " + newBookId);
                    } else {
                        txtKetqua.setText("Thêm sách không thành công");
                    }
                } catch (SQLException ex) {
                    txtKetqua.setText("Error in SQL: " + ex.getMessage());
                } catch (ClassNotFoundException ex) {
                    txtKetqua.setText("JDBC Driver not found: " + ex.getMessage());
                }
            }
        });

        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtTitle.setText(null);
                txtPrice.setText(null);
                txtKetqua.setText(null);
                txtTitle.requestFocus();
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });



        pnBottom.add(btnSave);
        pnBottom.add(btnReset);
        pnBottom.add(btnExit);
        pnMain.add(pnBottom, BorderLayout.SOUTH);


        frame.setVisible(true);
    }


    public static void main(String[] args) {
        new Bai1();
    }
}
