package com.olio.android;

import android.app.Activity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class MainActivity extends Activity {
    EditText input, fileinput;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = (EditText) findViewById(R.id.input);
        fileinput = (EditText) findViewById(R.id.fileinput);
        context = MainActivity.this;
        //Prints files directory location to console to make it easier to find files
        System.out.println("Files location: " + context.getFilesDir());
        }

//Open file with filename from filename input box and read its contents to input box
    public void readFile(View v){
        try{
            InputStream is = context.openFileInput(fileinput.getText().toString());
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String temp;
            input.setText("");
            while ((temp = br.readLine()) != null){
                input.append(temp + "\n");
            }
            is.close();
        } catch (IOException e){
            Log.e("IOException", "Faulty input.");
        }
    }
//Save contents of input box to file with filename from filename input box
    public void writeFile(View v){
        try{
            OutputStreamWriter osw = new OutputStreamWriter(context.openFileOutput(fileinput.getText().toString(), Context.MODE_PRIVATE));
            String temp = input.getText().toString();
            osw.write(temp);
            osw.close();
        } catch (IOException e){
            Log.e("IOException", "Faulty input.");
        } finally{
            input.setText("");
        }
    }

}