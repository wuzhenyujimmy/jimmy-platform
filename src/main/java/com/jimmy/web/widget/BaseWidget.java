package com.jimmy.web.widget;

public class BaseWidget {
    protected String className;

    public BaseWidget() {

    }

    public BaseWidget(String className) {
        this.className = className;
    }

    public void removeClass(String className) {
        // Empty
    }

    public void addClass() {
        // Empty
    }

    public String getHtmlContent() {
        return "";
    }

    /* Setter and getter start */

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    /* Setter and getter end */
}
