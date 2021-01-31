/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.uniwa.bookshop.servlets;

import gr.uniwa.bookshop.database.BookDao;
import gr.uniwa.bookshop.model.Book;
import java.io.IOException;
import java.io.PrintWriter;
import static java.nio.charset.StandardCharsets.ISO_8859_1;
import static java.nio.charset.StandardCharsets.UTF_8;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Μπαλτατζίδης Χαράλαμπος
 */
public class UpdateServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        response.setContentType("text/html;charset=UTF-8");

        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);

        String isbn = request.getParameter("isbn");     //το isbn δεν εχει ελλνικους χαρακτηρες αλλα για σιγουρια
        byte[] ptext = isbn.getBytes(ISO_8859_1);      //υπαρχει προβλημα με τους ελληνικους χαρακτηρες οποτε μετατρεπω ολα τα String σε encoding UTF-8
        isbn = new String(ptext, UTF_8);

        String title = request.getParameter("title");
        ptext = title.getBytes(ISO_8859_1);      //υπαρχει προβλημα με τους ελληνικους χαρακτηρες οποτε μετατρεπω ολα τα String σε encoding UTF-8
        title = new String(ptext, UTF_8);

        String author = request.getParameter("author");
        ptext = author.getBytes(ISO_8859_1);       //υπαρχει προβλημα με τους ελληνικους χαρακτηρες οποτε μετατρεπω ολα τα String σε encoding UTF-8
        author = new String(ptext, UTF_8);

        String publisher = request.getParameter("publisher");
        ptext = publisher.getBytes(ISO_8859_1);         //υπαρχει προβλημα με τους ελληνικους χαρακτηρες οποτε μετατρεπω ολα τα String σε encoding UTF-8
        publisher = new String(ptext, UTF_8);

        String squantity = request.getParameter("quantity");
        int quantity = Integer.parseInt(squantity);

        Book book = BookDao.getBookById(id);    //βρισκω το βιβλιο μεσω id 

        book.setAuthor(author);     //αλλαζω τις τιμες του βιβλιου
        book.setTitle(title);
        book.setQuantity(quantity);
        book.setPublisher(publisher);
        book.setIsbn10(isbn);

        int status = 0;     //
        status = BookDao.updateById(book);   //ενημερωνω τη βαση και επιστρεφω 1 για Success Η 0 gia Error

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.print("<style>h1 {text-align: center;} .center { margin: 0; position: absolute; top: 50%; left: 50%; -ms-transform: translate(-50%, -50%); transform: translate(-50%, -50%); }</style>");
            out.println("<title>Update</title>");
            out.println("</head>");
            out.println("<body>");
            out.print("<div class=\"center\">\n");
            if (status != 0) {      //print αποτελεσμα
                out.print("<h1>Successfull Update<h1>");
            } else {
                out.print("<h1>Update Failed<h1>");
            }
            out.println("<a href='index.html'>Main Menu</a>\n");
            out.print("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
