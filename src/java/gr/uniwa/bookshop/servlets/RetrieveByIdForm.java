package gr.uniwa.bookshop.servlets;

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
public class RetrieveByIdForm extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.print("<style> h1 {text-align: center;} .center { margin: 0; position: absolute; top: 50%; left: 50%; -ms-transform: translate(-50%, -50%); transform: translate(-50%, -50%); }</style>");
            out.println("<title>Enter ID</title>");
            out.println("</head>");
            out.println("<body>");
            out.print("<div class=\"center\">\n");
            out.print("<h3>Insert the ID of your book</h3>\n");
            out.print("<form action='RetrieveByIdServlet' method='post'>");
            out.print("<label for='id'>ID:</label><input min='1' type='number' name='id'/>");   //to id πρεπει να ειναι >= 1
            out.print("<input type='submit' value='Retrieve '/>");
            out.print("</form>");
            out.println("<a href='index.html'>Main Menu</a>\n");    //link στην αρχικη
            out.print("</div>");
            out.println("</body>");
            out.println("</html>");
            out.close();
        }
    }

}
