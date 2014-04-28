package com.jimmy.web.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.jimmy.web.widget.Button;

public class FlatuiButtonTag extends SimpleTagSupport {

    private String value = "Search";

    private boolean isWide = false;

    /*
     * The value for type can be: normal, danger, gray, danger, info, success,
     * inverse
     */
    private String type = "normal";

    @Override
    public void doTag() throws JspException, IOException {

        JspWriter out = getJspContext().getOut();

        Button button = new Button(value, isWide, type);

        out.print(button.getHtmlContent());
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setIsWide(boolean isWide) {
        this.isWide = isWide;
    }

    public void setType(String type) {
        this.type = type;
    }

}
