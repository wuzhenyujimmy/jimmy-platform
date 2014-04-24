package com.jimmy.web.widget;

public class Button extends BaseWidget {
    
    /*
     * <button class="btn btn-hg btn-primary"> Boss Button </button>
     */

    private String value;

    public Button() {

    }

    // public Button(String className, String value) {
    // this.className = className;
    // this.value = value;
    // }

    public Button(String value) {
        this.value = value;
    }

    @Override
    public String getHtmlContent() {
        return "<button class='btn btn-primary'>" + value + "</button>";
    }

}
