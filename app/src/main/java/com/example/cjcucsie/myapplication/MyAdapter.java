package com.example.cjcucsie.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MyAdapter
{
    Double temp;
    Double pressure;
    Double humidity;
    Double temp_min;
    Double temp_max;
    Double sea_level;
    Double grnd_level;
    String name;

    public MyAdapter (String data) {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(data);
            JSONObject main = jsonObject.getJSONObject("main");
            temp = main.getDouble("temp");
            pressure = main.getDouble("pressure");
            humidity = main.getDouble("humidity");
            temp_min = main.getDouble("temp_min");
            temp_max = main.getDouble("temp_max");
            sea_level = main.getDouble("sea_level");
            grnd_level = main.getDouble("grnd_level");
            name = jsonObject.getString("name");

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
