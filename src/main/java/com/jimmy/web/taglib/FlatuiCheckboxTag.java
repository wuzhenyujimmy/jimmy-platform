package com.jimmy.web.taglib;

import java.util.UUID;

public class FlatuiCheckboxTag extends BaseFlatUITag {

    private String name;

    private String text;

    private boolean checked;

    @Override
    public String getHtmlContent() {
        String id = UUID.randomUUID().toString();

        String checkedClass = checked ? "checked" : "";
        String className = ("checkbox " + checkedClass).trim();

        String html = "<label class='" + className + "' for='" + id + "'"
                + "<input type='" + "checkbox' id='" + id
                + "' data-toggle='checkbox'" + this.text + "</label>";

        return html;
    }

    public String getName() {
        return name;
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

    public void setText(String text) {
        this.text = text;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }


}
