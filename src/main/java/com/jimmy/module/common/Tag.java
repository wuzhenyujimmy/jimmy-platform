package com.jimmy.module.common;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.jimmy.base.common.BaseEntity;

@Entity
public class Tag extends BaseEntity {

    /**
     * 
     */
    private static final long serialVersionUID = 951181804345788271L;

    private String name;

    private Tag parent;

    private Set<Tag> children;

    /* Getter and Setter start */

    @Column
    public String getName() {
        return name;
    }

    @ManyToOne
    @JoinColumn
    public Tag getParent() {
        return parent;
    }

    @OneToMany(fetch = FetchType.LAZY)
    public Set<Tag> getChildren() {
        return children;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParent(Tag parent) {
        this.parent = parent;
    }

    public void setChildren(Set<Tag> children) {
        this.children = children;
    }

    /* Getter and Setter end */

}
