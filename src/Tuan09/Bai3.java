package Tuan09;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class Bai3 extends JFrame {
    private JTable table;
    private DefaultTableModel model;

    public Bai3() {
        JFrame frame = new JFrame();
        frame.setSize(500, 350);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pnMain = new JPanel();
        pnMain.setLayout(new BorderLayout(10,10));
        pnMain.setBorder(new EmptyBorder(10, 10, 10, 10));
        frame.add(pnMain, BorderLayout.CENTER);

        JPanel pnTop = new JPanel();
        pnTop.setLayout(new FlowLayout());
        pnMain.add(pnTop, BorderLayout.NORTH);

        JPanel pnTopLeft = new JPanel();
        TitledBorder border = new TitledBorder(new LineBorder(Color.BLACK, 1, true), "Filter");
        pnTopLeft.setBorder(border);
        pnTopLeft.setLayout(new FlowLayout());
        JLabel lblTitle = new JLabel("Title:");
        JTextField txtTitle = new JTextField(20);

        pnTopLeft.add(lblTitle);
        pnTopLeft.add(txtTitle);
        pnTop.add(pnTopLeft);

        JPanel pnTopRight = new JPanel();
        pnTopRight.setLayout(new FlowLayout());
        JButton btnSearch = new JButton("Search");
        JButton btnExit = new JButton("Exit");

        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String keyword = txtTitle.getText().trim();
                if (!keyword.isEmpty()) {
                    try {
                        BookDAO bookDAO = new BookDAO();
                        List<Books> searchResults = bookDAO.searchBooks(keyword);

                        DefaultTableModel model = (DefaultTableModel) table.getModel();
                        model.setRowCount(0); // Xóa tất cả các hàng hiện tại trong bảng

                        for (Books book : searchResults) {
                            model.addRow(new Object[]{book.getId(), book.getTitle(), book.getPrice()});
                        }
                    } catch (SQLException | ClassNotFoundException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Loi khi search", "Loi", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ban chua nhap tu khoa", "Loi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        pnTopRight.add(btnSearch);
        pnTopRight.add(btnExit);
        pnTop.add(pnTopRight);

        JPanel pnMid = new JPanel();
        pnMid.setLayout(new BorderLayout());
        LineBorder lineBorder = new LineBorder(Color.BLACK, 1, true);
        pnMid.setBorder(lineBorder);
        model = new DefaultTableModel();
        table = new JTable(model);

        model.addColumn("Id");
        model.addColumn("Title");
        model.addColumn("Price");

        JScrollPane scrollPane = new JScrollPane(table);

        pnMid.add(scrollPane, BorderLayout.CENTER);
        pnMain.add(pnMid, BorderLayout.CENTER);

        try {
            BookDAO bookDAO = new BookDAO();
            List<Books> books = bookDAO.layTatCaSach();

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            for (Books book : books) {
                model.addRow(new Object[]{book.getId(),book.getTitle(),book.getPrice()});
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        JPanel pnBottom = new JPanel();
        pnBottom.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JButton btnDelete = new JButton("Delete");

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    int confirm = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa không?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        DefaultTableModel model = (DefaultTableModel) table.getModel();

                        // Xóa dữ liệu từ cơ sở dữ liệu
                        int bookId = (int) model.getValueAt(selectedRow, 0); // Giả sử cột đầu tiên là ID sách
                        try {
                            BookDAO bookDAO = new BookDAO();
                            bookDAO.deleteBook(bookId);
                        } catch (SQLException | ClassNotFoundException ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Có lỗi khi xóa dữ liệu", "Lỗi", JOptionPane.ERROR_MESSAGE);
                            return; // Ngừng thực hiện nếu xảy ra lỗi
                        }

                        // Xóa dữ liệu từ bảng JTable
                        model.removeRow(selectedRow);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Bạn chưa chọn mục muốn xóa", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        pnBottom.add(btnDelete);
        pnMain.add(pnBottom, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Bai3();
    }
}
