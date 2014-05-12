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

    /**
     * Url of blog forwarded from other blog system.
     */
    private String url;

    private String htmlContent;

    private String textContent;

    private boolean forward;

    /**
     * Foward blog
     * 
     * @param title
     * @param url
     * @param forward
     */
    public Article(String title, String url, boolean forward) {
        this.title = title;
        this.url = url;
        this.forward = true;
    }

    /**
     * Create blog
     * 
     * @param title
     * @param htmlContent
     */
    public Article(String title, String htmlContent) {
        this.title = title;
        this.htmlContent = htmlContent;
        this.textContent = HtmlParserUtils.parseHtml2Text(htmlContent);
        this.forward = false;
    }

    /* getter and setter start */

    @Column
    public String getTitle() {
        return title;
    }

    @Column
    public String getUrl() {
        return url;
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

    @Column
    public boolean getForward() {
        return forward;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public void setForward(boolean forward) {
        this.forward = forward;
    }

    /* getter and setter end */
}
