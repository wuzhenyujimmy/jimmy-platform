package com.jimmy.module.vo;

public class WordDto {

    private String id;
    private String en;
    private String ch;
    private String eg;
    private String status;

    public WordDto() {

    }

    public WordDto(String id, String en, String ch, String eg, String status) {
        super();
        this.id = id;
        this.en = en;
        this.ch = ch;
        this.eg = eg;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getCh() {
        return ch;
    }

    public void setCh(String ch) {
        this.ch = ch;
    }

    public String getEg() {
        return eg;
    }

    public void setEg(String eg) {
        this.eg = eg;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

}
