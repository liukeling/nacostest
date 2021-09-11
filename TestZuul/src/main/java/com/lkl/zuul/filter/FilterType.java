package com.lkl.zuul.filter;

public enum FilterType {
    PRE("pre"),
    POST("post"),
    ROUTE("route");
    private String type;
    FilterType(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
