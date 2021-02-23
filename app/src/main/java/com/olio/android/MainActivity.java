package com.olio.android;

import android.app.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void helloWorld(View v){
        text = (TextView) findViewById(R.id.textView);
        text.setText("Hello World!");
    }
}