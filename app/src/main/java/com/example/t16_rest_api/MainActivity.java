package com.example.t16_rest_api;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.jar.JarException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void myClick(View view) {
            Ion.with(this)
                    .load("http://api.icndb.com/jokes/random")
                    .asString()
                    .setCallback(new FutureCallback<String>() {
                        public void onCompleted(Exception e, String data) {
                            // process the data or error
                            try {
                                JSONObject json = new JSONObject(data);
                                JSONObject value = json.getJSONObject("value");
                                String joke = value.getString("joke");
                                TextView myTV = (TextView) findViewById(R.id.myview);
                                myTV.setText(joke);
                            } catch (JSONException jse) {
                                Log.wtf("problem", jse);
                            }
                        }
                    });

        }

}
