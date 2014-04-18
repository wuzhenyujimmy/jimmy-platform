package com.jimmy.dev.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.jimmy.base.common.Article;
import com.jimmy.base.common.BaseEntity;

@Entity
public class DevLog extends BaseEntity {

    /**
     * 
     */
    private static final long serialVersionUID = -8638265085543709617L;

    private Article article;

    /* Setter and getter start */

    @OneToOne
    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    /* Setter and getter end */

}