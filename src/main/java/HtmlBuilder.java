/**
 * Created with IntelliJ IDEA.
 * User: Alpen Ditrix
 * Date: 02.11.13
 * Time: 4:36
 * To change this template use File | Settings | File Templates.
 */
public class HtmlBuilder {

    private static final String pagePost;
    private static final String pageGet;

    static {
        StringBuilder sb = new StringBuilder("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">");
        sb.append("<HTML><HEAD><TITLE>Dummy talkie web-appliaction</TITLE><meta http-equiv=\"Content-Type\"");
        sb.append("content=\"text/html; charset=UTF-8\"></HEAD>");
        sb.append("<BODY BGCOLOR=\"#FDF5E6\">");
        sb.append("<H1 ALIGN=\"CENTER\">THIS IS HEADING</H1>");

        sb.append("<FORM ACTION=\"/my-webapp/\"");
        sb.append("METHOD=\"POST\">");
        sb.append("А можно ли мне ");
        sb.append("<INPUT TYPE=\"TEXT\" NAME=\"quest\" onfocus=\"this.value=\'\'\" onblur=\"if (this.value==\'\'));");
        sb.append("this.value=\'не программировать\'\" VALUE=\"не программировать\"><BR>");
        sb.append("<INPUT TYPE=\"SUBMIT\" VALUE=\"Воспрашать!\"></FORM>");

        StringBuilder sb2 = new StringBuilder(sb);
        sb2.append("</BODY>");
        sb2.append("</HTML>");

        pageGet = sb2.toString();

        sb.append("<BR>%s<BR>");

        sb.append("</BODY>");
        sb.append("</HTML>");

        pagePost = sb.toString();
    }

    public static final String getDefaultPage() {
        return pageGet;
    }

    public static final String getResponseString(String newData) {
        return String.format(pagePost, newData);
    }

}
