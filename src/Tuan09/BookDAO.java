package Tuan09;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class BookDAO {
    public List<Books> layTatCaSach() throws SQLException, ClassNotFoundException {
        List<Books> dsb = new ArrayList<>();

        try (Connection connection = KetNoiCSDL.getConnection()) {
            String query = "SELECT * FROM books";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("Id");
                    String title = resultSet.getString("Title");
                    int price = resultSet.getInt("Price");
                    Books b = new Books(id, title, price);
                    dsb.add(b);
                }

            }
        }
        return dsb;
    }

    public int addBook(String title, int price) throws SQLException, ClassNotFoundException {
        int newBookId = -1; // Mã số sách mới thêm vào

        try (Connection connection = KetNoiCSDL.getConnection()) {
            String query = "INSERT INTO books (Title, Price) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, title);
                statement.setInt(2, price);
                int affectedRows = statement.executeUpdate();

                if (affectedRows > 0) {
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

    public void updateBook(int bookId, String title, int price) throws SQLException, ClassNotFoundException {
        try (Connection connection = KetNoiCSDL.getConnection()) {
            String query = "UPDATE books SET Title = ?, Price = ? WHERE Id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, title);
                statement.setInt(2, price);
                statement.setInt(3, bookId);
                statement.executeUpdate();
            }
        }
    }

    public void deleteBook(int bookId) throws SQLException, ClassNotFoundException {
        try (Connection connection = KetNoiCSDL.getConnection()) {
            String query = "DELETE FROM books WHERE Id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, bookId);
                statement.executeUpdate();
            }
        }
    }

    public Books getBookById(int bookId) throws SQLException, ClassNotFoundException {
        Books book = null;

        try (Connection connection = KetNoiCSDL.getConnection()) {
            String query = "SELECT * FROM books WHERE Id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, bookId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        int id = resultSet.getInt("Id");
                        String title = resultSet.getString("Title");
                        int price = resultSet.getInt("Price");
                        book = new Books(id, title, price);
                    }
                }
            }
        }

        return book;
    }

    public List<Books> searchBooks(String keyword) throws SQLException, ClassNotFoundException {
        List<Books> searchResults = new ArrayList<>();

        try (Connection connection = KetNoiCSDL.getConnection()) {
            String query = "SELECT * FROM books WHERE Title LIKE ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, "%" + keyword + "%");
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("Id");
                        String title = resultSet.getString("Title");
                        int price = resultSet.getInt("Price");
                        Books book = new Books(id, title, price);
                        searchResults.add(book);
                    }
                }
            }
        }

        return searchResults;
    }

}
