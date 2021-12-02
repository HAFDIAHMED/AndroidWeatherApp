package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
        final WeatherAppService weatherAppService= new WeatherAppService(MainActivity.this) ;

        btn_getId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weatherAppService.getCityId(cityName_textInput.getText().toString(), new WeatherAppService.VolleyResponseListener() {
                    @Override
                    public void OnError(String message) {
                        Toast.makeText(MainActivity.this,"someting wrong here ",Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void OnResponse(String cityID) {
                        Toast.makeText(MainActivity.this,"Return an ID of "+ cityID,Toast.LENGTH_LONG).show();

                    }

                });

                // Instantiate the RequestQueue.
                //RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                /*String url ="https://www.metaweather.com/api/location/search/?query="+cityName_textInput.getText().toString()  ;
                JsonArrayRequest requestJson = new JsonArrayRequest(Request.Method.GET,url,null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        String CityID="";
                        try {
                            JSONObject cityinfo=response.getJSONObject(0);
                             CityID=cityinfo.getString("woeid");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        Toast.makeText(MainActivity.this,"City ID ="+ CityID,Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this,"show the error",Toast.LENGTH_LONG).show();
                    }
                });
                MySingleton.getInstance(MainActivity.this).addToRequestQueue(requestJson);*/

                //queue.add(requestJson);

                /*// Request a string response from the provided URL.
                                    StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                                            new Response.Listener<String>() {
                                                @Override
                                                public void onResponse(String response) {
                                                    // Display the first 500 characters of the response string.
                                                    Toast.makeText(MainActivity.this,response,Toast.LENGTH_LONG).show();
                                                }
                                            }, new Response.ErrorListener() {
                                        @Override
                                        public void onErrorResponse(VolleyError error) {
                                            Toast.makeText(MainActivity.this,"error ",Toast.LENGTH_LONG).show();
                                        }
                                    });

                    // Add the request to the RequestQueue.*/
                //queue.add(stringRequest);
               // Toast.makeText(MainActivity.this,"City ID "+cityName_textInput.getText().toString(),Toast.LENGTH_LONG).show();
            }
        });
        btn_getName.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View view) {
                
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