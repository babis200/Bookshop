package gr.uniwa.bookshop.servlets;

import gr.uniwa.bookshop.database.BookDao;
import gr.uniwa.bookshop.model.Book;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RetrieveAllServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {  //Ανοιγω printwriter για να γραψω τον κωδικα εμφανισης

            out.print("<head>\n"
                    + //html: κεντραρω οτι εμφανιζεται 
                    "        <style>  h1 {text-align: center;} .center { margin: 0; position: absolute; top: 50%; left: 50%; -ms-t  ransform: translate(-50%, -50%); transform: translate(-50%, -50%); } </style>\n "
                    + "        <title>UniWA Bookshop</title>\n"
                    + "        <meta charset=\"UTF-8\">\n"
                    + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                    + "    </head>\n<body>\n"
                    + "        <div class =\"center\">");

            out.println("<h1>Books List</h1>");

            List<Book> list;    //δημιουρω λιστα απο books
            list = BookDao.getAllBooks();   //βαζω στι λιστα ολα τα books απο τη βαση

            out.print("<table border='1' width='100%'");    //δημιουργο πινακα
            out.print("<tr><th>ID</th><th>ISBN-10</th><th>Title</th><th>Author</th><th>Publisher</th><th>Quantity</th><th>Action</th></tr>");

            list.forEach((e) -> {   //σε κάθε γραμή γραφω απο ενα βιβλιο και στο τελος 3 λειτουργιες για αυτο το βιβλιο
                out.print("<tr><td>"
                        + e.getId() + "</td><td>"
                        + e.getIsbn10() + "</td><td>"
                        + e.getTitle() + "</td><td>"
                        + e.getAuthor() + "</td><td>"
                        + e.getPublisher() + "</td><td>"
                        + e.getQuantity() + "</td><td>"
                        + "<a href='OrderForm?id=" + e.getId() + "'>Order</a>\t" //παραγγειλε το βιβλιοτης γραμμης
                        + "<a href='UpdateForm?id=" + e.getId() + "'>Edit</a>\t" //Edit  το βιβλιο
                        + "<a onclick=\"return confirm('This book will be deleted permanetly.\\nAre you sure?')\" href='DeleteServlet?id=" + e.getId() + "'>Delete</a>"); //delete το βιβλιο της γραμμης μετα απο επιβεβαιωση alert
            });
            out.print("</table>");
            out.println("<a href='index.html'>Main Menu</a>\n");    //link στην αρχικη
            out.print("</div>\n ");
            out.close();
        }
    }
}
