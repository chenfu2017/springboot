package com.chenfu.pojo;


public class DataContent {

    private Integer action;		// 动作类型
    private Object object;
    private String extand;

    public DataContent(){
    }

    public DataContent(int action,Police police){
        this.action = action;
        this.object = police;
    }
    public DataContent(int action,Coordinate position){
        this.action = action;
        this.object = position;
    }

    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getExtand() {
        return extand;
    }

    public void setExtand(String extand) {
        this.extand = extand;
    }
}

