import students.DefaultReplyGenerator;
import students.Messages;
import students.ReplyGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Alpen Ditrix
 * Date: 02.11.13
 * Time: 3:21
 */
public class DefaultServlet extends HttpServlet {
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html");
//        resp.setCharacterEncoding("UTF-8");
//        PrintWriter pw = resp.getWriter();
//        StringBuilder sb = new StringBuilder();
//        while(es.hasMoreElements())     {
//            System.out.println(es.nextElement());
//        }
//        String reqString = sb.toString();
//
//        String respString ="<HTML>\n<HEAD>\n<TITLE>A Sample FORM using POST</TITLE>\n</HEAD>\n<BODY BGCOLOR=\"#FDF5E6\">\n<H1 ALIGN=\"CENTER\">A Sample FORM using POST</H1>\n<FORM ACTION=\"/my-webapp/\"\nMETHOD=\"POST\">\nВаш вопрос:\n<INPUT TYPE=\"TEXT\" NAME=\"itemNum\" onfocus=\"this.value=\'\'\" onblur=\"if (this.value==\'\') this.value=\'А можно ли мне\'\" VALUE=\"А можно ли мне...\"><BR>\n<CENTER>\n<INPUT TYPE=\"SUBMIT\" VALUE=\"Submit Order\">\n</CENTER>\n</FORM><br>%s\n</BODY>\n</HTML>";
//        pw.print(String.format(respString,reqString));
//        pw.flush();
//        pw.close();
//    }

    private static String printQuestion(final String question) {
        String questionOut = Messages.getString("App.can_u") + question;
        if (!questionOut.endsWith("?")) {
            questionOut += "?";
        }
        return questionOut;
    }

    private static String printAnswer(final ReplyGenerator replyGenerator) {
        return replyGenerator.generate();
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
            out.println(HtmlBuilder.getResponseString(printQuestion(question).concat("<br>").concat(printAnswer(replier))));
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
