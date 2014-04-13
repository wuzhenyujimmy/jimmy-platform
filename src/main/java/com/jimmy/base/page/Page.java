package com.jimmy.base.page;

import java.util.List;

public class Page<T> {
    /** max record number in one page **/
    private int maxResult = 15;
    /** max page index to show on page **/
    private int totalPageToShow = 10;
    /** current page index **/
    private int currentPageNumber = 1;

    /** entitys **/
    private List<T> entities;
    /** the first record' index that will be query from **/
    private int firstResult = 0;
    /** pagination's start index **/
    private int pageIndexFrom = 1;
    /** pagination's finish index **/
    private int pageIndexTo = 1;
    /** total record number **/
    private int totalRecordNumber = 0;
    /** total page number **/
    private int totalPageNumber = 0;

    public Page() {
        setFirstResult();
    }

    public Page(int currentPageNumber) {
        this.currentPageNumber = currentPageNumber;
        setFirstResult();
    }

    public Page(int currentPageNumber, int maxResult) {
        this.currentPageNumber = currentPageNumber;
        this.maxResult = maxResult;
        setFirstResult();
    }

    /** getter and setter start **/
    public int getTotalRecordNumber() {
        return totalRecordNumber;
    }

    public int getTotalPageNumber() {
        int yushu = this.totalRecordNumber % maxResult;
        int chushu = this.totalRecordNumber / maxResult;
        this.totalPageNumber = yushu == 0 ? chushu : chushu + 1;
        return this.totalPageNumber;
    }

    public int getPageIndexFrom() {
        int half = totalPageToShow / 2;
        if (currentPageNumber > half) {
            if (currentPageNumber + half < getTotalPageNumber()) {
                pageIndexFrom = currentPageNumber - half;
            } else {
                pageIndexFrom = getTotalPageNumber() - totalPageToShow + 1;
            }
        }
        return pageIndexFrom;
    }

    public int getCurrentPageNumber() {
        return currentPageNumber;
    }

    public int getPageIndexTo() {
        pageIndexTo = getPageIndexFrom() + totalPageToShow - 1;
        return pageIndexTo;
    }

    public int getFirstResult() {
        return firstResult;
    }

    public int getMaxResult() {
        return maxResult;
    }

    public List<T> getEntities() {
        return entities;
    }

    public void setTotalPageNumber(int totalPageNumber) {
        this.totalPageNumber = totalPageNumber;
    }

    public void setTotalRecordNumber(int totalRecordNumber) {
        this.totalRecordNumber = totalRecordNumber;
    }

    public void setCurrentPageNumber(int currentPageNumber) {
        this.currentPageNumber = currentPageNumber;
    }

    public void setPageIndexFrom(int pageIndexFrom) {
        this.pageIndexFrom = pageIndexFrom;
    }

    public void setPageIndexTo(int pageIndexTo) {
        this.pageIndexTo = pageIndexTo;
    }

    public void setFirstResult() {
        this.firstResult = (this.currentPageNumber - 1) * maxResult;
    }

    public void setMaxResult(int maxResult) {
        this.maxResult = maxResult;
    }

    public void setEntities(List<T> entities) {
        this.entities = entities;
    }
    /* getter and setter end */

}
