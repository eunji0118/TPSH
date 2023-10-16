package com.eunji0118.tpsmarthabit.data;

public class Todo {
    public int _no;
    public String title;
    public String date;
    public String id;
    public int isDone;
    public int important;

    public Todo(int _no, String title, String date, String id, int isDone, int important) {
        this._no = _no;
        this.title = title;
        this.date = date;
        this.id = id;
        this.isDone = isDone;
        this.important = important;
    }

    public Todo() {
    }
}
