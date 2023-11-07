import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FavoriteServlet")
public class FavoriteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    String eventDate;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get the venue information from the request parameters
        response.setContentType("text/plain");
        eventDate = request.getParameter("eventDate");
        System.out.println(eventDate);
        PrintWriter out = response.getWriter();
        out.print(eventDate);
        out.flush();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.print(eventDate);
        out.flush();
    }

}