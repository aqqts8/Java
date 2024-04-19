package DeThiMau.Dang2;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Cau2 extends JFrame {
    private JTable table;
    private DefaultTableModel model;

    public Cau2() {
        JFrame frame = new JFrame();
        frame.setSize(500, 400);
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
                        List<Book> searchResults = bookDAO.searchBooks(keyword);

                        DefaultTableModel model = (DefaultTableModel) table.getModel();
                        model.setRowCount(0); // Xóa tất cả các hàng hiện tại trong bảng

                        for (Book book : searchResults) {
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
                int result = JOptionPane.showConfirmDialog(null, "Ban co muon thoat khong", "Xac nhan thoat" , JOptionPane.YES_NO_OPTION);

                if (result == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        pnTopRight.add(btnSearch);
        pnTopRight.add(btnExit);
        pnTop.add(pnTopRight);

        JPanel pnMid = new JPanel();
        pnMid.setLayout(new BorderLayout());
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
            List<Book> books = bookDAO.layTatCaBook();

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            for (Book book : books) {
                model.addRow(new Object[]{book.getId(), book.getTitle(), book.getPrice()});
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        JPanel pnBottom = new JPanel();
        pnBottom.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JButton btnAdd = new JButton("Add");
        JButton btnEdit = new JButton("Edit");
        JButton btnDelete = new JButton("Delete");

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = JOptionPane.showInputDialog(null, "Enter title:", "Add Book", JOptionPane.PLAIN_MESSAGE);
                if (title == null || title.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Title khong duoc de trong", "Loi", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Get price from user input
                String priceInput = JOptionPane.showInputDialog(null, "Enter price:", "Add Book", JOptionPane.PLAIN_MESSAGE);
                if (priceInput == null || priceInput.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Price khong duoc de trong", "Loi", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                // Convert priceInput to integer
                int price;
                try {
                    price = Integer.parseInt(priceInput);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Price phai la mot so", "Loi", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Add new book to database
                try {
                    BookDAO bookDAO = new BookDAO();
                    int newBookId = bookDAO.addBook(title, price); // Assuming addBook method returns the ID of newly added book
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.addRow(new Object[]{newBookId, title, price});
                } catch (SQLException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Loi khi add vao databse", "Loi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int id = (int) model.getValueAt(selectedRow, 0); // Lấy ID của cuốn sách được chọn
                    String title = (String) model.getValueAt(selectedRow, 1); // Lấy tiêu đề của cuốn sách được chọn
                    int price = (int) model.getValueAt(selectedRow, 2); // Lấy giá của cuốn sách được chọn

                    // Hiển thị một dialog hoặc form cho phép người dùng chỉnh sửa thông tin
                    JTextField titleField = new JTextField(title);
                    JTextField priceField = new JTextField(String.valueOf(price));
                    Object[] fields = {"Title:", titleField, "Price:", priceField};
                    int option = JOptionPane.showConfirmDialog(null, fields, "Edit Book", JOptionPane.OK_CANCEL_OPTION);

                    if (option == JOptionPane.OK_OPTION) {
                        // Lấy thông tin mới từ người dùng
                        String newTitle = titleField.getText();
                        int newPrice = Integer.parseInt(priceField.getText());

                        // Cập nhật thông tin của cuốn sách trong cơ sở dữ liệu
                        try {
                            BookDAO bookDAO = new BookDAO();
                            bookDAO.editBook(id, newTitle, newPrice);

                            // Cập nhật thông tin của cuốn sách trong bảng JTable
                            model.setValueAt(newTitle, selectedRow, 1);
                            model.setValueAt(newPrice, selectedRow, 2);
                        } catch (SQLException | ClassNotFoundException ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Loi khi edit sach", "Loi", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ban chua chon muc can edit", "Loi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();

                    // Xóa dữ liệu từ cơ sở dữ liệu
                    int bookId = (int) model.getValueAt(selectedRow, 0); // Giả sử cột đầu tiên là ID sách
                    try {
                        BookDAO bookDAO = new BookDAO();
                        bookDAO.deleteBook(bookId);
                    } catch (SQLException | ClassNotFoundException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Co loi khi xoa du lieu", "Loi", JOptionPane.ERROR_MESSAGE);
                        return; // Ngừng thực hiện nếu xảy ra lỗi
                    }

                    // Xóa dữ liệu từ bảng JTable
                    model.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(null, "Ban chua chon muc muon xoa", "Loi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        pnBottom.add(btnAdd);
        pnBottom.add(btnEdit);
        pnBottom.add(btnDelete);
        pnMain.add(pnBottom, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public  class BookManager {
        private static final String URL = "jdbc:mysql://localhost/test_filter";
        private static final String USER = "root";
        private static final String PASS = "";
        public BookManager() throws ClassNotFoundException {
        }
        public static Connection getConnection() throws SQLException, ClassNotFoundException {
            return DriverManager.getConnection(URL, USER, PASS);
        }
    }

    public class Book {
        private int Id;
        private String Title;
        private int Price;

        public Book(int id, String title, int price) {
            super();
            Id = id;
            Title = title;
            Price = price;
        }

        public int getId() {
            return Id;
        }

        public void setId(int id) {
            Id = id;
        }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String title) {
            Title = title;
        }

        public int getPrice() {
            return Price;
        }

        public void setPrice(int price) {
            Price = price;
        }
    }

    public class BookDAO {
        public List<Book> layTatCaBook() throws SQLException, ClassNotFoundException {
            List<Book> dsb = new ArrayList<>();

            try (Connection connection = BookManager.getConnection()) {
                String query = "SELECT * FROM book";
                try (Statement statement = connection.createStatement();
                     ResultSet resultSet = statement.executeQuery(query)) {

                    while (resultSet.next()) {
                        int id = resultSet.getInt("Id");
                        String title = resultSet.getString("Title");
                        int price = resultSet.getInt("Price");
                        Book b = new Book(id, title, price);
                        dsb.add(b);
                    }
                }
            }

            return dsb;
        }

        public List<Book> searchBooks(String keyword) throws SQLException, ClassNotFoundException {
            List<Book> searchResults = new ArrayList<>();

            try (Connection connection = BookManager.getConnection()) {
                String query = "SELECT * FROM book WHERE Title LIKE ?";
                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setString(1, "%" + keyword + "%");
                    try (ResultSet resultSet = statement.executeQuery()) {
                        while (resultSet.next()) {
                            int id = resultSet.getInt("Id");
                            String title = resultSet.getString("Title");
                            int price = resultSet.getInt("Price");
                            Book book = new Book(id, title, price);
                            searchResults.add(book);
                        }
                    }
                }
            }

            return searchResults;
        }


        public int addBook(String title, int price) throws SQLException, ClassNotFoundException {
            int newBookId = -1; // Mã số sách mới thêm vào

            try (Connection connection = BookManager.getConnection()) {
                String query = "INSERT INTO book (Title, Price) VALUES (?, ?)";
                try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                    statement.setString(1, title);
                    statement.setInt(2, price);
                    int affectedRows = statement.executeUpdate();

                    if (affectedRows > 0) {
                        // Lấy mã số sách mới thêm vào
                        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                            if (generatedKeys.next()) {
                                newBookId = generatedKeys.getInt(1);
                            }
                        }
                    }
                }
            }

            return newBookId;
        }

        public void editBook(int id, String title, int price) throws SQLException, ClassNotFoundException {
            try (Connection connection = BookManager.getConnection()) {
                String query = "UPDATE book SET Title = ?, Price = ? WHERE Id = ?";
                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setString(1, title);
                    statement.setInt(2, price);
                    statement.setInt(3, id);
                    statement.executeUpdate();
                }
            }
        }

        public void deleteBook(int bookId) throws SQLException, ClassNotFoundException {
            try (Connection connection = BookManager.getConnection()) {
                String query = "DELETE FROM book WHERE Id = ?";
                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setInt(1, bookId);
                    statement.executeUpdate();
                }
            }
        }

    }


    public static void main(String[] args) {
        new Cau2();
    }
}

