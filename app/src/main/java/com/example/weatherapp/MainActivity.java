package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_getId,btn_getName,btn_getWeather;
    EditText cityName_textInput;
    ListView weather_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_getId=findViewById(R.id.btn_cityId);
        btn_getName=findViewById(R.id.btn_cityName);
        btn_getWeather=findViewById(R.id.btn_cityWeather);
        cityName_textInput=findViewById(R.id.cityNameText);
        weather_list=findViewById(R.id.listViewWeather);
        //make listeners
        btn_getId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"City ID",Toast.LENGTH_LONG).show();
            }
        });
        btn_getName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"City NAME",Toast.LENGTH_LONG).show();
            }
        });
        btn_getWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"City WEATHER",Toast.LENGTH_LONG).show();
            }
        });
    }
}