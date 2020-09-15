package com.example.flightbookingapp.DataBase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.flightbookingapp.BookingTable;
import com.example.flightbookingapp.Dao.DatabaseDao;

@Database(entities = {BookingTable.class},version = 1,exportSchema = false)
public abstract class RoomDatabse extends RoomDatabase {

    public abstract DatabaseDao getdatabseDoa();
   }
