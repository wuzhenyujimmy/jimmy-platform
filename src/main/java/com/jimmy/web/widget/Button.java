package com.jimmy.web.widget;

public class Button extends BaseWidget {
    
    /*
     * <button class="btn btn-hg btn-primary"> Boss Button </button>
     */

    private String value = "";

    private boolean isWide = false;

    private String type = "";

    public Button() {

    }

    // public Button(String className, String value) {
    // this.className = className;
    // this.value = value;
    // }

    public Button(String value, boolean isWidth, String type) {
        this.value = value;
        this.isWide = isWidth;
        this.type = type;
    }

    @Override
    public String getHtmlContent() {
        String className = "btn mrm";

        if (isWide) {
            className += " btn-wide";
        }

        if ("normal".equals(type)) {
            className += " btn-primary";
        } else if ("gray".equals(type)) {
            className += " btn-default";
        } else {
            className += (" btn-" + type);
        }

        return "<button class='" + className + "'>" + value + "</button>";
    }

}
