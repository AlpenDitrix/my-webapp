import students.DefaultReplyGenerator;
import students.Messages;
import students.ReplyGenerator;

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

    private static String printQuestion(final String question) {
        String questionOut = Messages.getString("App.can_u") + question;
        if (!questionOut.endsWith("?")) {
            questionOut += "?";
        }
        return questionOut;
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();

        req.setCharacterEncoding("UTF-8");

        ReplyGenerator replier = new DefaultReplyGenerator();

        String[] paramValues = req.getParameterValues("quest");

        if (paramValues != null && paramValues.length > 0) {
            String question = paramValues[0];
            out.println(HtmlBuilder.getResponseString(printQuestion(question).concat("<br>").concat(replier.generate())));
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter pw = resp.getWriter();
        pw.print(HtmlBuilder.getDefaultPage());
        pw.flush();
        pw.close();
    }

}
