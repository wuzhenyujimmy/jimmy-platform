package com.jimmy.module.po;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.jimmy.base.common.Article;
import com.jimmy.base.common.BaseEntity;
import com.jimmy.base.common.EntityStatus;

@Entity
public class DevLog extends BaseEntity {

    /**
     * 
     */
    private static final long serialVersionUID = -8638265085543709617L;

    private Article article;

    private EntityStatus status;

    private Tag tag;

    public DevLog() {

    }

    public DevLog(Article article, EntityStatus status) {
        this.article = article;
        this.status = status;
    }

    public DevLog(String title, String htmlContent) {
        this.article = new Article(title, htmlContent);
        this.status = EntityStatus.NEW;
    }

    /* Setter and getter start */

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn
    public Article getArticle() {
        return article;
    }

    @Column
    public EntityStatus getStatus() {
        return status;
    }

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn
    public Tag getTag() {
        return tag;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public void setStatus(EntityStatus status) {
        this.status = status;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    /* Setter and getter end */

}
