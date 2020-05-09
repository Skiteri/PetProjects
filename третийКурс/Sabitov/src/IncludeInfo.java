import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/iinfo")
public class IncludeInfo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        procPeq(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        procPeq(req, resp);
    }

    protected void procPeq(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter writer = response.getWriter();
        String act = request.getParameter("act");
        if (act != null) {
            RequestDispatcher info = request.getRequestDispatcher("info");
            if (act.equalsIgnoreCase("include")) {
                info.include(request, response);
            } else {
                info.forward(request, response);
            }
        }
    }
}
