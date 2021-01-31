package gr.uniwa.bookshop.servlets;

import gr.uniwa.bookshop.database.BookDao;
import gr.uniwa.bookshop.model.Book;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Μπαλτατζίδης Χαράλαμπος
 */
public class RetrieveByIdServlet extends HttpServlet {

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

        String sid = request.getParameter("id");  //δεχομαι αποτο RetrieveByIdForm το id 
        int id = Integer.parseInt(sid);   //περναω το id σε μεταβλητη τυπου int

        Book book = BookDao.getBookById(id);        //βρισκω το βιβλιο που αντιστοιχει στο id μου

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.print("<style>h1 {text-align: center;} .center { margin: 0; position: absolute; top: 50%; left: 50%; -ms-transform: translate(-50%, -50%); transform: translate(-50%, -50%); }</style>");
            out.println("<title>Your Book</title>");
            out.println("</head>");
            out.println("<body>");
            out.print("<div class=\"center\">\n");
            if (book.getAuthor() != null) {
                out.print("<table >");
                out.print("<tr><th>ID</th><th>ISBN-10</th><th>Title</th><th>Author</th><th>Publisher</th><th>Quantity</th></tr>");  //τυπώνω μεσα σε πινακα τα στοιχεία του βιβλιου
                out.print("<tr><td>"
                        + book.getId() + "</td><td>"
                        + book.getIsbn10() + "</td><td>"
                        + book.getTitle() + "</td><td>"
                        + book.getAuthor() + "</td><td>"
                        + book.getPublisher() + "</td><td>"
                        + book.getQuantity() + "</td>");
                out.print("</table>");
            } else {
                out.print("<h2>There is no book with that ID.</h2>");  //δεν υπαρχει βιβλιο με το ζητουμενο id
            }
            out.println("<a href='index.html'>Main Menu</a>\n");
            out.print("</div>");
            out.println("</body>");
            out.println("</html>");
            out.close();
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
