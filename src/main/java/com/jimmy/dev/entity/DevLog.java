package com.jimmy.dev.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;

import com.jimmy.base.BaseEntity;

@Entity
public class DevLog extends BaseEntity {

    /**
     * 
     */
    private static final long serialVersionUID = -8638265085543709617L;

    private String title;

    private String content;

    /* Setter and getter start */

    @Column
    public String getTitle() {
        return title;
    }

    @Lob
    @Column
    public String getContent() {
        return content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /* Setter and getter end */

}
