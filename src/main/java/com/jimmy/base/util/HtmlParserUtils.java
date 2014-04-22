package com.jimmy.base.util;

import org.htmlparser.Parser;
import org.htmlparser.beans.StringBean;
import org.htmlparser.util.ParserException;
import org.htmlparser.visitors.TextExtractingVisitor;

public class HtmlParserUtils {

    private static TextExtractingVisitor textVisitor = new TextExtractingVisitor();


    public static String parseHtml2Text(String html) {
        try {
            Parser htmlParser = new Parser(html);
            htmlParser.visitAllNodesWith(textVisitor);
        } catch (ParserException e) {
            LogUtils.logExceptionMessage(e);
        }

        System.out.println(textVisitor.getExtractedText());

        return textVisitor.getExtractedText();
    }

    public static String extractTextFromUrl(String url) {
        StringBean sb = new StringBean();
        sb.setLinks(false);
        sb.setURL(url);

        return sb.toString();
    }

}
