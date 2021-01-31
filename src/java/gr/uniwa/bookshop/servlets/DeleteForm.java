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
public class DeleteForm extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.print("<style>h1 {text-align: center;} .center { margin: 0; position: absolute; top: 50%; left: 50%; -ms-transform: translate(-50%, -50%); transform: translate(-50%, -50%); }</style>");
            out.println("<title>Delete</title>");
            out.println("</head>");
            out.println("<body>");
            out.print("<div class=\"center\">\n"
                    + "<form method=\"post\" action=\"DeleteServlet\" id=\"form1\" action=\"DeleteServlet\">\n"
                    + "                                   <label for=\"id\">Enter book ID:</label>\n"
                    + "		<input type=\"number\"  min=\"0\" id=\"id\" name=\"id\">\n"
                    + "                                   <input onclick=\"return confirm('This book will be deleted permanetly.\\nAre you sure?')\"  type=\"submit\" value=\"Delete\">\n"
                    + //μετα απο alert επιβεβαίωσης καλει το  servlet για διαγραφη
                    "                              </form>"
                    + "</div>");
            out.println("</body>");
            out.println("</html>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
