package com.example.flightbookingapp;

import android.widget.TextView;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "BookingTable")
public class BookingTable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    private int id;

    @ColumnInfo(name="Name")
    private String Name;

    @ColumnInfo(name="FromDate")
    private String FromDate;

    @ColumnInfo(name="toDtae")
    private String toDate;

    @ColumnInfo(name = "FromCity")
    private String fromCity;

    @ColumnInfo(name = "toCity")
    private String toCity;

    public BookingTable( String name, String fromDate, String toDate, String fromCity, String toCity) {
        Name = name;
        FromDate = fromDate;
        this.toDate = toDate;
        this.fromCity = fromCity;
        this.toCity = toCity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public String getFromDate() {
        return FromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public String getFromCity() {
        return fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setFromDate(String fromDate) {
        FromDate = fromDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }
    @Override
    public String toString()
    {
        return "BookingTable{"+"id=" +id + ",name='"+Name + '\''+",fromDate='"+FromDate+ '\''+",toDate='"+toDate+'\''+",fromCity='"+fromCity+'\''+",toCity='"+toCity+'\''+'}';

    }
}
