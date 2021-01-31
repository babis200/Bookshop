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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UpdateForm", urlPatterns = {"/UpdateForm"})
public class UpdateForm extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");

        if (request.getParameter("id") != null) {       //αμα κανω Edit απο τον πινακα με ολα τα βιβλια σε stock
            String sid = request.getParameter("id");  //με αυτο τον τρόπο μπορω να εχω default values τις προηγουμενες τιμες στα πεδια 
            int id = Integer.parseInt(sid);
            Book book = BookDao.getBookById(id);

            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.print("<style>h1 {text-align: center;} .center { margin: 0; position: absolute; top: 50%; left: 50%; -ms-transform: translate(-50%, -50%); transform: translate(-50%, -50%); }</style>");
                out.println("<title>Order</title>");
                out.println("</head>");
                out.println("<body>");
                out.print("<div class=\"center\">\n");
                out.print("<form action='UpdateServlet' method='post'>");
                out.print("<table>");
                out.print("<tr><td></td><td><input type='hidden' name='id' value='" + book.getId() + "'/></td></tr>");  //to id einai hidden gia na mh to vlepei o xrhsths, afou to xeirizetai mono h bash
                out.print("<tr><td>ISBN-10:</td><td><input type='text' name='isbn' value='" + book.getIsbn10() + "'/></td></tr>");
                out.print("<tr><td>Title:</td><td><input type='text' name='title' value='" + book.getTitle() + "'/></td></tr>");
                out.print("<tr><td>Author:</td><td><input type='text' name='author' value='" + book.getAuthor() + "'/></td></tr>");
                out.print("<tr><td>Publisher:</td><td><input type='text' name='publisher' value='" + book.getPublisher() + "'/></td></tr>");
                out.print("<tr><td>Quantity:</td><td><input type='number' name='quantity' value='" + book.getQuantity() + "'/></td></tr>");
                out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");
                out.print("</table>");
                out.print("</form>");
                out.print("</div>");
                out.println("</body>");
                out.println("</html>");
                out.close();
            }
        } else {       //αμα κανω Edit απο το κεντικο menu ή απευθειας το link

            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.print("<style>h1 {text-align: center;} .center { margin: 0; position: absolute; top: 50%; left: 50%; -ms-transform: translate(-50%, -50%); transform: translate(-50%, -50%); }</style>");
                out.println("<title>Order</title>");
                out.println("</head>");
                out.println("<body>");
                out.print("<div class=\"center\">\n");
                out.print("<form action='UpdateServlet' method='post'>");
                out.print("<table>");
                out.print("<tr><td>ID:</td><td><input type='number' name='id' /></td></tr>");
                out.print("<tr><td>ISBN-10:</td><td><input type='text' name='isbn' /></td></tr>");
                out.print("<tr><td>Title:</td><td><input type='text' name='title' /></td></tr>");
                out.print("<tr><td>Author:</td><td><input type='text' name='author' /></td></tr>");
                out.print("<tr><td>Publisher:</td><td><input type='text' name='publisher' /></td></tr>");
                out.print("<tr><td>Quantity:</td><td><input type='number' name='quantity' /></td></tr>");
                out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");
                out.print("</table>");
                out.print("</form>");
                out.print("</div>");
                out.println("</body>");
                out.println("</html>");
                out.close();
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
