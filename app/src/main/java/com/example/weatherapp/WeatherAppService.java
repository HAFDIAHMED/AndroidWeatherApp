package com.example.weatherapp;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class WeatherAppService {
    public static final String QUERY_CITY_ID = "https://www.metaweather.com/api/location/search/?query=";

    public WeatherAppService(Context context) {
        this.context = context;
    }
    public interface  VolleyResponseListener {
        void OnError (String message);
        void OnResponse(String cityID);

    }

    Context context;
    String CityID;
    public void getCityId (String cityName,VolleyResponseListener  volleyResponseListener) {

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
    public  void getForcastByID(String cityID){
        //List<WeatherReportModel> report = new ArrayList<>();
        List<WeatherReportModel> report = new ArrayList<WeatherReportModel>()
            //get the json object


            //get the property called "consolidated_weather"

            // get each item in the array and assign it to a new WeatherReaport
    }

    /*public List<WeatherReportModel> geCityByName(String cityName){

    }*/

    public static class WeatherReportModel {


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

        public int getId() {
            return id;
        }

        public String getWeather_state_name() {
            return weather_state_name;
        }

        public String getWeather_state_abbr() {
            return weather_state_abbr;
        }

        public String getWind_direction_compass() {
            return wind_direction_compass;
        }

        public String getCreated() {
            return created;
        }

        public String getApplicable_date() {
            return applicable_date;
        }

        public float getMin_temp() {
            return min_temp;
        }

        public float getMax_temp() {
            return max_temp;
        }

        public float getThe_temp() {
            return the_temp;
        }

        public float getWind_speed() {
            return wind_speed;
        }

        public float getWind_direction() {
            return wind_direction;
        }

        public float getAir_pressure() {
            return air_pressure;
        }

        public int getHumidity() {
            return humidity;
        }

        public float getVisibility() {
            return visibility;
        }

        public int getPredictability() {
            return predictability;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setWeather_state_name(String weather_state_name) {
            this.weather_state_name = weather_state_name;
        }

        public void setWeather_state_abbr(String weather_state_abbr) {
            this.weather_state_abbr = weather_state_abbr;
        }

        public void setWind_direction_compass(String wind_direction_compass) {
            this.wind_direction_compass = wind_direction_compass;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public void setApplicable_date(String applicable_date) {
            this.applicable_date = applicable_date;
        }

        public void setMin_temp(float min_temp) {
            this.min_temp = min_temp;
        }

        public void setMax_temp(float max_temp) {
            this.max_temp = max_temp;
        }

        public void setThe_temp(float the_temp) {
            this.the_temp = the_temp;
        }

        public void setWind_speed(float wind_speed) {
            this.wind_speed = wind_speed;
        }

        public void setWind_direction(float wind_direction) {
            this.wind_direction = wind_direction;
        }

        public void setAir_pressure(float air_pressure) {
            this.air_pressure = air_pressure;
        }

        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }

        public void setVisibility(float visibility) {
            this.visibility = visibility;
        }

        public void setPredictability(int predictability) {
            this.predictability = predictability;
        }

        @Override
        public String toString() {
            return "WeatherReportModel{" +
                    "id=" + id +
                    ", weather_state_name='" + weather_state_name + '\'' +
                    ", weather_state_abbr='" + weather_state_abbr + '\'' +
                    ", wind_direction_compass='" + wind_direction_compass + '\'' +
                    ", created='" + created + '\'' +
                    ", applicable_date='" + applicable_date + '\'' +
                    ", min_temp=" + min_temp +
                    ", max_temp=" + max_temp +
                    ", the_temp=" + the_temp +
                    ", wind_speed=" + wind_speed +
                    ", wind_direction=" + wind_direction +
                    ", air_pressure=" + air_pressure +
                    ", humidity=" + humidity +
                    ", visibility=" + visibility +
                    ", predictability=" + predictability +
                    '}';
        }
    }
}
