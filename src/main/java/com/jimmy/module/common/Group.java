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
public class Group extends BaseEntity {

    /**
     * 
     */
    private static final long serialVersionUID = 951181804345788271L;

    private String name;

    private Group parent;

    private Set<Group> children;

    /* Getter and Setter start */

    @Column
    public String getName() {
        return name;
    }

    @ManyToOne
    @JoinColumn
    public Group getParent() {
        return parent;
    }

    @OneToMany(fetch = FetchType.LAZY)
    public Set<Group> getChildren() {
        return children;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParent(Group parent) {
        this.parent = parent;
    }

    public void setChildren(Set<Group> children) {
        this.children = children;
    }

    /* Getter and Setter end */

}
