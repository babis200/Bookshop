/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.uniwa.bookshop.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import static javax.faces.component.UIInput.isEmpty;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Μπαλτατζίδης Χαράλαμπος
 */
public class OrderForm extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        response.setContentType("text/html;charset=UTF-8");

        String sid = request.getParameter("id");

        if (isEmpty(sid) || sid == null) {        //αμα κληθει απο το menu
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.print("<style>h1 {text-align: center;} .center { margin: 0; position: absolute; top: 50%; left: 50%; -ms-transform: translate(-50%, -50%); transform: translate(-50%, -50%); }</style>");
                out.println("<title>Order</title>");
                out.println("</head>");
                out.println("<body>");
                out.print("<div class=\"center\">\n"
                        + "<form method=\"post\"  id=\"form1\" action=\"OrderServlet\">\n"
                        + //φορμα για εισαγωγη τιμων
                        "		<label for=\"copies\">How many copies do you want:</label>\n"
                        + "		<input type=\"number\" min=\"0\" id=\"copies\" name=\"copies\">\n"
                        + "                                   <label for=\"id\">Enter book ID:</label>\n"
                        + "		<input type=\"number\"  min=\"0\" id=\"ID\" name=\"ID\">\n"
                        + "                                   <input type=\"submit\" value=\"Submit\">\n"
                        + "                              </form>");
                out.print("<a href='index.html'>Main Menu</a>\n");
                out.print("</div>");
                out.println("</body>");
                out.println("</html>");
            }
        } else {             // αμα κληθει απο το πινακα με ολα τα βιβλια εχει default τιμη για το id
            int id = Integer.parseInt(sid);

            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.print("<style>h1 {text-align: center;} .center { margin: 0; position: absolute; top: 50%; left: 50%; -ms-transform: translate(-50%, -50%); transform: translate(-50%, -50%); }</style>");
                out.println("<title>Order</title>");
                out.println("</head>");
                out.println("<body>");
                out.print("<div class=\"center\">\n"
                        + "<form method=\"post\" id=\"form1\" action=\"OrderServlet\">\n"
                        + //φορμα για εισαγωγη τιμων
                        "		<label for=\"copies\">How many copies do you want:</label>\n"
                        + "		<input type=\"number\" min=\"0\" id=\"copies\" name=\"copies\">\n"
                        + "                                   <label for=\"id\">Enter book ID:</label>\n"
                        + "		<input type=\"number\" value=" + id + "  min=\"0\" id=\"ID\" name=\"ID\">\n"
                        + "                                   <input type=\"submit\" value=\"Submit\">\n"
                        + "                              </form>");
                out.println("<a href='index.html'>Main Menu</a>\n");
                out.print("</div>");
                out.println("</body>");
                out.println("</html>");
            }
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
