package com.jimmy.module.common;

import java.util.Set;

import javax.persistence.CascadeType;
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

    private int level;

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

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "parent")
    public Set<Tag> getChildren() {
        return children;
    }

    @Column
    public int getLevel() {
        return level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChildren(Set<Tag> children) {
        this.children = children;
    }

    public void setParent(Tag parent) {
        this.parent = parent;
        if (null != this.parent) {
            this.level = this.parent.level + 1;
        }
    }

    public void setLevel(int level) {
        this.level = level;
    }

    /* Getter and Setter end */

}
