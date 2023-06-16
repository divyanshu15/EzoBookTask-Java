package com.divyanshu.ezobooksjava;

public class ResponseDataClassItem {
    private String author;
    private String download_url;
    private int height;
    private String id;
    private String url;
    private int width;

    public ResponseDataClassItem(String author, String download_url, int height, String id, String url, int width) {
        this.author = author;
        this.download_url = download_url;
        this.height = height;
        this.id = id;
        this.url = url;
        this.width = width;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDownloadUrl() {
        return download_url;
    }

    public void setDownloadUrl(String download_url) {
        this.download_url = download_url;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}

