package com.example.bdiverse.Objects;

public class Task {
    String title;
    boolean isDraft;
    int id;
    String date;
    String timeStart;
    String timeEnd;
    String nameCmpany;
    String locationCompany;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isDraft() {
        return isDraft;
    }

    public void setDraft(boolean draft) {
        isDraft = draft;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getNameCmpany() {
        return nameCmpany;
    }

    public void setNameCmpany(String nameCmpany) {
        this.nameCmpany = nameCmpany;
    }

    public String getLocationCompany() {
        return locationCompany;
    }

    public void setLocationCompany(String locationCompany) {
        this.locationCompany = locationCompany;
    }

    public Task(String title, boolean isDraft, int id, String date, String timeStart, String timeEnd, String nameCmpany, String locationCompany) {
        this.title = title;
        this.isDraft = isDraft;
        this.id = id;
        this.date = date;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.nameCmpany = nameCmpany;
        this.locationCompany = locationCompany;
    }
}
