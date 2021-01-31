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
public class CreateForm extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.print("<style>  h1 {text-align: center;} .center { margin: 0; position: absolute; top: 50%; left: 50%; -ms-transform: translate(-50%, -50%); transform: translate(-50%, -50%); }</style>");
            out.println("<title>Order</title>");
            out.println("</head>");
            out.println("<body>");
            out.print("<div class=\"center\">\n");
            out.print("<form method=\"post\" action=\"CreateServlet\" id=\"form1\" action=\"CreateServlet\">\n"
                    + //δημιουργο φορμα για εισοδο των στοιχειων του νεου βιβλιου
                    "		<label for=\"isbn\">ISBN:</label>\n"
                    + //δεν υπαρχει input για το ιδ dioti dhmioyrgeitai aytomata mesv toy AUTO_INCREMENT sth bash
                    "		<input type=\"text\" id=\"isbn\" name=\"isbn\"><br>\n"
                    + "                                        <label for=\"title\">Title:</label>\n"
                    + "		<input type=\"text\"  id=\"title\" name=\"title\"><br>\n"
                    + "                                        <label for=\"author\">Author:</label>\n"
                    + "		<input type=\"text\"  id=\"author\" name=\"author\"><br>\n"
                    + "                                        <label for=\"Publisher\">Publisher:</label>\n"
                    + "		<input type=\"text\"  id=\"publisher\" name=\"publisher\"><br>\n"
                    + "                                        <label for=\"quantity\">Quantity:</label>\n"
                    + "		<input type=\"number\"  min='0' id=\"quantity\" name=\"quantity\"><br>\n"
                    + "                                   <input type=\"submit\" value=\"Submit\">\n"
                    + "                              </form>");
            out.println("<a href='index.html'>Main Menu</a>\n");
            out.print("</div>");
            out.println("</body>");
            out.println("</html>");
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
