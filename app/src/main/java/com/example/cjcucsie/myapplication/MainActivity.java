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


public class MainActivity extends AppCompatActivity {
    // https://samples.openweathermap.org/data/2.5/weather?lat=35&lon=139&appid=66316a6c43b8b6f6e2602946a2e546ea
    OkHttpClient okHttpClient = new OkHttpClient();

    String runData(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = okHttpClient.newCall(request).execute();
        return response.body().string();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String data = runData("https://samples.openweathermap.org/data/2.5/weather?lat=35&lon=139&APPID=66316a6c43b8b6f6e2602946a2e546ea");
                    final MyAdapter myAdapter=new MyAdapter(data);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            TextView tv1 = (TextView) findViewById(R.id.a);
                            TextView tv2 = (TextView) findViewById(R.id.b);
                            TextView tv3 = (TextView) findViewById(R.id.c);
                            TextView tv4 = (TextView) findViewById(R.id.d);
                            TextView tv5 = (TextView) findViewById(R.id.e);
                            TextView tv6 = (TextView) findViewById(R.id.f);
                            TextView tv7 = (TextView) findViewById(R.id.g);
                            TextView tv8 = (TextView) findViewById(R.id.h);
                            tv1.setText("tempture: "+myAdapter.temp.toString());
                            tv2.setText("pressure: "+myAdapter.pressure.toString());
                            tv3.setText("humidity: "+myAdapter.humidity.toString());
                            tv4.setText("temp_min: "+myAdapter.temp_min.toString());
                            tv5.setText("temp_max: "+myAdapter.temp_max.toString());
                            tv6.setText("sea_level: "+myAdapter.sea_level.toString());
                            tv7.setText("grnd_level: "+myAdapter.grnd_level.toString());
                            tv8.setText("name: " + myAdapter.name);
                        }
                    });

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
        }).start();
    }
}
