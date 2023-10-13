package com.eunji0118.tpsmarthabit.data;

public class CalendarItem {

    public int _no;
    public String title;
    public String date;
    public String id;

    public CalendarItem(int _no, String title, String date, String id) {
        this._no = _no;
        this.title = title;
        this.date = date;
        this.id = id;
    }

    public CalendarItem() {
    }
}
