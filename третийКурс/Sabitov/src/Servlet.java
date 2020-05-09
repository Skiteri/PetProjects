import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/do")
public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<Film> list = FilmDAO.getBase();

        try (PrintWriter out = resp.getWriter()) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Sabitov</title>");
            out.println("   </head>");
            out.println("       <body>");
            for (Film i: list) {
                out.println(        "<p>" +
                                        i +
                                    "</p>");
            }
            out.println("       </body>");
            out.println("</html>");
        }
    }
}
