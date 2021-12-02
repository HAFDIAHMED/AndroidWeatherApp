package com.example.weatherapp;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WeatherAppService {
    public static final String QUERY_CITY_ID = "https://www.metaweather.com/api/location/search/?query=";

    public WeatherAppService(Context context) {
        this.context = context;
    }

    Context context;
    String CityID;
    public String getCityId (String cityName) {

        String url =QUERY_CITY_ID+cityName ;
        JsonArrayRequest requestJson = new JsonArrayRequest(Request.Method.GET,url,null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                 CityID="";
                try {
                    JSONObject cityinfo=response.getJSONObject(0);
                    CityID=cityinfo.getString("woeid");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Toast.makeText(context,"City ID ="+ CityID,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context,"show the error",Toast.LENGTH_LONG).show();
            }
        });
        MySingleton.getInstance(context).addToRequestQueue(requestJson);
        return CityID;
    }
    /*public List<WeatherReportModel> getCityByID(String cityID){

    }

    public List<WeatherReportModel> geCityByName(String cityName){

    }*/
}
