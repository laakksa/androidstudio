package com.olio.android;

import android.app.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Scanner;

public class MainActivity extends Activity {
    TextView text;
    EditText edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void helloWorld(View v){
        Scanner scan = new Scanner(System.in);
        text = (TextView) findViewById(R.id.textView);
        edit = (EditText) findViewById(R.id.input);
        String input = edit.getText().toString();
        text.setText(input);

    }

}