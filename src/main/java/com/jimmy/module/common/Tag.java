package com.jimmy.module.common;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.jimmy.base.common.BaseEntity;

@Entity
public class Tag extends BaseEntity {

    /**
     * 
     */
    private static final long serialVersionUID = 951181804345788271L;

    private String name;

    private Set<Tag> parents;

    private Set<Tag> children;

    /* Getter and Setter start */

    @Column
    public String getName() {
        return name;
    }

    @OneToMany(fetch = FetchType.LAZY)
    public Set<Tag> getParents() {
        return parents;
    }

    @OneToMany(fetch = FetchType.LAZY)
    public Set<Tag> getChildren() {
        return children;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParents(Set<Tag> parents) {
        this.parents = parents;
    }

    public void setChildren(Set<Tag> children) {
        this.children = children;
    }

    /* Getter and Setter end */

}
