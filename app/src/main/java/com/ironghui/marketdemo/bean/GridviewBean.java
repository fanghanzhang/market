package com.ironghui.marketdemo.bean;

public class GridviewBean {
    private int bitmapId;//图片Id

    private String name;//图片编号

    public GridviewBean(int bitmap, String name) {
        this.bitmapId = bitmap;
        this.name = name;
    }

    public int getBitmapId() {
        return bitmapId;
    }

    public void setBitmapId(int bitmapId) {
        this.bitmapId = bitmapId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
