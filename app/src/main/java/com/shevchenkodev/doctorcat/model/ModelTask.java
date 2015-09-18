package com.shevchenkodev.doctorcat.model;

/**
 * Created by Администратор on 18.09.2015.
 */
public class ModelTask implements Item {

    String title;
    Long date;

    public ModelTask() {

    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ModelTask(String title, Long date) {
        this.title = title;
        this.date = date;

    }

    @Override
    public boolean isTask() {
        return true;
    }
}
