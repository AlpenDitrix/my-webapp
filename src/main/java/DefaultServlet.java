import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: Alpen Ditrix
 * Date: 02.11.13
 * Time: 3:21
 */
public class DefaultServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();
        boolean closed = false;

        String[] paramValues = req.getParameterValues(HtmlBuilder.QUEST_KEY);

        if (paramValues != null && paramValues.length > 0) {
            String question = paramValues[0];
            if (!question.equals("")) {
                out.println(HtmlBuilder.getResponsePage(question));
                out.close();
                closed = true;
            }
        }
        if (!closed) {
            out.println(HtmlBuilder.getDefaultPage());
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter pw = resp.getWriter();

        pw.print(HtmlBuilder.getDefaultPage());

        pw.close();
    }

}
