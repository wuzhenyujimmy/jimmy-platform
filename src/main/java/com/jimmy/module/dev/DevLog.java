package com.jimmy.module.dev;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.jimmy.base.common.Article;
import com.jimmy.base.common.BaseEntity;
import com.jimmy.base.common.EntityStatus;
import com.jimmy.module.common.Group;

@Entity
public class DevLog extends BaseEntity {

    /**
     * 
     */
    private static final long serialVersionUID = -8638265085543709617L;

    private Article article;

    private EntityStatus status;

    private Group group;

    public DevLog(Article article, EntityStatus status) {
        this.article = article;
        this.status = status;
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

    @JoinColumn
    public Group getGroup() {
        return group;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public void setStatus(EntityStatus status) {
        this.status = status;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    /* Setter and getter end */

}
