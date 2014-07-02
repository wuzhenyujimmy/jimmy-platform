package com.jimmy.module.po;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.jimmy.base.common.BaseEntity;
import com.jimmy.enums.DictionaryStatus;

@Entity
public class Word extends BaseEntity {
    private static final long serialVersionUID = 1L;
    /** English word **/
    private String en;
    /** Chinese mean **/
    private String ch;
    /** The example about how to use the English word **/
    private String eg;
    /** former English word **/
    private Word former;
    /** next English word **/
    private Word next;
    /** English word's status **/
    private DictionaryStatus status;
    /** is remove or not **/
    private boolean remove;

    public Word() {
    }

    public Word(String word, String mean, String example) {
        this.en = word;
        this.ch = mean;
        this.eg = example;
    }

    /* getter and setter */

    @Column
    public String getEn() {
        return en;
    }

    @Column
    public String getCh() {
        return ch;
    }

    @Column(length = 1000)
    public String getEg() {
        return eg;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn()
    public Word getFormer() {
        return former;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn
    public Word getNext() {
        return next;
    }

    @Enumerated
    public DictionaryStatus getStatus() {
        return status;
    }

    @Column
    public boolean isRemove() {
        return remove;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public void setCh(String ch) {
        this.ch = ch;
    }

    public void setEg(String eg) {
        this.eg = eg;
    }

    public void setFormer(Word former) {
        this.former = former;
    }

    public void setNext(Word next) {
        this.next = next;
    }

    public void setStatus(DictionaryStatus status) {
        this.status = status;
    }

    public void setRemove(boolean remove) {
        this.remove = remove;
    }

}
