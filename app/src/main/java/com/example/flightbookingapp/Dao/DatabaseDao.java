package com.example.flightbookingapp.Dao;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.flightbookingapp.BookingTable;

@Dao
public interface DatabaseDao {

    @Query("SELECT * FROM BookingTable where name=name")
    BookingTable getBookingTable(String name);

    @Insert
    void insert(BookingTable bookingTable);
}
