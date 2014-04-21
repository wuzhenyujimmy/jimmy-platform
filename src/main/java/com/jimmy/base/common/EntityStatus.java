package com.jimmy.base.common;

public enum EntityStatus {
    
    NEW("new"), SCAN("scanned"), VIEW_PART("view_part"), VIEW_COMPLETED(
            "view_completed"), KNOW("know"), FAMILIAR("familiar"), MASTER(
            "master");
    
    private String name;
    
    private EntityStatus(String name){
        this.name = name;
    }
}
