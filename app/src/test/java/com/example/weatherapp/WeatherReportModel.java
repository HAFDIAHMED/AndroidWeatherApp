package com.example.weatherapp;

public class WeatherReportModel {


    private int id ;
    private String weather_state_name;
    private String weather_state_abbr;
    private String wind_direction_compass ;
    private String created ;
    private String applicable_date;
    private float min_temp;
    private float max_temp;
    private float the_temp;
    private float wind_speed;
    private float wind_direction;
    private float air_pressure;
    private int humidity ;
    private float visibility;
    private int predictability;

    public WeatherReportModel(int id, String weather_state_name, String weather_state_abbr, String wind_direction_compass, String created, String applicable_date, float min_temp, float max_temp, float the_temp, float wind_speed, float wind_direction, float air_pressure, int humidity, float visibility, int predictability) {
        this.id = id;
        this.weather_state_name = weather_state_name;
        this.weather_state_abbr = weather_state_abbr;
        this.wind_direction_compass = wind_direction_compass;
        this.created = created;
        this.applicable_date = applicable_date;
        this.min_temp = min_temp;
        this.max_temp = max_temp;
        this.the_temp = the_temp;
        this.wind_speed = wind_speed;
        this.wind_direction = wind_direction;
        this.air_pressure = air_pressure;
        this.humidity = humidity;
        this.visibility = visibility;
        this.predictability = predictability;
    }
}
