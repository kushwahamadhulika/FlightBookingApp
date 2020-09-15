package com.example.flightbookingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.flightbookingapp.Dao.DatabaseDao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    DatePickerDialog datePickerDialog;
    EditText et_name;
    TextView tv_fromdate,tv_todate,et_fromdate,et_todate,tv_fromcity;
    Spinner fromcity,tocity;
    Button booking;
    String tocityitem,fromcityItem;
    DatabaseDao databaseDao;
    String fromdate,todateformate;
    String[] FromCity=new String[]{"Lucknow","Kanpur","Jhansi"};
    String[] ToCity={"Lucknow","Kanpur","Jhansi"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_name=findViewById(R.id.et_name);
        tv_todate=findViewById(R.id.tv_todate);
        tv_fromdate=findViewById(R.id.tv_fromdate);
        et_todate=findViewById(R.id.et_toDate);
        et_fromdate=findViewById(R.id.et_fromDate);
        fromcity=findViewById(R.id.et_fromcity);
        tocity=findViewById(R.id.et_tocity);
        booking=findViewById(R.id.booking);

          List<String> list=new ArrayList<String>();
          list.add("kjh");
        list.add("kjh");
        list.add("kjh");
        list.add("kjh");
        list.add("kjh");
        databaseDao= Room.databaseBuilder(this,RoomDatabase.class,"mi-database.db").allowMainThreadQueries().build().getdatabseDoa();

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fromcity.setAdapter(arrayAdapter);
        tv_fromdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               final Calendar calendar=Calendar.getInstance();
               final int Day=calendar.get(Calendar.DAY_OF_MONTH);
               final int Month=calendar.get(Calendar.MONTH);
               int year=calendar.get(Calendar.YEAR);

                DateFormat dateFormat=new SimpleDateFormat("DD/MM/YYYY");
                fromdate=dateFormat.format(calendar);


               //
                booking.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                        getBooking();
                    }
                });


               //date piker dialog
               datePickerDialog=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                   @Override
                   public void onDateSet(DatePicker datePicker, int Dayof, int MonthOf, int YearOF) {
                      et_fromdate.setText(Dayof+ "/" +(MonthOf+1) + "/"+YearOF);
                   }
               },Day,Month,year);
               datePickerDialog.show();

            }
        });
        tv_todate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar=Calendar.getInstance();
                final int Day=calendar.get(Calendar.DAY_OF_MONTH);
                final int Month=calendar.get(Calendar.MONTH);
                int year=calendar.get(Calendar.YEAR);
                DateFormat dateFormat=new SimpleDateFormat("DD/MM/YYYY");
                todateformate=dateFormat.format(calendar);

                //date piker dialog
                datePickerDialog=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int Dayof, int MonthOf, int YearOF) {
                        et_todate.setText(Dayof+ "/" +(MonthOf+1) + "/"+YearOF);
                    }
                },Day,Month,year);
                datePickerDialog.show();

            }
        });
        AdapterView.OnItemSelectedListener onItemSelectedListener=new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               //tv_fromcity.setText(FromCity[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        };
        fromcity.setOnItemSelectedListener(onItemSelectedListener);


        //
        ToCity();

    }
    public void ToCity()
    {
        List<String> toCity=new ArrayList<String>();
        toCity.add("Lucknow");
        toCity.add("Kanpur");
        toCity.add("Jhansi");
        toCity.add("Gonda");
        toCity.add("Goa");
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,ToCity);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tocity.setAdapter(arrayAdapter);

        AdapterView.OnItemSelectedListener onItemSelectedListener=new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //tv_fromcity.setText(FromCity[i]);
                String tocityitem=adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        };
        tocity.setOnItemSelectedListener(onItemSelectedListener);


    }
    public void getBooking()

    {
        String Name=et_name.getText().toString().trim();

        BookingTable bookingTable=new BookingTable(Name,fromcityItem,tocityitem,fromdate,todateformate);
        databaseDao.insert(bookingTable);
    }
}