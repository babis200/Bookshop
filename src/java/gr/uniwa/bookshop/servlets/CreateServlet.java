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
public class CreateServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");

        //δεχομαι και αναθετω σε μεταβλητες τις τιμες απο το CreateForm
        String isbn = request.getParameter("isbn");      //το isbn δεν εχει ελλνικους χαρακτηρες αλλα για σιγουρια
        byte[] ptext = isbn.getBytes(ISO_8859_1);       //υπαρχει προβλημα με τους ελληνικους χαρακτηρες οποτε μετατρεπω ολα τα String σε encoding UTF-8
        isbn = new String(ptext, UTF_8);

        String title = request.getParameter("title");
        ptext = title.getBytes(ISO_8859_1);             //υπαρχει προβλημα με τους ελληνικους χαρακτηρες οποτε μετατρεπω ολα τα String σε encoding UTF-8
        title = new String(ptext, UTF_8);

        String author = request.getParameter("author");
        ptext = author.getBytes(ISO_8859_1);           //υπαρχει προβλημα με τους ελληνικους χαρακτηρες οποτε μετατρεπω ολα τα String σε encoding UTF-8
        author = new String(ptext, UTF_8);

        String publisher = request.getParameter("publisher");
        ptext = publisher.getBytes(ISO_8859_1);             //υπαρχει προβλημα με τους ελληνικους χαρακτηρες οποτε μετατρεπω ολα τα String σε encoding UTF-8
        publisher = new String(ptext, UTF_8);

        String squantity = request.getParameter("quantity");
        int quantity = Integer.parseInt(squantity);

        Book book = new Book();                 //δημιουργω νεο βιβλιο

        //αναθετω τις τιμες
        book.setAuthor(author);
        book.setTitle(title);
        book.setQuantity(quantity);
        book.setPublisher(publisher);
        book.setIsbn10(isbn);

        int status = 0;     //η δημιουργια του βιβλιου επιστρεφει 1 για επιτυχια
        status = BookDao.createBook(book);       //δημιουργω το νεο βιβλιο στη βαση

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.print("<style>h1 {text-align: center;} .center { margin: 0; position: absolute; top: 50%; left: 50%; -ms-transform: translate(-50%, -50%); transform: translate(-50%, -50%); }</style>");
            out.println("<title>Order</title>");
            out.println("</head>");
            out.println("<body>");
            out.print("<div class=\"center\">\n");
            if (status != 0) {                                           //τυπωνω μυνημα επιτυχιας/αποτυχιας
                out.print("<h1>Insert Completed!<h1>");
            } else {
                out.print("<h1>Insert Error<h1>");
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
    }// </editor-fold>

}
