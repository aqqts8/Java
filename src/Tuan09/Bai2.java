package Tuan09;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

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

        btnSave.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               try {
                   BookDAO bookDAO = new BookDAO();
                   int bookId = Integer.parseInt(cbId.getSelectedItem().toString());
                   String title = txtTitle.getText();
                   int price = Integer.parseInt(txtPrice.getText());
                   bookDAO.updateBook(bookId, title, price);
                   txtKetqua.setText("Sách đã được sửa thành công");
               } catch (SQLException | ClassNotFoundException | NumberFormatException ex) {
                   ex.printStackTrace();
                   txtKetqua.setText("Lỗi khi sửa sách: " + ex.getMessage());
               }
           }
        });

        pnBottom.add(txtKetqua);
        pnBottom.add(btnSave);
        pnBottom.add(btnExit);
        pnMain.add(pnBottom, BorderLayout.SOUTH);

        try {
            BookDAO bookDAO = new BookDAO();
            List<Books> allBooks = bookDAO.layTatCaSach();
            for (Books book : allBooks) {
                cbId.addItem(Integer.toString(book.getId()));
            }
            if (!allBooks.isEmpty()) {
                Books firstBook = allBooks.get(0);
                txtTitle.setText(String.valueOf(firstBook.getTitle()));
                txtPrice.setText(String.valueOf(firstBook.getPrice()));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            txtKetqua.setText("Lỗi khi lấy ID: " + e.getMessage());
        }

        cbId.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    BookDAO bookDAO = new BookDAO();
                    int bookId = Integer.parseInt(cbId.getSelectedItem().toString());
                    Books book = bookDAO.getBookById(bookId);
                    if (book != null) {
                        txtTitle.setText(String.valueOf(book.getTitle()));
                        txtPrice.setText(String.valueOf(book.getPrice()));
                    } else {
                        lblTitle.setText("Title: N/A");
                        lblPrice.setText("Price: N/A");
                    }
                } catch (SQLException | ClassNotFoundException | NumberFormatException ex) {
                    ex.printStackTrace();
                    txtKetqua.setText("Lỗi khi lấy thông tin sách: " + ex.getMessage());
                }
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Bai2();
    }
}
