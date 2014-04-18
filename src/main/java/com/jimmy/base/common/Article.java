package com.jimmy.base.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;

@Entity
public class Article extends BaseEntity {
    /**
     * 
     */
    private static final long serialVersionUID = 6072408666356120019L;

    private String title;

    private String htmlContext;
    
    private String textContext;

    /* getter and setter start */

    @Column
    public String getTitle() {
        return title;
    }

    @Lob
    @Column
    public String getTextContext() {
        return textContext;
    }

    @Lob
    @Column
    public String getHtmlContext() {
        return htmlContext;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setHtmlContext(String htmlContext) {
        this.htmlContext = htmlContext;
    }

    public void setTextContext(String textContext) {
        this.textContext = textContext;
    }

    /* getter and setter end */

}
