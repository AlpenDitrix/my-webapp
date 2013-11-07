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

    private static PrintWriter prepareAndGetWriter(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        return resp.getWriter();
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = prepareAndGetWriter(req, resp);

        String[] paramValues = req.getParameterValues(HtmlBuilder.QUEST_KEY);
        if (paramValues != null && paramValues.length > 0 && !paramValues[0].equals("")) {
            out.println(HtmlBuilder.getResponsePage(paramValues[0]));
        } else {
            out.println(HtmlBuilder.getDefaultPage());
        }

        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = prepareAndGetWriter(req, resp);

        out.print(HtmlBuilder.getDefaultPage());

        out.close();
    }

}
