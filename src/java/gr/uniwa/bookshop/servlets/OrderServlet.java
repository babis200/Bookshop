package gr.uniwa.bookshop.servlets;

import gr.uniwa.bookshop.database.BookDao;
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
public class OrderServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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

        String scopies = request.getParameter("copies");        //λαμβανω απο το orderForm τα δεδομενα
        int copies = Integer.parseInt(scopies);                     //τα μετατρεπω απο string σε int 
        String sid = request.getParameter("ID");
        int id = Integer.parseInt(sid);

        int status = BookDao.orderBook(id, copies);     //καλω την εντολη στη βαση η οποια επιστρεφει 1 για επιτυχια και 0 για αποτυχια

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.print("<style>h1 {text-align: center;} .center { margin: 0; position: absolute; top: 50%; left: 50%; -ms-transform: translate(-50%, -50%); transform: translate(-50%, -50%); }</style>");
            out.println("<title>Order</title>");
            out.println("</head>");
            out.println("<body>");
            out.print("<div class=\"center\">\n");
            if (status != 0) {          //τυπωνω τα αποτελεσματα
                out.print("<h1>Successfull Order<h1>");
            } else {
                out.print("<h1>Out of Stock<h1>");
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
