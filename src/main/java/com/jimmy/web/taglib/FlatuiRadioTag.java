package com.jimmy.web.taglib;


public class FlatuiRadioTag extends BaseFlatUITag {

    private String name;

    private String text;

    private String value;

    private boolean checked;

    @Override
    public String getHtmlContent() {
        String className = "radio ";

        if (this.checked) {
            className += "checked";
        }

        String html = "<label class='" + className + "'>"
                + "<input type='radio' name='" + this.name + "' value='"
                + this.value + "' data-toggle='radio'>" + this.text
                + "</label>";

        return html;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
