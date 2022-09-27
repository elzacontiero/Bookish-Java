package org.softwire.training.bookish;

import org.jdbi.v3.core.Jdbi;
import org.softwire.training.bookish.models.database.Book;

import java.sql.*;
import java.util.List;


public class Main {

    public static void main(String[] args) throws SQLException {
        String hostname = "localhost";
        String database = "bookish";
        String user = "root";
        String password = "guess my password";
        String connectionString = "jdbc:mysql://" + hostname + "/" + database + "?user=" + user + "&password=" + password + "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT&useSSL=false";

        jdbcMethod(connectionString);
        jdbiMethod(connectionString);
    }

    private static void jdbcMethod(String connectionString) throws SQLException {
        String query = "select BookID, title, author, isbn, category from Books";
        System.out.println("JDBC method...");

        // See this page for details: https://docs.oracle.com/javase/tutorial/jdbc/basics/processingsqlstatements.html
        Connection connection = DriverManager.getConnection(connectionString);
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int bookID = rs.getInt("BookId");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String isbn = rs.getString("isbn");
                String category = rs.getString("category");
                System.out.println("BookId is: " + bookID + " Title is: " + title +
                        " Author is: " + author + " ISBN: " + isbn + " category: " + category);
            }
            rs.close();
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    private static void jdbiMethod(String connectionString) {
        System.out.println("\nJDBI method...");

        // See this page for details: http://jdbi.org
        Jdbi jdbi = Jdbi.create(connectionString);

        List<Book> books = jdbi.withHandle(handle -> {
           return handle.createQuery("select BookID, title, author, isbn, category from Books")
                   .mapToBean(Book.class)
                   .list();
        });

        for(Book b: books) {
            System.out.println(b);
        }
    }
}
