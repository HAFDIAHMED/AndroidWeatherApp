package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    Button btn_getId,btn_getName,btn_getWeather;
    EditText cityName_textInput;
    ListView list_view_weather;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_getId=findViewById(R.id.btn_cityId);
        btn_getName=findViewById(R.id.btn_cityName);
        btn_getWeather=findViewById(R.id.btn_cityWeather);
        cityName_textInput=findViewById(R.id.cityNameText);
    }
}