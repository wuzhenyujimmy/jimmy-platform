package com.jimmy.web.taglib;


public class FlatuiButtonTag extends BaseFlatUITag {

    private String value = "Search";

    private boolean isWide = false;

    private String type = "normal";

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
