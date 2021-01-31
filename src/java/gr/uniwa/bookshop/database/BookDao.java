package gr.uniwa.bookshop.database;

import gr.uniwa.bookshop.model.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Μπαλτατζίδης Χαράλαμπος
 */
public class BookDao {

    public static Connection getConnection() {      //method για συνδεση με ΒΔ
        Connection conn = null;

        try {
            Class.forName("org.mariadb.jdbc.Driver");       //χρησημοποιω JDBC Driver mariaDB v2.7.1
            conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/bookshop", "baltatzidis", "1234");
        } catch (ClassNotFoundException | SQLException ex) {
        }
        return conn;
    }

    public static List<Book> getAllBooks() {       //επιστρεφει ολα ταβιβλια με αντιτυπα 
        List<Book> bookList = new ArrayList();
        Connection conn = BookDao.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM books WHERE Quantity > 0 ");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {   //οσο υπαρχει επομενη εγγραφη
                Book book = new Book();  //δημιουργησε νεο βιβλιο, παρε απο ΒΔ τις τιμες του
                book.setId(rs.getInt(1));
                book.setIsbn10(rs.getString(2));
                book.setTitle(rs.getString(3));
                book.setAuthor(rs.getString(4));
                book.setPublisher(rs.getString(5));
                book.setQuantity(rs.getInt(6));
                bookList.add(book);  //κα βαλτο στη λιστα
            }
            conn.close();
        } catch (SQLException ex) {

        }
        return bookList;    //επιστρεφει τη λιστα με τα βιβλια

    }

    public static Book getBookById(int id) {        //βρες βιβλιο με αντισοιχο id
        Book book = new Book();
        Connection conn = BookDao.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM books WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                book.setId(rs.getInt(1));
                book.setIsbn10(rs.getString(2));
                book.setTitle(rs.getString(3));
                book.setAuthor(rs.getString(4));
                book.setPublisher(rs.getString(5));
                book.setQuantity(rs.getInt(6));
            }
            conn.close();
        } catch (SQLException ex) {
        }
        return book;
    }

    public static int createBook(Book book) {   //δημιουργησε νεο entry στο database
        int status = 0;
        Connection conn = BookDao.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO `books` (`ISBN`, `Title`, `Author`, `Publisher`, `Quantity`) VALUES (?,?,?,?,?)");
            ps.setString(1, book.getIsbn10());
            ps.setString(2, book.getTitle());
            ps.setString(3, book.getAuthor());
            ps.setString(4, book.getPublisher());
            ps.setInt(5, book.getQuantity());
            status = ps.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
        }
        return status;
    }

    public static int updateById(Book book) {       //ενημερωση βιβλιου με αντισοιχο id
        int status = 0;
        Connection conn = BookDao.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE books SET ISBN=?, Title=?, Author=?, Publisher=?, Quantity=? WHERE id=?");
            ps.setString(1, book.getIsbn10());
            ps.setString(2, book.getTitle());
            ps.setString(3, book.getAuthor());
            ps.setString(4, book.getPublisher());
            ps.setInt(5, book.getQuantity());
            ps.setInt(6, book.getId());
            status = ps.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
        }
        return status;
    }

    public static int deleteById(int id) {  //διαγραφη βιβλιου με αντισοιχο id
        int status = 0;
        Connection conn = BookDao.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM books WHERE id=?");
            ps.setInt(1, id);
            status = ps.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
        }
        return status;
    }

    public static int orderBook(int id, int quantity) {    //θεσε το stock του βιβλιου με αντισοιχο id σε: oldQuantity - newQuantity αμα γινεται
        int status = 0;
        Connection conn = BookDao.getConnection();

        Book e = BookDao.getBookById(id);

        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE books SET Quantity = ((SELECT Quantity FROM books WHERE id=?)-?) WHERE books.ID = ? AND Quantity >= ?; ");

            ps.setInt(1, e.getId());
            ps.setInt(2, quantity);
            ps.setInt(3, e.getId());
            ps.setInt(4, quantity);
            status = ps.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
        }
        return status;
    }

}
