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
public class DeleteServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");

        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);     //δεχομαι id και το μετατρεπω απο String σε int

        int status = BookDao.deleteById(id);        //delete το βιβλιο με αντισtοιχο id status==1 αν επιτυχω

        try (PrintWriter out = response.getWriter()) {  //τυπωνω μυνημα για τα αποτελεσματα
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.print("<style>h1 {text-align: center;} .center { margin: 0; position: absolute; top: 50%; left: 50%; -ms-transform: translate(-50%, -50%); transform: translate(-50%, -50%); }</style>");
            out.println("<title>Delete</title>");
            out.println("</head>");
            out.println("<body>");
            out.print("<div class=\"center\">\n");
            if (status != 0) {
                out.print("<h1>Book deleted<h1>");
            } else {
                out.print("<h1>Delete Failed<h1>");
            }
            out.println("<a href='index.html'>Main Menu</a>\n");
            out.print("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);     //δεχομαι id και το μετατρεπω απο String σε int

        int status = BookDao.deleteById(id);        //delete το βιβλιο με αντισtοιχο id status==1 αν επιτυχω

        try (PrintWriter out = response.getWriter()) {  //τυπωνω μυνημα για τα αποτελεσματα
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.print("<style>h1 {text-align: center;} .center { margin: 0; position: absolute; top: 50%; left: 50%; -ms-transform: translate(-50%, -50%); transform: translate(-50%, -50%); }</style>");
            out.println("<title>Delete</title>");
            out.println("</head>");
            out.println("<body>");
            out.print("<div class=\"center\">\n");
            if (status != 0) {
                out.print("<h1>Book deleted<h1>");
            } else {
                out.print("<h1>Delete Failed<h1>");
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
