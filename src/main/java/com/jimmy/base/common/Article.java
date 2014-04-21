package com.jimmy.base.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;

import com.jimmy.base.util.HtmlParserUtils;

@Entity
public class Article extends BaseEntity {
    /**
     * 
     */
    private static final long serialVersionUID = 6072408666356120019L;

    private String title;

    private String htmlContent;
    
    private String textContent;

    public Article(String title, String htmlContent) {
        this.title = title;
        this.htmlContent = htmlContent;
        this.textContent = HtmlParserUtils.parseHtml2Text(htmlContent);
    }

    /* getter and setter start */

    @Column
    public String getTitle() {
        return title;
    }

    @Lob
    @Column
    public String getTextContent() {
        return textContent;
    }

    @Lob
    @Column
    public String getHtmlContent() {
        return htmlContent;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    /* getter and setter end */

}
