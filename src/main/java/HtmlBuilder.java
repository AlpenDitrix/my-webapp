import students.AnswerGenerator;

/**
 * Created with IntelliJ IDEA.
 * User: Alpen Ditrix
 * Date: 02.11.13
 * Time: 4:36
 */
class HtmlBuilder {

    static final String QUEST_KEY = "q";

    static {
        StringBuilder sb = new StringBuilder("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">");
        sb.append("<HTML><HEAD><TITLE>Dummy talkie web-appliaction</TITLE><meta http-equiv=\"Content-Type\"");
        sb.append("content=\"text/html; charset=UTF-8\"></HEAD>");
        sb.append("<BODY BGCOLOR=\"#FDF5E6\">");
        sb.append("<H1 ALIGN=\"CENTER\">THIS IS HEADING</H1>");

        sb.append("<FORM ACTION=\"/my-webapp/\"");
        sb.append("METHOD=\"POST\">");
        sb.append("А можно ли мне ");
        sb.append("<INPUT TYPE=\"TEXT\" NAME=\"");
        sb.append(QUEST_KEY);
        sb.append("\" onfocus=\"this.value=\'\'\" onblur=\"if (this.value==\'\'))");
        sb.append("this.value=\'не программировать\'\" VALUE=\"не программировать\"><BR>");
        sb.append("<INPUT TYPE=\"SUBMIT\" VALUE=\"Воспрашать!\"></FORM>");

        StringBuilder sb2 = new StringBuilder(sb);
        sb2.append("</BODY>");
        sb2.append("</HTML>");

        defaultPage = sb2.toString();

        sb.append("<BR>%s<BR>");

        sb.append("</BODY>");
        sb.append("</HTML>");

        responsePage = sb.toString();
    }

    private static final String responsePage;
    private static final String defaultPage;

    public static String getDefaultPage() {
        return defaultPage;
    }

    public static String getResponsePage(String question) {
        return String.format(responsePage, createAnswer(question));
    }

    private static String createAnswer(String question) {
        return AnswerGenerator.printQuestion(question).concat("<br>").concat(AnswerGenerator.generateReply());
    }
}