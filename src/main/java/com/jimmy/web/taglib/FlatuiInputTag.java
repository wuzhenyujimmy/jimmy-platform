package com.jimmy.web.taglib;


public class FlatuiInputTag extends BaseFlatUITag {

    private String name;

    private String placeHolder;

    private boolean isFlat;

    private String size;

    private String type;

    @Override
    public String getHtmlContent() {
        String className = "form-control ";

        if (this.isFlat) {
            className += "flat ";
        }

        // set size style
        switch (this.size) {
        case "small":
            className += "input-sm ";
            break;
        case "large":
            className += "input-lg ";
            break;
        case "huge":
            className += "input-hg ";
            break;

        default:
            break;
        }
        
        // set type style
        switch (this.type) {
        case "success":
            className += "has-success ";
            break;
        case "warning":
            className += "has-warning ";
            break;
        case "error":
            className += "has-error ";
            break;

        default:
            break;
        }
        
        String disabled = "";
        if ("disabled".equals(this.type)) {
            disabled = " disabled";
        }

        String html = "<input class='" + className + "' + placeholder='"
                + this.placeHolder + "' " + disabled + ">";

        return html;
    }

    public String getName() {
        return name;
    }

    public String getPlaceHolder() {
        return placeHolder;
    }

    public boolean isFlat() {
        return isFlat;
    }

    public String getSize() {
        return size;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlaceHolder(String placeHolder) {
        this.placeHolder = placeHolder;
    }

    public void setIsFlat(boolean isFlat) {
        this.isFlat = isFlat;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setType(String type) {
        this.type = type;
    }

}
