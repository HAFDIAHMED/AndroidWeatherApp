package com.example.weatherapp;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class WeatherAppService {
    public static final String QUERY_CITY_ID = "https://www.metaweather.com/api/location/search/?query=";
    public static final String QUERY_CITY_WEATHER_BY_ID = "https://www.metaweather.com/api/location/";

    public WeatherAppService(Context context) {
        this.context = context;
    }

    public interface VolleyResponseListener {
        void OnError(String message);

        void OnResponse(String cityID);

    }

    Context context;
    String CityID;

    public void getCityId(String cityName, VolleyResponseListener volleyResponseListener) {

        String url = QUERY_CITY_ID + cityName;
        JsonArrayRequest requestJson = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                CityID = "";
                try {
                    JSONObject cityinfo = response.getJSONObject(0);
                    CityID = cityinfo.getString("woeid");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                //Toast.makeText(context,"City ID ="+ CityID,Toast.LENGTH_LONG).show();
                volleyResponseListener.OnResponse(CityID);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Toast.makeText(context,"show the error",Toast.LENGTH_LONG).show();
                volleyResponseListener.OnError("something wrong");
            }
        });
        MySingleton.getInstance(context).addToRequestQueue(requestJson);
        //return CityID;
    }

    public void getForcastByID(String cityID) {
        //List<WeatherReportModel> report = new ArrayList<>();
        List<WeatherReportModel> report = new ArrayList<>();
        String url = QUERY_CITY_WEATHER_BY_ID + cityID;
        //get the json object
        JsonObjectRequest requestJson = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(context,response.toString(),Toast.LENGTH_LONG).show();
                try {
                    JSONArray  consolidated_weather_list =response.getJSONArray("consolidated_weather");
                    //
                    WeatherReportModel first_day= new WeatherReportModel()
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }



            // get each item in the array and assign it to a new WeatherReaport
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context,"show the error",Toast.LENGTH_LONG).show();
            }
        });
        //get the property called "consolidated_weather"



    /*public List<WeatherReportModel> geCityByName(String cityName){

    }*/
        MySingleton.getInstance(context).addToRequestQueue(requestJson);


    }
}

