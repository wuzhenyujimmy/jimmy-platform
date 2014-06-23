package com.jimmy.base.common;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

@SuppressWarnings("serial")
@MappedSuperclass
public class BaseEntity implements Serializable {

    protected String id;

    protected String createDate;

    protected String updateDate;

    protected String deleteDate;

    protected boolean deleted = false;

    /* Setter and getter start */

    @Id
    @Column
    @GenericGenerator(name = "uuidKey", strategy = "uuid")
    @GeneratedValue(generator = "uuidKey")
    public String getId() {
        return id;
    }

    @Column
    public String getCreateDate() {
        return createDate;
    }

    @Column
    public String getUpdateDate() {
        return updateDate;
    }

    @Column
    public String getDeleteDate() {
        return deleteDate;
    }

    @Column
    public boolean isDeleted() {
        return deleted;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public void setDeleteDate(String deleteDate) {
        this.deleteDate = deleteDate;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    /* Setter and getter end */

}
