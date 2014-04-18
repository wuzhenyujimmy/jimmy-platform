package com.jimmy.base.util;

import org.htmlparser.Parser;
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

        return textVisitor.getExtractedText();
    }

}
